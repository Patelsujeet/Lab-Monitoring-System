package lms;
import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.Image;
import java.net.*;

public class SplashScreen
{
	JFrame f;
	JLabel logo,nameOfInstitute;
	GridLayout gl;
	
	public SplashScreen()
	{
		f=new JFrame("Lab Monitoring System");
		
                URL url=getClass().getResource("/ImageIcons/Admin.jpg");
                

		gl=new GridLayout(2,1);
		f.setLayout(gl);
			
		logo=new JLabel(new ImageIcon(getClass().getResource("/ImageIcons/VIMAT.jpg")));
			
		nameOfInstitute=new JLabel("VIDHYADEEP INSTITUTE OF ENGINEEERING & TECHNOLOGY",JLabel.CENTER);
		nameOfInstitute.setFont(new Font("Times New Roman", Font.BOLD, 40));
                nameOfInstitute.setForeground(Color.RED);
			
			
		f.add(logo);
		f.add(nameOfInstitute);
		f.getContentPane().setBackground(new Color(216,191,216));
                
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		f.setSize(d);
		f.getContentPane().setBackground(new Color(216,191,216));	
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                
			
		try
		{
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f.setVisible(false);
		login z = new login();
			
	}
}
