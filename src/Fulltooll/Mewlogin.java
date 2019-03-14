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
import java.lang.reflect.Array;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.Arrays;
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
public class Mewlogin {

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

     WebDriver driver = new ChromeDriver(options);


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
        File PrivateKey = new File("PrivateKey.txt");
        String data = FileUtils.readFileToString(PrivateKey, "UTF-8");
        String [] arr = data.trim().split(" ");
        driver.get("https://www.myetherwallet.com/#view-wallet-info");
         wait(5);
        for (int i = 0; i <  arr.length;i++){
            try {
                
                driver.findElement(By.xpath("//img[@title='Close']")).click();
                wait(7);
                driver.findElement(By.xpath("//input[@value='pasteprivkey']")).click();
                wait(5);
                driver.findElement(By.xpath("//textarea[@id='aria6']")).sendKeys(arr[i]);
                wait(10);

                driver.findElement(By.xpath("//a[@class='btn btn-primary ng-scope']")).click();
                wait(10);
                refresh();
            } catch (Exception e) {
                
            }
        }

    }

}
