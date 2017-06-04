/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Dinuksha
 */
public class grades {
    
    Connection con = null;
    PreparedStatement ps = null;
    
    public grades(Connection con,PreparedStatement ps){
        this.con = con;
        this.ps = ps;
    }
    
    public void getExamCode(JComboBox jC){
        try{
            String sql = "Select * from exam";
            ps = con.prepareStatement(sql);
            ResultSet r1 = ps.executeQuery();

            while(r1.next()){
            
                jC.addItem(r1.getString("exam_code"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void getCourses(JComboBox jC){
        try{
            String sql = "Select * from course";
            ps= con.prepareStatement(sql);
            ResultSet r1 = ps.executeQuery();

            while(r1.next()){
            
                jC.addItem(r1.getString("name"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void viewExams(JTable j){
     
        try{
            String grades = "SELECT exam_code as 'Exam Code',exam as 'Exam',description as 'Description',academic_year as 'Academic Year',semester as 'Semester',exam_date as 'Date' FROM exam";
            ps = con.prepareStatement(grades);
            ResultSet rs = ps.executeQuery();
            
            j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            
        }
    }
    
    public void getStudentGrades(JTable j, String sid){
    
        try{
            String grades = "SELECT c.name as 'Course Name', s.grade as 'Grade' FROM student_courses s,course c WHERE student = '"+sid+"' AND c.Course_id = s.course";
            ps = con.prepareStatement(grades);
            ResultSet rs = ps.executeQuery();
            j.setVisible(true);
            j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void getCourseGrades(JTable j, String course){
    
        try{
            String grades = "SELECT s.student,s.grade FROM student_courses s,course c WHERE c.name = '"+course+"' AND c.Course_id = s.course";
            ps = con.prepareStatement(grades);
            ResultSet rs = ps.executeQuery();
            j.setVisible(true);
            j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void getCourseGrades(JTable j, String course,int exam){
    
        try{
            String grades = "SELECT s.student,s.grade FROM student_courses s,course c WHERE c.name = '"+course+"' AND c.Course_id = s.course AND s.exam ="+exam;
            ps = con.prepareStatement(grades);
            ResultSet rs = ps.executeQuery();
            j.setVisible(true);
            j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /*public void getEnrolledStudents(JTable j,String course){
    
        try{
            String students = "SELECT s.stu_id as 'Student ID' FROM programs_and_courses x,course c,student s"
                    + " WHERE c.name = '"+course+"' AND c.Course_id = x.course_code AND s.program = x.program_code";
            ps = con.prepareStatement(students);
            ResultSet rs = ps.executeQuery();
            j.setVisible(true);
            j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }*/
    public void getEnrolledStudents(JTable j,int exam,String course){

        try{
            String students = "SELECT s.stu_id as 'Student ID' FROM student s,programs_and_courses p,course c WHERE s.program = p.program_code AND p.semester=s.cur_sem AND p.course_code=c.Course_id AND c.name ='"+course+"'";
            ps = con.prepareStatement(students);
            ResultSet rs = ps.executeQuery();
            j.setVisible(true);
            j.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void getEnrolledStudents(JTable j,int exam){

        try{
            String students = "SELECT DISTINCT student as 'Student ID' FROM student_courses WHERE exam = "+exam;
            ps = con.prepareStatement(students);
            ResultSet rs = ps.executeQuery();
            j.setVisible(true);
            j.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void assignGrades(String id, String grd, String course, int exam){
       
        try{
            String course_id = "SELECT Course_id from course WHERE name = '"+course+"'";
            ps = con.prepareStatement(course_id);
            ResultSet rs = ps.executeQuery();
            String cid = null;
            
            while(rs.next()){
                cid = rs.getString("Course_id");
            }
            
            String new_grade = "INSERT INTO student_courses VALUES('"+id+"',"+Integer.parseInt(cid)+","+exam+",'"+grd+"')";
            ps = con.prepareStatement(new_grade);
            ps.execute();

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "A Grade already assigned!");
            return;
        }
        JOptionPane.showMessageDialog(null, "Grade Assigned Successfully!");
    }
    
    public void allGPAs(int exam_id){
        try{
            String students = "SELECT DISTINCT student FROM student_courses WHERE exam = "+exam_id;
            ps = con.prepareStatement(students);
            ResultSet rs = ps.executeQuery();
            double gpa;
            String student;
            
            while(rs.next()){
                student = rs.getString("student");
                gpa = calculateGPA(student, exam_id);
                
                if(gpa>0){
                    
                   //rounding off to the second decimal place
                    DecimalFormat df = new DecimalFormat("#.##");
                    gpa = Double.parseDouble(df.format(gpa));
                    
                    String gpa_insert = "INSERT INTO student_gpa (student_ID,exam,gpa) VALUES ('"+student+"',"+exam_id+","+gpa+")";
                    ps = con.prepareStatement(gpa_insert);
                    ps.execute();    
                }
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    public double calculateGPA(String sid,int exam_id){
        double gpa = 0;
        try{
            String new_exam= "SELECT grade FROM student_courses WHERE exam = "+exam_id+" AND student = '"+sid+"'";
            ps = con.prepareStatement(new_exam);
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            int row = rs.getRow();
            rs.beforeFirst();

            double totalCredits = 0;
            if(row==5){
                while(rs.next()){
                    String grade = rs.getString("grade");
                    totalCredits = totalCredits + getCreditPoints(grade);
                    gpa = totalCredits/5;
                }
                JOptionPane.showMessageDialog(null, "GPA Calculated!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Grades are not assigned for all courses for '"+sid+"'");
                return -1;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return gpa;
    }
    
    public double getCreditPoints(String grade){
        double credits = 0;
        switch(grade){
            case "A+":
            case "A": credits = 4.0;
                        break;
            case "A-": credits = 3.7;
                        break;
            case "B+": credits = 3.3;
                        break;
            case "B": credits = 3.0;
                        break;
            case "B-": credits = 2.7;
                        break;
            case "C+": credits = 2.3;
                        break;
            case "C": credits = 2.0;
                        break;
            case "C-": credits = 1.7;
                        break;
            case "D+": credits = 1.3;
                        break;
            case "D": credits = 1.0;
                        break;
            case "D-": credits = 0.7;
                        break;
        }
        return credits;
    }
    
    
    public void getGPA(JTable j,String sid){
        try{
            String show_grades = "SELECT e.semester,s.gpa FROM exam e,student_gpa s WHERE s.exam = e.exam_code AND s.student_ID = '"+sid+"'" ;
            ps = con.prepareStatement(show_grades);
            ResultSet rs = ps.executeQuery();
            
            j.setVisible(true);
            j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
}
