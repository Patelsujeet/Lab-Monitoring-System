/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateUsers;

import java.awt.*;
import java.text.ParseException;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import lms.DBConnection;
import lms.Validation;



/**
 *
 * @author HP
 */
public class UpdateStudentDetails extends JPanel implements UpdateUserFunction
{

    
    JFrame AddUser;
    JLabel enrollment,name,sem,branch,mobile,email,password,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField namefield,emailfield;
    JTextField mobilefield,enrollmentnumber,passwordfield;
  
    JComboBox branchbox,sembox;
    JButton bupdate,bclear;
    
    DBConnection db;
    
    Font bfont,textfieldfont;
    
    JPanel p1,pbutton,p2,ptitle;
    GridBagConstraints gbsAddUser,gbsAddUser1;
    GridBagLayout gblAddUser;
     
    public UpdateStudentDetails() 
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
        p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Fill Up Students Details"));
        
        ptitle.setLayout(gblAddUser);
        
        
     /*----------Font---------------------*/   
        bfont=new Font("Copperplate Gothic Bold",Font.BOLD,15);
        textfieldfont=new Font("Times New Roman",Font.BOLD,15);
        
        
    /*---------------Labels----------------------------*/    
        AddUser=new JFrame("Update Student Details");
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
        l8=new JLabel("UPDATE STUDENT DETAILS");
    
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
        
        String branchvalue[]={"Choose Department","Computer Engineering","Civil Engineering","Electrical Engineering","Electronics & Communication ","Mechanical Engineering"};
        branchbox=new JComboBox(branchvalue);
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
        
        enrollmentnumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e)
            {
                
            }

            @Override
            public void focusLost(FocusEvent fe)
            {
                if(enrollmentnumber.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(enrollmentnumber,"Please Fill Up This Field " ,"Data Entery",JOptionPane.ERROR_MESSAGE);
                    enrollmentnumber.requestFocus();
                }
                else if(enrollmentnumber.getText().length()<12 || enrollmentnumber.getText().length()>12)
                {
                    JOptionPane.showMessageDialog(enrollmentnumber,"Enrollment Number Must Be 12 Digits " ,"Data Entery",JOptionPane.ERROR_MESSAGE);
                    enrollmentnumber.requestFocus();
                }
                else if(!enrollmentnumber.getText().matches("[0-9_]+"))
                {
                    JOptionPane.showMessageDialog(enrollmentnumber,"Enrollment Number Must Be Numeric " ,"Data Entery",JOptionPane.ERROR_MESSAGE);
                    enrollmentnumber.requestFocus();
                }    

                else
                {

                  try
                  {
                  ResultSet rs=db.getUserDetailsForProfile("student","enrollment",enrollmentnumber.getText());
                 
                  if(rs.next())
                  {    
                    namefield.setText(rs.getString(2));
                    sembox.setSelectedItem(rs.getString(3));

                    branchbox.setSelectedItem(rs.getString(4));
                    mobilefield.setText(rs.getString(6));

                    emailfield.setText(rs.getString(7));
                    passwordfield.setText(rs.getString(5));
                    
                    enrollmentnumber.setEditable(false);
                    editAbleOfFields(true);
                    
                  }
                  else if(rs.next()==false)
                  {
                    JOptionPane.showMessageDialog(enrollmentnumber,"Record Is Not Found" ,"Records",JOptionPane.ERROR_MESSAGE);
                    enrollmentnumber.setText("");
                    enrollmentnumber.requestFocus();
                  }
                  
                  }
                  catch(SQLException e)
                  {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(enrollmentnumber,"Record Is Not Found" ,"Records",JOptionPane.ERROR_MESSAGE);
                    enrollmentnumber.setText("");
                    enrollmentnumber.requestFocus();
                    
                  }
              
                } 
            }
                
            
        });
                                
        
        
        bupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
               String enr=enrollmentnumber.getText();
               
               setSpace();
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
                    else if(new Validation().isValidEmail(emailfield.getText())==false)
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

                int i=0;
                String sem=(String)sembox.getSelectedItem();
                String department=(String)branchbox.getSelectedItem();

                try
                {
               i=db.updateStudentProfile(enrollmentnumber.getText(),enrollmentnumber.getText(),namefield.getText(), sem, department, passwordfield.getText(), mobilefield.getText(), emailfield.getText());
               }catch(Exception e){e.printStackTrace();}


               if(i==1)
               {
                JOptionPane.showMessageDialog(sembox,"Data Sucessfuly Updated! ! !");
               }

             }
            
            }
        });
        bclear.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e)
            {
                clear();
            }
        });
        
    }
  /*
    public static void main(String []args) throws ParseException
    {
        new UpdateStudentDetails();
    }
 */
    
    @Override
     public void clear()
    {
        enrollmentnumber.setEditable(true);
        enrollmentnumber.setText("");
        namefield.setText("");
        mobilefield.setText("");
        sembox.setSelectedIndex(0);
        branchbox.setSelectedIndex(0);
        emailfield.setText("");
        passwordfield.setText("");
        editAbleOfFields(false);
        setSpace();
    }
     @Override
    public void setSpace()
    {
        
        l2.setText("               ");
        l3.setText("               ");
        l4.setText("               ");
        l5.setText("                ");
        l6.setText("                 ");
        l7.setText("                 ");
    }
    
    @Override
    public void editAbleOfFields(boolean value)
    {
        
        namefield.setEditable(value);
        sembox.setEnabled(value);
        branchbox.setEnabled(value);
        mobilefield.setEditable(value);
        emailfield.setEditable(value);
        passwordfield.setEditable(value);
        bupdate.setEnabled(value);
    }
}

