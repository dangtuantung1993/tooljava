/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import com.google.gson.Gson;

/**
 *
 * @author TDG
 */
public class vigson1 {
    public static void main(String[] args) {
        // Serialization
        Gson gson = new Gson();
        gson.toJson(5); // ==> 1
        gson.toJson("abcd");
        gson.toJson("kutephomaique");// ==> "abcd"
        gson.toJson(new Long(10)); // ==> 10
        int[] values = { 1 };
        gson.toJson(values); // ==> [1]
      
        System.out.println(5);
        // Deserialization
        int one = gson.fromJson("1", int.class);// ==> 1
        Integer oneInteger = gson.fromJson("1", Integer.class);// ==> 1
        Long oneLong = gson.fromJson("1", Long.class);// ==> 1
        Boolean bool = gson.fromJson("false", Boolean.class); // ==> false
        String str = gson.fromJson("\"abc\"", String.class);// ==> "abcd"
        String kute = gson.fromJson("\"kutephomaique\"",String.class);
        String[] anotherStr = gson.fromJson("[\"abcd\"]", String[].class);// ==> ["abc"]
        String[] kuteStr = gson.fromJson("[\"kutephomaique\"]",String[].class);//vi tri dau tien
        System.out.println(kuteStr);
        
        
        
        
        
        
    }
    
}
