
package lms;

import AddUsers.AddStudent;
import AddUsers.*;  
import Operation.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class Admin extends MouseAdapter
{
    String username,email;
        
    JFrame jAdminframe;
    JPanel pLeftSidepanel,plogowithname;
     
    JPanel pRightSidepanel,pTopButtonPanel,pBottomSidePanel,pCenterPanel;
    JPanel PAfterLeftSidePanel;
    
    JPanel pnumberofuser,pusertype,psubmitbutton,paddUser;
    JRadioButton rbsingleuser,rbmultipeuser;
    JRadioButton rbAdmin,rbFaculty,rbHod,rbStudent;
    ButtonGroup bgnumberofuser,bgusertype;
    JButton bsubmit;
    
    JButton bProfile,bAddUser,bRemoveUser,bUpdateUser;
    JButton blogout,breportgeneration,bviewdetails;
    JButton bnotification,bhelp,bsetting,bemail;
    
    
    JLabel lselectusertype,lnumberofusers;
    JLabel logo,ltemp;
       
    GridBagLayout gblAdmin;
    GridBagConstraints gbsAdmin;

    Setting setting;
    
    Color bccolor,fccolor;
    
    FileDirectory fd;
    public Admin()
    {
        this(null);
    }
    public Admin(ResultSet rs)
    {
        
        fd=new FileDirectory();
        
                
        setting=new Setting();
        
        
     username="";email="admin@gmail.com";  
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
       bccolor=Color.WHITE;
       fccolor=Color.BLACK;
               
        gbsAdmin=new GridBagConstraints();
        gblAdmin=new GridBagLayout();
        
        jAdminframe=new JFrame("ADMIN");
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
      
       
       pTopButtonPanel=new JPanel(gblAdmin);
       
    /*-----------Right side Label panel------------*/    
        pBottomSidePanel=new JPanel();
        pBottomSidePanel.setLayout(gblAdmin);
    
        PAfterLeftSidePanel=new JPanel(new BorderLayout());
        PAfterLeftSidePanel.setBackground(Color.WHITE);
        

       
       /*------------------Label-----------------*/
        logo=new JLabel(new ImageIcon(getClass().getResource("/ImageIcons/AdminFrame.jpeg")));
        ltemp=new JLabel("");
      
    /*----------------Button----------------*/  
        bnotification=new JButton("NOTIFICATION",new ImageIcon(getClass().getResource("/ImageIcons/Notification.png")));
        bnotification.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bnotification.setBackground(bccolor);
        bnotification.setForeground(fccolor);
        
        bemail=new JButton("EMAIL",new ImageIcon(getClass().getResource("/ImageIcons/gmail.png")));
        bemail.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bemail.setBackground(bccolor);
        bemail.setForeground(fccolor);
        
        bsetting=new JButton("SETTINGS",new ImageIcon(getClass().getResource("/ImageIcons/Setting.png")));
        bsetting.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bsetting.setBackground(bccolor);
        bsetting.setForeground(fccolor);
        
        bhelp=new JButton("HELP",new ImageIcon(getClass().getResource("/ImageIcons/Help.png")));
        bhelp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bhelp.setBackground(bccolor);
        bhelp.setForeground(fccolor);
        
      
        bProfile=new JButton("PROFILE",new ImageIcon(getClass().getResource("/ImageIcons/Profile.png")));
        bProfile.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bProfile.setBackground(bccolor);
        bProfile.setForeground(fccolor);
        
        bAddUser=new JButton("ADD USER",new ImageIcon(getClass().getResource("/ImageIcons/AddUser.png")));
        bAddUser.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bAddUser.setBackground(bccolor);
        bAddUser.setForeground(fccolor);
        
        
       
        bRemoveUser=new JButton("REMOVE USER",new ImageIcon(getClass().getResource("/ImageIcons/RemoveUser.png")));
        bRemoveUser.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bRemoveUser.setBackground(bccolor);
        bRemoveUser.setForeground(fccolor);
        
        
        bUpdateUser=new JButton("UPDATE USER",new ImageIcon(getClass().getResource("/ImageIcons/Update.png")));
        bUpdateUser.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK,2),BorderFactory.createBevelBorder(5)));
        bUpdateUser.setBackground(bccolor);
        bUpdateUser.setForeground(fccolor);
        
        
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
        pLeftSidepanel.add(bProfile,gbsAdmin);
        
    /*--------3rd Row-------------------*/     
        gbsAdmin.gridy=2;
        pLeftSidepanel.add(bAddUser,gbsAdmin);
        
    /*--------4th Row-------------------*/         
        gbsAdmin.gridy=3;
        pLeftSidepanel.add(bRemoveUser,gbsAdmin);
        
    /*--------5th Row-------------------*/         
        gbsAdmin.gridy=4;
        pLeftSidepanel.add(bUpdateUser,gbsAdmin);
        
    /*--------2nd Row-------------------*/       
        gbsAdmin.gridy=5;
        pLeftSidepanel.add(breportgeneration,gbsAdmin);
        
    /*--------3rd Row-------------------*/       
        gbsAdmin.gridy=6;
        pLeftSidepanel.add(bviewdetails,gbsAdmin);  
        
    /*--------Add Component at Top Panel-------*/   
       
        gbsAdmin.gridy=0;
        gbsAdmin.ipady=5;
        gbsAdmin.ipadx=5;        
        gbsAdmin.gridx=0;
        gbsAdmin.weightx=0.2;
        gbsAdmin.fill=GridBagConstraints.BOTH;
        pTopButtonPanel.add(bnotification,gbsAdmin);
        
    /*--------2nd Row-------------------*/       
        gbsAdmin.gridx=1;
        gbsAdmin.weightx=0.2;
        gbsAdmin.fill=GridBagConstraints.BOTH;
        pTopButtonPanel.add(bhelp,gbsAdmin);  
        
    /*--------3rd Row-------------------*/       
        gbsAdmin.gridx=2;
        gbsAdmin.weightx=0.2;
        gbsAdmin.fill=GridBagConstraints.BOTH;
        pTopButtonPanel.add(bsetting,gbsAdmin);  
        
        gbsAdmin.gridx=3;
        gbsAdmin.weightx=0.2;
        gbsAdmin.fill=GridBagConstraints.BOTH;
        pTopButtonPanel.add(bemail,gbsAdmin);  
        
     /*--------------------------Add User Panel-----------------------*/
            
            paddUser=new JPanel(new GridBagLayout());
            
            pnumberofuser=new JPanel(new GridLayout(2,1));
            pnumberofuser.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Number Of Users",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Copperplate Gothic Bold",Font.BOLD,25)));
            
            pusertype=new JPanel(new GridLayout(5,1));
            pusertype.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"User Type",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Copperplate Gothic Bold",Font.BOLD,25)));
            
            rbsingleuser=new JRadioButton("Single User");
            rbsingleuser.setFont(new Font("Times New Roman",Font.BOLD,25));
            
            rbmultipeuser=new JRadioButton("Multiple User");
            rbmultipeuser.setFont(new Font("Times New Roman",Font.BOLD,25));
            
            rbAdmin=new JRadioButton("Admin");
            rbAdmin.setFont(new Font("Times New Roman",Font.BOLD,25));
            
            rbFaculty=new JRadioButton("Faculty");
            rbFaculty.setFont(new Font("Times New Roman",Font.BOLD,25));
            
            rbHod=new JRadioButton("HOD");
            rbHod.setFont(new Font("Times New Roman",Font.BOLD,25));
            
            rbStudent=new JRadioButton("Student");
            rbStudent.setFont(new Font("Times New Roman",Font.BOLD,25));
            
            bsubmit=new JButton("Submit");
            
            psubmitbutton=new JPanel(new GridBagLayout());
            GridBagConstraints gbs=new GridBagConstraints();
            
            gbs.gridx=0;
            gbs.gridy=0;
            gbs.ipadx=150;
            gbs.ipady=50;
            bsubmit.setFont(new Font("Times New Roman", Font.BOLD, 20));
            psubmitbutton.add(bsubmit,gbs);
            
            bgnumberofuser=new ButtonGroup();
                bgnumberofuser.add(rbmultipeuser);
                bgnumberofuser.add(rbsingleuser);
            
            bgusertype=new ButtonGroup();
                bgusertype.add(rbAdmin);
                bgusertype.add(rbFaculty);
                bgusertype.add(rbHod);
                bgusertype.add(rbStudent);

            
            pnumberofuser.add(rbsingleuser);
            pnumberofuser.add(rbmultipeuser);
            
            
            pusertype.add(rbAdmin);
            pusertype.add(rbFaculty);
            pusertype.add(rbHod);
            pusertype.add(rbStudent);
            
            gbsAdmin.gridx=0;
            gbsAdmin.gridy=0;
            paddUser.add(pnumberofuser,gbsAdmin);
            
            gbsAdmin.gridx=1;
            gbsAdmin.gridy=0;
            paddUser.add(pusertype,gbsAdmin);
            
            gbsAdmin.gridx=0;
            gbsAdmin.gridy=1;
            gbsAdmin.gridwidth=2;
            gbsAdmin.fill=GridBagConstraints.BOTH;
            psubmitbutton.setBorder(BorderFactory.createLoweredBevelBorder());
            paddUser.add(psubmitbutton,gbsAdmin);
            
            
    /*-------------Add Component to Frame------------------------------------------*/    
        jAdminframe.add(PAfterLeftSidePanel,BorderLayout.CENTER);
        jAdminframe.add(pLeftSidepanel,BorderLayout.WEST);

            
    /*---------------------PAfterLeftSide panel---------------------------*/    
            
        PAfterLeftSidePanel.add(pTopButtonPanel,BorderLayout.NORTH);
        PAfterLeftSidePanel.add(pCenterPanel,BorderLayout.CENTER);

   
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      
        jAdminframe.setSize(d);         
        jAdminframe.setVisible(true);
        
        jAdminframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jAdminframe.setLocationRelativeTo(null);     
      
   /*----------------Add Mouse Lisetener---------------------------*/
   
        bProfile.addMouseListener(this);
        bAddUser.addMouseListener(this);
        bRemoveUser.addMouseListener(this);
        bUpdateUser.addMouseListener(this);        
        blogout.addMouseListener(this);
        breportgeneration.addMouseListener(this);
        bviewdetails.addMouseListener(this);
        bnotification.addMouseListener(this);
        bhelp.addMouseListener(this);
        bsetting.addMouseListener(this);
        bemail.addMouseListener(this);
   /*-------------------Add ActionListener--------------------------*/
   
    bAddUser.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            pCenterPanel.removeAll();
            pCenterPanel.add(paddUser);
            Validation.refreshFrame(jAdminframe);
        }
    });
    
    bRemoveUser.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            pCenterPanel.removeAll();
            pCenterPanel.add(new UserByType("Remove User").removeUser(),BorderLayout.NORTH);
            Validation.refreshFrame(jAdminframe);
        }
    });
    
    bUpdateUser.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            pCenterPanel.removeAll();
            pCenterPanel.add(new UserByType("UPDATE USER DETAILS").updateUser(),BorderLayout.CENTER);
            Validation.refreshFrame(jAdminframe);
        }
    });
    bviewdetails.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            pCenterPanel.removeAll();
            pCenterPanel.add(new UserByType("View Details").viewUserDetails());
            Validation.refreshFrame(jAdminframe);
        }
    });
    breportgeneration.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
         pCenterPanel.removeAll();
         pCenterPanel.add(new ReportGeneration(jAdminframe));
         Validation.refreshFrame(jAdminframe);
        }
    });
    bsubmit.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
           pCenterPanel.removeAll();
           if(rbsingleuser.isSelected())
           {    
                if(rbAdmin.isSelected())
                {
                    pCenterPanel.add(new AddAdmin());
                    Validation.refreshFrame(jAdminframe);
                }
                else if(rbFaculty.isSelected())
                {
                    pCenterPanel.add(new AddFaculty());
                     Validation.refreshFrame(jAdminframe);
                }
                else if(rbHod.isSelected())
                {
                    pCenterPanel.add(new AddHod());
                    Validation.refreshFrame(jAdminframe);
                }
                else if(rbStudent.isSelected())
                {
                    pCenterPanel.add(new AddStudent());
                    Validation.refreshFrame(jAdminframe);
                }
            }    
            else if(rbmultipeuser.isSelected())
            {   
                if(rbAdmin.isSelected())
                {
                    new AddMultipleUser("Admin",jAdminframe);
                    jAdminframe.setEnabled(false);
                    
                }
                else if(rbFaculty.isSelected())
                {
                    new AddMultipleUser("Faculty",jAdminframe);
                    
                    jAdminframe.setEnabled(false);
                }
                else if(rbHod.isSelected())
                {
                    new AddMultipleUser("Hod",jAdminframe);
                    
                    jAdminframe.setEnabled(false);
                }
                else if(rbStudent.isSelected())
                {
                    new AddMultipleUser("Students",jAdminframe);
                    
                    jAdminframe.setEnabled(false);
                }
                
            }       
           
        }
    });
    
     bProfile.addActionListener(new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent ae)
          {
              pCenterPanel.removeAll();
              pCenterPanel.add(new AddAdmin(username,email,rs));
              System.out.println(username+email);
              Validation.refreshFrame(jAdminframe);
          }
      });
    
