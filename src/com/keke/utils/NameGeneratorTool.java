package com.keke.utils;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.ajbrown.namemachine.NameGenerator;
import org.apache.commons.io.FileUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JMango
 */
public class NameGeneratorTool {
    
    public static void main(String[] args) throws IOException {
        NameGenerator generator = new NameGenerator();
        
        File nameGeneratorFiles = new File("bitpack_username.txt");
        if(!nameGeneratorFiles.exists()) {
            nameGeneratorFiles.createNewFile();
        }
        
        File githubAccountFile = new File("bitpack_accounts.txt");
        if(!githubAccountFile.exists()) {
            githubAccountFile.createNewFile();
        }
    
        List<String> nickNames = FileUtils.readLines(nameGeneratorFiles, "utf-8");
        List<String> githubAccounts = new ArrayList<String>();
        
        int count = 0;
        
        while(count < 50) {
            String nickName = generator.generateName().getFirstName().toLowerCase() + generator.generateName().getLastName().toLowerCase() + randInt(1000, 9999);

            if(!nickNames.contains(nickName)) {
                nickNames.add(nickName);
            }
            
            String email = nickName + "@bhadoo.net";
            String userAgent = UserAgentGenerator.generate();
            String password = "Sa123456";
            
            githubAccounts.add("\"" + nickName + "\",\"" + email + "\",\"" + password + "\",\"" + userAgent + "\"");
            count++;
        }
        
        
        FileUtils.writeLines(nameGeneratorFiles, nickNames, "\n", false);
        FileUtils.writeLines(githubAccountFile, githubAccounts, "\n", true);
    }
    
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
