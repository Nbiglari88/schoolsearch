package app;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConf {

    public Connection getConnection() throws Exception{
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

    public static void main(String [] args) throws Exception{
        Connection c = null;


        Class.forName("org.postgresql.Driver");
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/schoolsearch",
                        "NBIGLARI", "-kots578-");


        System.out.println("Opened database successfully");
        System.out.println(c);

    }
}