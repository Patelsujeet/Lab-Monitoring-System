/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import UpdateUsers.UpdateStudentDetails;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import UpdateUsers.*;
import lms.Validation;
/**
 *
 * @author HP
 */
public class UserByType extends JPanel
{
    JRadioButton rbAdmin,rbFaculty,rbHod,rbStudent;
    ButtonGroup bgusertype;
    JLabel lselectusertype;
    
    JPanel pusertype;
   
    JPanel pwholepanel,pbutton;
    JButton bsubmit;
    public UserByType(String operation)
    {
    /*-----------------User Type Panel----------------------------------------------------------------*/    
       pusertype=new JPanel(new GridLayout(6,1));
            pusertype.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),operation,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Copperplate Gothic Bold",Font.BOLD,25)));
            
            rbAdmin=new JRadioButton("Admin");
            rbAdmin.setFont(new Font("Times New Roman",Font.BOLD,25));
            
            rbFaculty=new JRadioButton("Faculty");
            rbFaculty.setFont(new Font("Times New Roman",Font.BOLD,25));
            
            rbHod=new JRadioButton("HOD");
            rbHod.setFont(new Font("Times New Roman",Font.BOLD,25));            
            
            rbStudent=new JRadioButton("Student");
            rbStudent.setFont(new Font("Times New Roman",Font.BOLD,25));
            
            bsubmit=new JButton("Submit");
            bsubmit.setFont(new Font("Times New Roman", Font.BOLD, 20));
/*------------------------------Button Panel------------------------------------------*/            
            
            pbutton=new JPanel(null);
            
            bsubmit.setBounds(0,0,240,35);
            pbutton.add(bsubmit);
            
/*-----------------------Add Component on Panels-----------------------------------------*/
            bgusertype=new ButtonGroup();
                bgusertype.add(rbAdmin);
                bgusertype.add(rbFaculty);
                bgusertype.add(rbHod);
                bgusertype.add(rbStudent);      
            
            pusertype.add(rbAdmin);
            pusertype.add(rbFaculty);
            pusertype.add(rbHod);
            pusertype.add(rbStudent);
            pusertype.add(pbutton);
           
            pwholepanel=new JPanel(new BorderLayout());
            pwholepanel.add(pusertype,BorderLayout.NORTH);

    }
    public JPanel removeUser()
    {
             
            this.bsubmit.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    pwholepanel.removeAll();
                    if(rbAdmin.isSelected())
                    {                       
                        pwholepanel.add(new RemoveUser(rbAdmin.getText()),BorderLayout.SOUTH);
                        Validation.refreshPanel(pwholepanel);
                    }
                    else if(rbFaculty.isSelected())
                    {
                        pwholepanel.add(new RemoveUser(rbFaculty.getText()),BorderLayout.SOUTH);
                        Validation.refreshPanel(pwholepanel);
                    }
                    else if(rbHod.isSelected())
                    {
                        pwholepanel.add(new RemoveUser(rbHod.getText()),BorderLayout.SOUTH);
                        Validation.refreshPanel(pwholepanel);
                    }
                    else if(rbStudent.isSelected())
                    {
                        pwholepanel.add(new RemoveUser(rbStudent.getText()),BorderLayout.SOUTH);
                        Validation.refreshPanel(pwholepanel);
                    }
                }
            });
            return pwholepanel;
    }
    
    public JPanel viewUserDetails()
    {
        this.bsubmit.addActionListener(new ActionListener()
        {
         
            public void actionPerformed(ActionEvent e) 
            {
                 pwholepanel.removeAll();
                    if(rbAdmin.isSelected())
                    {                       
                        pwholepanel.add(new ViewDetails(rbAdmin.getText()));
                        Validation.refreshPanel(pwholepanel);
                    }
                    else if(rbFaculty.isSelected())
                    {   
                        pwholepanel.add(new ViewDetails(rbFaculty.getText()));
                        Validation.refreshPanel(pwholepanel);
                    }
                    else if(rbHod.isSelected())
                    {
                        pwholepanel.add(new ViewDetails(rbHod.getText()));
                        Validation.refreshPanel(pwholepanel);
                    }
                    else if(rbStudent.isSelected())
                    {
                        pwholepanel.add(new ViewDetails(rbStudent.getText()));
                        Validation.refreshPanel(pwholepanel);
                    }
            }
        });
        
        return pwholepanel;
    }
    public JPanel updateUser()
    {
        this.bsubmit.addActionListener(new ActionListener()
        {   
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                pwholepanel.removeAll();
                if(rbStudent.isSelected())
                {
                    pwholepanel.add(new UpdateStudentDetails());
                    Validation.refreshPanel(pwholepanel);
                }
                else if(rbHod.isSelected())
                {
                    pwholepanel.add(new UpdateHodDetails());
                    Validation.refreshPanel(pwholepanel);
                }
                else if(rbFaculty.isSelected())
                {
                    pwholepanel.add(new UpdateFacultyDetails());
                    Validation.refreshPanel(pwholepanel);
                }
                else if(rbAdmin.isSelected())
                {
                    pwholepanel.add(new UpdateAdminDetails());
                    Validation.refreshPanel(pwholepanel);
                }
                
                
            }
            
        });
           
     return pwholepanel;   
        
    }
}
