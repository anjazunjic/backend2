package com.example.demo.repositories;

import com.example.demo.DBUtil;
import com.example.demo.models.Regruter;
import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class RegruterRepository {

    //GET Regruter by ID

    public Regruter getRegruterByUsername(String username) {
        Connection conn = null;
        Regruter result = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "SELECT * FROM regruteri WHERE username = ?";
            ps = conn.prepareStatement(commandText);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new Exception("Not existing position!");
            }

            result = new Regruter(
                    rs.getInt("id"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("email"),
                    rs.getString("telefon"),
                    rs.getString("lozinka"),
                    rs.getString("username"),
                    rs.getInt("firma_id")
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



}
