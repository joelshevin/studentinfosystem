/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinuksha
 */
public class validateUser {
    public static boolean checkAdmin(String user,String pwd,PreparedStatement ps,Connection con){
        
        try{
            String sql = "SELECT COUNT(*) FROM admin where username = '"+user+"' AND pwd = '"+pwd+"'";
            ps = con.prepareStatement(sql);
            ResultSet r1 = ps.executeQuery();
            
            r1.next();
            
            if(r1.getInt("COUNT(*)")==1){
                return true;
            }
        }
        catch(Exception e){
             
        }
        return false;  
    }
    public static boolean checkStudent(String user,String pwd,PreparedStatement ps,Connection con){
        try{
            String sql = "SELECT COUNT(*) FROM student where stu_id = '"+user+"' AND pwd = '"+pwd+"'";
            ps = con.prepareStatement(sql);
            ResultSet r1 = ps.executeQuery();
            
            r1.next();
            
            if(r1.getInt("COUNT(*)")==1){
                return true;
            }
        }
        catch(Exception e){
             
        }
        return false;
    }
    public static boolean checkLecturer(String user,String pwd,PreparedStatement ps,Connection con){
        try{
            String sql = "SELECT COUNT(*) FROM lecturer where name = '"+user+"' AND pw = '"+pwd+"'";
            ps = con.prepareStatement(sql);
            ResultSet r1 = ps.executeQuery();
            
            r1.next();
            
            if(r1.getInt("COUNT(*)")==1){
                return true;
            }
        }
        catch(Exception e){
             
        }
        return false;
    }
    
    public static boolean checkLecturer(String user,PreparedStatement ps,Connection con){
        try{
            String sql = "SELECT COUNT(*) FROM lecturer where name = '"+user+"'";
            ps = con.prepareStatement(sql);
            ResultSet r1 = ps.executeQuery();
            
            r1.next();
            
            if(r1.getInt("COUNT(*)")==1){
                return true;
            }
        }
        catch(Exception e){
             
        }
        return false;
    }
}
