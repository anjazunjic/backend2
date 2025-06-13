package com.example.demo.repositories;

import com.example.demo.DBUtil;
import com.example.demo.models.Application;
import com.example.demo.models.Position;
import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class ApplicationRepository {

    //GET Application by candidateID and positionID
    public Application getApplicationByID(int positionID,int candidateID) {
        Connection conn = null;
        Application result = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "SELECT * FROM prijave WHERE pozicija_id = ? AND kandidat_id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, positionID);
            ps.setInt(2, candidateID);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new Exception("Not existing position!");
            }

            result = new Application(
                    rs.getInt("id"),
                    rs.getInt("kandidat_id"),
                    rs.getInt("pozicija_id"),
                    rs.getString("status_prijave"),
                    rs.getDate("datum_prijave")
            );

            ps.close();
            conn.close();
        } catch (Exception ex) {
            result = null;
            System.out.println(ex);
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        return result;
    }


    //Update Application by applicationID
    public int updateApplicationByID(int applicationID, Application application) {
        Connection conn = null;
        int result = -1;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            conn.setAutoCommit(false);

            System.out.println("Updating application with ID: " + applicationID);
            System.out.println("New status_prijave: " + application.getStatus_prijave());
            System.out.println("New datum_prijave: " + application.getDatum_prijave());
            System.out.println("Candidate ID: " + application.getIdKandidata());
            System.out.println("Position ID: " + application.getIdPozicije());

            String commandText = "UPDATE `sistem_za_regrutaciju`.`prijave` " +
                    "SET " +
                   "`status_prijave` =  ?," +
                    "`datum_prijave` = ?," +
                    "`kandidat_id` = ?," +
                    "`pozicija_id` = ? " +
                    "WHERE `id` = ?;";

           /* String commandText = "BEGIN TRANSACTION; " +
                    "UPDATE `sistem_za_regrutaciju`.`prijave` " +
                    "SET  `sistem_za_regrutaciju`.`prijave`.`status_prijave` =  ?, " +
                    "FROM `sistem_za_regrutaciju`.`prijave` as p, `sistem_za_regrutaciju`.`kandidati` as k" +
                    "WHERE p.kandidat_id = k.id " +
                    "AND p.kandidat_id = ?;\n" +
                    "UPDATE `sistem_za_regrutaciju`.`kandidati` " +
                    "SET TABLE_2.TABLE_2_COLUMN = VALUE_2\n" +
                    "FROM TABLE_1 T1, TABLE_2 T2\n" +
                    "WHERE T1.ID = T2.ID\n" +
                    "AND T2.ID = ID_VALUE_2;\n" +
                    "COMMIT; "*/

            ps = conn.prepareStatement(commandText);
            ps.setString(1, application.getStatus_prijave());
            ps.setDate(2, application.getDatum_prijave());
            ps.setInt(3, application.getIdKandidata());
            ps.setInt(4, application.getIdPozicije());
            ps.setInt(5, applicationID);

            int affectedRows = ps.executeUpdate();
            System.out.println("Rows affected by update: " + affectedRows);

            if (affectedRows == 0) {
                conn.rollback();
                throw new Exception("Error while updating project!");
            }

            conn.commit(); // ← obavezno pre zatvaranja konekcije

            result = 1;

        } catch (Exception ex) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception rollbackEx) {
                System.out.println("Rollback failed: " + rollbackEx);
            }
            result = -1;
            System.out.println(ex);
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        return result;
    }


    //INSERT
    public int insertApplication(Application application) {
        Connection conn = null;
        int result = -1;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "INSERT INTO prijave (kandidat_id,pozicija_id) " +
                    "VALUES(?, ?)";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1,application.getIdKandidata());
            ps.setInt(2,application.getIdPozicije());


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