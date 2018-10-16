/*

Login File is Completed Done


*/
package lms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class login 
{
	JFrame f;
	
        GridBagLayout gbl1;
        GridBagLayout gbl2;
        
	GridBagConstraints gbs;
	GridBagConstraints gbs1;
    
        
	JTextField t1;
	JPasswordField t2;
	
	JLabel luserId,lpassword,l3,l4,l5,l6,logo,lusertype,lcompanydetails,lother;
	
	JButton b1,b2;
	JPanel p,pbutton,pusertype,pcompanydetail,pwhole;
        
        Font tfont;
        JComboBox cUserType;
        
        DBConnection db;
        Validation vd;

        Color bcolor;
	public login()
	{
		
            f=new JFrame("LAB MONITORING SYSTEM");

            gbl1=new GridBagLayout();
            gbl2=new GridBagLayout();
            
            p=new JPanel();
            pbutton=new JPanel();            
            
            pusertype=new JPanel();
            pcompanydetail=new JPanel();
            
            pwhole=new JPanel();

            gbs=new GridBagConstraints();
            gbs1=new GridBagConstraints();
           
            tfont=new Font("Times New Roman",Font.BOLD,16);
            t1=new JTextField(25);
            t1.setFont(tfont);
            
            t2=new JPasswordField(25);
            t2.setFont(tfont);
            
            luserId=new JLabel("User ID");
            luserId.setForeground(Color.GRAY);
            
            lpassword=new JLabel("Password");
            lpassword.setForeground(Color.GRAY); 
            
            l3=new JLabel("                           ");
            l4=new JLabel("                ");
            
            l5=new JLabel("                ");
            l6=new JLabel("                ",JLabel.CENTER);
            
            logo=new JLabel(new ImageIcon(getClass().getResource("/ImageIcons/UnknownUser.jpeg")));
            logo.setSize(225,225);
            
            lusertype=new JLabel("User Type");
            
            bcolor=new Color(255,140,0);
            b1=new JButton("LOGIN");
            b1.setBorder(BorderFactory.createLoweredBevelBorder());
            b1.setFont(new Font("Times New Roman",Font.BOLD,20));
            b1.setBackground(bcolor);
            b1.setForeground(Color.WHITE);
            
            b2=new JButton("RESET");
            b2.setBorder(BorderFactory.createLoweredBevelBorder());
            b2.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,20));
            b2.setBackground(bcolor);
            b2.setForeground(Color.WHITE);
            
            String usertype[]={"SELECT USER TYPE","ADMIN","FACULTY","HOD","STUDENT",};
            cUserType=new JComboBox(usertype);
            
            
            p.setLayout(gbl1);
            pbutton.setLayout(gbl2);
           
            pusertype.setLayout(gbl1);
            pwhole.setLayout(gbl1);

        /*-----------pusertype panel-----------------*/
        //----------1st-----------   
            gbs.gridx=0;
            gbs.gridy=0;
            gbs.gridwidth=2;
            gbs.insets=new Insets(0, 0, 10, 0);
            gbs.ipadx=250;
            gbs.fill=GridBagConstraints.BOTH;
            pusertype.add(logo,gbs);
        //-------------2nd-------    
            gbs.gridx=0;
            gbs.gridy=1;
            gbs.gridwidth=1;
            gbs.ipadx=0;
            gbs.insets=new Insets(0, 10, 0, 10);
            gbs.fill=GridBagConstraints.BOTH;
            pusertype.add(lusertype,gbs);
            lusertype.setFont(new Font("Times New Roman", Font.BOLD, 25));

            gbs.gridx=1;
            gbs.gridy=1;
            gbs.gridwidth=1;
            gbs.insets=new Insets(0, 37, 0, 20);
            gbs.fill=GridBagConstraints.BOTH; 
            cUserType.setFont(new Font("Times New Roman",Font.BOLD,15));
            pusertype.add(cUserType,gbs);
         //--------------3rd Panel--------------
            gbs.gridx=1;
            gbs.gridy=2;
            l3.setFont(new Font("Times New Roman",Font.BOLD,15));
            pusertype.add(l3,gbs);

   /*----------plogin panel-------------------*/         

            gbs.gridx=0;
            gbs.gridy=0;
            gbs.insets=new Insets(0, 0, 0, 20);
            luserId.setFont(new Font("Times New Roman", Font.BOLD, 25));
            p.add(luserId,gbs);

            gbs.gridx=1;
            gbs.gridy=0;
            p.add(t1,gbs);

            gbs.gridx=1;
            gbs.gridy=1;
            l4.setFont(new Font("Times New Roman", Font.BOLD, 15));
            p.add(l4,gbs);

            gbs.gridx=0;
            gbs.gridy=2;
            lpassword.setFont(new Font("Times New Roman",Font.BOLD,25));
            p.add(lpassword,gbs);

            gbs.gridx=1;
            gbs.gridy=2;
            p.add(t2,gbs);

            gbs.gridx=1;
            gbs.gridy=3;
            l5.setFont(new Font("Times New Roman",Font.BOLD,15));
            p.add(l5,gbs);

            gbs.gridx=0;
            gbs.gridy=4;
            gbs.gridwidth=2;
            gbs.fill=GridBagConstraints.BOTH;
            p.add(pbutton,gbs);


                    gbs1.gridx=0;
                    gbs1.gridy=0;
                    gbs1.ipady=20;
                    gbs1.ipady=20;
                    gbs1.weightx=0.5;
                    gbs1.insets=new Insets(5,0,0,5);
                    gbs1.fill=GridBagConstraints.BOTH;
                    pbutton.add(b1,gbs1);

                    gbs1.gridx=1;
                    gbs1.gridy=0;
                    gbs1.ipady=20;
                    gbs1.ipady=20;
                    gbs1.insets=new Insets(5,5,0,0);
                    gbs1.fill=GridBagConstraints.BOTH;
                    pbutton.add(b2,gbs1);  		

                gbs.gridx=0;
                gbs.gridy=5;
                p.add(l6,gbs);
                l6.setFont(new Font("Times New Roman", Font.BOLD, 25));
                l6.setForeground(Color.RED);
