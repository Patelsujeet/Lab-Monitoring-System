/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllThreads;

import java.awt.Component;
import java.io.DataInputStream;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author HP
 */
public class Receiving extends Thread
{
    DataInputStream dis;
    JTextArea jtext;
    
    Component component;
    public Receiving(DataInputStream dis,JTextArea jtext) 
    {
        this.dis=dis;
        this.jtext=jtext;
        this.component=component;
    }
    
    @Override
    public void run() {
        try{
            while(true){
                
                String msg = dis.readUTF();
                jtext.append("\n"+msg+"\n");
                
            }
        }
        catch (Exception ex)
        {
           
            System.out.println(ex);
        }
    }
}

