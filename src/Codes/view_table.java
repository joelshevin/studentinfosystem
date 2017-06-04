/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Shehanka
 */
public class view_table { 
    
    public void loadtable(JTable table,PreparedStatement ps, Connection c)
    {
        try{
        String j="SELECT program_id,name,specialization,description,duration,semester_fee FROM program";
        ps=c.prepareStatement(j);
        ResultSet result= ps.executeQuery();
        
        table.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e)
        {
        
        }
    }
    
}
