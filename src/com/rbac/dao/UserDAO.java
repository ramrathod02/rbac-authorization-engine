package com.rbac.dao;

import java.sql.*;
import com.rbac.model.User;

public class UserDAO {

    public static User login(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("user_id"), rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
