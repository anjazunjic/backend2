package com.example.demo.repositories;

import com.example.demo.DBUtil;
import com.example.demo.models.Candidate;
import com.example.demo.models.Position;
import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LogInRepository {

      //GET log_in by ID

    public User getUserByUsername(String username) {
        Connection conn = null;
        User result = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "SELECT * FROM log_in_sign_up WHERE username = ?";
            ps = conn.prepareStatement(commandText);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new Exception("Not existing candidate!");
            }

            result = new User(
                    rs.getInt("id"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("lozinka"),
                    rs.getString("tip")
            );

            ps.close();
            conn.close();
        }
        catch (Exception ex) {
            result = null;
            System.out.println(ex);
        }
        finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }

        return result;
    }


    //INSERT

    public int insertUser(User user) {
        Connection conn = null;
        int result = -1;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "INSERT INTO `sistem_za_regrutaciju`.`log_in_sign_up` " +
                    "(`username`,`ime`,`prezime`,`email`,`lozinka`,`tip`) " +
                    "VALUES (?,?,?,?,?,?);";
            ps = conn.prepareStatement(commandText);

            ps.setString(1,user.getUsername());
            ps.setString(2, user.getIme());
            ps.setString(3, user.getPrezime());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getLozinka());
            ps.setString(6, user.getTip());


            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
                throw new Exception("Error while inserting project!");

            result = 1;
            ps.close();
            conn.close();
        }
        catch (Exception ex){
            result = -1;
            System.out.println(ex);
        }
        finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }

        return result;
    }

}
