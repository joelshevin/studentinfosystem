/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProfilePicture {
    public static void browseImage(JTextField jf1,JLabel jl){
        
        JFileChooser fileChooser = new JFileChooser(); 
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png"); 
        fileChooser.addChoosableFileFilter(filter); 
        int result = fileChooser.showSaveDialog(null); 
        
        if(result == JFileChooser.APPROVE_OPTION){ 
            File selectedFile = fileChooser.getSelectedFile(); 
            String path = selectedFile.getAbsolutePath(); 

            jf1.setText(path);
            ImageIcon icon=new ImageIcon(path);
            jl.setIcon(ResizeImage(path,jl));    
        } 
        else if(result == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null,"No File Selected!");
        }
    
    }
    public static ImageIcon ResizeImage(String imgPath,JLabel jl){
        ImageIcon MyImage = new ImageIcon(imgPath); 
        Image img = MyImage.getImage(); 
        Image newImage = img.getScaledInstance(jl.getWidth(), jl.getHeight(),Image.SCALE_SMOOTH); 
        ImageIcon image = new ImageIcon(newImage); 
        return image; 
    }
    
    public static void setImage(JTextField jt,PreparedStatement pst,Connection con,String sid){
        try{
            String update_path = jt.getText();
            String sql = "UPDATE student SET Pro_pic = LOAD_FILE(?) WHERE stu_id = '"+sid+"'";
            pst = con.prepareStatement(sql);
            pst.setString(1, update_path);
            int row = pst.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(null,"Profile Picture was updated successfully!");
            }
            else{
                JOptionPane.showMessageDialog(null,"No Record Entered!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static void viewProfilePicture(PreparedStatement pst,Connection con,JLabel jl,String sid){
        
        try{
            String sql = "SELECT Pro_pic FROM student WHERE stu_id = '"+sid+"'";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            
            while(rs.next()){
                try {
                    InputStream stream = rs.getBinaryStream(1);
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    int a1 = stream.read();
                    while (a1 >= 0) {
                      output.write((char) a1);
                      a1 = stream.read();
                    }
                    Image myImage = Toolkit.getDefaultToolkit().createImage(output.toByteArray());
                    //To resize
                    
                    Image newImage = myImage.getScaledInstance(jl.getWidth(), jl.getHeight(),Image.SCALE_SMOOTH); 
                    //ImageIcon image = new ImageIcon(newImage); //converting to an image Icon
                    jl.setIcon(new ImageIcon(newImage));
                    
                } catch (Exception ex) {
                    //JOptionPane.showMessageDialog(null, "Could Not Find Image");
                } 
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
}
