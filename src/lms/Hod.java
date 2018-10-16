/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import AddUsers.AddHod;
import Operation.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
/**
 *
 * @author HP
 */
public class Hod extends MouseAdapter
{
    JFrame jHodframe;
    JPanel pLeftSidepanel,plogowithname;
    JPanel pRightSidepanel,pTopPanel,pTopButtonPanel,pBottomSidePanel,pCenterPanel;
    
    JButton bprofile;
    JButton blogout,bviewdetails;
    JButton bnotification,bhelp,bsetting;
    
    JLabel lselectusertype,lnumberofusers;
    JLabel logo,ltemp;
    
    GridBagLayout gblAdmin;
    GridBagConstraints gbsAdmin;
    
    Setting setting;
    Font fnt;
    
    String username,email;
    public Hod()
    {
        this(null);
    }  
    public Hod(ResultSet rs)
    {
       username="nodata";email="";
       try
       {
           if(rs.next())
           {
               username=rs.getString(3);
               email=rs.getString(1);
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        
       setting=new Setting(); 
    
       Color bccolor=Color.WHITE;
       Color fccolor=Color.BLACK;
       fnt=new Font("Copperplate Gothic Bold",Font.BOLD,13);
                     
        gbsAdmin=new GridBagConstraints();
        gblAdmin=new GridBagLayout();
        
        jHodframe=new JFrame("HOD");
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
        logo=new JLabel(new ImageIcon(getClass().getResource("/ImageIcons/HODFrame.png")));
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
        blogout.setBackground(bccolor);
        blogout.setForeground(fccolor);
        
        
        
        bviewdetails=new JButton("VIEW DETAILS",new ImageIcon(getClass().getResource("/ImageIcons/ViewDetails.png")));
        bviewdetails.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
         bviewdetails.setBackground(bccolor);
        bviewdetails.setForeground(fccolor);
        
       
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
                plogowithname.setBackground(Color.WHITE);
                
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
     pLeftSidepanel.add(bviewdetails,gbsAdmin);
        
     
        bhelp.addMouseListener(this);
        blogout.addMouseListener(this);
        bnotification.addMouseListener(this);
        bprofile.addMouseListener(this);
        bsetting.addMouseListener(this);
        bviewdetails.addMouseListener(this);
        
     
        /*-------------Add Component to Frame------------------------------------------*/    
    
        jHodframe.add(pLeftSidepanel,BorderLayout.WEST);
        jHodframe.add(pCenterPanel,BorderLayout.CENTER);
        
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      
        jHodframe.setSize(d);         
        jHodframe.setVisible(true);
        
        jHodframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jHodframe.setLocationRelativeTo(null);     
      
   /*-------------------Add ActionListener--------------------------*/
        bprofile.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
            pCenterPanel.removeAll();
            pCenterPanel.add(new AddHod(username,email,rs));
            Validation.refreshFrame(jHodframe);
              
           }
       });
        
       bsetting.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) 
           {
               pCenterPanel.removeAll();
               pCenterPanel.add(setting);
               Validation.refreshFrame(jHodframe);
           }
       });
       
this.setting.bsubmit.addActionListener(new ActionListener()
{
   public void actionPerformed(ActionEvent ae)
   {
     setButtonColor(setting.leftSideButtonColor(),setting.topSideButtonColor());
     setButtonFontColor(setting.leftSideFontColor(),setting.topSideFontColor());


     setButtonFont(new Font(setting.comboboxfontleft.getSelectedItem().toString(),Font.BOLD,13),
             new Font(setting.comboboxfonttop.getSelectedItem().toString(),Font.BOLD,13));

     Validation.refreshFrame(jHodframe);

   }
});
bnotification.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) 
           {
               new Notification();
           }
       });

bhelp.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               pCenterPanel.removeAll();
               pCenterPanel.add(new Help(),BorderLayout.CENTER);
               Validation.refreshFrame(jHodframe);
         
           }
       });

bviewdetails.addActionListener(new ActionListener() 
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        pCenterPanel.removeAll();
        pCenterPanel.add(new UserByType("View Details").viewUserDetails(),BorderLayout.CENTER);
        Validation.refreshFrame(jHodframe);

    }
});
    
blogout.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               Validation.logout(jHodframe);
           }
       });
}
    
    public static void main(String []args)
    {
        new Hod();
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
    
    
    
    public void setButtonFont(Font leftSideFont,Font topSideFont)
    {
        pLeftSidepanel.setFont(leftSideFont);
        pTopButtonPanel.setFont(topSideFont);
        
        bprofile.setFont(leftSideFont);
        bviewdetails.setFont(leftSideFont);     
        blogout.setFont(leftSideFont);
        bnotification.setFont(leftSideFont);
        bhelp.setFont(leftSideFont);
        bsetting.setFont(leftSideFont);
    }
   
    public void setButtonColor(Color leftSideColor,Color topPanelColor)
    {
        bprofile.setBackground(leftSideColor);
        bviewdetails.setBackground(leftSideColor);
        blogout.setBackground(leftSideColor);
        bnotification.setBackground(leftSideColor);
        bhelp.setBackground(leftSideColor);
        bsetting.setBackground(leftSideColor);
    }
    
    public void setButtonFontColor(Color leftSideColor,Color topPanelColor)
    {
        
        bprofile.setForeground(leftSideColor);
        bviewdetails.setForeground(leftSideColor);
        blogout.setForeground(leftSideColor);
        bnotification.setForeground(leftSideColor);
        bhelp.setForeground(leftSideColor);
        bsetting.setForeground(leftSideColor);
    }

    
}
