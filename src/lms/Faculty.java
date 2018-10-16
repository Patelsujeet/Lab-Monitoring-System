
package lms;

import AddUsers.*;
import UpdateUsers.*;
import Operation.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import AllThreads.*;    
import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;

public class Faculty extends MouseAdapter implements Cloneable
{
    ServerAddress sa;
    
    String username,userid;
    
    public JFrame jfacultyframe;
    JPanel pLeftSidepanel,plogowithname;
            
    public JPanel pAfterLeftSidePanel,pserverAdress;
    public JPanel pnumberofuser;
    public JPanel pRightSidepanel,pTopButtonPanel,pBottomSidePanel,pCenterPanel;
    JRightSidePanel pRightSidePanel;
    
    JButton bsingleuser,bmultipleuser;
    JButton bProfile,bMonitoring,bRemoveStudent,bAddStudent,bUpdate,bBroadCasting,bNotification;
    JButton blogout,breportgeneration,bviewdetails,bmailing,bshutdownterminals,brestartterminals;
    JButton bhelp,bsettings;
    
    JLabel logo,ltemp;
    JLabel serverAddress;
    
    GridBagLayout gblFaculty;
    GridBagConstraints gbsFaculty,gbs1;
   
    ServerSocket ssForFileTransfer,ssForShutDownAndRestart;
    
    Map<String,Socket> listofConnectedUserForFileTransfer,listofConnectedUserForShutDownAndRestart;
    
