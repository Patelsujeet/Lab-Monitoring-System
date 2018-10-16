/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class Validation {
    
   public boolean isValidEmail(String name)
    {
         boolean at=name.contains("@");
         boolean dot=name.contains(".");
         if(at==true && dot==true)
         {
             return true;
         }
        return false;
    }
   public static void refreshFrame(JFrame framename)
   {
        framename.validate();
        framename.repaint();
        framename.revalidate();
   }
   public static void refreshPanel(JPanel jpanel)
   {
       jpanel.validate();
       jpanel.repaint();
       jpanel.revalidate();
       
   }
   
   public static void logout(JFrame frame)
   {
       frame.setVisible(false);
       new SplashScreen();
   }
   
   public static Color fontColor()
   {
       return Color.ORANGE;
   }

    public static void refreshDailog(JDialog dial)
    {
        dial.validate();
        dial.repaint();
        dial.revalidate();
        
                
    }
            
}
