  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import AddUsers.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.*;
import Operation.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.text.*;
import java.util.logging.Level;
import java.time.*;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.imageio.ImageIO;



/**
 *
 * @author HP
 */
public class Student extends MouseAdapter
{
    JFrame StudentFrame;
    DBConnection db;
 
    JPanel pLeftSidepanel,plogowithname;
    JPanel pRightSidepanel,pTopPanel,pTopButtonPanel,pBottomSidePanel,pCenterPanel;
    
    JButton bprofile;
    JButton blogout,bchatting;
    JButton bnotification,bhelp,bsetting;
    
    JLabel lselectusertype,lnumberofusers;
    JLabel logo,ltemp;
    
    GridBagLayout gblAdmin;
    GridBagConstraints gbsAdmin;
 
    String username,email;
    
    Font fnt;    
public Socket socketForUserName,socketForFileTransfer,socketForShutDownAndRestart;

public Socket sc,socketforShutDown,socketForScreenSharing;

public DataOutputStream dousername;
public DataInputStream dis; 
   
    String serverAddress="localhost";
    public String serverEmail;
    
    Setting setting;

    FileDirectory directroy;
    
    public int sec=0,min=0,hour=0;

    String temp;
    
    public Student() 
    {
        this(null);
    }
    
    public Student(ResultSet rs)
    {
        serverAddress=JOptionPane.showInputDialog(pCenterPanel,"Please Enter Server Ip");
        System.out.println("Address"+serverAddress);
        
        
        username="XYZX";
        email="140940107042";
        try
        {
           if(rs.next())
           {     
            username=rs.getString(2);
            email=rs.getString(1);
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();    
        }
        
        setting=new Setting();

       
        StudentFrame=new JFrame("Student");
        db=new DBConnection(StudentFrame);
        
        Color bccolor=Color.WHITE;
        Color fccolor=Color.BLACK;
        
        fnt=new Font("Copperplate Gothic Bold",Font.BOLD,13);
        
        gbsAdmin=new GridBagConstraints();
        gblAdmin=new GridBagLayout();
        
        StudentFrame=new JFrame("STUDENT");
     /*----------ComboBox--------------------*/
        
        lselectusertype=new JLabel("Select User Type",JLabel.CENTER);
        lnumberofusers=new JLabel("Number Of Users",JLabel.CENTER);
        
    /*-------Left Side Panel-----------------*/    
        pLeftSidepanel=new JPanel();    
        pLeftSidepanel.setLayout(gblAdmin);
        pLeftSidepanel.setBackground(Color.WHITE);
        
    /*-------logo with Panel--------------------*/    
        plogowithname=new JPanel();
        plogowithname.setLayout(gblAdmin);
        plogowithname.setBackground(Color.RED);
    /*---------center Panel-----------------*/    
        pCenterPanel=new JPanel(new BorderLayout());
        
        
    /*-----------Right side panel------------*/
        pRightSidepanel=new JPanel();
        pRightSidepanel.setLayout(gblAdmin);
        
    /*------------Top Panel------------------*/
       pTopPanel=new JPanel();
       pTopPanel.setLayout(gblAdmin);
       
       pTopButtonPanel=new JPanel(gblAdmin);
       
    /*-----------Right side Label panel------------*/    
        pBottomSidePanel=new JPanel();
        pBottomSidePanel.setLayout(gblAdmin);
           
       /*------------------Label-----------------*/
        logo=new JLabel(new ImageIcon(getClass().getResource("/ImageIcons/StudentFrame.png")));
        ltemp=new JLabel("");
      
    /*----------------Button----------------*/  
        bnotification=new JButton("NOTIFICATION",new ImageIcon(getClass().getResource("/ImageIcons/Notification.png")));
        bnotification.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bnotification.setBackground(bccolor);
        bnotification.setForeground(fccolor);
        
        bsetting=new JButton("SETTINGS",new ImageIcon(getClass().getResource("/ImageIcons/Setting.png")));
        bsetting.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bsetting.setBackground(bccolor);
        bsetting.setForeground(fccolor);
        
        bhelp=new JButton("HELP",new ImageIcon(getClass().getResource("/ImageIcons/Help.png")));
        bhelp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bhelp.setBackground(bccolor);
        bhelp.setForeground(fccolor);
        
      
        bprofile=new JButton("PROFILE",new ImageIcon(getClass().getResource("/ImageIcons/Profile.png")));
        bprofile.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bprofile.setBackground(bccolor);
        bprofile.setForeground(fccolor);
        
        
        blogout=new JButton("LOGOUT");
        blogout.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        blogout.setFont(fnt);
        blogout.setBackground(bccolor);
        blogout.setForeground(fccolor);
        
        
        
        bchatting=new JButton("CHATTING",new ImageIcon(getClass().getResource("/ImageIcons/chat.png")));
        bchatting.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bchatting.setFont(fnt);
        bchatting.setBackground(bccolor);
        bchatting.setForeground(fccolor);
        
       
    /*-----------------logo with name panel----------------*/    
                gbsAdmin.gridx=0;
                gbsAdmin.gridy=0;
                gbsAdmin.ipadx=20;
                gbsAdmin.ipady=0;
                gbsAdmin.weightx=0.3;
                gbsAdmin.weighty=1;
                gbsAdmin.fill=GridBagConstraints.BOTH;
                plogowithname.add(logo,gbsAdmin); 
                
                 
                gbsAdmin.gridx=0;
                gbsAdmin.gridy=1;
                ltemp.setText(username);
                ltemp.setForeground(Color.BLUE);
                ltemp.setFont(new Font("Times New Roman",Font.BOLD,15));
                plogowithname.add(ltemp,gbsAdmin);
               
                
                gbsAdmin.gridx=1;
                gbsAdmin.gridy=1;
                plogowithname.add(blogout,gbsAdmin);
                
    /*--------1st Row-------------------*/           
        gbsAdmin.gridy=0;
        gbsAdmin.gridx=0;
        gbsAdmin.fill=GridBagConstraints.BOTH;
        pLeftSidepanel.add(plogowithname,gbsAdmin);
        
    /*--------2nd Row-------------------*/   
    
        gbsAdmin.gridy=1;
        pLeftSidepanel.add(bprofile,gbsAdmin);
        
    /*--------3rd Row-------------------*/     
        gbsAdmin.gridy=2;
        pLeftSidepanel.add(bnotification,gbsAdmin);
        
    /*--------4th Row-------------------*/         
        gbsAdmin.gridy=3;
        pLeftSidepanel.add(bhelp,gbsAdmin);
        
    /*--------5th Row-------------------*/         
        gbsAdmin.gridy=4;
        pLeftSidepanel.add(bsetting,gbsAdmin);
        
    /*--------2nd Row-------------------*/       
        gbsAdmin.gridy=5;
        pLeftSidepanel.add(bchatting,gbsAdmin);
        
    /*--------3rd Row-------------------*/       
        gbsAdmin.gridy=6;
        //pLeftSidepanel.add(bviewdetails,gbsAdmin);  
          
        
        /*-------------Add Component to Frame------------------------------------------*/    
    
        StudentFrame.add(pLeftSidepanel,BorderLayout.WEST);
        StudentFrame.add(pCenterPanel,BorderLayout.CENTER);
        
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      
        StudentFrame.setSize(d);         
        StudentFrame.setVisible(true);        
        StudentFrame.setLocationRelativeTo(null);     
      
   /*----------------Add Mouse Lisetener---------------------------*/
   
        bprofile.addMouseListener(this);
        bnotification.addMouseListener(this);
        bhelp.addMouseListener(this);
        bsetting.addMouseListener(this);
       
        blogout.addMouseListener(this);
        bchatting.addMouseListener(this);
   /*-------------------Add ActionListener--------------------------*/

        StudentFrame.setVisible(true);
        StudentFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        bprofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                pCenterPanel.removeAll();
                pCenterPanel.add(new AddStudent(username,email,rs));
                Validation.refreshFrame(StudentFrame);
            }
        });
        
        bhelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCenterPanel.removeAll();
                pCenterPanel.add(new Help(),BorderLayout.CENTER);
                Validation.refreshFrame(StudentFrame);
            }
        });
        
        bsetting.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                pCenterPanel.removeAll();
                pCenterPanel.add(setting);
                Validation.refreshFrame(StudentFrame);
           }
        });
        bnotification.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    new Notification();
                } 
                catch (Exception ex)
                {
                  ex.printStackTrace();
                }
         
            }
        });
        StudentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
