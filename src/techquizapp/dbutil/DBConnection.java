/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
     private static Connection conn;
   static{
       try{
             Class.forName("oracle.jdbc.OracleDriver");
             conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-RA2424V:1521/XE", "onlineexam", "student");
             JOptionPane.showMessageDialog(null,"Connected Successfully to the DB"); 
         }
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(null,"Cannot Connect to the DB"); 
         e.printStackTrace();
         System.exit(1);
      }
    }  
    public static Connection getConnection()
       {
           return conn;
       }
    public static void closeConnection()
    {
        try{
            conn.close();
            JOptionPane.showMessageDialog(null,"Disconnected Successfully to the DB"); 
        }
         catch(SQLException e)
      {
         JOptionPane.showMessageDialog(null,"Cannot Disconnect to the DB"); 
         e.printStackTrace();
      }
    }
}
