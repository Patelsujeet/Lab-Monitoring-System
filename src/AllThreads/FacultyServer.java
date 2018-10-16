/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllThreads;

import Operation.Monitoring;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacultyServer extends UserNameThread implements Runnable
{

    Socket sc;
    
    Set users;
    Iterator it;
    
    HashMap<String,Socket> connectedUserName;
    HashMap<String,Socket> newlist;
    
    public FacultyServer()
    {
        try
        {    
            
//        sp=ServerPort.getInstance();
        connectedUserName=(HashMap<String, Socket>) listOfConnectedUsers;
        
        users=connectedUserName.entrySet();
        it=users.iterator();
        
        newlist=new HashMap<>();
        System.out.println("Size01"+connectedUserName.size());
        start();
     
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }
    
    public void run()
    {
        try
        {
            System.out.println("Faculty Server Thread");
            System.out.println("Size"+connectedUserName.size());
            while(it.hasNext())
            {
                System.out.println("Faculty Server Thread with While Loop");
                System.out.println("User Connecteds");
                Map.Entry map=(Map.Entry)it.next();
                newlist.put(map.getKey().toString(), sc);
                
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public HashMap getList()
    {
        return newlist;
    }
}