    Setting sc;
    
    
    public Faculty() 
    {
        this(null);
    }
    public Faculty(ResultSet rs)
    {
        sa=new ServerAddress();
        sc=new Setting(); 

    username="abcdef";userid="sujeet24051996@gmail.com";
     try
      {
       if(rs.next())
       {
          username=rs.getString(3);
          userid=rs.getString(1);
       }   
      }    
      catch(Exception e)
      {
          e.printStackTrace();
      }
       
        Color bccolor=Color.WHITE;
        Color fccolor=Color.BLACK;
              
        
        gbsFaculty=new GridBagConstraints();
        gbs1=new GridBagConstraints();
        gblFaculty=new GridBagLayout();
        
        jfacultyframe=new JFrame("FACULTY");
        
    /*-------Left Side Panel-----------------*/    
        pLeftSidepanel=new JPanel();
        pLeftSidepanel.setLayout(gblFaculty);
        pLeftSidepanel.setBackground(Color.WHITE);
        
    /*----------------------Right Side Panel-----------------*/
        pRightSidePanel=new JRightSidePanel();
        
    /*-------logo with Panel--------------------*/    
        plogowithname=new JPanel();
        plogowithname.setLayout(gblFaculty);
    
        
        pserverAdress=new JPanel(new BorderLayout());     //server Adress Panel
        
    /*---------center Panel-----------------*/    
        pCenterPanel=new JPanel();
        pCenterPanel.setLayout(new BorderLayout());
        
        
    /*-----------Right side panel------------*/
        pRightSidepanel=new JPanel();
        pRightSidepanel.setLayout(gblFaculty);
        
     
    /*-----------Top Button panel------------*/    
        pTopButtonPanel=new JPanel();
        pTopButtonPanel.setLayout(gblFaculty);
        
    /*-----------Right side Label panel------------*/    
        pBottomSidePanel=new JPanel(new BorderLayout());
        
        pAfterLeftSidePanel=new JPanel(new BorderLayout());
        pnumberofuser=new JPanel(new GridBagLayout());        
    /*------------------Label-----------------*/
        logo=new JLabel(new ImageIcon(getClass().getResource("/ImageIcons/FacultyFrame.jpeg")));
        ltemp=new JLabel("");
      
    /*----------------Button----------------*/  
        bsingleuser=new JButton("Single Student");
        bsingleuser.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 13));
        
        bmultipleuser=new JButton("Multiple Students");
        bmultipleuser.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 13));
       
    
           
    
        bProfile=new JButton("PROFILE",new ImageIcon(getClass().getResource("/ImageIcons/Profile.png")));
        bProfile.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bProfile.setBackground(bccolor);
        bProfile.setForeground(fccolor);
        
        
        bMonitoring=new JButton("MONITORING",new ImageIcon(getClass().getResource("/ImageIcons/Monitoring.png")));
        bMonitoring.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bMonitoring.setBackground(bccolor);
        bMonitoring.setForeground(fccolor);
        
        
        bRemoveStudent=new JButton("REMOVE STUDENT",new ImageIcon(getClass().getResource("/ImageIcons/RemoveUser.png")));
        bRemoveStudent.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bRemoveStudent.setBackground(bccolor);
        bRemoveStudent.setForeground(fccolor);
        
        
        bAddStudent=new JButton("ADD STUDENT",new ImageIcon(getClass().getResource("/ImageIcons/AddUser.png")));
        bAddStudent.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bAddStudent.setBackground(bccolor);
        bAddStudent.setForeground(fccolor);
        
        
        bUpdate=new JButton("UPDATE STUDENT",new ImageIcon(getClass().getResource("/ImageIcons/Update.png")));
        bUpdate.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bUpdate.setBackground(bccolor);
        bUpdate.setForeground(fccolor);
        
        bBroadCasting=new JButton("BROADCASTING",new ImageIcon(getClass().getResource("/ImageIcons/Broadcasting.png")));
        bBroadCasting.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bBroadCasting.setBackground(bccolor);
        bBroadCasting.setForeground(fccolor);
        
        bNotification=new JButton("NOTIFICATION",new ImageIcon(getClass().getResource("/ImageIcons/Notification.png")));
        bNotification.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bNotification.setBackground(bccolor);
        bNotification.setForeground(fccolor);
        
        
        blogout=new JButton("LOGOUT");
        blogout.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        blogout.setBackground(bccolor);
        blogout.setForeground(fccolor);
        
        
        breportgeneration=new JButton("REPORT GENERATION",new ImageIcon(getClass().getResource("/ImageIcons/ReportGeneration.png")));
        breportgeneration.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        breportgeneration.setBackground(bccolor);
        breportgeneration.setForeground(fccolor);
        
        
        bviewdetails=new JButton("VIEW DETAILS",new ImageIcon(getClass().getResource("/ImageIcons/ViewDetails.png")));
        bviewdetails.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bviewdetails.setBackground(bccolor);
        bviewdetails.setForeground(fccolor);
        
        bmailing=new JButton("EMAIL",new ImageIcon(getClass().getResource("/ImageIcons/gmail.png")));
        bmailing.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bmailing.setBackground(bccolor);
        bmailing.setForeground(fccolor);
        
        
        bhelp=new JButton("HELP",new ImageIcon(getClass().getResource("/ImageIcons/Help.png")));
        bhelp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bhelp.setBackground(bccolor);
        bhelp.setForeground(fccolor);
        
        bsettings=new JButton("SETTINGS",new ImageIcon(getClass().getResource("/ImageIcons/Setting.png")));
        bsettings.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bsettings.setBackground(bccolor);
        bsettings.setForeground(fccolor);
        
        bshutdownterminals=new JButton("<html>SHUTDOWN<br/>ALL<br/>TERMINALS</html>",new ImageIcon(getClass().getResource("/ImageIcons/ShutDown.png")));
        bshutdownterminals.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bshutdownterminals.setBackground(bccolor);
        bshutdownterminals.setForeground(fccolor);
        
        brestartterminals=new JButton("<html>RESTART<br/>ALL<br/>TERMINALS</html>",new ImageIcon(getClass().getResource("/ImageIcons/Restart.png")));
        brestartterminals.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        brestartterminals.setBackground(bccolor);
        brestartterminals.setForeground(fccolor);

    /*-----------------logo with name panel----------------*/    
                gbsFaculty.gridx=0;
                gbsFaculty.gridy=0;
                gbsFaculty.ipadx=15;
                gbsFaculty.weightx=0.3;
                gbsFaculty.weighty=1;
                gbsFaculty.fill=GridBagConstraints.BOTH;
                plogowithname.add(logo,gbsFaculty); 
                
                             
                gbsFaculty.gridx=0;
                gbsFaculty.gridy=1;
                plogowithname.add(ltemp,gbsFaculty);
                ltemp.setText(username);
                ltemp.setForeground(Color.BLUE);
                ltemp.setFont(new Font("Times New Roman",Font.BOLD,15));
                plogowithname.setBackground(Color.WHITE);
                
                gbsFaculty.gridx=1;
                gbsFaculty.gridy=1;
                plogowithname.add(blogout,gbsFaculty);
                
    /*--------1st Row-------------------*/           
        gbsFaculty.gridy=0;
        gbsFaculty.gridx=0;
        gbsFaculty.fill=GridBagConstraints.BOTH;
        pLeftSidepanel.add(plogowithname,gbsFaculty);
        
    /*--------2nd Row-------------------*/   
    
        gbsFaculty.gridy=1;
        pLeftSidepanel.add(bProfile,gbsFaculty);
        
    /*--------3rd Row-------------------*/     
        gbsFaculty.gridy=2;
        pLeftSidepanel.add(bMonitoring,gbsFaculty);
        
    /*--------4th Row-------------------*/         
        gbsFaculty.gridy=3;
        pLeftSidepanel.add(bRemoveStudent,gbsFaculty);
        
    /*--------5th Row-------------------*/         
        gbsFaculty.gridy=4;
        pLeftSidepanel.add(bAddStudent,gbsFaculty);
        
    /*--------6th Row-------------------*/         
        gbsFaculty.gridy=5;
        pLeftSidepanel.add(bUpdate,gbsFaculty);
        
    /*--------7th Row-------------------*/         
        gbsFaculty.gridy=6;
        pLeftSidepanel.add(bBroadCasting,gbsFaculty);
        
    /*--------8th Row-------------------*/         
        gbsFaculty.gridy=7;
        pLeftSidepanel.add(bNotification,gbsFaculty);
     
    /*--------9th Row-------------------*/         
        gbsFaculty.gridy=8;
        pLeftSidepanel.add(bshutdownterminals,gbsFaculty);

    /*--------10th Row-------------------*/         
        gbsFaculty.gridy=9;
        pLeftSidepanel.add(brestartterminals,gbsFaculty);
    /*--------1st Row-------------------*/
    
        gbsFaculty.gridy=0;
        gbsFaculty.ipady=5;
        gbsFaculty.ipadx=5;     
        gbsFaculty.gridx=1;
        gbsFaculty.weightx=0.1;
        gbsFaculty.fill=GridBagConstraints.BOTH;
        pTopButtonPanel.add(breportgeneration,gbsFaculty);
        
    /*--------3rd Row-------------------*/       
        gbsFaculty.gridx=2;
        gbsFaculty.fill=GridBagConstraints.BOTH;
        pTopButtonPanel.add(bviewdetails,gbsFaculty);  
        
    /*--------4th Row-------------------*/       
        gbsFaculty.gridx=3;
        pTopButtonPanel.add(bmailing,gbsFaculty);  
        
    /*--------5th Row-------------------*/       
        
    /*--------6th Row-------------------*/       
        gbsFaculty.gridx=5;
        pTopButtonPanel.add(bhelp,gbsFaculty);  
        
    /*--------7th Row-------------------*/       
        gbsFaculty.gridx=6;
        pTopButtonPanel.add(bsettings,gbsFaculty);  
    /*-----------------------Server Address Label----------------------------*/
    try
    {
    
        gbsFaculty.gridx=1;
        gbsFaculty.gridy=1;        
        gbsFaculty.gridwidth=6;
        serverAddress=new JLabel("Server Ip Address:"+sa.getServerAddress().toString());
        pserverAdress.add(serverAddress,BorderLayout.WEST);   
        pserverAdress.setBackground(Color.ORANGE);
        pTopButtonPanel.add(pserverAdress,gbsFaculty);
    }
    catch(NullPointerException ne)
    {
        JOptionPane.showMessageDialog(jfacultyframe,"Device Is Not Connected","Network Error",JOptionPane.ERROR_MESSAGE);
    }
    /*-----------Right Side Panel--------------- */  
        gbs1.gridx=0;
        gbs1.gridy=0;
        gbs1.ipadx=10;
        gbs1.ipady=50;
        gbs1.weightx=0.5;
        gbs1.fill=GridBagConstraints.BOTH;
        pnumberofuser.setBackground(Color.ORANGE);
        pnumberofuser.add(bsingleuser,gbs1);
    
        gbs1.gridx=0;
        gbs1.gridy=1;
        gbs1.weightx=0.5;
        pnumberofuser.add(bmultipleuser,gbs1);
        
              
        bsingleuser.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) 
            {
                panelRemoval();
                pCenterPanel.add(new AddStudent(),BorderLayout.CENTER);
                Validation.refreshFrame(jfacultyframe);
            }
        });
        
        bmultipleuser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
               panelRemoval();
                AddMultipleUser adm=new AddMultipleUser("students",jfacultyframe);
                jfacultyframe.setEnabled(false);
            }
        });
        
    /*-------------------------------------------------------*/     
        
        pAfterLeftSidePanel.add(pTopButtonPanel,BorderLayout.NORTH);
        pAfterLeftSidePanel.add(pCenterPanel,BorderLayout.CENTER);
        pAfterLeftSidePanel.add(pBottomSidePanel,BorderLayout.SOUTH);
        pAfterLeftSidePanel.add(pRightSidePanel,BorderLayout.EAST);
                
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        jfacultyframe.setSize(d);         
        jfacultyframe.setVisible(true);
        jfacultyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfacultyframe.setLocationRelativeTo(null);     
        
        jfacultyframe.getContentPane().add(pLeftSidepanel,BorderLayout.WEST);
        jfacultyframe.getContentPane().add(pAfterLeftSidePanel,BorderLayout.CENTER);
     
     
