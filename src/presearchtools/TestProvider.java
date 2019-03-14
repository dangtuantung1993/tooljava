/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearchtools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author JMango
 */
public class TestProvider {
    
    public static void main(String[] args) throws IOException {  
        String[] categories = new String[]{"all", "furniture","github", "art","address", "book", "company", "crypto", "imdb","animal","politic","player","city", "movie", "people", "product", "question", "song", "domain", "hotel"};
        List<String> categoriesList = Arrays.asList(categories);
        // Check files
        for(String fileName : categoriesList) {
            File file = new File("keyword/" + fileName + ".txt");
            if(fileName.equalsIgnoreCase("all")) continue;
            if(!file.exists()) {
                System.out.println(fileName);
            }
        }
        
        
        File file =new File("provider.txt");
        List<String> providers = FileUtils.readLines(file, "utf-8");
        for(String provider: providers) {
            String[] arrs = provider.split(",");
            if(arrs.length < 2) {
                System.out.println(provider);
            }
            String p = arrs[0];
            String cat = arrs[1];
            if(!categoriesList.contains(cat)) {
                System.out.println(p);
            }
        }
    }
    
}
