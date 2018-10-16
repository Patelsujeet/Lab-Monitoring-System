/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 *
 * @author HP
 */
public class ServerAddress
{
    String address;

    public ServerAddress() 
    {
       
     try
     {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) 
        {
            NetworkInterface networkInterface = interfaces.nextElement();
       
            if (!networkInterface.isUp())
            {
                continue;
            }

            // smth we can explore
            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
            int i=0;
            while(addresses.hasMoreElements()) 
            {
                InetAddress addr = addresses.nextElement();
                if(networkInterface.getDisplayName().endsWith("Wi-Fi Adapter")==true)
                {
                    address=addr.getHostAddress();
                }
                break;
            }
        }
     }  
     catch(Exception ex)
    {
        ex.printStackTrace();
    }         
    }
    
    public String getServerAddress()
    {
        return address;
    }
}
