package app.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConf {

    public static Connection getConnection() throws SQLException {
        Connection c = null;
           try {
               Class.forName("org.postgresql.Driver");
               c = DriverManager
                       .getConnection("jdbc:postgresql://localhost:5432/schoolsearch",
                               "NBIGLARI", "-kots578-");
           } catch(Exception e){
               e.printStackTrace();
           }


        System.out.println("Opened database successfully");
        System.out.println(c);
        return c;
    }
}