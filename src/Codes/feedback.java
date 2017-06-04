/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Joel
 */
public class feedback {
     
    public void cb1items(PreparedStatement pst, Connection con, ResultSet rs,JComboBox c){
        try{
            String cb="select * from lecturer";
            pst= con.prepareStatement(cb);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String name=rs.getString("name");
                c.addItem(name);
                
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void cb2items(PreparedStatement pst, Connection con, ResultSet rs,JComboBox c){
        try{
            String cb="select * from course";
            pst= con.prepareStatement(cb);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String name=rs.getString("name");
                c.addItem(name);
                
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public boolean feedback(PreparedStatement pst, Connection con, String name, String Course, String feed){
        try{
            String Q= "INSERT INTO feedback (lecturerName,course,feedback) values ('"+ name+"','"+Course+"','"+feed+"')";
            pst= con.prepareStatement(Q);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Thank you for your feedback!");
            return true;
         }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
        
    }
    
    //this method checks feedback for the logged in lecturer
    public void viewfeedback(PreparedStatement pst, Connection con, ResultSet rs, JTable jt,String lecName){
        try{
        String q1="SELECT lecturerName,course,feedback FROM feedback WHERE lecturerName='"+lecName+"'";
        pst = con.prepareStatement(q1);
        rs=pst.executeQuery();

        jt.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
        }
    }
    
    public void clickupdate(PreparedStatement pst, Connection conn, ResultSet rs, JTable j){
        try{
        String q1="SELECT feedback FROM feedback";
        pst = conn.prepareStatement(q1);
        rs=pst.executeQuery();

        j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
        }
    }

    
}
