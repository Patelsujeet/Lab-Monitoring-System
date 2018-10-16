/* * To change this license header, choose License Headers in Project Properties.
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
import java.sql.ResultSet;
import javax.swing.*;
import lms.*;

/**
 *
 * @author HP
 */
public class ViewDetails extends JPanel
{
    DBConnection db;        
    JLabel lTitle,luserid,lchoosefield;
   

    JButton bfind;
    JTextField tuseId;

    GridBagLayout gbl;
    GridBagConstraints gbs;

    JPanel pviewdetails,pfillup,pwhole;
    
    /*----------Label for details Panel-----------*/
    JLabel luserid2,lusername,lsem,ldepartment,lpassword,lmobilenumber,lemail;
    JLabel luseriddetails,lusernamedetails,lsemdetails,ldepartmentdetails,lpassworddetails,lmobiledetails,lemaildetails;
        
    /*---------Labels for details Panel------------*/
    public JPanel pdetails;
    
    Font fnt;

    
    GridBagConstraints gbs1;

    public ViewDetails(String usertype)
    {
        gbs1=new GridBagConstraints();
        
        db=new DBConnection(this);
              
        fnt=new Font("Times New Roman",Font.BOLD,20);
        
        lTitle =new JLabel("VIEW "+usertype.toUpperCase()+" DETAILS",JLabel.CENTER);
        lTitle.setFont(new Font("Times New Roman",Font.BOLD,40));
        lTitle.setForeground(Validation.fontColor());
        
        tuseId=new JTextField(20);
        tuseId.setFont(new Font("Times New Roman",Font.BOLD,15));


        luserid =new JLabel("USER ID");
        luserid.setForeground(Validation.fontColor());
        
        lchoosefield =new JLabel("               ");
        lchoosefield.setForeground(Validation.fontColor());
       
       
        bfind=new JButton("SEARCH");

        pviewdetails=new JPanel(new GridBagLayout());        
        
        pfillup=new JPanel(new GridBagLayout());     
                
        pdetails=new JPanel(new GridBagLayout());
        
        pdetails.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"USER-DETAILS"));
              
        pwhole=new JPanel(new GridBagLayout());
               
        pviewdetails.add(lTitle);
		
		
		gbs=new GridBagConstraints();
		
				
		gbs.gridx=0;
		gbs.gridy=0;
                gbs.insets=new Insets(0,0,5, 5);
                gbs.fill=GridBagConstraints.BOTH;
                luserid.setFont(new Font("Times New Roman",Font.BOLD,20));
		pfillup.add(luserid,gbs);
                
		
		gbs.gridx=1;
		gbs.gridy=0;
                gbs.ipadx=5;
		gbs.gridwidth=2;
		pfillup.add(tuseId,gbs);
		
                gbs.gridx=1;
		gbs.gridy=1;
		gbs.gridwidth=2;
		pfillup.add(lchoosefield,gbs);
                
		gbs.gridx=0;
		gbs.gridy=2;
		gbs.gridwidth=1;
                gbs.ipadx=0;
                gbs.ipady=0;
                gbs.fill=GridBagConstraints.BOTH;
                bfind.setFont(new Font("Times New Roman",Font.BOLD,15));
		pfillup.add(bfind,gbs);
                
                
                luserid2=new JLabel("USER-ID");
                gbs.gridx=0;
                gbs.gridy=0;
                pdetails.add(luserid2,gbs);
                
                luseriddetails=new JLabel(" ");
                gbs.gridx=1;
                gbs.gridy=0;
                pdetails.add(luseriddetails,gbs);
                
                lusername=new JLabel("USER-NAME");
                gbs.gridx=0;
                gbs.gridy=1;
                pdetails.add(lusername,gbs);
                
                lusernamedetails=new JLabel(" ");
                gbs.gridx=1;
                gbs.gridy=1;
                pdetails.add(lusernamedetails,gbs);
                   
                lpassword=new JLabel("USER-PASSWORD");
                gbs.gridx=0;
                gbs.gridy=2;
                pdetails.add(lpassword,gbs);
                
                lpassworddetails=new JLabel(" ");
                gbs.gridx=1;
                gbs.gridy=2;
                pdetails.add(lpassworddetails,gbs);
                
                lmobilenumber=new JLabel("USER-MOBILE NO.");
                gbs.gridx=0;
                gbs.gridy=3;
                pdetails.add(lmobilenumber,gbs);
                
                lmobiledetails=new JLabel(" ");
                gbs.gridx=1;
                gbs.gridy=3;
                pdetails.add(lmobiledetails,gbs);
                
                                
                                ldepartment=new JLabel(" ");
                                gbs.gridx=0;
                                gbs.gridy=4;
                                pdetails.add(ldepartment,gbs);
                                
                                ldepartmentdetails=new JLabel(" ");
                                gbs.gridx=1;
                                gbs.gridy=4;
                                pdetails.add(ldepartmentdetails,gbs);
                                
                
                                lemail=new JLabel(" ");
                                gbs.gridx=0;
                                gbs.gridy=5;
                                pdetails.add(lemail,gbs);
                                
                                lemaildetails=new JLabel(" ");
                                gbs.gridx=1;
                                gbs.gridy=5;
                                pdetails.add(lemaildetails,gbs);
                                
                                
                                lsem=new JLabel(" ");
                                gbs.gridx=0;
                                gbs.gridy=6;
                                pdetails.add(lsem,gbs);
                                
                                lsemdetails=new JLabel(" ");
                                gbs.gridx=1;
                                gbs.gridy=6;
                                pdetails.add(lsemdetails,gbs);
                                                
                gbs.gridx=0;
                gbs.gridy=0;
                gbs.insets=new Insets(0, 0,50, 0);
                pwhole.add(lTitle,gbs);
                
                gbs.gridx=0;
                gbs.gridy=1;
                pwhole.add(pfillup,gbs);       
                
                gbs.gridx=0;
                gbs.gridy=2;
                pwhole.add(pdetails,gbs);
                
                pdetails.setVisible(false);
                add(pwhole);
                
                
 
