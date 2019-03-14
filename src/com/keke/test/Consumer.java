/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keke.test;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import presearchtools.PreSearchTools;
import static presearchtools.PreSearchTools.deleteCookie;
import static presearchtools.PreSearchTools.getProxy;
import static presearchtools.PreSearchTools.initChrome;
import static presearchtools.PreSearchTools.isLogged;
import static presearchtools.PreSearchTools.login;
import static presearchtools.PreSearchTools.run;
import presearchtools.models.Account;

/**
 *
 * @author JMango
 */
public class Consumer implements Runnable {

    private BlockingQueue<Account> queue;

    public Consumer(BlockingQueue<Account> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            Account account;
            //consuming messages until exit message is received
            while ((account = queue.take()) != null) {
                if((account.getUsername().equalsIgnoreCase("pxson2903"))) break;
                System.out.println("");
                System.out.println("Pick " + account.getUsername() + "|" + account.getProxy() + " from queue to handle");
                System.out.println("");
                
                WebDriver driver = PreSearchTools.initChrome(account, account.getProxy(), 80);
                PreSearchTools.login(driver, account);
                PreSearchTools.run(driver, account);
                deleteCookie(driver);
                driver.quit();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
