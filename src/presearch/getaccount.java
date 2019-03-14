/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import presearchtools.models.Account;

/**
 *
 * @author TDG
 */
public class getaccount {
    public static void main(String[] args) {
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
            
            String userAgent = null;
            
            if (accParts.length == 4) {
                userAgent = accParts[3].replaceAll("|||", ",");
            }
            accounts.add(new Account(email, password, userAgent));
            
        }System.out.println(accounts);
        return accounts;
        
    }

    }
    

