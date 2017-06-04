//This code updates the lecturer
package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Joel
 */
public class Updatelec {
     public void updateRecord(int id,String name, String position, String email, String phone, String address, String pw, PreparedStatement pst, Connection conn){
         String record = "SELECT * FROM lecturer WHERE name = '"+name+"' AND position = '"+position+"' AND email = '"+email+"' AND phone = '"+phone+"' AND address = '"+address+"' AND pw = '"+pw+"'";
         try{
              pst = conn.prepareStatement(record);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Record Already Exists");
                    
                }
                else{
                    String update = "UPDATE lecturer SET name = '"+name+"',position = '"+position+"',email = '"+email+"',phone = '"+phone+"',address = '"+address+"',pw = '"+pw+"' WHERE lec_id = '"+id+"'" ;
                    pst = conn.prepareStatement(update);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Record updated successfully!"); 
                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        }
        
    }
    
    public void deleteRecord(String name, PreparedStatement pst, Connection conn){
        try{
            String delete = "DELETE FROM lecturer WHERE name = '"+name+"'";
            pst = conn.prepareStatement(delete);
            pst.execute();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e); 
        }
        JOptionPane.showMessageDialog(null, "Record Deleted!");
    }
    
    public void clickupdate(PreparedStatement pst, Connection conn, ResultSet rs, JTable j){
        try{
        String q1="SELECT lec_id,name FROM lecturer";
        pst = conn.prepareStatement(q1);
        rs=pst.executeQuery();

        j.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
        }
    }
    
}

