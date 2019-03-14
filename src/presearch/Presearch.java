/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author TDG
 */
public class Presearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(10);
 
        
        list.add(123);
        list.add(245);
        list.add(new Integer(345));
 
        
        list.add(null);
 
       
        System.out.println("Size:" + list.size());
 
        
        Integer i = list.get(1);
        System.out.println("Element index 1 =" + i);
        Integer newInt = 1000;
 
        
        Integer old = list.set(1, newInt);
        // 
        System.out.println("Old value:" + old);
        System.out.println("New value:" + list.get(1));
    
               
    }
     
      
    
}
