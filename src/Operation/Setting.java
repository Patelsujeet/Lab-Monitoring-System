/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import lms.Validation;
/**
 *
 * @author HP
 */
public class Setting  extends JPanel
{
    GridBagConstraints gbs;
    
    JFrame Setting;
    JPanel pwhole;        
    
    JPanel ptitle,pbutton;
  
    public JButton bsubmit,breset;
    JLabel lsetting;
 /*---------------Left Side Menu----------------*/   
    JPanel pleftsidemenu;
   
    public JComboBox comboboxbackgroundleft,comboboxforegroundleft,comboboxfontleft;
/*----------------Top Side Menu---------------*/    
    JPanel ptopsidemenu;
    
    public JComboBox comboboxbackgroundtop,comboboxforegroundtop,comboboxfonttop;
/*-----------------Window Frame Menu---------*/    
    JPanel pframewindow;
    
   public String leftSideFont;
    public  Setting()
    {
        Setting=new JFrame("Setting"); 
        
        
        String font[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        String ColorName[]={"Red","Blue","Green","Orange","Yellow","Pink","Gray","DarkGray","Cyan","White"};
        
        
    /*--------------Title----------------------*/    
        lsetting=new JLabel("Setting");
        lsetting.setFont(new Font("Times New Roman",Font.BOLD,30));
        lsetting.setForeground(Color.ORANGE);
        
        ptitle=new JPanel(new GridBagLayout());
        ptitle.add(lsetting);

        
    /*---------------Left Side Menu---------------*/    
        gbs=new GridBagConstraints();
        pleftsidemenu=new JPanel(new GridBagLayout());
        pleftsidemenu.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Left Side Menu"));

                
        
        comboboxbackgroundleft=new JComboBox(ColorName);
        comboboxforegroundleft=new JComboBox(ColorName);
        comboboxfontleft=new JComboBox(font);
        
        
        /*--------------------1st Row--------------------*/    
            gbs.gridx=0;
            gbs.gridy=0;
            gbs.ipadx=10;
            gbs.fill=GridBagConstraints.BOTH;
            JLabel lbackground=new JLabel("Background Color");
            lbackground.setForeground(Validation.fontColor());
            pleftsidemenu.add(lbackground,gbs);

            gbs.gridx=1;
            gbs.gridy=0;
            gbs.ipadx=10;
            pleftsidemenu.add(comboboxbackgroundleft,gbs);
        /*-----------------2nd Row----------------------*/    
            gbs.gridx=0;
            gbs.gridy=1;
            JLabel lforegraound=new JLabel("Foreground Color");
            lforegraound.setForeground(Validation.fontColor());
            pleftsidemenu.add(lforegraound,gbs);

            gbs.gridx=1;
            gbs.gridy=1;
            pleftsidemenu.add(comboboxforegroundleft,gbs);
        /*-------------------3rd Row----------------------*/    
            gbs.gridx=0;
            gbs.gridy=2;
            JLabel lfont=new JLabel("Font Style");
            lfont.setForeground(Validation.fontColor());
            pleftsidemenu.add(lfont,gbs);

            gbs.gridx=1;
            gbs.gridy=2;
            pleftsidemenu.add(comboboxfontleft,gbs);
    
    /*--------------Top Side Menu------------------------*/        
        ptopsidemenu=new JPanel(new GridBagLayout());
        ptopsidemenu.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Top Side Menu"));

        
        comboboxbackgroundtop=new JComboBox(ColorName);
        comboboxforegroundtop=new JComboBox(ColorName);
        comboboxfonttop=new JComboBox(font);
        
        /*--------------------1st Row--------------------*/    
            gbs.gridx=0;
            gbs.gridy=0;
            JLabel lbackground1=new JLabel("Background Color");
            lbackground1.setForeground(Validation.fontColor());
            ptopsidemenu.add(lbackground1,gbs);

            gbs.gridx=1;
            gbs.gridy=0;
            ptopsidemenu.add(comboboxbackgroundtop,gbs);
        /*-----------------2nd Row----------------------*/    
            gbs.gridx=0;
            gbs.gridy=1;
            JLabel lforegraound1=new JLabel("Foreground Color");
            lforegraound1.setForeground(Validation.fontColor());
            ptopsidemenu.add(lforegraound1,gbs);

            gbs.gridx=1;
            gbs.gridy=1;
            ptopsidemenu.add(comboboxforegroundtop,gbs);
        /*-------------------3rd Row----------------------*/    
            gbs.gridx=0;
            gbs.gridy=2;
            JLabel lfont1=new JLabel("Font Style");
            lfont1.setForeground(Validation.fontColor());
            ptopsidemenu.add(lfont1,gbs);

            gbs.gridx=1;
            gbs.gridy=2;
            ptopsidemenu.add(comboboxfonttop,gbs);
    
            
     /*--------------Button Panel---------------------*/
        breset=new JButton("RESET");
        bsubmit=new JButton("SUBMIT");
        pbutton=new JPanel(new GridBagLayout());
        pbutton.setBorder(BorderFactory.createLoweredBevelBorder());

        /*--------------------1st Row--------------------*/    
            gbs.gridx=0;
            gbs.gridy=0;
            gbs.ipadx=20;
            gbs.insets=new Insets(0, 0, 0, 0);
            gbs.fill=GridBagConstraints.BOTH;
            pbutton.add(bsubmit,gbs);

            gbs.gridx=1;
            gbs.gridy=0;
            gbs.insets=new Insets(0, 5, 0, 0);
            gbs.fill=GridBagConstraints.BOTH;
            pbutton.add(breset,gbs);
        
     
    /*----------------whole panel--------------------*/   
        
        pwhole=new JPanel(new GridBagLayout());
        
        gbs.gridx=0;
        gbs.gridy=0;
        gbs.ipadx=100;
        gbs.ipady=50;
        gbs.fill=GridBagConstraints.BOTH;
        pwhole.add(ptitle,gbs);
        
        gbs.gridy=1;
        pwhole.add(ptopsidemenu,gbs);
        
        gbs.gridy=2;
        pwhole.add(pleftsidemenu,gbs);
        
        gbs.gridy=3;
        pwhole.add(pbutton,gbs);
        
        
        
        add(pwhole);
        
               
    }
        
    public static void main(String []args)
    {
        new Setting();
    }
    
    public Color leftSideButtonColor()
    {
      String coloname=(String)comboboxbackgroundleft.getSelectedItem(); 
      Color objectColor=chooseColor(coloname);
      
        return objectColor;
    }
    
    public Color topSideButtonColor()
    {
      String coloname=(String)comboboxbackgroundtop.getSelectedItem(); 
      Color objectColor=chooseColor(coloname);
      return objectColor;
    }
    
    public Color leftSideFontColor()
    {
      String colorname=(String)comboboxforegroundleft.getSelectedItem();
      Color objectColor=chooseColor(colorname);
      return objectColor;
    }
    
    public Color topSideFontColor()
    {
      String colorname=(String)comboboxforegroundtop.getSelectedItem();
      Color objectColor=chooseColor(colorname);
      return objectColor;  
    }
    
    public Color chooseColor(String coloname)
    {
        Color objectColor=null;
        if(coloname.equalsIgnoreCase("Red"))
        {
            objectColor=Color.RED;
        }
        else if(coloname.equalsIgnoreCase("Blue"))
        {
            objectColor=Color.blue;
        }
        else if(coloname.equalsIgnoreCase("White"))
        {
            objectColor=Color.WHITE;
        }
        else if(coloname.equalsIgnoreCase("Green"))
        {
            objectColor=Color.GREEN;
        }
        else if(coloname.equalsIgnoreCase("Orange"))
        {
            objectColor=Color.ORANGE;
        }
        else if(coloname.equalsIgnoreCase("Yellow"))
        {
            objectColor=Color.YELLOW;
        }
        else if(coloname.equalsIgnoreCase("Pink"))
        {
            objectColor=Color.PINK;
        }
        else if(coloname.equalsIgnoreCase("Gray"))
        {
            objectColor=Color.GRAY;
        }
        else if(coloname.equalsIgnoreCase("Cyan"))
        {
            objectColor=Color.CYAN;
        }
        else if(coloname.equalsIgnoreCase("DarkGray"))
        {
            objectColor=Color.DARK_GRAY;
        }
        return objectColor;
    }
}
