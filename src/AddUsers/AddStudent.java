/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddUsers;

import lms.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.border.TitledBorder;


/**
 *
 * @author HP
 */
public class AddStudent extends JPanel implements ActionListener
{    

    JLabel enrollment,name,sem,branch,mobile,email,password,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField namefield,emailfield;
    JTextField mobilefield,enrollmentnumber;
    JPasswordField passwordfield;
    JComboBox branchbox,sembox;
    JButton bsubmit,bclear;
    
    JButton bchangename,bchangeemail,bchangemobile,bchangeenrollment,bchnagepassword,bchangebranch,bchnagesem;
    
    Font bfont,textfieldfont;
    DBConnection db;
        
    JPanel p1,pbutton,p2,ptitle;
    GridBagConstraints gbsAddUser,gbsAddUser1;
    GridBagLayout gblAddUser;

    TitledBorder border;
    public AddStudent()
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
    
     /*----------Font---------------------*/   
        bfont=new Font("Copperplate Gothic Bold",Font.BOLD,15);
        textfieldfont=new Font("Times New Roman",Font.BOLD,15);
        
    /*---------------Labels----------------------------*/    
  
        enrollment=new JLabel("Enrollment Number");
        enrollment.setForeground(Validation.fontColor());
        
        name=new JLabel("Name");
        name.setForeground(Validation.fontColor());
        
        sem=new JLabel("Semester");
        sem.setForeground(Validation.fontColor());
        
        branch=new JLabel("Department");
        branch.setForeground(Validation.fontColor());
        
        mobile=new JLabel("Mobile Number");
        mobile.setForeground(Validation.fontColor());
        
        email=new JLabel("Email-Id");
        email.setForeground(Validation.fontColor());
        
        password=new JLabel("Password");
        password.setForeground(Validation.fontColor());
        
        l1=new JLabel("                      ");
        l2=new JLabel("                      ");
        l3=new JLabel("                      ");
        l4=new JLabel("                      ");
        l5=new JLabel("                      ");
        l6=new JLabel("                      ");
        l7=new JLabel("                      ");
        l8=new JLabel("Student Registation Form");
    
    /*---------------Text Field------------------------*/
     
        enrollmentnumber=new JTextField(12);
        enrollmentnumber.setFont(textfieldfont);
        
        namefield=new JTextField(20);
        namefield.setFont(textfieldfont);
        
        mobilefield=new JTextField();         
        mobilefield.setFont(textfieldfont);
        
        emailfield=new JTextField(35);
        emailfield.setFont(textfieldfont);
        
        passwordfield=new JPasswordField(20);
        password.setFont(textfieldfont);
        
    /*---------------Combobox------------------------*/ 
        String semvalue[]={"Choose Semester","1st","2nd","3rd","4th","5th","6th","7th","8th"};
        sembox=new JComboBox(semvalue);
        sembox.setFont(textfieldfont);
        
        String branchvalue[]={"Choose Department","Computer Engineering","Civil Engineering","Electrical Engineering","Electronics & Communication ","Mechanical Engineering"};
        branchbox=new JComboBox(branchvalue);
        branchbox.setFont(textfieldfont);
        
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
        gbsAddUser.ipadx=10;
        gbsAddUser.ipady=10;
        gbsAddUser.fill=GridBagConstraints.BOTH;
        enrollment.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(enrollment,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=0;
        p1.add(enrollmentnumber,gbsAddUser);
      /*----2nd Row---------*/  
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=1;
        p1.add(l1,gbsAddUser);
      /*----3rd Row---------*/  
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=2;
        name.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(name,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=2;
        p1.add(namefield,gbsAddUser);
      /*----4th Row---------*/  
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=3;
        
        p1.add(l2,gbsAddUser);
      /*----5th Row---------*/  
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=4;
        
        sem.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(sem,gbsAddUser); 
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=4;
        
        p1.add(sembox,gbsAddUser);
     /*----6th Row---------*/
     
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=5;
        
        p1.add(l3,gbsAddUser);  
        /*----7th Row---------*/
        
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=6;
        
        branch.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(branch,gbsAddUser); 
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=6;
        
        p1.add(branchbox,gbsAddUser); 
        /*----8th Row---------*/ 
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=7;
        
        p1.add(l4,gbsAddUser); 
        /*----9th Row---------*/
        
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=8;
        mobile.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(mobile,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=8;
        
        p1.add(mobilefield,gbsAddUser);
        /*----10th Row---------*/ 
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=9;
        
        p1.add(l5,gbsAddUser);
         /*----11th Row---------*/  
         
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=10;
        
        email.setFont(new Font("Times New Roman", Font.BOLD, 15));
        p1.add(email,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=10;
        
        p1.add(emailfield,gbsAddUser);
         /*----12th Row---------*/ 
         
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=11;
        
        p1.add(l6,gbsAddUser);
         /*----13th Row---------*/ 
         
        gbsAddUser.gridx=0;
        gbsAddUser.gridy=12;
        
        password.setFont(new Font("Times New Roman", Font.BOLD,15));
        p1.add(password,gbsAddUser);
        
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=12;
        
        p1.add(passwordfield,gbsAddUser);
         /*----14th Row---------*/
         
        gbsAddUser.gridx=1;
        gbsAddUser.gridy=13;
        p1.add(l7,gbsAddUser);

        /*-----------15th Row------*/
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
        
        bsubmit.addActionListener(this);
        bclear.addActionListener(this);
        
    }

    public AddStudent(String name,String email,ResultSet rs)
    {
        this();
        try
        {
            enrollmentnumber.setText(rs.getString(1));
            namefield.setText(rs.getString(2));
            
            sembox.setSelectedItem(rs.getString(3));
            branchbox.setSelectedItem(rs.getString(4));
            
            passwordfield.setText(rs.getString(5));          
            mobilefield.setText(rs.getString(6));
            
            emailfield.setText(rs.getString(7));
           
            setTextEditable();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        bchangebranch=new JButton("Change");
        bchangeemail=new JButton("Change");
        
        bchangeenrollment=new JButton("Change");
        bchangemobile=new JButton("Change");
        
        bchangename=new JButton("Change");
        bchnagepassword=new JButton("Change");
        
        bchnagesem=new JButton("Change");
        
        border.setTitle("Profile:"+name);
        l8.setText("Profile");
        bsubmit.setText("UPDATE");
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=0;
        p1.add(bchangeenrollment,gbsAddUser);
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=2;
        p1.add(bchangename,gbsAddUser);
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=4;
        p1.add(bchnagesem,gbsAddUser);
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=6;
        p1.add(bchangebranch,gbsAddUser);
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=8;
        p1.add(bchangemobile,gbsAddUser);
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=10;
        p1.add(bchangeemail,gbsAddUser);
        
        gbsAddUser.gridx=2;
        gbsAddUser.gridy=12;
        p1.add(bchnagepassword,gbsAddUser);
        
        bchangeenrollment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                enrollmentnumber.setEditable(true);
            }
        });
        bchangebranch.addActionListener(new ActionListener(){
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
        
        bchangemobile.addActionListener(new ActionListener(){
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
        
        bchnagesem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                sembox.setEnabled(true);
            }
        });
        
        bchnagepassword.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                passwordfield.setEditable(true);
            }
        });
    
        bsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(e.getActionCommand().equalsIgnoreCase("update"))
                {    
                    int useroption=JOptionPane.showConfirmDialog(emailfield,"Are You Sure Update Your Profile","Updation Confirmation" ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(useroption==0)
                    {    
                    updateProfile(email);
                    }
                }    
            }
        });
        setBackground(new Color(186,104,200));
    }
  /* 
    public static void main(String []args)
    {
        AddStudent addStudent = new AddStudent();
    }
*/
    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent ae)
    {
        String submit=ae.getActionCommand();
        
        if(submit.equals("SUBMIT"))
        { 
           String enr=enrollmentnumber.getText();
            setSpace();       
           if(enr.equals(""))
           {
               l1.setForeground(Color.RED);
               l1.setText("Please Fill Up This Field"); 
                enrollmentnumber.requestFocus();
           } 
           else if(enr.length()<12 || enr.length()>12)
           {
            
               l1.setForeground(Color.RED);
               l1.setText("Enrollment Number Must Be 12 Digits");
               
            enrollmentnumber.requestFocus();
           }
           else if(!enr.matches("[0-9_]+"))
           {
               l1.setForeground(Color.RED);
               l1.setText("Please Fill Up Only Numeric Data");
                enrollmentnumber.requestFocus();
           }    
                    else if(namefield.getText().equals(""))
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
            else if(sembox.getSelectedIndex()==0)
            {
                l3.setText("Please Choose Valid Semester");
                l3.setForeground(Color.RED);
                sembox.requestFocus();
            }
                   else if(branchbox.getSelectedIndex()==0)
                   {
                       l4.setText("Please Choose Valid Department");
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
                submit();
            }
           
        }
        else if(submit.equals("CLEAR"))
        {
            clear();
        }
    } 
    
    @SuppressWarnings("deprecation")
    void submit()
    {
        String sem=(String)sembox.getSelectedItem();
        String department=(String)branchbox.getSelectedItem();
        
        int i=db.insertStudentData(enrollmentnumber.getText(),namefield.getText(),sem, department, passwordfield.getText(),mobilefield.getText(), emailfield.getText() );
    
        if(i==0)
        {
         JOptionPane.showMessageDialog(namefield,"INSERTED USER IS ALREADY REGISTERED","USER REGISTRAION",JOptionPane.WARNING_MESSAGE);
        }
        else if(i==1)
        {    
        JOptionPane.showMessageDialog(namefield,"Data SuccessFully Inserted","USER REGISTRAION",JOptionPane.WARNING_MESSAGE);
        }
        clear();
    }
    
    @SuppressWarnings("deprecation")
    void updateProfile(String oldemail)
    {
        String sem=(String)sembox.getSelectedItem();
        String department=(String)branchbox.getSelectedItem();
        System.out.println(enrollmentnumber.getText());
     
        int i=db.updateStudentProfile(oldemail,enrollmentnumber.getText(),namefield.getText(),sem, department, passwordfield.getText(),mobilefield.getText(), emailfield.getText() );
        
        if(i>0)
        {
           JOptionPane.showMessageDialog(emailfield,"<html>Data is SuccessFully Update<br/>Updation Will Refelect Next Login</html>","Updation",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    void clear()
    {
        enrollmentnumber.setText("");
        namefield.setText("");
        mobilefield.setText("");
        sembox.setSelectedIndex(0);
        branchbox.setSelectedIndex(0);
        emailfield.setText("");
        passwordfield.setText("");
        setSpace();
    }
    void setSpace()
    {
            l1.setText(" ");
            l2.setText("               ");
            l3.setText("               ");
            l4.setText("               ");
            l5.setText("                ");
            l6.setText("                 ");
            l7.setText("                 ");
        
    }

final void setTextEditable()
    {
        namefield.setEditable(false);
        mobilefield.setEditable(false);
        emailfield.setEditable(false);
        passwordfield.setEditable(false);
        branchbox.setEnabled(false);
        sembox.setEnabled(false);
        enrollmentnumber.setEditable(false);
    }    
}

    