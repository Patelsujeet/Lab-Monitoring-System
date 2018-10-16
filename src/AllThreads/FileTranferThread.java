/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllThreads;

import java.io.*;
import java.net.*;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author HP
 */
public class FileTranferThread extends Thread
{
    Socket s;
    ServerSocket ss;
    long fileSize;
    String fileName;
    JButton bsubmit;
    
    String st;
    File f;
    
    byte []data;
    public FileTranferThread(Socket s,File f,JButton jsubmit) throws IOException 
    {
        this.bsubmit = jsubmit;
        this.s=s;
        this.f=f;
    }
    
    @Override
    public void run()
    {        
        try
        {    
            
            FileInputStream fis=new FileInputStream(f);                       
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            
            System.out.println("This File Thread");
            
            byte []fileArray=new byte[4096];

            fileSize=f.length();
            fileName=f.getName();
            
            dos.writeLong(fileSize);
            dos.writeUTF(fileName);
    
            while(fis.read(fileArray)>0)
            {
                dos.write(fileArray);
            }
            
            fis.close();
            bsubmit.setEnabled(true);
            System.out.println(fileName+":"+fileSize);
                        
            dos.flush();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void user()
    {
        System.out.print(st);
    }
}
