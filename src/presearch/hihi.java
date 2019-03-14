/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author TDG
 */
public class hihi {
    
    public static void main(String[] args) {
        Gson gson = new Gson();
       
        int[] ints = { 1, 2, 3, 4, 5 };
        
        String[] strings = { "abc", "def", "ghi" };
        String json = gson.toJson(ints);
        System.out.println(json);
        // Serialization
        gson.toJson(ints); // ==> [1,2,3,4,5]
        gson.toJson(strings); // ==> ["abc", "def", "ghi"]
 
        // Deserialization
        int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class);
        // ==> ints2 will be same as ints
        System.out.println(ints2);
       }

 
}
