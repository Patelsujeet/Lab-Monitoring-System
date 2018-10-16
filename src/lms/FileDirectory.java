/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.io.*;
/**
 *
 * @author HP
 */
public class FileDirectory 
{
    String dir;
    String mkdir="F://LMS//Data//";
    File directory=new File(mkdir);
    
    public FileDirectory() 
    {
        try
        {
        
        
        if(!directory.exists())
        {
             boolean succ=directory.mkdirs();
             dir=directory.getPath();
             System.out.println("created...." + dir);
        }
         
        else
        {
            System.out.println("hellp");
            System.out.println("this directory"+directory.getPath());
            dir = directory.getPath();
        }
               
         
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void setDir(String dir)
    {
        this.dir=dir;
    }
    public String getDirectoryPath()
    {
       return dir;
    }
    
}