bsetting.addActionListener(new ActionListener()
{
   @Override
   public void actionPerformed(ActionEvent e)
   {
       pCenterPanel.removeAll();
       pCenterPanel.add(setting);
       Validation.refreshFrame(jAdminframe);
   }
}); 

bnotification.addActionListener(new ActionListener() 
{
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
                pCenterPanel.add(new Help());
                Validation.refreshFrame(jAdminframe); 
               
            }
        });
bemail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCenterPanel.removeAll();
                new EmailSending(email);
            }
        });

this.setting.bsubmit.addActionListener(new ActionListener() 
   {
       @Override
       public void actionPerformed(ActionEvent e) 
       {
            setButtonColor(setting.leftSideButtonColor(),setting.topSideButtonColor());
            setButtonFontColor(setting.leftSideFontColor(),setting.topSideFontColor());

           setButtonFont(new Font(setting.comboboxfontleft.getSelectedItem().toString(),Font.BOLD,13),
                   new Font(setting.comboboxfonttop.getSelectedItem().toString(),Font.BOLD,13));


         Validation.refreshFrame(jAdminframe);

       }
   });

blogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Validation.logout(jAdminframe);
            }
        });
}   
    
  
    public static void main(String []args)
    {
        Admin a=new Admin(null);
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
        
        bProfile.setFont(leftSideFont);     
        bAddUser.setFont(leftSideFont);     
        bRemoveUser.setFont(leftSideFont);     
        bUpdateUser.setFont(leftSideFont);     
        breportgeneration.setFont(leftSideFont);     
        bviewdetails.setFont(leftSideFont);     
        blogout.setFont(leftSideFont);
        
        bnotification.setFont(topSideFont);     
        bhelp.setFont(topSideFont);     
        bsetting.setFont(topSideFont);     
    }
   
    public void setButtonColor(Color leftSideColor,Color topPanelColor)
    {
        
        bProfile.setBackground(leftSideColor);
        bAddUser.setBackground(leftSideColor);
        bRemoveUser.setBackground(leftSideColor);
        bUpdateUser.setBackground(leftSideColor);
        breportgeneration.setBackground(leftSideColor);
        bviewdetails.setBackground(leftSideColor);
        blogout.setBackground(leftSideColor);
        
        bnotification.setBackground(topPanelColor);
        bhelp.setBackground(topPanelColor);
        bsetting.setBackground(topPanelColor);
    }
    
    public void setButtonFontColor(Color leftSideColor,Color topPanelColor)
    {
        bProfile.setForeground(leftSideColor);
        bAddUser.setForeground(leftSideColor);
        bRemoveUser.setForeground(leftSideColor);
        bUpdateUser.setForeground(leftSideColor);
        breportgeneration.setForeground(leftSideColor);
        bviewdetails.setForeground(leftSideColor);
        blogout.setForeground(leftSideColor);
        
        bnotification.setForeground(topPanelColor);
        bhelp.setForeground(topPanelColor);
        bsetting.setForeground(topPanelColor);
    }


}