/*---------------Network Connection------------------------------*/
/*-----------------------User Name Thread------------------------*/

UserNameThread unt=new UserNameThread();
unt.start();
        
/*-----------------------File Transfer Thread-----------------------------------*/

Fileread read = new Fileread();
read.start();

/*--------------------Shut Down Thread-----------------*/
ShutDownRestartThread sdrt=new ShutDownRestartThread();
sdrt.start();

/*-------------------Duration Thread-------------------------------*/
DurationThread dt=new DurationThread();
dt.start();

/*----------------------Personal Shut Down Thread------------------*/
PersonalShutDownThread pst=new PersonalShutDownThread();
pst.start();

/*-------------------Screen Sharing Thread----------------------------*/
ScreenSharingConnectionThread ssct=new ScreenSharingConnectionThread();
ssct.start();

/*--------------------------Faculty Server Thread--------------------*/


bchatting.addActionListener(new ActionListener()
{

    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            DataInputStream dis=new DataInputStream(sc.getInputStream());
            DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
            Chatting chatting=new Chatting(username, dos, dis);
        } 
        catch (Exception ex) 
        {
            serverOfflineException();
            ex.printStackTrace();

        }
    }

});

this.setting.bsubmit.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {
        setButtonFont(new Font(setting.comboboxfontleft.getSelectedItem().toString(),Font.BOLD,13),
        new Font(setting.comboboxfonttop.getSelectedItem().toString(),Font.BOLD,13));

        setButtonColor(setting.leftSideButtonColor(),setting.topSideButtonColor());
        setButtonFontColor(setting.leftSideFontColor(),setting.topSideFontColor());
           
    Validation.refreshFrame(StudentFrame);

    }

});


