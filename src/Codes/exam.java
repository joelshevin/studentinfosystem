/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Codes.grades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Dinuksha
 */
public class exam {
    PreparedStatement ps;
    Connection con;
    
    public exam(PreparedStatement ps,Connection con){
        this.ps = ps;
        this.con = con;
    }
    
        public void addNewExam(String exam_name,String desc,int ac_year,int sem,String date_of_exam){
        try{
            
            String new_exam= "INSERT INTO exam (exam,description, academic_year, semester,exam_date) VALUES('"+exam_name+"','"+desc+"',"+ac_year+","+sem+",'"+date_of_exam+"')";
            ps = con.prepareStatement(new_exam);
            ps.execute();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return;
        }
        JOptionPane.showMessageDialog(null, "Exam Added Successfully!");
    }
    
    public void updateExam(int exam_id,String exam, String desc, int year, int sem, String date,grades g,JTable t){
        try{
            String update_query = "UPDATE exam SET exam = '"+exam+"',description = '"+desc+"',academic_year = "+year+",semester = "+sem+",exam_date = '"+date+"' WHERE exam_code = "+exam_id ;
            this.ps = this.con.prepareStatement(update_query);
            this.ps.execute();
            g.viewExams(t);
            JOptionPane.showMessageDialog(null, "Record updated successfully!"); 
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Record not updated!"); 
        }   
    }
    
    public void deleteExam(grades g,JTable t,int exam_id) {
        try{
            String update_query = "DELETE FROM exam WHERE exam_code = "+exam_id ;
            this.ps = this.con.prepareStatement(update_query);
            this.ps.execute();
            g.viewExams(t);
            JOptionPane.showMessageDialog(null,"Record Deleted Successfully!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in Deleting Record!");  
        }
        
    }
}
