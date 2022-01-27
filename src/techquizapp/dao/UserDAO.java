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
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Student;
import techquizapp.pojo.User;

public class UserDAO {
    public static boolean validateUser(User user)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from Users where userid=? and password=? and usertype=?");
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUsertype());
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    public static boolean RegisStudent(Student st)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into Users values(?,?,?)");
        ps.setString(1,st.getUserid());
        ps.setString(2,st.getPassword());
        ps.setString(3,st.getUserType());
        int ans=ps.executeUpdate();
        return ans==1;
    }
    public static boolean ChangePwd(Student st)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Update Users set password=? where userid=? and usertype=?");
        ps.setString(1,st.getPassword());
        ps.setString(2,st.getUserid());
        ps.setString(3,st.getUserType());
        int ans=ps.executeUpdate();
        return ans==1;
    }
}
