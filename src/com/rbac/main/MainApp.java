package com.rbac.main;

import com.rbac.dao.PermissionDAO;
import com.rbac.dao.UserDAO;
import com.rbac.model.User;

import java.util.Set;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        User user = UserDAO.login(username, password);

        if (user == null) {
            System.out.println("=====Login Failed====");
            return;
        }

        System.out.println("===== Login Successful=====");
        System.out.println("Welcome, " + user.getUsername());

        Set<String> permissions =
                PermissionDAO.getPermissionsByUserId(user.getId());

        System.out.println("\nUser Permissions:");
        for (String p : permissions) {
            System.out.println("• " + p);
        }
        System.out.println("Sorry Next operation not ready at that time I implemented admin authentication and authorization");
        sc.close();
    }
}
