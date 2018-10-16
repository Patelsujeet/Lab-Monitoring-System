package lms;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.awt.Component;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class DBConnection 
{
    String driver = "com.mysql.jdbc.Driver";
    String con_str = "jdbc:mysql://127.0.0.1:3306/lab_monitoring_system";
    String uname="root";
    String pass="";

    Connection con;
    PreparedStatement ps1,ps2;
    ResultSet rs;
    
    DateTimeFormatter fd;

    String start,startDate;
    
    Component parent;
    public DBConnection(Component parent)
    {
        try
        {
            
            this.parent=parent;
            
            Class.forName(driver);
            con = DriverManager.getConnection(con_str,uname,pass);
                           
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");  
        fd=DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.of("Asia/Calcutta"));
        
        java.util.Date date=new java.util.Date();
        start=LocalTime.now().format(fd);
        startDate=dateformat.format(date);
        

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }

    
    public boolean search(String id,String password,String tablename,String attribute)
    {
        try
        {
                String query="select * from "+tablename+" where "+attribute+"=? and password=?";
                ps2=con.prepareStatement(query);

                ps2.setString(1, id);
                ps2.setString(2, password);

                rs=ps2.executeQuery();
                return rs.next();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
 
    public ResultSet getUserDetailsForProfile(String table,String email,String user)
    {
        ResultSet rs=null;
            try
            {
             String query="select * from "+table+" where "+email+"=?";
             ps2=con.prepareStatement(query);
             ps2.setString(1,user);
             rs=ps2.executeQuery();
            }
            
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
   
public int insertStudentData(String enrollment,String name,String sem,String department,String pass,String mobile,String email)
{
    int i=0;
    System.out.print(i);
    try
    {                    
      String q="insert into student(enrollment,student_name,student_semester,student_department,password,student_mobile_number,student_email) values(?,?,?,?,?,?,?)";
      System.out.println(q);
      ps2=con.prepareStatement(q);
      
      ps2.setString(1,enrollment);
      ps2.setString(2,name);
      ps2.setString(3,sem);
      ps2.setString(4,department);
      ps2.setString(5,pass);
      ps2.setString(6,mobile);
      ps2.setString(7,email);
      
      i=ps2.executeUpdate();
        
    }
    catch(MySQLIntegrityConstraintViolationException mysqlduplication)
    {
        JOptionPane.showMessageDialog(parent,"Data Duplication Error","Data Base Error",JOptionPane.WARNING_MESSAGE);
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
    }
    return i;
}    
public int insertHODData(String emailID,String password,String name,String department,String mobilenumber)
{
    int i=0;
    try
    {
    String q="insert into hod(email,password,hod_name,hod_department,hod_mobile_number) values(?,?,?,?,?)";
    ps2=con.prepareStatement(q);
    
    ps2.setString(1,emailID);
    ps2.setString(2,password);
    ps2.setString(3,name);
    ps2.setString(4,department);
    ps2.setString(5,mobilenumber);
    
    i=ps2.executeUpdate();
    }
    catch(MySQLIntegrityConstraintViolationException mysqlduplication)
    {
        JOptionPane.showMessageDialog(parent,"Data Duplication Error","Data Base Error",JOptionPane.WARNING_MESSAGE);
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
    }
    return i;
    
}
public int insertFacultyData(String name,String department,String mobilenumber,String emailID,String password)
{
    
    int i=0;
    try
    {
    String q="insert into faculty(email,password,faculty_name,faculty_department,faculty_mobile_number) values(?,?,?,?,?)";
    ps2=con.prepareStatement(q);
    
    ps2.setString(1,emailID);
    ps2.setString(2,password);
    ps2.setString(3,name);
    ps2.setString(4,department);
    ps2.setString(5,mobilenumber);
    
    i=ps2.executeUpdate();
    }
    catch(MySQLIntegrityConstraintViolationException mysqlduplication)
    {
        JOptionPane.showMessageDialog(parent,"Data Duplication Error","Data Base Error",JOptionPane.WARNING_MESSAGE);
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
    }
    return i;
}

public int insertAdminData(String name,String mobilenumber,String email,String password)
{
    int i=0;
    try
    {
    String q="insert into admin(email,password,admin_name,admin_mobile_number) values(?,?,?,?)";
    ps2=con.prepareStatement(q);
    
    ps2.setString(1,email);
    ps2.setString(2,password);
    ps2.setString(3,name);
    ps2.setString(4,mobilenumber);
    
     i=ps2.executeUpdate();
    }catch(SQLException e){}
    
    return i;
}

public int remove(String tablename,String id,String branch,String sem) 
{
   int i=0;
   String q="";
    try
    {
        if(tablename.equalsIgnoreCase("student"))
        {
            System.out.println(tablename);
            System.out.println(branch);
            System.out.println(sem);
            System.out.println(id);
            if(branch==null || sem==null)
            {    
                q="delete from student where enrollment=?"; 
                ps2=con.prepareStatement(q);
                ps2.setString(1,id);
            }
            else if(id==null)
            {
                q="delete from student where student_department=? and student_semester=?"; 
                ps2=con.prepareStatement(q);
                ps2.setString(1,branch);
                ps2.setString(2,sem);
            }
        } 
        else if(tablename.equalsIgnoreCase("hod") || tablename.equalsIgnoreCase("faculty"))
        {
            System.out.println(tablename);
            System.out.println(branch);
            System.out.println(sem);
            System.out.println(id);
            if(branch==null)
            {    
                q="delete from "+tablename+" where email=?"; 
                ps2=con.prepareStatement(q);
                ps2.setString(1,id);
            }
            else if(id==null || sem==null)
            {
                q="delete from "+tablename+" where "+tablename+"_department=?"; 
                ps2=con.prepareStatement(q);
                ps2.setString(1,branch);
            }
            
        }
        else
        {
            q="delete from "+tablename+" where email=?"; 
            ps2=con.prepareStatement(q);
             ps2.setString(1,id);
        }
        System.out.println(q);
        i=ps2.executeUpdate();
        System.out.println(i);
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
    }
    return i;
}
  
    public int updateFacultyProfile(String oldemail,String newemail,String password,String name,String department,String mobile)
    {
     int i=0;
     try
     {
       String q="update faculty set email=? , password=? , faculty_name=? , faculty_department=? , faculty_mobile_number=? where email=?";
       
       ps2=con.prepareStatement(q);
       
       ps2.setString(1,newemail);
       ps2.setString(2,password);
       ps2.setString(3,name);
       ps2.setString(4,department);
       ps2.setString(5,mobile);
       ps2.setString(6,oldemail);
       
       i=ps2.executeUpdate();
     }
     catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
     return i;
    }
    public int updateStudentProfile(String oldEnrollment,String newenrollment,String name,String sem,String department,String pass,String mobile,String email)
    {        
        int i=0;
        try
        {    
                
        String q="update student set enrollment=? , student_name=? , student_semester=? , student_department=? , password=? , student_mobile_number=? , student_email=? where enrollment=?";
        ps2=con.prepareStatement(q);
            
            ps2.setString(1,newenrollment);
            ps2.setString(2,name);
            ps2.setString(3,sem);
            ps2.setString(4,department);
            ps2.setString(5,pass);
            ps2.setString(6,mobile);
            ps2.setString(7,email);
            ps2.setString(8,oldEnrollment);
            
        i=ps2.executeUpdate();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }
    
    public int updateAdminProfile(String oldemail,String newemail,String name,String pass,String mobile)throws Exception
    {
    String q="update admin set email=? , password=? , admin_name=? , admin_mobile_number=? where email=?";

    ps2=con.prepareStatement(q);

    ps2.setString(1,newemail);
    ps2.setString(2,pass);
    ps2.setString(3,name);
    ps2.setString(4,mobile);
    ps2.setString(5,oldemail);
    

    int i=ps2.executeUpdate();

        return i;
    }
    
    public int updateHodProfile(String oldemail,String newemail,String password,String name,String department,String mobile)
    {
        int i=0;
        try
        {
            String q="update hod set email=? , password=? , hod_name=? , hod_department=? , hod_mobile_number=? where email=?";
           
            ps2=con.prepareStatement(q);
            
            ps2.setString(1,newemail);
            ps2.setString(2,password);
            ps2.setString(3,name);
            ps2.setString(4,department);
            ps2.setString(5,mobile);
            ps2.setString(6,oldemail);
            
            i=ps2.executeUpdate();
        }
        catch(MySQLIntegrityConstraintViolationException mysqlduplication)
        {
            JOptionPane.showMessageDialog(parent,"Data Duplication Error","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }        
        return i;
    }
    
    public int student_login(String student_id,String server_email)
    {
        int i=0;
        try
        {
        java.util.Date date=new java.util.Date();

        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        fd=DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.of("Asia/Calcutta"));
        
        
        start=LocalTime.now().format(fd);
        startDate=dateformat.format(date);
        
        LocalTime ls=LocalTime.parse(LocalTime.now().format(fd), fd);
            
        System.out.println(student_id+":");
        System.out.println("Start Time:"+start);
               
        System.out.println(dateformat.format(date));
        
        
        
            String qury="insert into student_login(enrollment,login_date,login_time,server_email) values(?,?,?,?)";
            ps2=con.prepareStatement(qury);
            
            ps2.setString(1,student_id);
            ps2.setString(2,dateformat.format(date));
            ps2.setString(3,start);
            ps2.setString(4,server_email);
            
            i=ps2.executeUpdate();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }
    
    public ResultSet getStudentPrimaryKey(String enrollment,String starttime,String satrtDate)
    {
        ResultSet rs=null;
        try
        {
            String query="SELECT student_login.id FROM student_login WHERE student_login.enrollment=? AND student_login.login_date=? AND student_login.login_time=?";
            ps2=con.prepareStatement(query);

            System.out.println("start"+satrtDate+":"+starttime);
            ps2.setString(1,enrollment);
            ps2.setString(2,startDate);
            ps2.setString(3,starttime);
            
            
            rs=ps2.executeQuery();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    public String getStartTime()
    {
        return start;
    }
    public String getStartDate()
    {
        return startDate; 
    }
    
    public int student_logout(String foreignkeyId,String student_id,String server_email,int hours,int min,int sec)
    {
        int i=0;
        try
        {
            
            java.util.Date date=new java.util.Date();
            SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
            
            fd=DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.of("Asia/Calcutta"));           
            String stop=LocalTime.now().format(fd);
        
            LocalDate ld=LocalDate.now();
            LocalDateTime ldl=ld.atTime(hours, min, sec);
            
            System.out.println("Stop Time:"+stop);
        
            String query="insert into student_logout(id,enrollment,logout_date,logout_time,server_email,duration) values(?,?,?,?,?,?)";
            ps2=con.prepareStatement(query);
            
            ps2.setString(1,foreignkeyId);
            ps2.setString(2,student_id);
            ps2.setString(3,dateformat.format(date));
            ps2.setString(4,stop);
            ps2.setString(5,server_email);
            ps2.setString(6,ldl.format(fd));
            
            System.out.println("Key"+foreignkeyId);
             i=ps2.executeUpdate();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
        
        return i;        
    }
    
    public ResultSet loginTimeForReport(String from,String to)
    {
        ResultSet rs=null;
        try
        {
            String query="SELECT student_login.server_email,student_login.enrollment , student_login.login_date , student_login.login_time , student_logout.logout_time , student_logout.Duration FROM student_login INNER JOIN student_logout ON (student_login.id=student_logout.id) WHERE student_logout.logout_date BETWEEN ? AND ?";
            ps2=con.prepareStatement(query);
            
            ps2.setString(1,from);
            ps2.setString(2, to);
            
            rs=ps2.executeQuery();
            
        } 
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
public ResultSet getStudentData(String sem,String department)
{
    ResultSet rs=null;
    try
    {
        String query="SELECT student.enrollment ,student.student_name,student.student_semester,student.student_department from student WHERE student.student_semester=? and student.student_department=?";
        ps1=con.prepareStatement(query);

        ps1.setString(1, sem);
        ps1.setString(2, department);

        rs=ps1.executeQuery();
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
    }
    return rs;
}

ResultSet studenReport(String enrollment)
{
    ResultSet rs=null;
    try
    {
        String querry="SELECT student_logout.enrollment,student_logout.logout_date,student_logout.logout_time,student_logout.Duration from student_logout where  student_logout.enrollment=?";
       
        ps1=con.prepareStatement(querry);
        ps1.setString(1, enrollment);
        
        rs=ps1.executeQuery();
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(parent,"Data Base Server is OffLine","Data Base Error",JOptionPane.WARNING_MESSAGE);
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(parent,"System Error","System Error",JOptionPane.ERROR_MESSAGE);
    }
    return rs;
}
}         
