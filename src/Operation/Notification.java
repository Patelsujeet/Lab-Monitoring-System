/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import java.awt.Desktop;
import java.util.*;
import java.io.*;
import java.net.URI;

/**
 *
 * @author HP
 */
public class Notification
{

    String dir="F://LMS";
    File file;
    Desktop desktop;
    public Notification() 
    {
        file=new File(dir);
        desktop=Desktop.getDesktop();
        
        try
        {
            desktop.browse(URI.create(dir));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
