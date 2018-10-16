/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllThreads;

import java.awt.Component;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class UserNameThread extends Thread
{

    public DataOutputStream dos;
    public DataInputStream dis;
    public Socket socket;
    
    public Socket socketForChatting,socketforShutDown,socketForScreenSharing;
    
    ServerSocket ssForUSerNAme;
    ServerSocket ssForChatting,ssForShutDownAndThread;
    
    ServerSocket ssForScreenSharing;
    
    public Map<String,Socket> listOfConnectedUsers;
    public Map<String,Socket> listforChatting;
    public Map<String,Socket> listForShutDownAndRestart;
    public Map<String,Socket> listForScreenSharing;
       
    String userid;
    
    Component parent;
    public UserNameThread()
    {
        this("ABC",null);
    }
    public UserNameThread(String userid,Component parent) 
    {
        listOfConnectedUsers=new HashMap<String,Socket>();    
        this.userid=userid;
        this.parent=parent;
        
        listforChatting=new HashMap<>();
        listForShutDownAndRestart=new HashMap<>();
        listForScreenSharing=new HashMap<>();
    }
    

    public void run() 
    {
        try
        {   
            
            ssForUSerNAme=new ServerSocket(9979);
            ssForChatting=new ServerSocket(9574);
            
            ssForShutDownAndThread=new ServerSocket(5155);
            ssForScreenSharing=new ServerSocket(7047);
            
            while(true)
            {                
                socket=ssForUSerNAme.accept();                
                socketForChatting=ssForChatting.accept();
                
                socketforShutDown=ssForShutDownAndThread.accept();
                socketForScreenSharing=ssForScreenSharing.accept();
                
                dis=new DataInputStream(socket.getInputStream());

                dos=new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(userid);

                String enrollmentNumber = dis.readUTF();
                    
                
                listOfConnectedUsers.put(enrollmentNumber,socket);
                listforChatting.put(enrollmentNumber,socketForChatting);
                listForShutDownAndRestart.put(enrollmentNumber,socketforShutDown);
                listForScreenSharing.put(enrollmentNumber,socketForScreenSharing);
                
                System.out.println(enrollmentNumber);
                
            }    
        }
        catch(SocketException sc)
        {
            JOptionPane.showMessageDialog(parent,"Port Number is already Busy","Socket Error",JOptionPane.ERROR);
        }
        catch(IOException xe)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }    

    public HashMap getConnectedUser()
    {
        return  (HashMap) listOfConnectedUsers;
    }
    
    public HashMap getList()
    {
        return (HashMap)listforChatting;
    }
    
    public HashMap getListForShutDown()
    {
        return (HashMap)listForShutDownAndRestart;
    }
    public HashMap getListForScreenSharing()
    {
        return (HashMap)listForScreenSharing;
    }
}