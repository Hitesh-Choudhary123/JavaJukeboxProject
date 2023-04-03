package com.userlogin;

import java.sql.*;

public class User {
    public static Statement connection()  {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukeboxdb","root","root@123");
            Statement st=con.createStatement();
            return st;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void newUser(String firstName,String lastName,String userName,String password)  {
        try {
            Statement st = User.connection();
            st.executeUpdate("insert into customer values('"+firstName+"','"+lastName+"','"+userName+"','"+password+"')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkuser(String userName,String password)  {
        try {
            Statement st= User.connection();
            ResultSet r=st.executeQuery("select * from customer where userName='"+userName+"'and password='"+password+"'");
            if(r.next()){
                System.out.println("*******************************");
                System.out.println("     Logged in Successfully");
                System.out.println("*******************************");
            }
            else {
                System.out.println("Username and Password doesn't match");
                System.exit(0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
