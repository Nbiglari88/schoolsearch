package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
public class SchoolController {
//
//    @Autowired
//    private SchoolRepository repository;

    private DatabaseConf databaseConf;

    @RequestMapping("/school")
    public String school() throws Exception{

        Statement stmt = null;
        Connection c = databaseConf.getConnection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SCHOOLS;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String name = rs.getString("name");

                System.out.println("ID = " + id);
                System.out.println("City = " + city);
                System.out.println("NAME = " + name);
            }

        } catch(Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }

        return "Check your commandline";
        }


}