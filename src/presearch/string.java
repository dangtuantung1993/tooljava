/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

/**
 *
 * @author TDG
 */
public class string {
    public static void main(String[] args) {
        String blog = "Vũ kute";
        System.out.println(blog);
        System.out.println(blog.charAt(6));
        System.out.println(blog.indexOf("kute"));
        System.out.println(blog.substring(2,4));
        String vu = " Vũ đẦu tO";
        System.out.println(vu);
        System.out.println(vu.trim());
        System.out.println(vu.toLowerCase());
        System.out.println(vu.toUpperCase());
        String [] arr = vu.trim().split(" ");
            for (int i = 0 ;i < arr.length;i++)
            {
                System.out.println(arr[i]);
            }

    }
    
}
