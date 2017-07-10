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
public class SchoolController {

    private DatabaseConf databaseConf;


    @RequestMapping("/school")
    public ArrayList school() throws SQLException {

        Statement stmt = null;
        Connection c = databaseConf.getConnection();
        ArrayList schoollist = new ArrayList(100);

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SCHOOLS;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String name = rs.getString("name");

                schoollist.add("ID:"+ id+" City: "+city+ " School name: "+name);

                System.out.println("ID = " + id);
                System.out.println("City = " + city);
                System.out.println("NAME = " + name);
            }

        } catch(Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }

        return schoollist;
        }


}