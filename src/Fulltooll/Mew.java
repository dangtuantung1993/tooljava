/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fulltooll;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import presearchtools.PreSearchTools;
import static presearchtools.PreSearchTools.getAccounts;
import static presearchtools.PreSearchTools.getCookies;
import static presearchtools.PreSearchTools.saveAccounts;
import presearchtools.models.Account;
import presearchtools.models.Cookie;

/**
 *
 * @author TDG
 */
public class Mew {

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

            Account account = new Account("L5ePGtG6bHXrZhycQB7e2YnghkESbGq8GG8ZJM4tvVvmVEJ6VCL1", "vannhuthe1", "nl98.nordvpn.com", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1");

            WebDriver driver = initChrome(account, "nl98.nordvpn.com", 80);
            login(driver, account);

//            saveAccounts(accounts);
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

//       options.addExtensions(new File("Auth.crx"));
//        options.addArguments("--proxy-server=http://" + host + ":" + Integer.toString(port));
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

    public static void login(WebDriver driver, Account account) throws FileNotFoundException, IOException {
        List<Cookie> cookies = getCookies(account.getUsername());
        File PrivateKey = new File("PrivateKeyclear.txt");

        for (int i = 1; i < 100; i++) {
            try {
                driver.get("https://www.myetherwallet.com/#generate-wallet");
                wait(5);
                driver.findElement(By.xpath("//img[@title='Close']")).click();
                wait(10);
                driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/main[1]/article[1]/section[1]/div[1]/input[1]")).sendKeys(account.getPassword());
                wait(10);
                driver.findElement(By.xpath("//a[contains(text(),'Create New Wallet')]")).click();
                wait(10);

                driver.findElement(By.xpath("//span[contains(text(),'Keystore File (UTC / JSON)')]")).click();
                wait(10);
                driver.findElement(By.xpath("//span[contains(text(),'I understand. Continue.')]")).click();
                wait(10);
                String privatekey1 = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/main[1]/article[3]/section[1]/textarea[1]")).getText();
                wait(10);
                FileUtils.writeStringToFile(PrivateKey, privatekey1 + "\n", "UTF-8", true);

                driver.findElement(By.xpath("//span[contains(text(),'Save Your Address.')]")).click();
                wait(10);
                driver.findElement(By.xpath("//a[@class='brand']//img")).click();
                wait(10);
            } catch (Exception ex) {
                ex.printStackTrace();
                
            }
        }

    }

}
