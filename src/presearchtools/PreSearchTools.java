/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearchtools;

import com.example.NordVPN;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import presearchtools.models.Account;
import presearchtools.models.Cookie;

/**
 *
 * @author JMango
 */
public class PreSearchTools {

    static final String ROOT_PATH = "data";
    static final String COOKIE_PATH = "cookie";
    static final String HISTORY_PATH = "history";
    static final String KEYWORD_PATH = "keyword";
    static final String LOG_PATH = "log";

    public static String execPath = "chromedriver.exe";
    
    public static String vpn_user = "pxson.2903@gmail.com";//
    public static String vpn_pass = "Sa@069823418";//

    static Gson gson = new Gson();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Create a new desired capability

        try {
            List<Account> accounts = getAccounts();

            int size = accounts.size();
            int lastTurnSize = size % 6;
            int turn = size / 6;

            for (int i = 0; i < turn; i++) {
                Account account = accounts.get(i);

                String proxy = getProxy();

                if (account.isUsingProxy()) {
                    proxy = account.getProxy();
                }

                System.out.println("Account " + account.getUsername());
                System.out.println("Pass " + account.getPassword());

                if (isLogged(account)) {
                    continue;
                }

                WebDriver driver = initChrome(account, proxy, 80);
                login(driver, account);
                run(driver, account);

                account.setProxy(proxy);

                deleteCookie(driver);
                driver.close();
            }

            saveAccounts(accounts);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getProxy() throws IOException {
        File file = new File("proxy.txt");
        if (!file.exists()) {
            file.createNewFile();
            return "";
        }
        List<String> proxyLines = FileUtils.readLines(file, "utf-8");
        String selectedIp = "";
        for (String pLine : proxyLines) {
            String[] words = pLine.split(",");
            String ip = words[0];
            int count = Integer.parseInt(words[1]);
            if (count == 4) {
                continue;
            }

            selectedIp = ip;
        }
        if (selectedIp.isEmpty()) {
            Collections.shuffle(proxyLines);
            selectedIp = proxyLines.get(0).split(",")[0];
        }
        saveProxy(selectedIp);
        return selectedIp;
    }

    public static void saveProxy(String proxy) throws IOException {
        File file = new File("proxy.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        List<String> proxyLines = FileUtils.readLines(file, "utf-8");
        for (int i = 0; i < proxyLines.size(); i++) {
            String pLine = proxyLines.get(i);
            String[] words = pLine.split(",");
            String ip = words[0];
            int c = Integer.parseInt(words[1]);
            if (ip.contains(proxy)) {
                pLine = proxy + "," + (c + 1);
            }
            proxyLines.set(i, pLine);
        }
        FileUtils.writeLines(file, proxyLines, "\n", false);
    }
//khoi tao tool
    public static WebDriver initChrome(Account account, String host, int port) throws IOException {
        //cai vpn
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        File vpn = new File("vpn");
      
        String nordvpn = FileUtils.readFileToString(vpn, "UTF-8");
        NordVPN nordvpn1 = gson.fromJson(nordvpn, NordVPN.class);
        System.setProperty("webdriver.chrome.driver", execPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        
        if (account.getUserAgent() != null && !account.getUserAgent().isEmpty()) {
            options.addArguments("--user-agent=" + account.getUserAgent());
        }
        Random rand = new Random();

        int  n = rand.nextInt(nordvpn1.getValue().size()-1) + 1;
        options.addExtensions(new File("Auth.crx"));
        
        System.out.println("Selected proxy " + nordvpn1.getValue().get(n).getDomain());
        options.addArguments("--proxy-server=http://" + nordvpn1.getValue().get(n).getDomain() + ":" + Integer.toString(port));

        WebDriver driver = new ChromeDriver(options);

//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("chrome-extension://ggmdpepbjljkkkdaklfihhngmmgmpggp/options.html");
        //cai vpn

        driver.findElement(By.id("login")).sendKeys(vpn_user);
        driver.findElement(By.id("password")).sendKeys(vpn_pass);
        driver.findElement(By.id("retry")).clear();
        driver.findElement(By.id("retry")).sendKeys("5");
        driver.findElement(By.id("save")).click();
        wait(3);
        return driver;
    }

    public static List<Provider> getProviders() throws IOException {
        File file = new File("provider.txt");
        List<String> providers = FileUtils.readLines(file, "utf-8");

        List<Provider> ps = new ArrayList<>();
        for (String provider : providers) {
            String[] arrs = provider.split(",");
            if (arrs.length < 2) {
                continue;
            }
            String p = arrs[0];
            String cat = arrs[1];
            ps.add(new Provider(p, cat));
        }
        return ps;
    }

    public static String getCategory(Provider provider) {
        String category = provider.getCategory();

        String[] categories = new String[]{"finance", "tech", "furniture", "art", "github", "address", "book", "company", "crypto", "imdb", "animal", "politic", "player", "city", "movie", "people", "product", "question", "song", "domain", "hotel"};
        List<String> categoriesList = Arrays.asList(categories);

        if (category.equals("all")) {
            Collections.shuffle(categoriesList);
            return categoriesList.get(0);
        }

        return category;
    }

    public static String getKeyword(Provider provider) throws IOException {
        String category = getCategory(provider);
        File file = new File(KEYWORD_PATH + File.separator + category + ".txt");
        List<String> keywords = FileUtils.readLines(file, "utf-8");
        Collections.shuffle(keywords);

        String keyword = "";
        for (String key : keywords) {
            if (!existHistory(provider.getName(), keyword)) {
                keyword = key;
            }
        }
        if (keyword.isEmpty()) {
            keyword = keywords.get(0);
        }

        saveHistory(provider.getName(), keyword);

        return keyword;
    }

    public static void saveHistory(String provider, String keyword) throws IOException {
        File historyFile = new File("history.txt");
        if (!historyFile.exists()) {
            historyFile.createNewFile();
        }
        FileUtils.writeStringToFile(historyFile, provider + "," + keyword + "\n", "utf-8", true);
    }

    public static boolean existHistory(String provider, String keyword) throws IOException {
        File historyFile = new File("history.txt");
        if (!historyFile.exists()) {
            historyFile.createNewFile();
        }
        List<String> histories = FileUtils.readLines(historyFile, "utf-8");
        for (String history : histories) {
            if (history.contentEquals(provider) && history.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public static List<Cookie> getCookies(String username) {
        if (username == null || username.isEmpty()) {
            return new ArrayList<>();
        }
        File cookieFile = new File(COOKIE_PATH + "/" + username + ".json");
        if (!cookieFile.exists()) {
            return new ArrayList<>();
        }

        String jsonString = "";
        try {
            jsonString = FileUtils.readFileToString(cookieFile, "utf-8");
        } catch (Exception e) {
            return new ArrayList<>();
        }
        if (null == jsonString || jsonString.isEmpty()) {
            return new ArrayList<>();
        }
        Cookie[] data = gson.fromJson(jsonString, Cookie[].class);
        return Arrays.asList(data);
    }

    public static void login(WebDriver driver, Account account) throws IOException {
        List<Cookie> cookies = getCookies(account.getUsername());
        if (cookies == null || cookies.isEmpty()) {
            driver.get("https://www.presearch.org/login");
//            deleteCookie();
            wait(1);
            driver.findElement(By.xpath("//div[@id='login-form']//form[@method='POST']//div[contains(@class,'form-group')]//input[@type='email']")).sendKeys(account.getEmail());
            wait(1);
            driver.findElement(By.xpath("//div[@class='password-lock']//input[@type='password']")).sendKeys(account.getPassword());
            wait(2);
            driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Login')]")).click();
            wait(3);
            Set<org.openqa.selenium.Cookie> chromeCookies = driver.manage().getCookies();
            List<Cookie> userCookies = new ArrayList<>();

            for (org.openqa.selenium.Cookie c : chromeCookies) {
                if (c.getDomain().equals(".presearch.org")) {
                    Cookie uCookie = new Cookie();
                    uCookie.setName(c.getName());
                    uCookie.setValue(c.getValue());
                    uCookie.setExpirationDate((double) c.getExpiry().getTime());
                    uCookie.setHttpOnly(c.isHttpOnly());
                    uCookie.setSecure(c.isSecure());
                    uCookie.setDomain(c.getDomain());
                    userCookies.add(uCookie);
                }
            }
            if (!userCookies.isEmpty()) {
                File uCookieFile = new File(COOKIE_PATH + "/" + account.getUsername() + ".json");
                if (!uCookieFile.exists()) {
                    uCookieFile.createNewFile();
                }
                FileUtils.writeStringToFile(uCookieFile, gson.toJson(userCookies), "utf-8");
            }
            return;
        } else {
            driver.get("https://www.presearch.org/");

            for (Cookie cookie : cookies) {
                addCookie(driver, cookie.getName(), cookie.getValue());
            }
        }
    }

    public static void deleteCookie(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public static void addCookie(WebDriver driver, String name, String value) {
        org.openqa.selenium.Cookie cookie = new org.openqa.selenium.Cookie.Builder(name, value)
                .domain(".presearch.org")
                .isHttpOnly(false)
                .isSecure(true)
                .path("/")
                .build();

        driver.manage().addCookie(cookie);
    }

    public static void run(WebDriver driver, Account account) throws IOException {
        File providerFile = new File("provider.txt");
        if (!providerFile.exists()) {
            System.out.println("Provider file is not exist");
            return;
        }
        List<Provider> providers = getProviders();
        Collections.shuffle(providers);

        double startBalance = getBalance(driver);

        int retry = 0;
        // Search engine
        for (Provider provider : providers) {
            String keyword = getKeyword(provider).trim();

            if (retry == 3) {
                break;
            }

            double newBalanace = doSearch(driver, provider.getName(), keyword);
            if (Double.compare(newBalanace, 0.0f) != 0 && Double.compare(startBalance, newBalanace) != 0) {
                startBalance = newBalanace;
                retry = 0;
            } else {
                retry++;
            }
        }

        String userLog = account.getUsername() + "," + startBalance;
        log("csv", userLog);
        deleteCookie(driver);
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PreSearchTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static double doSearch(WebDriver driver, String provider, String keyword) {
        wait(1);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(keyword);
        wait(1);
        try {
            driver.findElement(By.xpath("//label[@data-original-title='" + provider + "']")).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.xpath("//label[@title='" + provider + "']")).click();
            } catch (Exception ex) {
                return getBalance(driver);
            }
        }
        checkPageIsReady(driver);
        return getBalance(driver);
    }

    public static double getBalance(WebDriver driver) {
        String balanceString = null;
        int retry = 0;
        while (balanceString == null || balanceString.isEmpty()) {
            try {
                if (retry == 2) {
                    break;
                }
                driver.get("https://www.presearch.org/");
                balanceString = driver.findElement(By.xpath("//span[@class='tour-balance']")).getText();
                if (!balanceString.isEmpty()) {
                    return Double.parseDouble(balanceString.replace("PRE", "").trim());
                } else {
                    retry++;
                }
            } catch (Exception ex) {
                retry++;
            }
        }
        return 0.0f;
    }

    public static void checkPageIsReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            return;
        }

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public static boolean checkBalance(double start, double stop) {
        return Double.compare(start, stop) == 8;
    }

    public static void log(String type, String message) throws IOException {
        String date = getCurrentDate();

        String ext = ".txt";
        if (type.equals("csv")) {
            ext = ".csv";
        } else if (type.equals("json")) {
            ext = ".json";
        }

        if (date == null) {
            return;
        }
        File logFile = new File(LOG_PATH + File.separator + date + ext);
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        FileUtils.writeStringToFile(logFile, message + "\n", "utf-8", true);
    }

    public static boolean isLogged(Account account) throws IOException {
        String date = getCurrentDate();
        File logFile = new File(LOG_PATH + File.separator + date + ".csv");
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        List<String> accountList = FileUtils.readLines(logFile, "utf-8");
        for (String acc : accountList) {
            if (acc.contains(account.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    public static List<Account> getAccounts() throws IOException {
        File accFile = new File("account.csv");
        if (!accFile.exists()) {
            accFile.createNewFile();
            return new ArrayList<>();
        }
        List<Account> accounts = new ArrayList<>();
        List<String> accLines = FileUtils.readLines(accFile, "utf-8");
        for (String accLine : accLines) {
            String[] accParts = accLine.split(",");
            String email = accParts[0].trim();
            String password = accParts[1].trim();
            String proxy = null;
            String userAgent = null;
            if (accParts.length == 3) {
                proxy = accParts[2];
            }
            if (accParts.length == 4) {
                userAgent = accParts[3].replaceAll("|||", ",");
            }
            accounts.add(new Account(email, password, proxy, userAgent));
        }
        return accounts;
    }

    public static void saveAccounts(List<Account> accounts) throws IOException {
        File accFile = new File("account.csv");
        if (!accFile.exists()) {
            accFile.createNewFile();
            return;
        }
        List<String> lines = new ArrayList<>();
        for (Account account : accounts) {
            String line = account.getEmail() + "," + account.getPassword() + "," + account.getProxy() + "," + account.getUserAgent().replaceAll(",", "|||");
            lines.add(line);
        }
        FileUtils.writeLines(accFile, lines, "\n", false);
    }

}
