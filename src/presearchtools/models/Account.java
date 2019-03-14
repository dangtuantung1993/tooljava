/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearchtools.models;

import com.keke.utils.UserAgentGenerator;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author JMango
 */
public class Account {
    private String username;
    private String email;
    private String password;
    private String userAgent;
    private String proxy;
    
    public Account(String email, String password, String proxy, String userAgent ) {
        this.password = password;
        this.email = email;
        
        this.username = email.substring(0);
        this.userAgent = userAgent;
        this.proxy = proxy;
        
    }

    public Account(String email, String password, String proxy) throws IOException {
        this.password = password;
        this.email = email;
        this.proxy = proxy;
        int index = email.indexOf('@');
        this.username = email.substring(0,index);
        this.userAgent = UserAgentGenerator.generate();
       
    }

    public Account(List<String> lines, String vannhuthe1, String nl98nordvpncom, String mozilla50_Windows_NT_61_WOW64_rv400_Gecko) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPassword() {
        return password;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }
    
    public boolean isUsingProxy() {
        return proxy != null && !proxy.isEmpty();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    
}
