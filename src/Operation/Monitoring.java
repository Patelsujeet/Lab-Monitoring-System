/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import ScreenSharing.*;
import AllThreads.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.sql.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;
import lms.*;
import Operation.*;
/**
 *
 * @author HP
 */
public class Monitoring extends JPanel implements ActionListener,MouseListener
{

    JPopupMenu jpopMenu;
    JMenuItem m1,m3,m4,m5,mdetails;

    JPanel pleft;
    JPanel pfotterpanel,pCenterPanel,pleftsidePanel;
    JPanel pUserDetails;
    
    JButton bconnectedComp[];
  
    DBConnection db;
    ResultSet rs;
    ViewDetails vw;
  
    GridBagConstraints gbs;
    Font buttonFont; 

    Socket s;    
    Set collectionofConnectedUsers;
    Iterator iteratorForRetriveUsers;
    Map.Entry retrieveData;
    
    HashMap<String,Socket> ls;
    HashMap<String,Socket> ls1,listForShutDown;
    HashMap<String,Socket> listForScreenSharing;
    
    int port=12345;
    
    String operationName;
    public String selectedUser;

    JRightSidePanel rightSidePanel;
    
    public Monitoring(HashMap connectedUserList,HashMap forChatting,HashMap forShutdown,HashMap listForScreenSharing) 
    {
        this.ls=connectedUserList;
        this.ls1=forChatting;
        
        this.listForShutDown=forShutdown;
        this.listForScreenSharing=listForScreenSharing;
        
        buttonFont=new Font("Times New Roman",Font.BOLD,15);
        bconnectedComp=new JButton[connectedUserList.size()];
        
        db=new DBConnection(this);
        vw=new ViewDetails("student");
        
        
        pleft=new JPanel(new BorderLayout());
        pfotterpanel=new JPanel(new GridBagLayout());
        pCenterPanel=new JPanel(new GridBagLayout());     
        pleftsidePanel=new JPanel(new BorderLayout());
        pUserDetails=new JPanel(new GridLayout(8,1));
        
        rightSidePanel=new JRightSidePanel();
        gbs=new GridBagConstraints();
        
        int x=0;    
        int i=0;
        int y=0;
        collectionofConnectedUsers=connectedUserList.entrySet();
        iteratorForRetriveUsers=collectionofConnectedUsers.iterator();
  
        if(connectedUserList.isEmpty())
        {
            JOptionPane.showMessageDialog(pCenterPanel, "User Is Not Connected???", "User Connection",JOptionPane.ERROR_MESSAGE);
        }
        
        while(iteratorForRetriveUsers.hasNext())
        {
            retrieveData=(Map.Entry)iteratorForRetriveUsers.next();
            s=(Socket)retrieveData.getValue();

            jpopMenu=new JPopupMenu("Edit");
                        
            m1=new JMenuItem("Chatting");

            m3=new JMenuItem("ShutDown");
            m4=new JMenuItem("Restart");
            m5=new JMenuItem("Live Streaming");
            mdetails=new JMenuItem("View Details");
                    
                jpopMenu.add(m1);

                jpopMenu.add(m3);
                jpopMenu.add(m4);
                jpopMenu.add(m5);
                jpopMenu.add(mdetails);
          
            bconnectedComp[i]=new JButton(retrieveData.getKey().toString(),new ImageIcon(getClass().getResource("/ImageIcons/computer.png")));
            
            gbs.gridx=x;
            gbs.gridy=y;
            gbs.insets=new Insets(0,5,5,5);
            pCenterPanel.add(bconnectedComp[i],gbs);
            
            bconnectedComp[i].addActionListener(this);
            bconnectedComp[i].addMouseListener(this);
           
            m1.addActionListener(this);

            m3.addActionListener(this);
            m4.addActionListener(this);
            m5.addActionListener(this);
            mdetails.addActionListener(this);
            
            
            
            x++;
            i++;
            if(x>=4)
            {
                x=0;
                y++;
            }
            
        }
    
/*---------------Add Whole panel to main Panel--------------------------------------*/                




    pleft.add(pCenterPanel,BorderLayout.NORTH);

    
    setLayout(new BorderLayout());
    add(pleft,BorderLayout.WEST);
/*----------------------------Add Action Events-----------------------------------*/   
}
/*  
    public static void main(String []ar)
    {
        new Monitoring(null);
    }
*/

