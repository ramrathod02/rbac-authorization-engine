package com.rbac.dao;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PermissionDAO {

    public static Set<String> getPermissionsByUserId(int userId) {
        Set<String> permissions = new HashSet<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = """
                SELECT p.permission_name
                FROM permissions p
                JOIN role_permissions rp ON p.permission_id = rp.permission_id
                JOIN user_roles ur ON rp.role_id = ur.role_id
                WHERE ur.user_id = ?
            """;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                permissions.add(rs.getString("permission_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissions;
    }
}
