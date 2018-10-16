/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import lms.DBConnection;
import lms.Validation;

/**
 *
 * @author HP
 */
public class RemoveUser extends JPanel
{
    DBConnection db;   
        
    JLabel lremovestudent,lenrollment,lchoosefieldforsingleuser;
    JLabel lsemester,lbranch,lchoosefieldformultipleusersem,lchoosefieldformultipleusebranch;
    
    JComboBox semester,branch;
    JButton bdeletebysem;
    
    JButton bdelete;
    JTextField tuserid;

    GridBagLayout gbl;
    GridBagConstraints gbs;

    JPanel premoveuser,psingleuser,pwhole,pmultipleuser;

    
    Font fnt;


    JPanel paddUser;
    
    GridBagConstraints gbs1;

    public RemoveUser(String usertype)
    {
        gbs1=new GridBagConstraints();
        
        db=new DBConnection(this);
              
        fnt=new Font("Times New Roman",Font.BOLD,20);


        lremovestudent =new JLabel("REMOVE "+usertype.toUpperCase(),JLabel.CENTER);
        lremovestudent.setFont(new Font("Times New Roman",Font.BOLD,40));
        lremovestudent.setForeground(Validation.fontColor());
        
        tuserid=new JTextField(20);
        tuserid.setFont(new Font("Times New Roman",Font.BOLD,15));


        lenrollment =new JLabel("USER ID");
        lenrollment.setForeground(Validation.fontColor());
        
        lchoosefieldforsingleuser =new JLabel("               ");
        
        lbranch=new JLabel("Derpartment");
        lbranch.setForeground(Validation.fontColor());
        String branchvalue[]={"Choose Department","Computer Engineering","Civil Engineering","Electrical Engineering","Electronics & Communication ","Mechanical Engineering"};
        branch=new JComboBox(branchvalue);
        
        
        lsemester=new JLabel("Semester");
        lsemester.setForeground(Validation.fontColor());
        String semvalue[]={"Choose Semester","1st","2nd","3rd","4th","5th","6th","7th","8th"};
        semester=new JComboBox(semvalue);
       
        bdelete=new JButton("REMOVE");
        bdeletebysem=new JButton("REMOVE");

        premoveuser=new JPanel(new GridBagLayout());
       
        
        psingleuser=new JPanel(new GridBagLayout());
        psingleuser.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Single User"));
       
        
        pmultipleuser=new JPanel(new GridBagLayout());
        pmultipleuser.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Multiple User"));
       
        
        pwhole=new JPanel(new GridBagLayout());
       
        
        premoveuser.add(lremovestudent);
	/*------------------------Single User Panel---------------------------------*/	
		gbs=new GridBagConstraints();
			
		gbs.gridx=0;
		gbs.gridy=0;
                    gbs.insets=new Insets(0,0,5, 5);
                gbs.fill=GridBagConstraints.BOTH;
		psingleuser.add(lenrollment,gbs);
                lenrollment.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		gbs.gridx=1;
		gbs.gridy=0;
		gbs.gridwidth=2;
		psingleuser.add(tuserid,gbs);
		
                gbs.gridx=1;
		gbs.gridy=1;
		gbs.gridwidth=2;
		psingleuser.add(lchoosefieldforsingleuser,gbs);
                
		gbs.gridx=0;
		gbs.gridy=2;
		gbs.gridwidth=1;
                gbs.fill=GridBagConstraints.BOTH;
                bdelete.setFont(new Font("Times New Roman",Font.BOLD,15));
		psingleuser.add(bdelete,gbs);
    /*------------------------Single User Panel---------------------------------*/	    
    /*------------------------Mulitple User Panel---------------------------------*/	            
            if(usertype.equalsIgnoreCase("student"))
            {    
                gbs.gridx=0;
                gbs.gridy=0;
                gbs.gridwidth=2;
                gbs.insets=new Insets(0,0,5,15);
                gbs.fill=GridBagConstraints.BOTH;
                pmultipleuser.add(lsemester,gbs);
                lsemester.setFont(new Font("Times New Roman",Font.BOLD,20));
                
                gbs.gridx=1;
                gbs.gridy=0;
                pmultipleuser.add(semester,gbs);
                
                gbs.gridx=1;
                gbs.gridy=1;
                lchoosefieldformultipleusersem=new JLabel("  ");
                pmultipleuser.add(lchoosefieldformultipleusersem,gbs);
            }      
            
            if(usertype.equalsIgnoreCase("hod") || usertype.equalsIgnoreCase("student") || usertype.equalsIgnoreCase("faculty"))
            {   
                gbs.gridx=0;
                gbs.gridy=2;
                pmultipleuser.add(lbranch,gbs);
                lbranch.setFont(new Font("Times New Roman",Font.BOLD,20));
                
                gbs.gridx=1;
                gbs.gridy=2;
                pmultipleuser.add(branch,gbs);
                
                gbs.gridx=1;
                gbs.gridy=3;
                lchoosefieldformultipleusebranch=new JLabel(" ");
                pmultipleuser.add(lchoosefieldformultipleusebranch,gbs);
                                
            }    
                gbs.gridx=0;
                gbs.gridy=4;
                gbs.gridwidth=1;
                gbs.fill=GridBagConstraints.BOTH;
                bdeletebysem.setFont(new Font("Times New Roman",Font.BOLD,15));
                pmultipleuser.add(bdeletebysem,gbs);
    /*------------------------Mulitple User Panel---------------------------------*/	                        
                gbs.gridx=0;
                gbs.gridy=0;
                gbs.ipadx=150;
                gbs.insets=new Insets(0, 0,20, 0);
                pwhole.add(lremovestudent,gbs);
                
                gbs.gridx=0;
                gbs.gridy=1;
                pwhole.add(psingleuser,gbs);       
                
             if(usertype.equalsIgnoreCase("hod") || usertype.equalsIgnoreCase("student") || usertype.equalsIgnoreCase("faculty") )
             {   
                gbs.gridx=0;
                gbs.gridy=2;
                pwhole.add(pmultipleuser,gbs);   
             }  
                add(pwhole);
      
 
bdelete.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {                

    if(tuserid.getText().equals(""))
    {
        lchoosefieldforsingleuser.setForeground(Color.red);
        lchoosefieldforsingleuser.setText("Please Fill Up This Field");

    }
    else
    {  
        try
        {
            int i=0,useroption;
            useroption=JOptionPane.showConfirmDialog(tuserid,"Are You Sure Remove This User", "User Remove", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(useroption==0)
            {
                i=db.remove(usertype.toLowerCase(),tuserid.getText(),null,null);
                if(i>0)
                {    
                    JOptionPane.showMessageDialog(tuserid,"DATA SUCCESSFULLY REMOVED ! ! !");
                }  
                else
                {
                    JOptionPane.showMessageDialog(tuserid,"RECORD NOT FOUND ! ! !");
                }   
                tuserid.setText("");
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
    }
    }
});        

bdeletebysem.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(usertype.equalsIgnoreCase("student"))
        {    
            if(semester.getSelectedIndex()==0)
            {
                lchoosefieldformultipleusersem.setText("Please Choose Semester");
                lchoosefieldformultipleusersem.setForeground(Color.red);
                lchoosefieldformultipleusebranch.setText(" ");
            }
            else if(branch.getSelectedIndex()==0)
            {
                lchoosefieldformultipleusebranch.setText("Please Choose Branch");
                lchoosefieldformultipleusebranch.setForeground(Color.red);
                lchoosefieldformultipleusersem.setText(" ");
            }
            else
            {
                try
               {
                int i=0,useroption;
                useroption=JOptionPane.showConfirmDialog(tuserid,"Are You Sure Remove This User", "User Remove", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                   System.out.println(branch.getSelectedItem().toString());
                   System.out.println(semester.getSelectedItem().toString());
                if(useroption==0)
                {
                    i=db.remove(usertype.toLowerCase(),null,branch.getSelectedItem().toString(),semester.getSelectedItem().toString());
                     if(i>0)
                    {    
                    JOptionPane.showMessageDialog(tuserid,"DATA SUCCESSFULLY REMOVED ! ! !");
                    }  
                    else
                    {
                    JOptionPane.showMessageDialog(tuserid,"RECORD NOT FOUND ! ! !");
                    }   
                    tuserid.setText("");
                }
                }
                catch(Exception e)
                 {
                e.printStackTrace();
                }
                
            }
        } 
        else
        {
            if(branch.getSelectedIndex()==0)
            {
                lchoosefieldformultipleusersem.setText("Please Choose Branch");
                lchoosefieldformultipleusersem.setForeground(Color.red);
            }
            else
            {
                try
               {
                int i=0,useroption;
                useroption=JOptionPane.showConfirmDialog(tuserid,"Are You Sure Remove This User", "User Remove", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(useroption==0)
                {
                    i=db.remove(usertype.toLowerCase(),null,branch.getSelectedItem().toString(),null);
                     if(i>0)
                    {    
                    JOptionPane.showMessageDialog(tuserid,"DATA SUCCESSFULLY REMOVED ! ! !");
                    }  
                    else
                    {
                    JOptionPane.showMessageDialog(tuserid,"RECORD NOT FOUND ! ! !","Data Base",JOptionPane.ERROR_MESSAGE);
                    }   
                    tuserid.setText("");
                }
                }
                catch(Exception e)
                {
                e.printStackTrace();
                }
                
            }
            
            
        }
    }
});

}

    
    /*        
    public static void main(String []args)
    {
        new RemoveUser("hello");
    }*/
}
