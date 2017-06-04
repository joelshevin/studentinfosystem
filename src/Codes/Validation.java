/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinuksha
 */
public class Validation {
    
    Connection con;
    PreparedStatement ps;
    
    public Validation(){
      
    }
    
    public Validation(Connection con,PreparedStatement ps){
      this.con = con;
      this.ps = ps;
    }
    
    public static boolean isValidDate(String inDate) {

      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      Date dateobj = new Date();//today's date
      dateFormat.setLenient(false);

      Date exam_date;

      //checking if the date is before current date
      try {
          exam_date = dateFormat.parse(inDate);

          if(dateobj.after(exam_date)){
              return false;
          }
      } catch (ParseException ex) {
          return false;
      }

      //checking the date format
      try {
        dateFormat.parse(inDate.trim());
      }
      catch (ParseException pe) {
        return false;
      }
      return true;
    } 
    
    public static boolean isValidBirthDate(String inDate) {

      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      dateFormat.setLenient(false);


      //checking the date format
      try {
        dateFormat.parse(inDate.trim());
      }
      catch (ParseException pe) {
        return false;
      }
      return true;
    } 
  
    public static boolean studentITNumber(String id){
        if(!id.substring(0,2).matches("IT")||id.length()!=10){
        
            System.out.println("Invalid");
            return false;
        }
        else{
            char sID[] = id.toCharArray();

            for(int i=2;i<sID.length;i++){
                if(!Character.isDigit(sID[i])){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean validateSemester(int acYear,int semester){
        switch(acYear){
            case 1: if(semester==1 || semester==2){
                        return true;   
                    }
                    else{
                        return false;
                    }
            case 2: if(semester==3||semester==4){
                        return true;
                    }
                    else{
                        return false;
                    }
            case 3: if(semester==5||semester==6){
                        return true;
                    }
                    else{
                        return false;
                    }
            case 4: if(semester==7||semester==8){
                        return true;
                    }
                    else{
                        return false;
                    }
        }
        return false;
    }
    
    public static boolean validateNumber(String number){
        char arr[]=number.toCharArray();
        
        for(int i=0; i<arr.length;i++){
            if(!Character.isDigit(arr[i])){
                return false;
            }
        }
        return true;
    }
}
