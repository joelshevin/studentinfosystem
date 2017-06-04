/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author Joel
 */
public class addlecturer {
   public boolean addNewLecturer(PreparedStatement pst, Connection con,String name,String position,String email,String phone,String address,String pass){
        String record = "SELECT * FROM lecturer WHERE name = '"+name+"' AND position = '"+position+"' AND email = '"+email+"' AND phone = '"+phone+"' AND address = '"+address+"' AND pw = '"+pass+"'";
       try{
                pst = con.prepareStatement(record);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Record Already Exists");
                    return false;
                }
                else{
                    String Q= "INSERT INTO lecturer (name,position,email,phone,address,pw) values ('"+ name+"','"+position+"','"+email+"','"+phone+"','"+address+"','"+pass+"')";
                    pst= con.prepareStatement(Q);
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Successfully added!");
                    return true;
                }
            
         }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
   
   }
}
