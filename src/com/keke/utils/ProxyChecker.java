/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keke.utils;

import com.google.gson.Gson;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * "The real danger is not that computers will begin to think like men, but that
 * men will begin to think like computers." – Sydney Harris Created on
 * 10/31/2015
 *
 * @author Galkon
 */
public class ProxyChecker {

    /**
     * The User Agent
     */
    private static final String AGENT = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";

    /**
     * Used to store the proxy settings
     */
    private Proxy proxy;

    /**
     *
     * Method used to add proxy settings
     *
     * @param ip the proxy IP
     * @param port the proxy port
     */
    public void setProxy(String ip, int port) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
    }

    /**
     *
     * Method used to add proxy settings with authentication
     *
     * @param ip
     * @param port
     * @param username
     * @param password
     */
    public void setProxy(String ip, int port, String username, String password) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
        Authenticator authenticator = new Authenticator() {

            public PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication(username, password.toCharArray()));
            }
        };
        Authenticator.setDefault(authenticator);
        System.setProperty("http.proxyHost", ip);
        System.setProperty("http.proxyPort", Integer.toString(port));
    }

    /**
     * The method will return the content in a {@link InputStream} object
     *
     * @param domain The Domain name
     *
     * @return the content as {@link InputStream} object
     * @throws Exception
     */
    private InputStream getContent(String domain) throws Exception {

        URL url = new URL(domain);
        URLConnection connection = null;
        if (this.proxy != null) {
            connection = url.openConnection(this.proxy);
        } else {
            connection = url.openConnection();
        }

        connection.setRequestProperty("User-Agent", AGENT);
        return connection.getInputStream();
    }

    /**
     * Method used to get URL content in {@link String} format
     *
     * @param domain the {@link String} the URL
     * @return the {@link String} object returned
     * @throws Exception
     */
    public String getString(String domain) throws Exception {
        InputStream is = getContent(domain);
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**
             * finally block to close the {@link BufferedReader}
             */
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("URLConnection with Proxy Example");
        System.out.println();

        String url = "http://www.whatsmyip.org/";

        ProxyChecker con = new ProxyChecker();

        /**
         * activate this line if you are behind a proxy server - change the
         * settings accordingly
         */
        con.setProxy("al1.nordvpn.com", 80, "pxson.2903@gmail.com", "Sa@069823418");

        /**
         * activate this line if you are behind a proxy server with
         * authentication - change the settings accordingly
         */
        // con.setProxy("127.0.0.1", 7000, "user", "passowrd");
        String result = con.getString(url);

        System.out.println("URL: " + url);
        System.out.println();
        System.out.println(getIP(result));
    }
    
    public static boolean isValidVPN(String vpn) throws IOException, Exception {
        String url = "http://www.whatsmyip.org/";

        ProxyChecker con = new ProxyChecker();
        con.setProxy(vpn, 80, "pxson.2903@gmail.com", "Sa@069823418");
        String result = con.getString(url);
        String ip = getIP(result);
        if(ip.isEmpty()) {
            return false;
        }
        
        System.out.println(vpn + "|" + ip);
        return true;
    }

    public static String getIP(String content) throws IOException {
        String pattern = 
        "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";


        Pattern r = Pattern.compile(pattern);

        String verificationCode = "";

        Matcher m = r.matcher(content);
        
        new Gson().toJson(m);
            
        if (m.find()) {
            verificationCode = m.group();
        }
        return verificationCode;
    }
}