/*-------------------------user details panel--------------*/	


                lcompanydetails=new JLabel("@ LAB MONITORING SYSTEM CORPORATION ");
                lcompanydetails.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 15));
                lcompanydetails.setForeground(Color.BLUE);

                pcompanydetail.setBackground(Color.GREEN);
                pcompanydetail.add(lcompanydetails);

           /*-------------frame Panel-----------*/
                gbs.gridx=0;
                gbs.gridy=0;
                gbs.insets=new Insets(0, 0, 5, 0);
                gbs.ipadx=20;
                gbs.fill=GridBagConstraints.BOTH;
                pwhole.add(pusertype,gbs);

                gbs.gridx=1;
                gbs.gridy=1;
                pwhole.add(p,gbs);

                f.add(pwhole,BorderLayout.CENTER);
                f.add(pcompanydetail,BorderLayout.PAGE_END);


                b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                { 
                    blogin();
                }});

                b1.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e)
                {
                    if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    {
                        blogin();
                    }
                }
                });
        b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
          {
               reset();
          }}); 
        
        b2.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent ke)
        {
            if(ke.getKeyCode()==KeyEvent.VK_ENTER)
            {
               reset();
            }
        }
        });
        cUserType.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {

        int usertypeindex = cUserType.getSelectedIndex();

            t1.requestFocus();
                switch (usertypeindex) 
                {
                    case 0:
                        logo.setIcon(new ImageIcon(getClass().getResource("/ImageIcons/UnknownUser.jpeg")));
                        p.setVisible(false);
                        break;
                    case 1:
                        logo.setIcon(new ImageIcon(getClass().getResource("/ImageIcons/Admin.jpeg")));
                        luserId.setText("Email Id       ");
                        p.setVisible(true);
                        clear();
                        break;
                    case 2:
                        logo.setIcon(new ImageIcon(getClass().getResource("/ImageIcons/Faculty.jpeg")));
                        luserId.setText("Email Id       ");
                        p.setVisible(true);
                        clear();
                        break;
                    case 3:
                        logo.setIcon(new ImageIcon(getClass().getResource("/ImageIcons/HOD.png")));
                        luserId.setText("Email Id       ");
                        p.setVisible(true);
                        clear();
                        break;
                    case 4:
                        logo.setIcon(new ImageIcon(getClass().getResource("/ImageIcons/Student.jpeg")));
                        luserId.setText("Enrollment No.");
                        p.setVisible(true);
                        clear();
                        break;    
                    default:
                        break;
                }
                }
            });


            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            f.setSize(d);
            f.getContentPane().setBackground(Color.WHITE);
            f.setVisible(true);


            pusertype.setBackground(Color.WHITE);
            p.setBackground(Color.WHITE);
            pbutton.setBackground(Color.WHITE);
            pwhole.setBackground(Color.WHITE);

            p.setVisible(false);
            db=new DBConnection(f);
				 
	}

