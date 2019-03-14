/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keke.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author JMango
 */
public class UserAgentGenerator {
    public static void main(String[] args) throws IOException {
        
        System.out.println(UserAgentGenerator.generate());
       
    }
    
    public static String generate() throws IOException {
        File agentFile = new File("user_agent.txt");
        
        List<String> listAgents = FileUtils.readLines(agentFile, "utf-8");
        
        int pos = randInt(0, listAgents.size()-1);
        
        return listAgents.get(pos);
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
