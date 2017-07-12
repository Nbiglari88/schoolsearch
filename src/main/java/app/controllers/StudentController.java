package app.controllers;


import app.configuration.DatabaseConf;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


@RestController
public class StudentController {

    private DatabaseConf databaseConf = new DatabaseConf();
    ArrayList studentlist = new ArrayList(100);
    @RequestMapping("/student")
    public ArrayList student() throws SQLException {

        Statement stmt = null;
        Connection c = databaseConf.getConnection();


        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String birth_date = rs.getString("birth_date");

                studentlist.add("ID:"+ id+" Name: "+name+ " Birth date: "+birth_date);

                System.out.println("ID = " + id);
                System.out.println("City = " + name);
                System.out.println("NAME = " + birth_date);
            }

        } catch(Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return studentlist;
    }


}