bfind.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {                
        ResultSet result=null;
        if(tuseId.getText().equals(""))
        {
            lchoosefield.setForeground(Color.red);
            lchoosefield.setText("Please Fill Up This Field");

        }
        else
        { 
             try
            {
                    if(usertype.equalsIgnoreCase("student"))
                {
                    result=db.getUserDetailsForProfile(usertype.toLowerCase(),"enrollment",tuseId.getText());

                    if(result.next())
                    {  
                        pdetails.setVisible(true);
                        lchoosefield.setText("  ");
                        ldepartment.setText("USER-DEPARTMENT");
                        lemail.setText("USER-EMAIL");
                        lsem.setText("USER-SEMESTER");

                        luseriddetails.setText(": "+result.getString(1));
                        lusernamedetails.setText(": "+result.getString(2));
                        lpassworddetails.setText(": "+result.getString(5));
                        lmobiledetails.setText(": "+result.getString(6));
                        ldepartmentdetails.setText(": "+result.getString(4));
                        lemaildetails.setText(": "+result.getString(7));
                        lsemdetails.setText(": "+result.getString(3));

                    }
                    else
                    {
                        popOfDataNotFound();
                    }
                }
                else
                {
                   result=db.getUserDetailsForProfile(usertype.toLowerCase(),"email",tuseId.getText());
                   if(result.next())
                   {   
                        pdetails.setVisible(true);
                        if(usertype.equalsIgnoreCase("faculty"))
                         {
                            lchoosefield.setText(" ");
                            ldepartment.setText("USER-DEPARTMENT");
                            luseriddetails.setText(result.getString(1));
                            lusernamedetails.setText(result.getString(3));
                            lpassworddetails.setText(result.getString(2));
                            lmobiledetails.setText(result.getString(5));
                            ldepartmentdetails.setText(result.getString(4));
                         }
                         else if(usertype.equalsIgnoreCase("hod"))
                         {
                            lchoosefield.setText(" ");
                            ldepartment.setText("USER-DEPARTMENT");
                            luseriddetails.setText(result.getString(1));
                            lusernamedetails.setText(result.getString(3));
                            lpassworddetails.setText(result.getString(2));
                            lmobiledetails.setText(result.getString(5));
                            ldepartmentdetails.setText(result.getString(4));
                         }
                         else
                         {
                            lchoosefield.setText(" ");
                            luseriddetails.setText(result.getString(1));
                            lusernamedetails.setText(result.getString(3));
                            lpassworddetails.setText(result.getString(2));
                            lmobiledetails.setText(result.getString(4));
                         }

                   }
                   else
                   {
                       popOfDataNotFound();
                   }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            } 

        }
    }
});        

}

    
            
    public static void main(String []args)
    {
        
    }
    
    public void popOfDataNotFound()
    {
        JOptionPane.showMessageDialog(tuseId,"RECORD NOT FOUND ! ! !");
        tuseId.setText("");
        lchoosefield.setText(" ");
        tuseId.requestFocus();
    }
}

    