/*---------------Add Action Listener------------------------------*/      
breportgeneration.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e) 
    {
        panelRemoval();
        pCenterPanel.add(new ReportGeneration(jfacultyframe),BorderLayout.CENTER);
        Validation.refreshFrame(jfacultyframe);
    }
}
);

bhelp.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               panelRemoval();
               pCenterPanel.add(new Help(),BorderLayout.CENTER);
               Validation.refreshFrame(jfacultyframe);
           }
       });

bmailing.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               panelRemoval();
               EmailSending email=new EmailSending(userid);
           }
       });

bRemoveStudent.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              panelRemoval();
              pCenterPanel.add(new RemoveUser("student"),BorderLayout.CENTER);
              Validation.refreshFrame(jfacultyframe);
          }
      }
      );
      bAddStudent.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent ae)
          {
              panelRemoval();
              pRightSidePanel.add(pnumberofuser,BorderLayout.EAST);
              Validation.refreshFrame(jfacultyframe);
          }
      });

      bUpdate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            panelRemoval();
            pCenterPanel.add(new UpdateStudentDetails(),BorderLayout.CENTER);
            Validation.refreshFrame(jfacultyframe);
                                  }
        }); 

    bsettings.addActionListener(new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
            panelRemoval();
            pCenterPanel.add(sc,BorderLayout.CENTER);
            Validation.refreshFrame(jfacultyframe);
          }
      });
      
      bviewdetails.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) 
           {
               panelRemoval();
               pCenterPanel.add(new ViewDetails("student"),BorderLayout.CENTER);
               Validation.refreshFrame(jfacultyframe);
           }
       });
    bProfile.addActionListener(new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              panelRemoval();
              pCenterPanel.add(new AddFaculty(username,userid,rs),BorderLayout.CENTER);
              Validation.refreshFrame(jfacultyframe);
          }
      });
    
    bBroadCasting.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) 
            {
            panelRemoval();
            pCenterPanel.add(new BroadCasting((HashMap)listofConnectedUserForFileTransfer));
            Validation.refreshFrame(jfacultyframe);
           }
       });
  
 bNotification.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               new Notification();
               
           }
       });
    
