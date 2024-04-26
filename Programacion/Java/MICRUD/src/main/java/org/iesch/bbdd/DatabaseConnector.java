package org.iesch.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private  static final String url = "jdbc:mysql://localhost:3306/personas";
    private  static final String user = "root";
    private  static final String password = "1234";

    public  static Connection connection(){
        try {
            return DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