/*-------------------------Shut Down Thread-----------------------------*/



StudentFrame.addWindowListener(new WindowAdapter()
{
    @Override
    public void windowClosing(WindowEvent e)
    {
        try
        {   
            
            String startDate=db.getStartDate();
            String startTime=db.getStartTime();
            System.out.println("abc"+startDate);
            
            ResultSet rs=db.getStudentPrimaryKey(email, startTime, startDate);
            while(rs.next())
            {
                temp=rs.getString(1);
                System.out.println("data"+rs.getString(1));
            }
            
            
            db.student_logout(temp,email,serverEmail,hour, min, sec);
            System.out.println("Window Closing");
            
        }
        catch(Exception ae)
        {
            
            db.student_logout(temp,email,"Non-Faculty",hour, min, sec);
            ae.printStackTrace();
        }
    }


});

blogout.addActionListener(new ActionListener()
{
    @Override
    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            
            String startDate=db.getStartDate();
            String startTime=db.getStartTime();
            System.out.println("abc"+startDate);
            
            ResultSet rs=db.getStudentPrimaryKey(email, startTime, startDate);
            while(rs.next())
            {
                temp=rs.getString(1);
                System.out.println("data"+rs.getString(1));
            }
            
            
            dousername=new DataOutputStream(socketForUserName.getOutputStream());
            dousername.writeUTF("Socket Close"); 
            
            unt.stop();
            
            db.student_logout(temp,email,serverEmail,hour, min, sec);
            dt.stop();
            
            StudentFrame.setVisible(false);
            SplashScreen spl=new SplashScreen();
            
        }
        catch(NullPointerException ne)
        {
            db.student_logout(temp,email,"Non-Faculty",hour, min, sec);
            StudentFrame.setVisible(false);
            new SplashScreen();
        } 
        catch (IOException ex) 
        {
           ex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
            
                
    }
});

}
    
    public static void main(String []args)throws Exception
    {
       Student student = new Student();
    }

    public void setButtonFont(Font leftSideFont,Font topSideFont)
    {
    pLeftSidepanel.setFont(leftSideFont);
    pTopButtonPanel.setFont(topSideFont);

    bprofile.setFont(leftSideFont);     
    bnotification.setFont(leftSideFont);       
    bhelp.setFont(leftSideFont);     
    blogout.setFont(leftSideFont);
    bsetting.setFont(leftSideFont);     
    bchatting.setFont(leftSideFont);
    
    }
   
    public void setButtonColor(Color leftSideColor,Color topPanelColor)
    {
        bprofile.setBackground(leftSideColor);
        bnotification.setBackground(leftSideColor);
        bhelp.setBackground(leftSideColor);
        blogout.setBackground(leftSideColor);
        bhelp.setBackground(leftSideColor);
        bsetting.setBackground(leftSideColor);        
        
        bchatting.setBackground(leftSideColor);
    }
    
    public void setButtonFontColor(Color leftSideColor,Color topPanelColor)
    {
        blogout.setForeground(leftSideColor);
        bprofile.setForeground(leftSideColor);
        bnotification.setForeground(leftSideColor);
        bhelp.setForeground(leftSideColor);
        bhelp.setForeground(leftSideColor);
        bsetting.setForeground(leftSideColor);
    
        bchatting.setForeground(leftSideColor);
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
       
class Fileread extends Thread
{
    public void run()
    {
        try
        {
            System.out.println("File Read Thread");
            
        while(true)
        {
            socketForFileTransfer=new Socket(serverAddress,2000);
            DataOutputStream dos=new DataOutputStream(socketForFileTransfer.getOutputStream());
            dos.writeUTF(email);
            
            DataInputStream dis=null;
            dis=new DataInputStream(socketForFileTransfer.getInputStream());
            
            int fileSize=(int)dis.readLong();
            String fileName=dis.readUTF();
            System.out.println("direc"+directroy.getDirectoryPath());
        
            FileOutputStream fos=new FileOutputStream(directroy.getDirectoryPath()+fileName);           
            byte []buffer=new byte[4096];
        
           int read=0;
            int totalread=0;
            int rmain=fileSize;
  
            System.err.println("filesize = " +fileSize);
            System.err.println("file name "+fileName);
            while((read=dis.read(buffer,0,Math.min(buffer.length,rmain)))>0)
            {
                totalread+=read;
                rmain-=read;
                System.out.println("Read"+totalread+"bytes");
                fos.write(buffer,0, read);
            }
         fos.close();
         fos = null;
        }
            
        }
        catch(IOException se)
        {
            System.out.println("File Read Thread");
            serverEmail="Non-Faculty";
            se.printStackTrace();
            
        }
        catch(Exception e)
        {
            
            serverOfflineException();
            e.printStackTrace();
        }
        finally
        {       
            
        }
    }
}

class UserNameThread extends Thread
{
    
    public void run()
    {
       
       System.out.println("USer Name Thread");
           try
            {    
       
            directroy=new FileDirectory();
       
            socketForUserName=new Socket(serverAddress,9979);
            sc=new Socket(serverAddress,9574);
            
            
            plogowithname.setBackground(Color.GREEN);

            dousername=new DataOutputStream(socketForUserName.getOutputStream());
            dousername.writeUTF(email); 

            dis=new DataInputStream(socketForUserName.getInputStream());
            serverEmail=dis.readUTF();

            db.student_login(email, serverEmail);
            
         
        }
        catch(SocketException se)
        {
           db.student_login(email,"Non-Faculty");
           serverOfflineException();
           se.printStackTrace();
        } 
        catch (IOException ex) 
        {
            System.out.println("USer name thread");
           ex.printStackTrace();
           
        }   
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}

class ShutDownRestartThread extends Thread
{
    public void run()
    {
        try
        {       
            System.out.println("Shut Down Thread");
  
            socketForShutDownAndRestart=new Socket(serverAddress,3000);
            
            
            DataOutputStream dos=new DataOutputStream(socketForShutDownAndRestart.getOutputStream());
            dos.writeUTF(email);
                    
            DataInputStream dis=new DataInputStream(socketForShutDownAndRestart.getInputStream());
            String op=dis.readUTF();
            SD(op);
            
        }
        catch(Exception e)
        {
            serverEmail="Non-Faculty";
            serverOfflineException();
        }
    }
}

class PersonalShutDownThread extends Thread
{
    public void run()
    {
        try
        {
            socketforShutDown=new Socket(serverAddress,5155);
            
            String opn=new DataInputStream(socketforShutDown.getInputStream()).readUTF();
            System.out.println("opn"+opn);
            SD(opn);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

class ScreenSharingConnectionThread extends Thread
{
    public void run()
    {
        try
        {
            Robot robot=new Robot();
            Dimension dscreen=Toolkit.getDefaultToolkit().getScreenSize();
            socketForScreenSharing=new Socket(serverAddress,7047);
            while(true)
            {
                BufferedImage image=robot.createScreenCapture(new Rectangle(0, 0,(int)dscreen.getWidth(),(int)dscreen.getHeight()));
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                
                ImageIO.write(image,"png",byteArrayOutputStream);
                socketForScreenSharing.getOutputStream().write(byteArrayOutputStream.toByteArray());
                
                Thread.sleep(10);
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
}

class DurationThread extends Thread
{
    public void run()
    {
        LocalDate ldt=LocalDate.now();
        LocalDateTime time=ldt.atTime(MIN_PRIORITY, MIN_PRIORITY, MIN_PRIORITY);
        while(true)
         {
            try
            {
            Thread.sleep(1000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            sec++;

            if(sec>=60)
            {
            sec=0;
            min=min+1;
                if(min>=60)
                {
                min=0;
                hour=hour+1;
                    if(hour>=24)
                    {
                        break;
                    }
                }
            }
            //System.out.println("Counter"+hour+":"+min+":"+sec);
        }   
    }
}

public void serverOfflineException()
{
    JOptionPane.showMessageDialog(StudentFrame,"Server Is Offline","Server Error",JOptionPane.WARNING_MESSAGE);
    plogowithname.setBackground(Color.RED);
            
}

void SD(String op)
{
    if(op.equalsIgnoreCase("shutdown"))
    {
        try
        {
            Process pr=Runtime.getRuntime().exec("shutdown -s -t 30");                
            JOptionPane.showMessageDialog(pCenterPanel,"This System Will ShutDown Within 30 Seconds ","SHUTDOWN",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception re)
        {
            re.printStackTrace();
            JOptionPane.showMessageDialog(pCenterPanel, "System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    else if(op.equalsIgnoreCase("restart"))
    {
        try
        {
        Process pr1=Runtime.getRuntime().exec("shutdown -r -t 30");
        JOptionPane.showMessageDialog(pCenterPanel,"This System Will Restart Within 30 Seconds ","SHUTDOWN",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception er)
        {
            er.printStackTrace();
            JOptionPane.showMessageDialog(pCenterPanel, "System Error","System Error",JOptionPane.ERROR_MESSAGE);        
        }
    }
}

}