bshutdownterminals.addActionListener(new ActionListener() 
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        try
        {  
            new SDAndRestart((HashMap)listofConnectedUserForShutDownAndRestart,"ShutDown");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
});
    
    brestartterminals.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
         try
        {  
            new SDAndRestart((HashMap)listofConnectedUserForShutDownAndRestart,"Restart");
        }
        catch(Exception ae)
        {
            ae.printStackTrace();
        }  
        }
    });

this.sc.bsubmit.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {      
        setButtonColor(sc.leftSideButtonColor(),sc.topSideButtonColor());
        setButtonFontColor(sc.leftSideFontColor(),sc.topSideFontColor());
        
        setButtonFont(new Font(sc.comboboxfontleft.getSelectedItem().toString(),Font.BOLD,13),
          new Font(sc.comboboxfonttop.getSelectedItem().toString(),Font.BOLD,13));
       
      Validation.refreshFrame(jfacultyframe);
    }
});
    


/*-----------------Server Starting--------------------------------------*/

listofConnectedUserForFileTransfer=new HashMap<String,Socket>();
listofConnectedUserForShutDownAndRestart=new HashMap<String,Socket>();

UserNameThread un=new UserNameThread(userid,jfacultyframe);
un.start();

FileTransfer();
ShutdownAndRestart();

/*---------------------------Server Communication---------------------------*/
bMonitoring.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        panelRemoval();
        FacultyServer fc=new FacultyServer(); 
        pCenterPanel.add(new Monitoring(un.getConnectedUser(),un.getList(),un.getListForShutDown(),un.getListForScreenSharing()),BorderLayout.CENTER);
        Validation.refreshFrame(jfacultyframe);
    }
 });       
    
