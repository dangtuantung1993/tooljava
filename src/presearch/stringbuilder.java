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
public class stringbuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Adamkhoo di day học");
        StringBuffer buffer = new StringBuffer("Phong cach adamkhoo");
        
        builder.append(" 2018");
        System.out.println(builder);
        builder.deleteCharAt(6);
        System.out.println(builder);
        builder.delete(6,9);
        System.out.println(builder);
        builder.insert(5,"hung");
        System.out.println(builder);
        builder.reverse();
        System.out.println(builder);
    }
    
}