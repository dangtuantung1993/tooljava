/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keke.test;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import presearchtools.PreSearchTools;
import static presearchtools.PreSearchTools.getProxy;
import static presearchtools.PreSearchTools.isLogged;
import presearchtools.models.Account;

/**
 *
 * @author JMango
 */
public class Producer implements Runnable {

    private BlockingQueue<Account> queue;

    public Producer(BlockingQueue<Account> q) {
        this.queue = q;
    }

    @Override
    public void run() {

        try {
            //produce messages
            List<Account> accounts = PreSearchTools.getAccounts();

            for (int i = 0; i < accounts.size(); i++) {
                Account account = accounts.get(i);

                String proxy = getProxy();

                if (account.isUsingProxy()) {
                    proxy = account.getProxy();
                }

                if (isLogged(account)) {
                    continue;
                }
                queue.put(account);
                System.out.println("Put " + account.getUsername() + " to queue");
            }
            queue.put(new Account("pxson2903@gmail.com", "123", "123.123.123.123"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        int chromeInstanceCount = 4;
        Map<String, String> params = extractParam(args);
        if (params.containsKey("path")) {
            PreSearchTools.execPath = params.get("path");
            File file = new File(PreSearchTools.execPath);
            if (!file.exists()) {
                System.out.println("Error: Chrome Driver file doesn't exist");
                System.exit(0);
            }
        }
        if (params.containsKey("instance")) {
            try {
                chromeInstanceCount = Integer.parseInt(params.get("instance"));
                System.out.println("Num of instances from params " + chromeInstanceCount);
            } catch (Exception e) {
                System.out.println("Error: Instance count must be a number");
                System.exit(0);
            }
        }
        if(params.containsKey("user") && params.containsKey("pass")) {
            PreSearchTools.vpn_user = params.get("user");
            PreSearchTools.vpn_pass = params.get("pass");
        }
        
        System.out.println("Num of instances will start " + chromeInstanceCount);

        //Creating BlockingQueue of size chromeInstanceCount
        BlockingQueue<Account> queue = new ArrayBlockingQueue<>(chromeInstanceCount);
        Producer producer = new Producer(queue);
        new Thread(producer).start();
        for (int i = 0; i < chromeInstanceCount; i++) {
            Consumer consumer = new Consumer(queue);
            new Thread(consumer).start();
        }
    }

    public static Map<String, String> extractParam(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (String arg : args) {
            String[] split = arg.split("=");
            String key = split[0];
            String value = split[1];
            map.put(key, value);
        }
        return map;
    }
}
