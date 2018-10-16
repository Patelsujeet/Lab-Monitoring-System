/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateUsers;

import AddUsers.*;
import java.awt.*;
import lms.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;



/**
 *
 * @author HP
 */
public class UpdateAdminDetails extends JPanel implements UpdateUserFunction
{
    
    JFrame AddUser;
    JLabel name,mobile,email,password,l2,l4,l5,l6,l7,l8;
    JTextField namefield,emailfield;
    JTextField mobilefield;
    JPasswordField passwordfield;
   
    JButton bupdate,bclear;
    
    DBConnection db;   
    Font bfont,textfieldfont;

    
    JPanel p1,pbutton,p2,ptitle;
    GridBagConstraints gbsAddUser,gbsAddUser1;
    GridBagLayout gblAddUser;
     
    public UpdateAdminDetails() 
    {
     /*-------------------Frame and Panel---------------*/
        db=new DBConnection(this);
     
        p1=new JPanel();
        pbutton=new JPanel();
        ptitle=new JPanel();
        p2=new JPanel();
     
        
        gblAddUser=new GridBagLayout();
        gbsAddUser=new GridBagConstraints();
        gbsAddUser1=new GridBagConstraints();
        
        p2.setLayout(gblAddUser);
        pbutton.setLayout(gblAddUser);
        
        p1.setLayout(gblAddUser);
        p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Please Fill Up Admin Details"));
        
        ptitle.setLayout(gblAddUser);
        
        
    /*---------------Labels----------------------------*/    
        AddUser=new JFrame("Admin Registration Form");
        name=new JLabel("Name");

        mobile=new JLabel("Mobile Number");
        email=new JLabel("Email-Id");
        password=new JLabel("Password");
        
        
        l2=new JLabel("                      ");
        l4=new JLabel("                      ");
        l5=new JLabel("                      ");
        l6=new JLabel("                      ");
        l7=new JLabel("                      ");
        l8=new JLabel("UPDATE ADMIN DETAILS");
    
            
     /*----------Font---------------------*/   
        bfont=new Font("Copperplate Gothic Bold",Font.BOLD,15);
        textfieldfont=new Font("Times New Roman",Font.BOLD,15);

    /*---------------Text Field------------------------*/
     
        namefield=new JTextField(20);
        namefield.setFont(textfieldfont);
        
        mobilefield=new JTextField();         
        mobilefield.setFont(textfieldfont);
        
        emailfield=new JTextField(35);
        emailfield.setFont(textfieldfont);
        
        passwordfield=new JPasswordField(20);
        passwordfield.setFont(textfieldfont);
        
   /*---------------Button------------------------*/ 
        bupdate=new JButton("UPDATE");
        bupdate.setBorder(BorderFactory.createLoweredBevelBorder());
        bupdate.setFont(bfont);
        
        bclear=new JButton("CLEAR");
        bclear.setBorder(BorderFactory.createLoweredBevelBorder());
        bclear.setFont(bfont);
        

    /*--------------Add Component to Panel--------------*/
    
    /*-----------------Title Lable----------------------*/
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=0;
        l8.setFont(new Font("Time New Romann", Font.BOLD,30));
        l8.setForeground(Color.ORANGE);
        ptitle.add(l8,gbsAddUser);
    
     /*----1st Row---------*/  
        
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=0;
        gbsAddUser.fill=GridBagConstraints.BOTH;
        gbsAddUser.ipadx=10;
        gbsAddUser.ipady=10;
        name.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(email,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=0;
        p1.add(emailfield,gbsAddUser);
      /*----2nd Row---------*/  
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=1;
        
        p1.add(l2,gbsAddUser);
      /*----3rd Row---------*/
                     
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=4;
        mobile.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(mobile,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=4;
        p1.add(mobilefield,gbsAddUser);
        /*----4th Row---------*/ 
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=5;
        p1.add(l5,gbsAddUser);
         /*----5th Row---------*/  
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=6;
        email.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(name,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=6;
        p1.add(namefield,gbsAddUser);
        
         /*----6th Row---------*/ 
         gbsAddUser.gridx=1;
         gbsAddUser.gridy=7;
        
        p1.add(l6,gbsAddUser);
         /*----7th Row---------*/ 
         
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=8;
        password.setFont(new Font("Times New Roman", Font.BOLD,15));
        p1.add(password,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=8;
        p1.add(passwordfield,gbsAddUser);
         /*----8th Row---------*/
         
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=9;
        p1.add(l7,gbsAddUser);

        /*-----------9th Row------*/
        gbsAddUser1.gridx=0;
        gbsAddUser1.gridy=0;
        gbsAddUser1.ipadx=35;
        gbsAddUser1.ipady=20;
        gbsAddUser1.insets=new Insets(5, 0, 0, 0);
        gbsAddUser1.weightx=0.5;
        gbsAddUser1.fill=GridBagConstraints.HORIZONTAL;
        pbutton.add(bupdate,gbsAddUser1);

        gbsAddUser1.gridx=1;
        gbsAddUser1.gridy=0;
        gbsAddUser1.insets=new Insets(5, 0, 0, 0);
        gbsAddUser1.weightx=0.5;    
        pbutton.add(bclear,gbsAddUser1);   
        
        /*-----Panel Combine---------*/
        
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=0;
        gbsAddUser.insets=new Insets(0, 0, 10, 0);
        p2.add(ptitle,gbsAddUser);
        
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=1;
        gbsAddUser.insets=new Insets(0, 0, 0, 0);
        p2.add(p1,gbsAddUser);
        
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=2;
        p2.add(pbutton,gbsAddUser);
         
        editAbleOfFields(false);
        add(p2);
    

 emailfield.addFocusListener(new FocusListener()
 {
    @Override 
     public void focusGained(FocusEvent e)
        {
            emailfield.setText("");
        }
        @Override
        public void focusLost(FocusEvent fe)
        {
            if(emailfield.getText().equals(""))
            {
                JOptionPane.showMessageDialog(emailfield,"Please Fill Up This Field " ,"Data Entery",JOptionPane.ERROR_MESSAGE);
                emailfield.requestFocus();
            }
            else if(new Validation().isValidEmail(emailfield.getText())==false)
            {
                JOptionPane.showMessageDialog(emailfield,"Please Fill Up Valid Email-Id " ,"Data Entery",JOptionPane.ERROR_MESSAGE);
                emailfield.requestFocus();
            }
            else
            {

              try
              {
              ResultSet rs=db.getUserDetailsForProfile("admin","email",emailfield.getText());
                if(rs.next())
                {    
                  namefield.setText(rs.getString(3));
                  mobilefield.setText(rs.getString(4));

                  emailfield.setText(rs.getString(1));
                  passwordfield.setText(rs.getString(2));
                  
                    editAbleOfFields(true);
                    emailfield.setEditable(false);
                }
                else if(rs.next()==false)
                {
                JOptionPane.showMessageDialog(emailfield,"Record Is Not Found" ,"Records",JOptionPane.ERROR_MESSAGE);
                emailfield.setText("");
                emailfield.requestFocus();
                }
                
              }
              catch(Exception e)
              {
                
                JOptionPane.showMessageDialog(emailfield,"Record Is Not Found" ,"Records",JOptionPane.ERROR_MESSAGE);
                emailfield.setText("");
                emailfield.requestFocus();

              }

            } 
        }
    });
       
bclear.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        clear();
    }
 });       

       
bupdate.addActionListener(new ActionListener() {
            @Override
            @SuppressWarnings("deprecation")
        public void actionPerformed(ActionEvent e)
        {
            setSpace();
            
            if(namefield.getText().equals(""))
                    {
                        l6.setForeground(Color.RED);
                        l6.setText("Please Fill Up This Field");
                        namefield.requestFocus();
                    }
                   else if(!namefield.getText().matches("[a-zA-Z_]+"))
                   {
                       l6.setForeground(Color.RED);
                       l6.setText("Please Fill Up Valid Data");
                        namefield.requestFocus();
                   }
                  
            else if(mobilefield.getText().equals(""))
            {
                l5.setForeground(Color.RED);
                l5.setText("Pleas Fill Up This Field"); 
                
                mobilefield.requestFocus();
            }
            else if(!mobilefield.getText().matches("[0-9_]+"))
            {
                l5.setForeground(Color.RED);
                l5.setText("Please Fill Up Only Numeric Data");
                mobilefield.requestFocus();
            }
            else if(mobilefield.getText().length()<10 || mobilefield.getText().length()>10)
            {
                l5.setForeground(Color.RED);
                l5.setText("Mobile Number Must Be 10 Digits");
                mobilefield.requestFocus();
            }
           else if(passwordfield.getText().equals(""))
            {              
                l7.setForeground(Color.RED);
                l7.setText("Pleas Fill Up This Field");
                 passwordfield.requestFocus();
            }
           else
            {
              
                int i=0;
                try
                {
                    i=db.updateAdminProfile(emailfield.getText(), emailfield.getText(),  namefield.getText(),passwordfield.getText(),mobilefield.getText());
                    if(i==1)
                    {
                        JOptionPane.showMessageDialog(emailfield,"Data Sucessfuly Updated! ! !","Data Updation",JOptionPane.INFORMATION_MESSAGE);
                        clear();
                    }
                }
                catch(Exception ex)
                {
                    
                }
                
            }
    }
});

}
    
/*    public static void main(String []args)
    {
       UpdateAdminDetails update=new UpdateAdminDetails();
       
    }
*/
 
    @Override
    public void clear()
    {
        emailfield.setEditable(true);
        namefield.setText("");
        mobilefield.setText("");
        emailfield.setText("");
        passwordfield.setText("");
        setSpace();
        editAbleOfFields(false);
    }
    @Override           
    public void setSpace()
    {   
        l2.setText("          ");
        l4.setText("          ");
        l5.setText("          ");
        l6.setText("          ");
        l7.setText("          ");
    }

    @Override
    public final void editAbleOfFields(boolean value)
    {
        namefield.setEditable(value);
        mobilefield.setEditable(value);
        passwordfield.setEditable(value);
        bupdate.setEnabled(value);
    }
    
}

