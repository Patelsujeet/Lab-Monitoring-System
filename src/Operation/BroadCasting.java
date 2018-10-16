/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;


import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.*;
import AllThreads.FileTranferThread;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JOptionPane;
import lms.*;
/**
 *
 * @author HP
 */
public class BroadCasting extends JPanel
{
    JLabel title,lchoosefile;
    JFrame bro;
    
    fileSelection f1;
    
    JButton bsubmit;
    JPanel pwhole,ptitle,pfilechooser;
    
    DatagramSocket dgs;
    DatagramPacket dgp;
    
    
    public BroadCasting(HashMap connectedUser) 
    {
        bro=new JFrame();
        
        pwhole=new JPanel(new BorderLayout());
        
        ptitle=new JPanel(new BorderLayout());
        
        title=new JLabel("BroadCasting",JLabel.CENTER);
        title.setForeground(Validation.fontColor());
        title.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        ptitle.add(title);
        
        pfilechooser=new JPanel(new GridBagLayout());
        
        GridBagConstraints gbs1=new GridBagConstraints();
                
        lchoosefile=new JLabel("Choose File");
        lchoosefile.setForeground(Validation.fontColor());
        
        pfilechooser.add(lchoosefile,gbs1);
        lchoosefile.setFont(new Font("Times New Roman",Font.BOLD,20));
        gbs1.gridx=1;
        gbs1.gridy=0;
        f1=new fileSelection();
        pfilechooser.add(f1,gbs1);
        
        gbs1.gridx=1;
        gbs1.gridy=3;
        gbs1.gridwidth=2;
        bsubmit=new JButton("SEND");
        pfilechooser.add(bsubmit,gbs1);
/*-----------------------------------------------------------------------------*/        
        pwhole.add(ptitle,BorderLayout.NORTH);
        pwhole.add(pfilechooser,BorderLayout.CENTER);

/*-------------------*Add Action Litioner-------------------------*/
    bsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    System.out.println("dosbroad");
                    if(!connectedUser.isEmpty())
                    {
                        Set data=connectedUser.entrySet();
                        Iterator utr=data.iterator();
                        FileTranferThread thread;
                        System.err.println(data.size());

                        while(utr.hasNext())
                        {
                            Map.Entry datar1=(Map.Entry)utr.next();
                            Socket sc=(Socket)datar1.getValue();
                            System.err.println(sc.getPort());
                            System.err.println("Hello");

                            File f=new File(f1.fd.getDirectory()+f1.fd.getFile());

                            thread=new FileTranferThread(sc,f,bsubmit);

                            bsubmit.setEnabled(false);
                            thread.start();


                        }
                        
                    }   
                    else if(connectedUser.isEmpty())
                    {
                        JOptionPane.showMessageDialog(f1.tchoose1,"User Is Not Connected","User Connection Error",JOptionPane.ERROR_MESSAGE);
                        
                    }
                    
                }
                catch(NullPointerException ne)
                {
                    JOptionPane.showMessageDialog(f1.tchoose1,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
                } 
                catch(Exception ae)
                {
                    JOptionPane.showMessageDialog(f1.tchoose1,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
                }                      
            }
        });

        add(pwhole);
        
        
    }
    /*
    public static void main(String []args)
    {
        new BroadCasting();
    }
    */
class fileSelection extends JPanel
{   
    FileDialog fd;
    JTextField tchoose1;
    
    JButton bBrowse;
    JPanel pfileSelection;
    
    
    public fileSelection() 
    {
        pfileSelection=new JPanel(new GridBagLayout());
        
        GridBagConstraints gbs=new GridBagConstraints();
        
        tchoose1=new JTextField(35);
        bBrowse=new JButton("BROWSE");
        
        gbs.gridx=0;
        gbs.gridy=0;
        gbs.ipadx=7;
        gbs.ipady=7;
        pfileSelection.add(tchoose1,gbs);
        
        gbs.gridx=1;
        gbs.gridy=0;
        gbs.insets=new Insets(0,5,0,0);
        pfileSelection.add(bBrowse,gbs);
    
        add(pfileSelection);
        
        bBrowse.addActionListener(new ActionListener()
        {
            @Override
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                System.out.println("Browse");
                fd=new FileDialog(new Dialog(fd));
                fd.show();

                tchoose1.setText(fd.getDirectory()+fd.getFile());
                }
                catch(NullPointerException nes)
                {
                    JOptionPane.showMessageDialog(tchoose1,"Please Again Click On BroadCasting");
                }
                catch(java.lang.InternalError ne)
                {
                    JOptionPane.showMessageDialog(tchoose1,"Please Again Click On BroadCasting","System Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        tchoose1.addFocusListener(new FocusAdapter()
        {
            @SuppressWarnings("deprecation")
            public void focusGained(FocusEvent fe)
            {
                fd=new FileDialog(new Dialog(fd));
                fd.show();
                tchoose1.setText(fd.getDirectory()+fd.getFile());                   
            }
        });
           
    }       
}
}
