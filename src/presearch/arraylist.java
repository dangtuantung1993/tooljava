/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import java.util.ArrayList;

/**
 *
 * @author TDG
 */
public class arraylist {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("hung");
        al.add(new String("Vu"));
        al.add(new Integer("6"));
        al.add(new Long("10"));
        System.out.println(al.get(3));
        al.remove(3);
        System.out.println(al.get(2));
        
        Object [] array = al.toArray();
        System.out.println(array.length + " " + al.size());
        
        for (int i=0;i<al.size();i++)
        {
            System.out.println(al.get(i));
        }
        
    }
    
}