blogout.addActionListener(new ActionListener() 
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Validation.logout(jfacultyframe);

    }
}); 
}
    public static void main(String []args) throws IOException
    {
        Faculty f=new Faculty(null);
    }   
      
    
    public void setButtonFont(Font leftSideFont,Font topSideFont)
    {
        pLeftSidepanel.setFont(leftSideFont);
        pTopButtonPanel.setFont(topSideFont);
        
        bProfile.setFont(leftSideFont);     
        bMonitoring.setFont(leftSideFont);     
        bRemoveStudent.setFont(leftSideFont);     
        bAddStudent.setFont(leftSideFont);     
        bUpdate.setFont(leftSideFont);     
        bBroadCasting.setFont(leftSideFont);     
        bNotification.setFont(leftSideFont);     
        bshutdownterminals.setFont(leftSideFont);               
        brestartterminals.setFont(leftSideFont);     
        
        breportgeneration.setFont(topSideFont);
        bviewdetails.setFont(topSideFont);     
        bhelp.setFont(topSideFont);     
        bsettings.setFont(topSideFont);     
    }

    
    public void setButtonColor(Color leftSideColor,Color topPanelColor)
    {
        bProfile.setBackground(leftSideColor);
        bMonitoring.setBackground(leftSideColor);
        bRemoveStudent.setBackground(leftSideColor);
        bAddStudent.setBackground(leftSideColor);
        bUpdate.setBackground(leftSideColor);
        bBroadCasting.setBackground(leftSideColor);
        bNotification.setBackground(leftSideColor);
        bshutdownterminals.setBackground(leftSideColor);
        brestartterminals.setBackground(leftSideColor);
        blogout.setBackground(leftSideColor);
        
        breportgeneration.setBackground(topPanelColor);
        bviewdetails.setBackground(topPanelColor);
        bmailing.setBackground(topPanelColor);
        bhelp.setBackground(topPanelColor);
        bsettings.setBackground(topPanelColor);
        
    }
    
    public void setButtonFontColor(Color leftSideColor,Color topPanelColor)
    {
        bProfile.setForeground(leftSideColor);
        bMonitoring.setForeground(leftSideColor);
        bRemoveStudent.setForeground(leftSideColor);
        bAddStudent.setForeground(leftSideColor);
        bUpdate.setForeground(leftSideColor);
        bBroadCasting.setForeground(leftSideColor);
        bNotification.setForeground(leftSideColor);
        bshutdownterminals.setForeground(leftSideColor);
        brestartterminals.setForeground(leftSideColor);
        blogout.setForeground(leftSideColor);

        
        breportgeneration.setForeground(topPanelColor);
        bviewdetails.setForeground(topPanelColor);
        bmailing.setForeground(topPanelColor);
        bhelp.setForeground(topPanelColor);
        bsettings.setForeground(topPanelColor);
    }

    public void mouseEntered(MouseEvent me) 
    {
       JButton temp=(JButton)me.getComponent();
       temp.setBorder(BorderFactory.createRaisedBevelBorder());      
    }
    
    public void mouseExited(MouseEvent e) 
    {
       JButton temp=(JButton)e.getComponent();
       temp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
    }
    
    public void panelRemoval()
    {
        pCenterPanel.removeAll();
        pBottomSidePanel.removeAll();
        pRightSidePanel.removeAll();
    }
    
public void ShutdownAndRestart()
{
    new Thread()
    {
        public void run()
        {
            try
            {
            Socket socket;
            DataInputStream disConnectedUserName;


            ssForShutDownAndRestart=new ServerSocket(3000);

            while(true)
            {                
                socket=ssForShutDownAndRestart.accept();
                System.out.println(socket);

                disConnectedUserName=new DataInputStream(socket.getInputStream());

                String a = disConnectedUserName.readUTF();

                listofConnectedUserForShutDownAndRestart.put(a,socket);
                System.out.println(a);                                     
                }    
            }
            catch(IOException xe)
            {
                xe.printStackTrace();   
                JOptionPane.showMessageDialog(pCenterPanel,"Port Number is Already is Used","Prot Error",JOptionPane.ERROR_MESSAGE);    
            }
            catch(Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(pCenterPanel,"Port Number is Already is Used","Prot Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }.start();        
}
    
public void FileTransfer()
{    
    new Thread()
    {
        public void run()
        {
            try
            {
            Socket socket;
            InputStream isConnectedUserName;
            DataInputStream disConnectedUserName;


            ssForFileTransfer=new ServerSocket(2000);

            while(true)
            {                
                socket=ssForFileTransfer.accept();
                System.out.println(socket);

                isConnectedUserName=socket.getInputStream();
                disConnectedUserName=new DataInputStream(isConnectedUserName);

                String a = disConnectedUserName.readUTF();

                listofConnectedUserForFileTransfer.put(a,socket);
                System.out.println(a);                                     
            }    
            }
            catch(IOException xe)
            {
                xe.printStackTrace();   

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    }.start();   
}
}
    

    

