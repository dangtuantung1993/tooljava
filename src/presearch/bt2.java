/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TDG
 */
public class bt2 {

   public static void main( String args[] ) {
      // String to be scanned to find the pattern.
      StringBuilder builder = new StringBuilder("C:\\Users\\laptop MD\\Downloads\\UTC--2018-10-30T03-11-06.199Z--ce12278929c71fa9ab7ea80cfbd6ebb407d053e3");
      builder.delete(0,60);
      builder.insert(0,"0x");
      System.out.println(builder);
      // Create a Pattern object
     
     
   }
}
    

