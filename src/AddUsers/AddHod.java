/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddUsers;

import lms.*;
import java.awt.*;
import java.text.ParseException;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.TitledBorder;



/**
 *
 * @author HP
 */
public class AddHod extends JPanel
{
    
    JFrame AddUser;
    JLabel name,branch,mobile,email,password,l2,l4,l5,l6,l7,l8;
    JTextField namefield,emailfield;
    JTextField mobilefield;
    JPasswordField passwordfield;
    JComboBox branchbox;
    JButton bsubmit,bclear;

    JButton bchangename,bchangedepartment,bchnagemobilenumber,bchangeemail,bchangepassord;
    
    Font bfont,textfieldfont;
    DBConnection db;
 
    
    JPanel p1,pbutton,p2,ptitle;
    GridBagConstraints gbsAddUser,gbsAddUser1;
    GridBagLayout gblAddUser;

    TitledBorder border;
    public AddHod() 
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
        border=BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Please Fill Up Details");
        p1.setBorder(border);
        
        ptitle.setLayout(gblAddUser);
        
        
    /*---------------Labels----------------------------*/    
      AddUser=new JFrame("HOD Registration Form");
        name=new JLabel("Name");
        branch=new JLabel("Department");
        mobile=new JLabel("Mobile Number");
        email=new JLabel("Email-Id");
        password=new JLabel("Password");
        
        
        l2=new JLabel("                      ");
        l4=new JLabel("                      ");
        l5=new JLabel("                      ");
        l6=new JLabel("                      ");
        l7=new JLabel("                      ");
        l8=new JLabel("HOD Registation Form");
    
        
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
    /*---------------Combobox------------------------*/ 
               
        String branchvalue[]={"Choose Department","Computer Engineering","Civil Engineering","Electrical Engineering","Electronics & Communication ","Mechanical Engineering"};
        branchbox=new JComboBox(branchvalue);
        
