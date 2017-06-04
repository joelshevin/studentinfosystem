//This code views the lecturers
package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
/**
 *
 * @author Joel
 */
public class ViewLecturer {
    
     public void tableload(PreparedStatement pst, Connection con, ResultSet rs,JTable jt)
    {
        try{
        String q1="SELECT name,position,email FROM lecturer";
        pst = con.prepareStatement(q1);
        rs=pst.executeQuery();

        jt.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
        }
     } 
     
      public void tableloadup(PreparedStatement pst, Connection con, ResultSet rs,JTable jt)
    {
        try{
        String q1="SELECT lec_id,name FROM lecturer";
        pst = con.prepareStatement(q1);
        rs=pst.executeQuery();

        jt.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
        }
     } 
    
}
