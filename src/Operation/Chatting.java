/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import AllThreads.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import lms.*;
import java.net.*;
import java.lang.*;
/**
 *
 * @author HP
 */
public class Chatting extends WindowAdapter
{
    JFrame chattingframe;
    
    JScrollPane mainfieldscrollpane;
    JScrollBar mainFieldScrollbar;
    
    JTextField subField;
    JTextArea mainField;
    JButton bsend;
    
    JPanel p1,pbottompanel;
    
    GridBagConstraints gbs;
    
    
public String serverAddress="localhost";
    
    String input="",output="";
    DataInputStream dis;
    DataOutputStream dos;
    
    Receiving recv;
    
    
    public Chatting(String username,DataOutputStream dos,DataInputStream dis) //throws IOException
    {
        try{
        this.dis=dis;
        this.dos=dos;
               
       chattingframe=new JFrame(username);
        
       mainField=new JTextArea();
       mainField.setFont(new Font("Times New Roman",Font.BOLD,15));
       mainField.setEditable(false);
       mainField.setLineWrap(true);
               
       subField=new JTextField(20);
       subField.setFont(new Font("Times New Roman",Font.BOLD,15)); 
       
       mainfieldscrollpane=new JScrollPane(mainField);
       mainFieldScrollbar=mainfieldscrollpane.getVerticalScrollBar();
       
       
       bsend=new JButton("SEND");
       
       gbs=new GridBagConstraints();
       
       p1=new JPanel();
       pbottompanel=new JPanel(new GridBagLayout());
       
       gbs.gridx=0;
       gbs.gridy=0;
       gbs.weightx=0.8;
       gbs.fill=GridBagConstraints.BOTH;
       pbottompanel.add(subField,gbs);
       
       gbs.gridx=1;
       gbs.gridy=0;
       gbs.weightx=0.2;
       gbs.ipadx=20;
       gbs.ipady=10;
       gbs.fill=GridBagConstraints.BOTH;
       pbottompanel.add(bsend,gbs);
       
      
       chattingframe.add(mainfieldscrollpane,BorderLayout.CENTER);
       chattingframe.add(pbottompanel,BorderLayout.SOUTH);
       
       chattingframe.setVisible(true);
       chattingframe.setSize(350,250);

       chattingframe.setLocationRelativeTo(null);
                      
    
       recv=new Receiving(dis, mainField);
       recv.start();
       
       bsend.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent ae)
           {

            try
              {  

                  output=subField.getText();
                  dos.writeUTF(output);  
                  
                  mainField.append("\n"+output+"\n");
                  subField.setText(" ");

              }    
              catch(Exception e)
              {
                  System.out.println(e);
              }                        
           }
               
       });
        
         chattingframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }   

}
