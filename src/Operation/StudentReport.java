/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;
import javax.swing.*;
import lms.DBConnection;
import lms.Validation;
import Operation.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class StudentReport extends JDialog
{
    JPanel ptitle,pbuttons,pdetails,pwhole;
    JFrame parent;
    
    JLabel ltitle,lsem,lbranch;
    JLabel lsemError,lbranchError;
    
    JComboBox branchbox,sembox;
    JButton bsubmit,breportGeneration;
   
    
    GridBagConstraints gbs;
    DBConnection db;

    JTable dataTable;
    ResultSet rs;
    
    String dir;
   
    int fileNumber=0;
    public StudentReport(String dir,JFrame parent) 
    {
        ptitle=new JPanel(new GridBagLayout());
        pdetails=new JPanel(new GridBagLayout());
        pwhole=new JPanel(new GridBagLayout());
        pbuttons=new JPanel(new GridBagLayout());
        
        
        db=new DBConnection(ptitle);
        gbs=new GridBagConstraints();
        
        this.dir=dir;
        this.parent=parent;
        
        ltitle=new JLabel("Student Report");
        ltitle.setFont(new java.awt.Font("Verdana",Font.BOLD,30));
        ptitle.add(ltitle,gbs);
        
        lsem=new JLabel("Semester");
        lsem.setFont(new java.awt.Font("Verdana",Font.BOLD,15));
        gbs.gridx=0;
        gbs.gridy=0;
        gbs.insets=new Insets(0, 5, 0,0);
        gbs.fill=GridBagConstraints.BOTH;
        pdetails.add(lsem,gbs);
        
        String semvalue[]={"Choose Semester","1st","2nd","3rd","4th","5th","6th","7th","8th"};
        sembox=new JComboBox(semvalue);
        sembox.setFont(new java.awt.Font("Verdana",Font.BOLD,15));
        gbs.gridx=1;
        gbs.gridy=0;
        pdetails.add(sembox,gbs);
       
        lbranch=new JLabel("Department");
        gbs.gridx=0;
        gbs.gridy=1;
        lbranch.setFont(new java.awt.Font("Verdana",Font.BOLD,15));
        pdetails.add(lbranch,gbs);
        
        String branchvalue[]={"Choose Department","Computer Engineering","Civil Engineering","Electrical Engineering","Electronics & Communication ","Mechanical Engineering"};
        branchbox=new JComboBox(branchvalue);
        branchbox.setFont(new java.awt.Font("Verdana",Font.BOLD,15));
        gbs.gridx=1;
        gbs.gridy=1;
        gbs.insets=new Insets(3, 5,0,0);
        pdetails.add(branchbox,gbs);
            
        bsubmit=new JButton("Submit");
        bsubmit.setFont(new java.awt.Font("Verdana",Font.BOLD,15));
        gbs.gridx=0;
        gbs.gridy=0;
        gbs.insets=new Insets(1, 5,10,5);
        pbuttons.add(bsubmit,gbs);
        
        breportGeneration=new JButton("Generate Report");
        breportGeneration.setFont(new java.awt.Font("Verdana",Font.BOLD,15));
        gbs.gridx=1;
        gbs.gridy=0;
        breportGeneration.setEnabled(false);
        pbuttons.add(breportGeneration,gbs);
        
        gbs.gridx=0;
        gbs.gridy=0;
        pwhole.add(ptitle,gbs);
        
        gbs.gridx=0;
        gbs.gridy=1;
        pwhole.add(pdetails,gbs);

        gbs.gridx=0;
        gbs.gridy=2;
        pwhole.add(pbuttons,gbs);
        
        setTitle("Student Report Generation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        setVisible(true);
        setSize(750, 650);
        setLocation(d.width/4, 0);
        setBackground(Color.WHITE);
        add(pwhole,BorderLayout.NORTH);
        
    bsubmit.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try
            {
                rs=db.getStudentData(sembox.getSelectedItem().toString(),branchbox.getSelectedItem().toString());
                ResultSetMetaData meta=rs.getMetaData();                
                
                Vector colname=new Vector(4);
                colname.add("Enrollment No.");
                colname.add("Name");
                colname.add("Semester");
                colname.add("Department");
                
                Vector<Vector<Object>> data=new Vector<Vector<Object>>();
                Vector<Object> vec;
               
                while(rs.next())
                {
                    vec=new Vector<>();
                    for(int i=1;i<=meta.getColumnCount();i++)
                    {
                        vec.add(rs.getString(i));
                    }
                    data.add(vec);
                }
                
                dataTable=new JTable(data,colname);
                
                dataTable.setEnabled(false);
                
                remove(dataTable);
                
                add(new JScrollPane(dataTable),BorderLayout.CENTER);
                breportGeneration.setEnabled(true);
                Validation.refreshDailog(StudentReport.this);
                
            }
            catch(Exception r)
            {
                r.printStackTrace();
            }
    
        }

    });
        
   
   breportGeneration.addActionListener(new ActionListener() 
   {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            rs=db.getStudentData(sembox.getSelectedItem().toString(),branchbox.getSelectedItem().toString());
            new DocumentGeneration(rs,dir,fileNumber);
            fileNumber++;
        }
        
    });
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                parent.setEnabled(true);
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                parent.setEnabled(true);
            }
        });
   
    } 
    
    public static void main(String []arg)
    {
       //new StudentReport();
    }
    
    class DocumentGeneration
    {

    
    PdfWriter pdfwriter;
    PdfDocument pdd;
    Document doc;
    Font h1,h2,h3;

    public DocumentGeneration(ResultSet rs,String dir,int i)
    {
        try
        {
           
            
           h1=new Font(Font.FontFamily.TIMES_ROMAN,20);
           h2=new Font(Font.FontFamily.TIMES_ROMAN,15);
           h3=new Font(Font.FontFamily.TIMES_ROMAN,10);
           doc=new Document(PageSize.A4);
           pdfwriter=PdfWriter.getInstance(doc, new FileOutputStream(new File(dir+i+"Report.pdf")));
           
            pdfwriter.setPageEvent(new PdfPageEventHelper(){
               
               @Override
               public void onStartPage(PdfWriter pdfWriter, Document doc) 
               {    
                   ColumnText.showTextAligned(pdfWriter.getDirectContent(), Element.ALIGN_RIGHT,new Phrase("VIEAT"), doc.right(),doc.top()+20, 0);                   
              }

               @Override
               public void onEndPage(PdfWriter writer, Document dcmnt) {

               }            
           });
            doc.open();
           
            
             
            Paragraph pf=new Paragraph("Vidhyadeep Insitute of Engineering & Technology",h1);
            pf.setAlignment(Element.ALIGN_CENTER);
            
            Phrase line_spacing=new Phrase(20);
            
            Paragraph pf1=new Paragraph("Kim(Anita),Surat",h2);
            pf1.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph title=new Paragraph("Student Details",h2);
            title.setAlignment(Element.ALIGN_CENTER);
           
            doc.add(pf);
            doc.add(pf1);
            doc.add(title);
            doc.add(line_spacing);
            
            PdfPTable table=new PdfPTable(4);
            table.addCell("Enrollment No.");
            table.addCell("Name");
            table.addCell("Semester");
            table.addCell("Department");
            
           while(rs.next())
           {
               table.addCell(rs.getString(1));
               table.addCell(rs.getString(2));
               table.addCell(rs.getString(3));
               table.addCell(rs.getString(4));
               
           }
           doc.add(table);
           doc.close();
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
        
    }
}
