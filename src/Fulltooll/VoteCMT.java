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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class VoteCMT {

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
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
        ChromeOptions options = new ChromeOptions();
	options.setBinary("C:/Users/laptop MD/AppData/Local/CocCoc/Browser/Application/browser.exe");
//        options.setBinary("C:/Users/admin/AppData/Local/CocCoc/Browser/Application/browser.exe");
//        if (account.getUserAgent() != null && !account.getUserAgent().isEmpty()) {
//            options.addArguments("--user-agent=" + account.getUserAgent());
//        }

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
                File Mail = new File("Mail.txt");
                driver.manage().window().maximize();

                ((JavascriptExecutor)driver).executeScript("window.open()");
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(0));
                driver.get("https://mail.bhadoomail.com/");
                wait(3);
                driver.findElement(By.xpath("//a[contains(text(),'Shared Hosting Server')]")).click();
                driver.switchTo().window(tabs.get(1));
                driver.get("https://clearfoundation.co.nz/invite/13368");
                wait(3);
                driver.findElement(By.xpath("//a[contains(text(),'Get CLEAR Tokens')]")).click();
                wait(5);
                driver.findElement(By.xpath("//a[contains(text(),'Or Register')]")).click();
                wait(1);
                driver.switchTo().window(tabs.get(0));
                String mail1 = driver.findElement(By.xpath("//span[@id='my-address']")).getText();
                wait(3);
                FileUtils.writeStringToFile(Mail, mail1 + "\n", "UTF-8", true);
                driver.switchTo().window(tabs.get(1));
                driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(mail1);
                wait(2);
                driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(mail1);
                wait(1);
                driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(mail1);
                wait(60);
                driver.switchTo().window(tabs.get(0));
                wait(40);
                driver.findElement(By.xpath("//p[@class='list-group-item-text text-truncate']")).click();
                wait(1);
                driver.findElement(By.xpath("//a[contains(text(),'Confirm Account')]")).click();
                wait(1);
        }
    
    

    



    
    }


