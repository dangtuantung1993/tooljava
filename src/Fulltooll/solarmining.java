/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fulltooll;

import presearch.*;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.lines;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import presearchtools.PreSearchTools;
import static presearchtools.PreSearchTools.addCookie;
import static presearchtools.PreSearchTools.getAccounts;
import static presearchtools.PreSearchTools.getCookies;
import static presearchtools.PreSearchTools.saveAccounts;
import static presearchtools.PreSearchTools.wait;
import presearchtools.models.Account;
import presearchtools.models.Cookie;

/**
 *
 * @author TDG
 */
public class solarmining {
    static final String ROOT_PATH = "data";
    static final String COOKIE_PATH = "cookie";
    static final String HISTORY_PATH = "history";
    static final String KEYWORD_PATH = "keyword";
    static final String LOG_PATH = "log";

    public static String execPath = "chromedriver.exe";
    
    public static String vpn_user = "pxson.2903@gmail.com";
    public static String vpn_pass = "Sa@069823418";

    static Gson gson = new Gson();
    public static void main(String[] args) {
        // TODO code application logic here
        //Create a new desired capability

        try {
            List<Account> accounts = getAccounts();

            int size = accounts.size();
            int lastTurnSize = size % 6;
            int turn = size / 6;
            
            Account account = new Account("15091993", "vannhuthe1", "nl98.nordvpn.com", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1");
           
                WebDriver driver = initChrome(account,"nl98.nordvpn.com", 80);
                login(driver, account);
               
saveAccounts(accounts);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static WebDriver initChrome(Account account, String host, int port) {
        //cai vpn
        System.setProperty("webdriver.chrome.driver", execPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        if (account.getUserAgent() != null && !account.getUserAgent().isEmpty()) {
            options.addArguments("--user-agent=" + account.getUserAgent());
        }

 //      options.addExtensions(new File("Auth.crx"));
 //      options.addArguments("--proxy-server=http://" + host + ":" + Integer.toString(port));

        WebDriver driver = new ChromeDriver(options);

//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.get("chrome-extension://ggmdpepbjljkkkdaklfihhngmmgmpggp/options.html");
//        //cai vpn
//
//        driver.findElement(By.id("login")).sendKeys(vpn_user);
//        driver.findElement(By.id("password")).sendKeys(vpn_pass);
//        driver.findElement(By.id("retry")).clear();
//        driver.findElement(By.id("retry")).sendKeys("5");
//        driver.findElement(By.id("save")).click();
//        wait(3);
        return driver;
    }
    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PreSearchTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static void login(WebDriver driver, Account account) throws IOException {
        List<Cookie> cookies = getCookies(account.getUsername());
        File fileA = new File("accsola.txt");
            String data = FileUtils.readFileToString(fileA, "UTF-8");
            System.out.println(data);
    
            List<String> lines = FileUtils.readLines(fileA, "UTF-8");
       
        if (cookies == null || cookies.isEmpty()) {
            driver.get("https://www.tokok.com/login");
//            deleteCookie();
             wait(30);
           
            driver.findElement(By.xpath("//a[@class='signup']")).click();
            wait(15);
//            driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/main[1]/article[1]/section[1]/div[1]/input[1]")).sendKeys(account.getEmail());
//            wait(1);
           for(int i = 0;i<lines.size();i++){
            driver.findElement(By.xpath("//input[@placeholder='E-mail']")).sendKeys(lines.get(i));
            wait(2);
            driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(account.getPassword());
            wait(5);
            driver.findElement(By.xpath("//input[@placeholder='Re-type password']")).sendKeys(account.getPassword());
            wait(5);
            driver.findElement(By.xpath("//p[contains(text(),'CONTINUE')]")).click();
            wait(3);
            driver.findElement(By.xpath("//p[contains(text(),'Wallet')]")).click();
            wait(3);
            driver.findElement(By.xpath("//p[contains(text(),'OPEN WALLET')]")).click();
            wait(3);
            driver.findElement(By.xpath("//input[@value='privatekey']")).click();
            wait(3);
            driver.findElement(By.xpath("//input[@id='textField-owpk-private-key']")).sendKeys(account.getEmail());
            wait(3);
            driver.findElement(By.xpath("//p[contains(text(),'UNLOCK')]")).click();
            wait(3);
            driver.findElement(By.xpath("//p[contains(text(),'GO TO WALLET')]")).click();
            wait(3);
            driver.findElement(By.xpath("//p[contains(text(),'NEW WALLET')]")).click();
            wait(3);
            }
        }
            Set<org.openqa.selenium.Cookie> chromeCookies = driver.manage().getCookies();
            List<Cookie> userCookies = new ArrayList<>();

            for (org.openqa.selenium.Cookie c : chromeCookies) {
                if (c.getDomain().equals(".https://neotracker.io/wallet")) {
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
        } 
        
    }
    
 
 