    /*---------------Button------------------------*/ 
        bsubmit=new JButton("SUBMIT");
        bsubmit.setBorder(BorderFactory.createLoweredBevelBorder());
        bsubmit.setFont(bfont);
        
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
        p1.add(name,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=0;
        p1.add(namefield,gbsAddUser);
      /*----2nd Row---------*/  
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=1;
        
        p1.add(l2,gbsAddUser);
      /*----3rd Row---------*/
      
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=2;
        
        branch.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(branch,gbsAddUser); 
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=2;
        p1.add(branchbox,gbsAddUser); 
        
        /*----4th Row---------*/ 
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=3;
        
        p1.add(l4,gbsAddUser); 
        /*----5th Row---------*/
        
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=4;
        mobile.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(mobile,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=4;
        p1.add(mobilefield,gbsAddUser);
        /*----6thth Row---------*/ 
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=5;
        p1.add(l5,gbsAddUser);
         /*----7th Row---------*/  
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=6;
        email.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(email,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=6;
        p1.add(emailfield,gbsAddUser);
        
         /*----8th Row---------*/ 
         gbsAddUser.gridx=1;
         gbsAddUser.gridy=7;
        
        p1.add(l6,gbsAddUser);
         /*----9th Row---------*/ 
         
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=8;
        password.setFont(new Font("Times New Roman", Font.BOLD,15));
        p1.add(password,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=8;
        p1.add(passwordfield,gbsAddUser);
         /*----10th Row---------*/
         
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=9;
        p1.add(l7,gbsAddUser);

        /*-----------11th Row------*/
        gbsAddUser1.gridx=0;
        gbsAddUser1.gridy=0;
        gbsAddUser1.ipadx=35;
        gbsAddUser1.ipady=20;
        gbsAddUser1.insets=new Insets(5, 0, 0, 5);
        gbsAddUser1.weightx=0.5;
        gbsAddUser1.fill=GridBagConstraints.HORIZONTAL;
        pbutton.add(bsubmit,gbsAddUser1);

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
        
        add(p2);
       // AddUser.add(p2);
       //AddUser.setVisible(true);
        AddUser.setSize(650,650);
        AddUser.setLocationRelativeTo(null);
        AddUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        bsubmit.addActionListener(new ActionListener()
        {
            @Override
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent ae)
            {
                setSpace();
            if(ae.getActionCommand().equalsIgnoreCase("submit"))
            {    
            if(namefield.getText().equals(""))
            {
                l2.setForeground(Color.RED);
                l2.setText("Please Fill Up This Field");
                namefield.requestFocus();
            }
           else if(!namefield.getText().matches("[a-zA-Z_]+"))
           {
               l2.setForeground(Color.RED);
               l2.setText("Please Fill Up Valid Data");
                namefield.requestFocus();
            }

            else if(branchbox.getSelectedIndex()==0)
                   {
                       l4.setText("Please Choose A Valid Department");
                       l4.setForeground(Color.RED);
                       branchbox.requestFocus();
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
                    else if(emailfield.getText().equals(""))
                    {              
                        l6.setForeground(Color.RED);
                        l6.setText("Pleas Fill Up This Field"); 
                            
                            emailfield.requestFocus();
                    }
                    else if(new Validation(){}.isValidEmail(emailfield.getText())==false)
                    {
                        l6.setForeground(Color.red);
                        l6.setText("Please Fill Up Valid Email-ID");
                        
                        emailfield.requestFocus();
                    }
                    
           else if(passwordfield.getText().equals(""))
            {              
                l7.setForeground(Color.RED);
                l7.setText("Pleas Fill Up This Field");
                
                passwordfield.requestFocus();
            }
           
           else
            {
                System.out.println("Hello");
                submit();
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
        
    }
    
    public AddHod(String name,String oldemail,ResultSet rs)
    {
        this();
                
        try
        {
            
            emailfield.setText(rs.getString(1));
            passwordfield.setText(rs.getString(2));
            namefield.setText(rs.getString(3));
            branchbox.setSelectedItem(rs.getString(4));
            mobilefield.setText(rs.getString(5));
            
            setTextEditable();
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }

        border.setTitle("Profile:"+name);
        l8.setText("Profile");
        bsubmit.setText("UPDATE");
                
        bchangedepartment=new JButton("Change");
        bchangeemail=new JButton("Change");
        bchnagemobilenumber=new JButton("Change");
        bchangepassord=new JButton("Change");
        bchangename=new JButton("Change");
        
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=0;
        p1.add(bchangename,gbsAddUser);
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=2;
        p1.add(bchangedepartment,gbsAddUser);
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=4;
        p1.add(bchnagemobilenumber,gbsAddUser);
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=6;
        p1.add(bchangeemail,gbsAddUser);
        
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=8;
        p1.add(bchangepassord,gbsAddUser);

        bchangedepartment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                branchbox.setEnabled(true);
            }
        });
        bchangeemail.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                emailfield.setEditable(true);
            }
        });
        
        bchnagemobilenumber.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                mobilefield.setEditable(true);
            }
        });
        
        
        bchangename.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                namefield.setEditable(true);
            }
        });
        
        
        bchangepassord.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                passwordfield.setEditable(true);
            }
        });
    
        bsubmit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getActionCommand().equalsIgnoreCase("update"))
                {    
                    int useroption=JOptionPane.showConfirmDialog(emailfield,"Are You Sure Update Your Profile","Updation Confirmation" ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(useroption==0)
                    {    
                    updateProfile(oldemail);
                    }
                }    
            }
        });
    }
 
    /*public static void main(String []args) throws ParseException
    {
       new AddHod();
    }*/
    @SuppressWarnings("deprecation")
    void submit()
    {
     int i;
     i=db.insertHODData( emailfield.getText(), passwordfield.getText(),namefield.getText(), branchbox.getSelectedItem().toString(), mobilefield.getText());
     
     if(i==0)
     {
         JOptionPane.showMessageDialog(namefield,"INSERTED USER ID IS ALREADY REGISTERED","USER REGISTRAION",JOptionPane.WARNING_MESSAGE);
         clear();
     }
     else if(i>0)
     {
         JOptionPane.showMessageDialog(namefield,"USER IS SUCCESSFULLY REGISTERED","USER REGISTRAION",JOptionPane.WARNING_MESSAGE);
         clear();
     }
         
     
    }
    
    void clear()
    {
      
        namefield.setText("");
        mobilefield.setText("");
        branchbox.setSelectedIndex(0);
        emailfield.setText("");
        passwordfield.setText("");
        
        setSpace();
    }
    
    void setSpace()
    {
         l2.setText("      ");
        l4.setText("        ");
        l5.setText("        ");
        l6.setText("        ");
        l7.setText("        ");                
    }
    
    @SuppressWarnings("deprecation")
    void updateProfile(String oldemail)
    {
     int i=db.updateHodProfile(oldemail, emailfield.getText(),passwordfield.getText(), namefield.getText(),branchbox.getSelectedItem().toString(), mobilefield.getText());
     
     if(i>0)
     {
        JOptionPane.showMessageDialog(emailfield,"<html>Data is SuccessFully Update<br/>Updation Will Refelect Next Login</html>","Updation",JOptionPane.INFORMATION_MESSAGE);
     }
    }

    final void setTextEditable()
    {
        namefield.setEditable(false);
        mobilefield.setEditable(false);
        emailfield.setEditable(false);
        passwordfield.setEditable(false);
        branchbox.setEnabled(false);
    }
}

