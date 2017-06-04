package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class student {

    Connection con;
    PreparedStatement ps;
    
    public student(Connection con,PreparedStatement ps) {
        this.con = con;
        this.ps = ps;
    }
    
    public void addNewStudent(String sid, String f_name, String mid_name, String l_name, String stu_address, String stu_phone, String d_o_b, String stu_mail, String program,int sem){
        try{
            String query = "SELECT program_id FROM program WHERE CONCAT_WS(' ',name,specialization) LIKE '"+program+"'";
            ps = con.prepareStatement(query);
            ResultSet degree_id = ps.executeQuery();
            String prog = null;
            
            while(degree_id.next()){
               prog = degree_id.getString("program_id");
            }
            
            String record = "SELECT * FROM student WHERE stu_fname = '"+f_name+"' AND stu_mname = '"+mid_name+"' AND stu_surname = '"+l_name+"' AND address = '"+stu_address+"' AND phone = '"+stu_phone+"' AND email = '"+stu_mail+"' AND program = "+prog+" AND cur_sem = "+sem;
            try{
                ps = con.prepareStatement(record);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Record Already Exists");
                    return;
                }
                else{
                    
                    String q1 = "INSERT INTO student (stu_id,stu_fname,stu_mname,stu_surname,address,phone,dob,email,program,pwd) "
                            + "VALUES ('"+sid+"','"+f_name+"','"+mid_name+"','"+l_name+"','"+stu_address+"','"+stu_phone+"','"+d_o_b+"','"+stu_mail+"','"+prog+"','"+sid+"')";

                    ps = con.prepareStatement(q1);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Record Saved Successfully!");
                }
            }
            catch(Exception e){
                    
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return;
        }
    }
    
    public String generateIdNumber(Connection connect, PreparedStatement existing_id, String program){
        String ID_num;
        int year = Calendar.getInstance().get(Calendar.YEAR); //getting the current year
        String yr = Integer.toString(year).substring(2); //converting to a string and extracting the last 2 digits
        String random;
        try{
            do{
                random = Integer.toString((int)(Math.random()*10))+Integer.toString((int)(Math.random()*10))+Integer.toString((int)(Math.random()*10))+Integer.toString((int)(Math.random()*10))+Integer.toString((int)(Math.random()*10))+Integer.toString((int)(Math.random()*10));
            }
            while(checkId(connect, existing_id, random));
            
            switch (program) {
                case "BBA (Special Honours) in Business Management":
                    ID_num = "BM"+yr+random;
                    break;
                case "B.Sc Engineering (Curtin)":
                case "B. Eng. (Hons) in Electronic Engineering":
                    ID_num = "EN"+yr+random;
                    break;
                default:
                    ID_num = "IT"+yr+random;
                    break;
            }
            return ID_num;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    
    //method to check if the ID already exists
    public boolean checkId(Connection connect, PreparedStatement existing_id, String ID){
        try{
            String q2 = "SELECT stu_id FROM student";
            existing_id = connect.prepareStatement(q2);
            ResultSet r1 = existing_id.executeQuery();
            
            while(r1.next()){
                if(r1.getString("stu_id").substring(2).equals(ID)){
                    return true;
                }
            }
        }
        catch(SQLException e){
           JOptionPane.showMessageDialog(null, e); 
        }  
        return false;
    }
    
    public void viewStudentDetails(JTable j){
        try{
            String query = "SELECT s.stu_id as 'Student ID',CONCAT_WS(' ',s.stu_fname,s.stu_mname,s.stu_surname) as 'Student Name',s.address as 'Address',s.phone as 'Phone',s.dob as 'Date Of Birth',s.email as 'e-mail',p.name as 'Program Name',p.specialization as 'Specialization'  FROM student s,program p WHERE s.program=p.program_id";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        }
        
    }
    
    public void viewStudent(JTable j){
        try{
            String query = "SELECT stu_id as 'Student ID',CONCAT_WS(' ',stu_fname,stu_mname,stu_surname) as 'Student Name' FROM student";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        } 
    }
    
    public void updateRecord(String sid, String f_name, String mid_name, String l_name, String stu_address, String stu_phone, String d_o_b, String stu_mail,int sem){
        
        String record = "SELECT * FROM student WHERE stu_fname = '"+f_name+"' AND stu_mname = '"+mid_name+"' AND stu_surname = '"+l_name+"' AND address = '"+stu_address+"' AND phone = '"+stu_phone+"' AND email = '"+stu_mail+"' AND cur_sem="+sem;
            try{
                ps = con.prepareStatement(record);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Record Already Exists");
                    return;
                }
                else{
                    String update_query = "UPDATE student SET stu_id = '"+sid+"',stu_fname = '"+f_name+"',stu_mname = '"+mid_name+"',stu_surname = '"+l_name+"',address = '"+stu_address+"',phone = '"+stu_phone+"',dob = '"+d_o_b+"', email = '"+stu_mail+"',cur_sem="+sem+" WHERE stu_id = '"+sid+"'" ;
                    ps = con.prepareStatement(update_query);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Record updated successfully!");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Record Not Updated!");
            }
    }
    
    public void deleteRecord(String sid){
        try{
            String delete_query = "DELETE FROM student WHERE stu_id = '"+sid+"'";
            ps = con.prepareStatement(delete_query);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Record Deleted!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Record Not Deleted!"); 
        }
    }
}
