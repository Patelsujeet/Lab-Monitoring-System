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
import com.toedter.calendar.*;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;
import lms.*;

/**
 *
 * @author HP
 */
public class LabReport extends JDialog
{
    
    JPanel pfrom,pdate,psubmit,pdatafield,pwhole;
    
    JLabel lform,lto,ltitle;
    JButton breportGeneration;
    
    JDateChooser datechooserfrom,dataChooserto;    
    DBConnection db;
    
    ResultSet rs;    
    String dir;
    int filenumber=0;
    
    GridBagConstraints gbs;

    JFrame frame;
    public LabReport(String dir,JFrame framename)
    {
        
        this.dir=dir;
        this.frame=framename;       
        
        datechooserfrom=new JDateChooser();
        datechooserfrom.setDateFormatString("yyyy-MM-dd");
        
        dataChooserto=new JDateChooser();
        dataChooserto.setDateFormatString("yyyy-MM-dd");
        
        gbs=new GridBagConstraints();
        
        pfrom=new JPanel(new GridBagLayout());
        psubmit=new JPanel(new GridBagLayout());
        pdate=new JPanel(new GridBagLayout());
        pdatafield=new JPanel(new GridBagLayout());
        
        
        lform=new JLabel("From");
        gbs.gridx=0;
        gbs.gridy=0;
        gbs.ipadx=5;
        gbs.insets=new Insets(5,0,0,0);
        pfrom.add(lform,gbs);
        
            gbs.gridx=0;
            gbs.gridy=0;
            pdate.add(datechooserfrom,gbs);
            
            gbs.gridx=1;
            gbs.gridy=0;
            gbs.insets=new Insets(5,5,0,0);
            lto=new JLabel("to");
            pdate.add(lto,gbs);
            
            gbs.gridx=2;
            gbs.gridy=0;
            pdate.add(dataChooserto,gbs);
            
        breportGeneration=new JButton("Generate Report");
        gbs.gridx=1;
        gbs.gridy=0;
        psubmit.add(breportGeneration,gbs);
        
        
        gbs.gridx=1;
        gbs.gridy=0;
        ltitle=new JLabel("Lab Report Generation",JLabel.CENTER);
        ltitle.setFont(new java.awt.Font("Times New Roman",Font.BOLD,25));
        pdatafield.add(ltitle,gbs);
               
        gbs.gridx=0;
        gbs.gridy=1;
        pdatafield.add(pfrom,gbs);
        
        gbs.gridx=1;
        gbs.gridy=1;
        pdatafield.add(pdate,gbs);
        
        gbs.gridx=1;
        gbs.gridy=2;
        gbs.gridwidth=1;
        pdatafield.add(psubmit,gbs);
        
        
        db=new DBConnection(pwhole);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Lab Report");
        setVisible(true);
        setSize(550,250);
        add(pdatafield,BorderLayout.NORTH);
        
        breportGeneration.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                try
                {
                    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");        

                    System.out.println(dateFormat.format(datechooserfrom.getDate()));
                    System.out.println(dateFormat.format(dataChooserto.getDate()));

                    rs=db.loginTimeForReport(dateFormat.format(datechooserfrom.getDate()),dateFormat.format(dataChooserto.getDate()));
                    new DocumentGeneration(rs, dir, filenumber,dateFormat.format(datechooserfrom.getDate()) , dateFormat.format(dataChooserto.getDate()));
                    filenumber++;
                    
                    System.out.println("Selected ");
                }
                catch(NullPointerException nex)
                {
                    JOptionPane.showMessageDialog(breportGeneration,"Please Fill Up Valid Date","Date Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                frame.setEnabled(true);
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                frame.setEnabled(true);
            }

        });
        
    }

   
   class DocumentGeneration
    {
   
    PdfWriter pdfwriter;
    PdfDocument pdd;
    Document doc;
    Font h1,h2,h3;

    public DocumentGeneration(ResultSet rs,String dir,int i,String from,String to)
    {
        try
        {
                       
           h1=new Font(Font.FontFamily.TIMES_ROMAN,20);
           h2=new Font(Font.FontFamily.TIMES_ROMAN,15);
           h3=new Font(Font.FontFamily.TIMES_ROMAN,10);
           doc=new Document(PageSize.A4);
           pdfwriter=PdfWriter.getInstance(doc, new FileOutputStream(new File(dir+"LabReport"+i+"Report.pdf")));
           
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
            
            Paragraph title=new Paragraph("Lab Report",h2);
            title.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph datefrom=new Paragraph("From:-"+from,h3);
            datefrom.setAlignment(Element.ALIGN_LEFT);
            
            Paragraph dateto=new Paragraph("To:-"+to,h3);
            datefrom.setAlignment(Element.ALIGN_LEFT);      
           
            doc.add(pf);
            doc.add(pf1);
            doc.add(title);
            doc.add(datefrom);
            doc.add(dateto
            
            );
            doc.add(line_spacing);
            
            PdfPTable table=new PdfPTable(6);
            
            
            table.addCell("Faculty Id");
            table.addCell("Enrollment No.");
            table.addCell("Login-Date");
            table.addCell("Login-Time");
            table.addCell("Logout-Time");
            table.addCell("Duration");
            
           while(rs.next())
           {
               table.addCell(rs.getString(1));
               table.addCell(rs.getString(2));
               table.addCell(rs.getString(3));
               table.addCell(rs.getString(4));
               table.addCell(rs.getString(5));
               table.addCell(rs.getString(6));
               
           }
           
           table.setWidths(new int[]{50,30,20,20,20,20});
           table.setTotalWidth(PageSize.A4.getWidth()-10);
           table.setLockedWidth(true);
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
