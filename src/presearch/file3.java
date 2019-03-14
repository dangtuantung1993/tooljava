/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TDG
 */
public class file3 {
    public static void main(String[] args) throws MalformedURLException, IOException {
        InputStream in = new URL("https://stackjava.com").openStream();
try {
  InputStreamReader inR = new InputStreamReader(in);
  BufferedReader buf = new BufferedReader(inR);
  String line;
        try {
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }     } catch (IOException ex) {
            Logger.getLogger(file3.class.getName()).log(Level.SEVERE, null, ex);
        }
} finally {
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(file3.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }
    
    
}
