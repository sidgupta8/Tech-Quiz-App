/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScore;

/**
 *
 * @author pc
 */
public class PerformanceDAO {
    public static void addPerformance(Performance p)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into performance values(?,?,?,?,?,?,?)");
        ps.setString(1, p.getUserid());
        ps.setString(2, p.getExamid());
        ps.setInt(3, p.getRight());
        ps.setInt(4,p.getWrong());
        ps.setInt(5,p.getUnattempted());
        ps.setDouble(6, p.getPer());
        ps.setString(7,p.getLanguage());
        ps.executeUpdate();
    }
    public static ArrayList<String> getAllExamId(String student)throws SQLException
    {
       String qry="select examid from performance where userid=?";
       ArrayList<String> examIdList=new ArrayList<>();
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1, student);
       ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               String id=rs.getString(1);
               examIdList.add(id);
           }
        return examIdList;                      
    }
    
    public static ArrayList<String> getAllStudentId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select distinct userid from performance");
        ArrayList<String> examIdList=new ArrayList<>();
        while(rs.next())
        {
            examIdList.add(rs.getString(1));
        }
        return examIdList;
    }
     
    public static ArrayList<String> getAllExamid(String userid) throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Select examid from performance where userid=?");
       ps.setString(1, userid);
       ResultSet rs=ps.executeQuery();
       ArrayList<String> examIdList=new ArrayList<>();
       while(rs.next())
       {
           examIdList.add(rs.getString(1));
       }
       return examIdList;
    }
    
    public static ArrayList<Performance> getAllData() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from performance");
        ArrayList<Performance> performList=new ArrayList<>();
        while(rs.next())
        {
            String userId=rs.getString(1);
            String examId=rs.getString(2);
            int right=rs.getInt(3);
            int wrong=rs.getInt(4);
            int unattm=rs.getInt(5);
            double perc=rs.getDouble(6);
            String lang=rs.getString(7);
            Performance p=new Performance(userId,examId,right,wrong,unattm,perc,lang);
            performList.add(p);
        }
        return performList;
    }
    
    public static StudentScore getScore(String userid,String examid) throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Select language,per from performance where userid=? and examid=?");
       ps.setString(1, userid);
       ps.setString(2,examid);
       ResultSet rs=ps.executeQuery();
       rs.next();
       StudentScore obj=new StudentScore();
       obj.setLanguage(rs.getString(1));
       obj.setPer(rs.getDouble(2));
       return obj;
    }
}
