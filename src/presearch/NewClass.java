/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearch;

import com.example.NordVPN;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author TDG
 */
public class NewClass {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        File vpn = new File("vpn");
      
        String nordvpn = FileUtils.readFileToString(vpn, "UTF-8");

       NordVPN nordvpn1 = gson.fromJson(nordvpn, NordVPN.class);
     
       for(int i=0;i< nordvpn1.getValue().size();i ++)
       {
           if(!nordvpn1.getValue().get(i).getFeatures().getProxy()){
                System.out.println(nordvpn1.getValue().get(i).getIpAddress());
       }
       }
    }
    
}