    @Override
    public void actionPerformed(ActionEvent e)
    {
        selectedOperation(e);
    }

    
    @Override
    public void mousePressed(MouseEvent e) 
    {
        selectUser(e);
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) 
    {
        selectUser(e);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
    public void selectUser(MouseEvent e)
    {
        JButton action=(JButton)e.getSource();

        String selectedButton=action.getText();
        String userInList;
        
        
        Set setforuser=ls.entrySet();
        Iterator itr=setforuser.iterator();
        
        while(itr.hasNext())
        {
            Map.Entry data=(Map.Entry)itr.next();
            userInList=data.getKey().toString();
            
            
            if(selectedButton.equalsIgnoreCase(userInList))
            {    
                System.out.println("Selected user"+selectedButton);      
                selectedUser=selectedButton;
                
                showPop(e);
            }
        }   
        
    }
    
    public String getSelectedUser()
    {
        return selectedUser;
    }
    
    public void showPop(MouseEvent e)
    {
        if(SwingUtilities.isRightMouseButton(e))
        {
            jpopMenu.show(e.getComponent(),e.getX(),e.getY());
        }   
    }
    
    public void selectedOperation(ActionEvent actionevent)
    {
        operationName=actionevent.getActionCommand();
        
        
        if(operationName.equalsIgnoreCase("View Details"))
        {
            try
            {
                rs=db.getUserDetailsForProfile("student","enrollment",getSelectedUser());
               
                pUserDetails.setBackground(Color.ORANGE);
                pUserDetails.removeAll();
                rightSidePanel.removeAll();
                while(rs.next())
                {
                    
                    pUserDetails.add(new JLabel("Student Details",JLabel.CENTER)).setFont(new Font("Verdana", Font.BOLD, 30));
                    pUserDetails.add(new JLabel("Name:- "+rs.getString(2))).setFont(new Font("Verdana", Font.BOLD, 15));
                    pUserDetails.add(new JLabel("Enrollment No.:- "+rs.getString(1))).setFont(new Font("Verdana", Font.BOLD, 15));
                    pUserDetails.add(new JLabel("Semester:- "+rs.getString(3))).setFont(new Font("Verdana", Font.BOLD,15));
                    pUserDetails.add(new JLabel("Branch:- "+rs.getString(4))).setFont(new Font("Verdana", Font.BOLD, 15));
                    pUserDetails.add(new JLabel("Password:- "+rs.getString(5))).setFont(new Font("Verdana", Font.BOLD, 15));
                    pUserDetails.add(new JLabel("Mobile Number:- "+rs.getString(6))).setFont(new Font("Verdana", Font.BOLD, 15));
                    pUserDetails.add(new JLabel("Email-Id:- "+rs.getString(7))).setFont(new Font("Verdana", Font.BOLD, 15));
                   
                    System.out.println("Student"+rs.getString(2));                          
                }
              
              rightSidePanel.add(pUserDetails);
              Validation.refreshPanel(rightSidePanel);
              
              add(rightSidePanel,BorderLayout.EAST);
              Validation.refreshPanel(this);
        
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }            
        }   
        else if(operationName.equalsIgnoreCase("Chatting"))
        {
         
            Set st=ls1.entrySet();
            Iterator it=st.iterator();
            while(it.hasNext())
            {
                Map.Entry map=(Map.Entry) it.next();
                String data=(String)map.getKey();
                Socket sc=(Socket)map.getValue();
                if(getSelectedUser().equals(data))
                {
                    
                    try
                    {
                        DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
                        DataInputStream dis=new DataInputStream(sc.getInputStream());
                        
                        Chatting ch=new Chatting(data,dos,dis);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }    
        }
        else if(operationName.equalsIgnoreCase("shutdown"))
        {
            operation("shutdown");
        }
        else if(operationName.equalsIgnoreCase("restart"))
        {
            operation("restart");
        }
        else if(operationName.equalsIgnoreCase("Live Streaming"))
        {
            Set st=listForScreenSharing.entrySet();
            Iterator itr=st.iterator();
            while(itr.hasNext())
            {
                Map.Entry map=(Map.Entry)itr.next();
                String user=map.getKey().toString();
                Socket sc=(Socket)map.getValue();
                if(getSelectedUser().equalsIgnoreCase(user))
                {
                    //System.out.println("USer Is Selected FOr ScreenSharing");
                   
                    ScreenSharingFrame ss=new ScreenSharingFrame(user,sc);
                    Thread th=new Thread(ss);
                    th.start();
                }
            }
        }
    }
   
    
    public void operation(String op)
    {
        Set set=listForShutDown.entrySet();
        Iterator itr=set.iterator();
        while(itr.hasNext())
        {
            Map.Entry map=(Map.Entry)itr.next();
            String user=(String)map.getKey();
            Socket sc=(Socket)map.getValue();
            if(getSelectedUser().equals(user))
              {
                  System.out.println("Shut Selected user"+user);
                  ShutDownThread st=new ShutDownThread(sc,op);
                  st.start();
              } 
        }       
    }

}