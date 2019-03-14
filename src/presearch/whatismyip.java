/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import com.example.NordVPN;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
import static presearch.neokute.initChrome;
import static presearch.neokute.login;
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
public class whatismyip {
    static final String ROOT_PATH = "data";
    static final String COOKIE_PATH = "cookie";
    static final String HISTORY_PATH = "history";
    static final String KEYWORD_PATH = "keyword";
    static final String LOG_PATH = "log";

    public static String execPath = "chromedriver.exe";
    
    public static String vpn_user = "pxson.2903@gmail.com";
    public static String vpn_pass = "Sa@069823418";

    static Gson gson = new Gson();
    public static void main(String[] args) throws IOException {
      

        try {
            List<Account> accounts = getAccounts();

            int size = accounts.size();
            int lastTurnSize = size % 6;
            int turn = size / 6;

            Account account = new Account("L5ePGtG6bHXrZhycQB7e2YnghkESbGq8GG8ZJM4tvVvmVEJ6VCL1", "vannhuthe1", "nl98.nordvpn.com", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1");
           
                WebDriver driver = initChrome(account,"ar2.nordvpn.com.tcp443.ovpn", 80);
                login(driver, account);
               
saveAccounts(accounts);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param host
     * @param port
     * @return
     */
    public static WebDriver initChrome(Account account1,String host, int port) throws IOException {
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        File vpn = new File("vpn");
      
        String nordvpn = FileUtils.readFileToString(vpn, "UTF-8");
        NordVPN nordvpn1 = gson.fromJson(nordvpn, NordVPN.class);
        System.setProperty("webdriver.chrome.driver", execPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        Random rand = new Random();

           int  n = rand.nextInt(nordvpn1.getValue().size()-1) + 1;
      
        options.addExtensions(new File("Auth.crx"));
        options.addArguments("--proxy-server=http://" + nordvpn1.getValue().get(n).getDomain() + ":" + Integer.toString(port));

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
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
    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PreSearchTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static void login(WebDriver driver, Account account) throws IOException {
        List<Cookie> cookies = getCookies(account.getUsername());
        if (cookies == null || cookies.isEmpty()) {
            driver.get("https://tideal.com/activations/012fde25ccade52afe96d8b80344286c");
//            deleteCookie();
             wait(2);

           
        }
    }
    
}
 
