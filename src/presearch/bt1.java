/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author TDG
 */
public class bt1 {
    public static void main(String[] args) {
       int Array [] = new int[]{1,2,5,9,6,4,8};
        int max =0;int min = Array[1];
        int dem=0;
       for ( int i=0;i<Array.length;i++)
       {
           System.out.println(Array[i]);
           if(Array[i]>max)
           {
              max = Array[i];
           }
           if(Array[i] < min)
           { min= Array[i];
           }
           if((Array[i]%2==0))
           { 
               dem++;
                       }
           
           
            
       }
        System.out.println("max = : " + max);
        System.out.println("min = : " +min);
        System.out.println("dem = :" +dem);
        System.out.println("sap xep ne hihi:");
       Arrays.sort(Array);
       for(int j=0;j<Array.length;j++)
       {
           System.out.print(Array[j]);
       }
       
           
       
      
        
        
        
    }
    
}
