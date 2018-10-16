/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllThreads;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author HP
 */
public class ShutDownThread extends Thread
{
    Socket sc;
    String operation;
    public ShutDownThread(Socket sc,String operation)
    {
        this.sc=sc;
        this.operation=operation;
    }
    
    public void run()
    {
        try
        {     
            OutputStream os=sc.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            
            dos.writeUTF(operation);
            
            os.flush();
            dos.flush();
        }   
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
}
