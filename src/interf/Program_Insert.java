/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

import Codes.DBconnect;
import Codes.view_table;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Shehanka
 */
public class Program_Insert extends javax.swing.JFrame {
    Connection con2=null;
    PreparedStatement a=null;
    PreparedStatement b=null;
    view_table view2 = new view_table();
    ResultSet rs = null;
        

    /**
     * Creates new form Program_Insert
     */
    public Program_Insert() {
        initComponents();
        con2=DBconnect.connect();
        view2.loadtable(jTable1,a,con2);
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        Specialization = new javax.swing.JTextField();
        Duration = new javax.swing.JTextField();
        Semfee = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Descript = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setLocation(new java.awt.Point(300, 70));
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(1200, 560));
        setSize(new java.awt.Dimension(1200, 560));
        getContentPane().setLayout(null);

        jLabel2.setText("Program Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 120, 140, 40);

        jLabel3.setText("Specialization");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 180, 130, 40);

        jLabel4.setText("Duration");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 310, 130, 40);

        jLabel5.setText("Semester Fee");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 380, 140, 40);

        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        getContentPane().add(Name);
        Name.setBounds(160, 120, 135, 40);
        getContentPane().add(Specialization);
        Specialization.setBounds(160, 180, 135, 40);

        Duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DurationActionPerformed(evt);
            }
        });
        getContentPane().add(Duration);
        Duration.setBounds(160, 310, 135, 40);
        getContentPane().add(Semfee);
        Semfee.setBounds(160, 380, 135, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button(9).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addpressed.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 450, 150, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rsz_arrow-back-icon.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1050, 10, 130, 50);

        jLabel1.setText("Description");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 250, 140, 40);
        getContentPane().add(Descript);
        Descript.setBounds(160, 250, 137, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(520, 80, 640, 400);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button(17).png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/presseddelete.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(110, 440, 150, 70);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button(13).png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pressedupdate.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(210, 450, 160, 50);

        jLabel6.setText("Program ID");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 50, 130, 40);
        getContentPane().add(id_label);
        id_label.setBounds(160, 50, 100, 40);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button(19).png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clearpressed.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(310, 450, 160, 50);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Light-Blue-blur-background1.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(-6, -6, 1240, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String name=Name.getText();
        String spec=Specialization.getText();
        String desc=Descript.getText();
        String dur=Duration.getText();
        String sem=Semfee.getText();
        
        
        
        try {
            boolean empty = true;
            
            if(name.equals("")||spec.equals("")||desc.equals("")||dur.equals("")||sem.equals(""))
            {   
                JOptionPane.showMessageDialog(null, " One or more fields are missing !! ");
                empty=true;
                
            }
            else{
                empty=false;
                
            }
            
            String query = "SELECT * FROM program WHERE name = '"+ name +"'";
            a=con2.prepareStatement(query);
            rs = a.executeQuery();
            boolean exist = false;
            
            while(rs.next())
            {
                String r = rs.getString("name");
                
                
                if(r.equals(name))
                {
                    JOptionPane.showMessageDialog(null," Data already exists !! ");
                    exist = true;
                }
            }
            
            if(exist == false  && empty == false)
            {
                String y= "INSERT INTO program(name,specialization,description,duration,semester_fee) values ('"+name+"','"+spec+"','"+desc+"','"+dur+"','"+sem+"')";
                    a=con2.prepareStatement(y);
                    a.execute();
                    JOptionPane.showMessageDialog(null,"The record has been added!","RECORD ADDED",JOptionPane.PLAIN_MESSAGE);
        
            }
            
            view2.loadtable(jTable1,a,con2);
        }
        catch(Exception e)
        {
        
        }
        
        
        
         
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row_table=jTable1.getSelectedRow();
        
        String proid=jTable1.getValueAt(row_table,0).toString();
        String pronm=jTable1.getValueAt(row_table,1).toString();
        String specilztion=jTable1.getValueAt(row_table,2).toString();
        String descrption=jTable1.getValueAt(row_table,3).toString();
        String durr=jTable1.getValueAt(row_table,4).toString();
        String semfe=jTable1.getValueAt(row_table,5).toString();
        
        id_label.setText(proid);
        Name.setText(pronm);
        Specialization.setText(specilztion);
        Descript.setText(descrption);
        Duration.setText(durr);
        Semfee.setText(semfe);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
       int confirm_val=JOptionPane.showConfirmDialog(null,"The record is about to be updated");
       
       if(confirm_val==0)
       {
           String id_2=id_label.getText();
           String name2=Name.getText();
           String spec2=Specialization.getText();
           String desc2=Descript.getText();
           String dur2=Duration.getText();
           String semfe2=Semfee.getText();
           
           
          
           
           try
           {
                   boolean empty_update = true;
            
            if(name2.equals("")||spec2.equals("")||desc2.equals("")||dur2.equals("")||semfe2.equals(""))
            {   
                JOptionPane.showMessageDialog(null, " One or more fields are missing !! ");
                empty_update=true;
                
            }
            else{
                empty_update=false;
                
            }
            
            if(empty_update==false)
            {
               String new_sql="UPDATE program set name='"+ name2+"',specialization='"+spec2+"',description='"+ desc2 +"',duration='"+dur2+"',semester_fee='"+semfe2+"' where program_id='"+id_2+"'";
               b=con2.prepareStatement(new_sql);
               b.execute();
               view2.loadtable(jTable1, a, con2);
               JOptionPane.showMessageDialog(null,"The record has been updated!","RECORD UPDATED",JOptionPane.PLAIN_MESSAGE);
            }
            }
           catch(SQLException | HeadlessException e)
           {}
           
       
           
       
       }
       
       else
       {
       JOptionPane.showMessageDialog(null,"No record has been updated!","NO RECORD UPDATED",JOptionPane.PLAIN_MESSAGE);
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void DurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DurationActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int delete_val=JOptionPane.showConfirmDialog(null,"Do you really want to delete this record");
        
        if(delete_val==0)
        {
        String id=id_label.getText();
        
        String del_sql="Delete from program where program_id='"+id+"'";
         try
           {
               a=con2.prepareStatement(del_sql);
               a.execute();
               view2.loadtable(jTable1, a, con2);
               JOptionPane.showMessageDialog(null,"The record has been deleted!","RECORD DELETED",JOptionPane.PLAIN_MESSAGE);
           }
           catch(SQLException | HeadlessException e)
           {}
        
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        id_label.setText(" ");
        Name.setText(" ");
        Specialization.setText(" ");
        Semfee.setText(" ");
        Duration.setText(" ");
        Descript.setText(" ");
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Program_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Program_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Program_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Program_Insert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Descript;
    private javax.swing.JTextField Duration;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Semfee;
    private javax.swing.JTextField Specialization;
    private javax.swing.JLabel id_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}