void reset()
{
    clear();
    cUserType.setSelectedIndex(0);
}

void clear()
{
    t1.setText("");
    t2.setText("");
    l4.setText("                  ");
    l5.setText("                  ");
    l6.setText("                  ");
}
@SuppressWarnings("deprecation")
void blogin()
{
                  
    String str=cUserType.getSelectedItem().toString();
    vd=new Validation();

   if(t1.getText().equals(""))
     {
       
       t1.requestFocus();
       l4.setText("Please Fill Up This Field");
       l4.setForeground(Color.RED);
       l6.setText("                 ");
       l5.setText("                 ");
     }
     else if(t2.getText().equals(""))
     {
       t2.requestFocus();  
       l5.setText("Please Fill Up This Field");
       l5.setForeground(Color.RED);
       l6.setText("             ");
       l4.setText("             ");
     }
     else if(str.equals("STUDENT"))
     {
         if(!t1.getText().matches("[0-9_]+"))
         {
             t1.setSelectionStart(0);
             t1.requestFocus();
             l4.setText("Please Fill Up Digits");
             l4.setForeground(Color.RED);
             l6.setText("                 ");
             l5.setText("                 ");
         }
         else if(t1.getText().length()<12 || t1.getText().length()>12)
         {
             t1.setSelectionStart(0);
             t1.requestFocus();
             l4.setText("Enrollment Number Must be 12 Digits");
             l4.setForeground(Color.RED);
             l6.setText("                 ");
             l5.setText("                 ");
         }
        else if(t1.getText()!=null && t2.getText()!=null)
        {    
        submit();
        }
     }
    else if(str.equals("ADMIN") || str.equals("FACULTY") || str.equals("HOD") || str.equals("LABCOORDINATOR"))
     {
         if(vd.isValidEmail(t1.getText())==false)
         {
           t1.setSelectionStart(0);  
           t1.requestFocus();
           l4.setText("Please Fill Up Valid Email ID");
           l4.setForeground(Color.RED); 
           l6.setText("                 ");
           l5.setText("            ");
         }  
         else if(t1.getText()!=null && t2.getText()!=null)
          {    
          submit();
          }
     }

}
@SuppressWarnings("deprecation")
void submit()
{
        String uid = t1.getText();
        String upassword = t2.getText();
        String selectuser=cUserType.getSelectedItem().toString();
        boolean b1=false;

        if(selectuser.equalsIgnoreCase("student"))
        {
           b1 = db.search(uid, upassword,selectuser.toLowerCase(),"enrollment");
        }
        else
        {
           b1 = db.search(uid, upassword,selectuser.toLowerCase(),"email");
        }
        
        if(b1 && selectuser.equalsIgnoreCase("faculty"))
        {
                f.setVisible(false);
                ResultSet rs=db.getUserDetailsForProfile(selectuser.toLowerCase(),"email", uid);
                             
                if(rs == null)
                {
                    Faculty f=new Faculty(); 
                }
                else
                {
                    try
                    {    
                        Faculty f1=new Faculty(rs); 
                    }
                    catch(Exception e)
                    {
                        
                    }
                }
        }
        else if(b1 && selectuser.equalsIgnoreCase("student"))
        {
            f.setVisible(false);
            ResultSet rs=db.getUserDetailsForProfile(selectuser.toLowerCase(),"enrollment", uid);
            if(rs==null)
            {
                try
                { 
                    Student s=new Student();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
            else
            {
              Student s1=new Student(rs); 
            }
        }
        else if(b1 && selectuser.equalsIgnoreCase("hod"))
        {
                f.setVisible(false);
                ResultSet rs=db.getUserDetailsForProfile(selectuser.toLowerCase(),"email", uid);
               if(rs==null)
               {    
                Hod h=new Hod();
               }
               else
               {
                   Hod h1=new Hod(rs);
               }
        }
        else if(b1 && selectuser.equalsIgnoreCase("admin"))
        {           
            f.setVisible(false);
            ResultSet rs=db.getUserDetailsForProfile(selectuser.toLowerCase(),"email", uid);
            
            if(rs==null)
            {
               Admin f=new Admin();  
            }
            else
            {
               Admin f=new Admin(rs);  
            }
                                  
        }

        else{
                t1.setSelectionStart(0);
                t1.requestFocus();
                l4.setText("                  ");
                l5.setText("                 ");
                l6.setText("INSERT USER ID IS NOT EXIST");
        }

    }
/*
	public static void main(String ar[])
	{
	
		new login();
	}
*/
}
