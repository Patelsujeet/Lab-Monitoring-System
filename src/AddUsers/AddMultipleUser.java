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
import java.io.*;
import jxl.*;
import lms.DBConnection;
import java.util.regex.*;
import javax.swing.table.*;

/**
 *
 * @author HP
 */
public class AddMultipleUser extends JDialog
{   
       
    JFrame addMultipleStudent;
    
    Font bfont;
    
    FileInputStream readFile;
    FileOutputStream writeFile;
    
    Workbook readSheetData;
    Sheet noofsheet;
    
    int numberOfHeader=0;
    int valueInHeader=0;
    
    FileDialog fd;
    
    JLabel ltitle,lfilename,lerror;
    JTextField tchooseFile;
    
    JButton bchoose,bok,baddUser;
    
    JPanel p1,ptitle,pwhole;
    
    GridBagConstraints gbs,gbs1;
    
    DBConnection db;
   
    JTable datatabel;
   
    String fileChooseError="Please Choose Valid File";
    String fileDataError="Please Fill Up Valid Data";
    
    
    public AddMultipleUser(String username,JFrame parent)
    {
        
        addMultipleStudent=parent;
        bfont=new Font("Copperplate Gothic Bold",Font.BOLD,15);
        
        lerror=new JLabel("                ");
        lerror.setForeground(Color.red);

        lfilename=new JLabel("File Name");
        lfilename.setFont(new Font("Times New Roman",Font.BOLD,25));
        lfilename.setForeground(Color.BLACK);
        
        ltitle=new JLabel("Add Multiple "+username,JLabel.CENTER);
        ltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
        ltitle.setForeground(Color.ORANGE);
        
        tchooseFile=new JTextField(30);
        tchooseFile.setFont(new Font("Times New Roman",Font.BOLD,15));
                
        bchoose=new JButton("Choose File");
        bchoose.setFont(bfont);
        
        bok=new JButton("OK");
        bok.setFont(bfont);
        
        baddUser=new JButton("<html>Add<br/> User</html>");
        baddUser.setFont(bfont);
        
        gbs=new GridBagConstraints();
        
        ptitle=new JPanel();
        ptitle.setLayout(new GridBagLayout());
               
            gbs.gridx=0;
            gbs.gridy=0;
            gbs.insets=new Insets(0, 0, 30, 0);
            ptitle.add(ltitle,gbs);
        
        
        p1=new JPanel();
        p1.setLayout(new GridBagLayout());
    
            gbs.gridx=0;
            gbs.gridy=0;
            gbs.ipady=1;
            gbs.insets=new Insets(0, 0, 0, 10);
            p1.add(lfilename,gbs);

            gbs.gridx=1;
            gbs.gridy=0;
            gbs.gridwidth=2;
            gbs.fill=GridBagConstraints.BOTH;
            p1.add(tchooseFile,gbs);

            gbs.gridx=1;
            gbs.gridy=1;
            gbs.gridwidth=2;
            
            gbs.fill=GridBagConstraints.BOTH;
            p1.add(lerror,gbs);
            
            gbs.gridx=1;
            gbs.gridy=2;
            gbs.gridwidth=1;
            gbs.ipadx=20;
            gbs.ipady=20;
            
            gbs.fill=GridBagConstraints.BOTH;
            p1.add(bchoose,gbs);

            gbs.gridx=2;
            gbs.gridy=2;
            gbs.gridwidth=1;
            gbs.ipadx=20;
            gbs.fill=GridBagConstraints.BOTH;
            p1.add(bok,gbs);

            gbs.gridx=3;
            gbs.gridy=0;
            gbs.gridheight=3;
            gbs.fill=GridBagConstraints.BOTH;
            baddUser.setEnabled(false);
            p1.add(baddUser,gbs);
            
         pwhole=new JPanel();   
         pwhole.setLayout(new GridBagLayout());
         gbs1=new GridBagConstraints();
         
            gbs1.gridx=0;
            gbs1.gridy=0;
            pwhole.add(ptitle,gbs1);
            
            gbs1.gridx=0;
            gbs1.gridy=1;
            pwhole.add(p1,gbs1);
     
        bchoose.addActionListener(new ActionListener()
        {
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent ae)
            {
                fd=new FileDialog(addMultipleStudent,"Select File");
                fd.show(true);
                
                String fileDirectory=fd.getDirectory();
                String filename=fd.getFile();
                tchooseFile.setText(fileDirectory+filename);
                               
            }
        });
        

        
        bok.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) 
            {                
                try
                {
                readFile=new FileInputStream(fd.getDirectory()+fd.getFile());
                readSheetData=Workbook.getWorkbook(readFile);
                
                noofsheet=readSheetData.getSheet(0);
                
                int noofcol=noofsheet.getColumns();
                int noofrow=noofsheet.getRows();
                
                Object data[][] = new Object[noofrow][noofcol];
                Object header[] = new Object[noofcol];
                
                while(numberOfHeader!=noofcol)
                {    
                    Cell cel=noofsheet.getCell(numberOfHeader,0);
                    if(cel.getContents()==null && cel.getContents().length()==0)
                    {
                        continue;
                    }
                    numberOfHeader++;
                    header[valueInHeader] = cel.getContents();
                    valueInHeader++;
                    System.out.println("val"+valueInHeader);
                }
                
                for(int i=1;i<noofrow;i++)
                {
                    for(int j=0;j<valueInHeader;j++)  
                    {
                        Cell cel1=noofsheet.getCell(j, i);
                        
                        if(cel1.getContents()==null && cel1.getContents().length()==0)
                        {
                            continue;
                        }
                        
                        data[i][j] = cel1.getContents();                         
                    }
                }

                if(username.equalsIgnoreCase("admin"))
                {    
                    if(!((valueInHeader==4) &&
                            (header[0].toString().equalsIgnoreCase("email") &&
                            header[1].toString().equalsIgnoreCase("password") && 
                            header[2].toString().equalsIgnoreCase("name") && 
                            header[3].toString().equalsIgnoreCase("mobilenumber"))))
                    {
                        JOptionPane.showMessageDialog(bok,fileChooseError,"Error",JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        setTable(data, header);
                    }
                }
                else if(username.equalsIgnoreCase("students"))
                {    
                    if(!((valueInHeader==7) &&
                            (header[0].toString().equalsIgnoreCase("enrollment") &&
                            header[1].toString().equalsIgnoreCase("name")&&
                            header[2].toString().equalsIgnoreCase("semester")&&
                            header[3].toString().equalsIgnoreCase("branch")&&
                            header[4].toString().equalsIgnoreCase("password")&&
                            header[5].toString().equalsIgnoreCase("mobilenumber")&&
                            header[6].toString().equalsIgnoreCase("email"))))
                    {
                        JOptionPane.showMessageDialog(bok,fileChooseError,"Error",JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        setTable(data, header);
                    }
                }    
                else if(username.equalsIgnoreCase("hod"))
                {    
                    if(!((valueInHeader==5) &&
                            (header[0].toString().equalsIgnoreCase("email") &&
                            header[1].toString().equalsIgnoreCase("password") && 
                            header[2].toString().equalsIgnoreCase("name") && 
                            header[3].toString().equalsIgnoreCase("branch")&&
                            header[4].toString().equalsIgnoreCase("mobilenumber"))))
                    {
                        JOptionPane.showMessageDialog(bok,fileChooseError,"Error",JOptionPane.ERROR_MESSAGE );
                        
                    }
                    else
                    {
                        setTable(data, header);
                    }
                }    
                else if(username.equalsIgnoreCase("faculty"))
                {
                    
                    if(!((valueInHeader==5) &&
                            (header[0].toString().equalsIgnoreCase("email") &&
                            header[1].toString().equalsIgnoreCase("password") && 
                            header[2].toString().equalsIgnoreCase("name") && 
                            header[3].toString().equalsIgnoreCase("branch")&&
                            header[4].toString().equalsIgnoreCase("mobilenumber"))))
                    {
                        JOptionPane.showMessageDialog(bok,fileChooseError,"Error",JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        setTable(data, header);
                    }
                }
                                   
                add(new JScrollPane(datatabel),BorderLayout.CENTER);
                Validation.refreshDailog(AddMultipleUser.this);

                }
                catch(FileNotFoundException ae)
                { JOptionPane.showMessageDialog(addMultipleStudent,"File Not Found");ae.printStackTrace();}
                catch(NullPointerException ae)
                { JOptionPane.showMessageDialog(addMultipleStudent,"Please Select File");ae.printStackTrace();}
                catch(Exception ae)
                { JOptionPane.showMessageDialog(addMultipleStudent,"File Not Found");ae.printStackTrace();}
 
            }
        });
        
        
        baddUser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {

                try
                {

                  db=new DBConnection(ptitle);
                  
                  int noofcol=datatabel.getColumnCount();
                  int noofrow=datatabel.getRowCount();
                    
                System.out.println(noofrow+":"+noofcol);
                  if(username.equalsIgnoreCase("students"))
                  {
                      addStudent(noofrow,noofcol);
                  }
                  else if(username.equalsIgnoreCase("admin"))
                  {
                      addAdmin(noofrow,noofcol);
                  }
                  else if(username.equalsIgnoreCase("faculty"))
                  {
                    addFaculty(noofrow, noofcol);
                  }
                  else if(username.equalsIgnoreCase("hod"))
                  {
                      addHod(noofrow,noofcol);
                  }
                  System.out.println("hello");
                  
                }   
                catch(NullPointerException e)
                { JOptionPane.showMessageDialog(addMultipleStudent,"Please Select File");}
                catch(Exception e)
                {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(addMultipleStudent,"File Not Found");
                }
        }            
        });
        
                
        add(pwhole,BorderLayout.PAGE_START);
        
        setTitle(username);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(550,550);
        addWindowListener(new WindowAdapter() {
         
            @Override
            public void windowClosing(WindowEvent e) {
                addMultipleStudent.setEnabled(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                addMultipleStudent.setEnabled(true);
            }

         
        }); 
    }
    
  void addStudent(int noofrow,int noofcol)
  {
    for(int row=1;row<noofrow;row++)
    {

        String enrollment = (String)datatabel.getValueAt(row, 0);
        String name=(String)datatabel.getValueAt(row,1);
        String sem=(String)datatabel.getValueAt(row,2);
        String department=(String)datatabel.getValueAt(row,3);
        String pass=(String)datatabel.getValueAt(row,4);
        String mobile=(String)datatabel.getValueAt(row,5);
        String email=(String)datatabel.getValueAt(row,6);
        
            if(enrollment.length()<12 || enrollment.length()>12 || !enrollment.matches("[0-9_]+"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
            else if(!name.matches("[a-zA-Z_]+"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
            else if(!sem.matches("[1-8]th"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
            else if(!department.matches("Computer Engineering|Civil Engineering|Electrical Engineering|Electronics & Communication|Mechanical Engineering"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }    
            else if(new Validation().isValidEmail(email)==false)
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
            else if(mobile.length()<10 || mobile.length()>10 || !mobile.matches("[0-9_]+"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
            
            else
            {    
            
                int j=db.insertStudentData(enrollment, name, sem, department, pass, mobile, email);

                if(j>0)
                {
                    System.out.println(j);
                }              
                System.err.println(enrollment+name+sem+department+pass+mobile+email);
            }
    }
  }
  
  void addFaculty(int noofrows,int noofcol)
  {
      
    for(int row=1;row<noofrows;row++)
    {
        String email = (String)datatabel.getValueAt(row, 0);
        String password=(String)datatabel.getValueAt(row,1);
        String name=(String)datatabel.getValueAt(row,2);
        String department=(String)datatabel.getValueAt(row,3);
        String mobilenumber=(String)datatabel.getValueAt(row,4);
        
        if(!name.matches("[a-zA-Z_]+"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else if(new Validation().isValidEmail(email)==false)
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else if(mobilenumber.length()<10 || mobilenumber.length()>10 || !mobilenumber.matches("[0-9_]+"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else if(!department.matches("Computer Engineering|Civil Engineering|Electrical Engineering|Electronics & Communication|Mechanical Engineering"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else
        {
            int col=db.insertFacultyData(name, department, mobilenumber, email, password);
            if(col>0)
            {
                System.out.println("Inserted Column"+col);
            }
            System.err.println(email+password+name+department+mobilenumber);
        }
        
    }
      
  }
  void addAdmin(int noofrows,int noofcol)
  {
      
    for(int row=1;row<noofrows;row++)
    {
        String email = (String)datatabel.getValueAt(row, 0);
        String password=(String)datatabel.getValueAt(row,1);
        String name=(String)datatabel.getValueAt(row,2);
        String mobilenumber=(String)datatabel.getValueAt(row,3);
        
        if(!name.matches("[a-zA-Z_]+"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else if(new Validation().isValidEmail(email)==false)
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else if(mobilenumber.length()<10 || mobilenumber.length()>10 || !mobilenumber.matches("[0-9_]+"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else
            {
                int col=db.insertAdminData(name, mobilenumber, email, password);
                if(col>0)
                {
                    System.out.println("Inserted Col"+col);
                }
            }

        
    }
    
  }
  void addHod(int noofrows,int noofcol)
  {
    for(int row=1;row<noofrows;row++)
    {
        String email = (String)datatabel.getValueAt(row, 0);
        String password=(String)datatabel.getValueAt(row,1);
        String name=(String)datatabel.getValueAt(row,2);
        String department=(String)datatabel.getValueAt(row,3);
        String mobilenumber=(String)datatabel.getValueAt(row,4);
        
        if(!name.matches("[a-zA-Z_]+"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else if(new Validation().isValidEmail(email)==false)
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else if(mobilenumber.length()<10 || mobilenumber.length()>10 || !mobilenumber.matches("[0-9_]+"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else if(!department.matches("Computer Engineering|Civil Engineering|Electrical Engineering|Electronics & Communication|Mechanical Engineering"))
            {
                JOptionPane.showMessageDialog(lfilename,fileDataError,"Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        else
        {
            int col=db.insertHODData(email, password, name, department, mobilenumber);
            if(col>0)
            {
                System.out.println("Inserted Column"+col);
            }
            System.err.println(email+password+name+department+mobilenumber);
        }   
    }      
  }
  
  public void setTable(Object data[][],Object header [])
  {
    datatabel=new JTable(data, header);        
    datatabel.setEnabled(false);
    baddUser.setEnabled(true);
    datatabel.setFont(new Font("Times New Roman",Font.BOLD,16));
  }
}

