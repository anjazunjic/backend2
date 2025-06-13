package com.example.demo.repositories;

import com.example.demo.DBUtil;
import com.example.demo.models.Application;
import com.example.demo.models.Candidate;
import com.example.demo.models.CandidatePositions;
import com.example.demo.models.Position;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CandidateRepository {

    // GET CANDIDATE BY Username
    public Candidate getCandidateByUsername(String username) {
        Connection conn = null;
        Candidate result = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "SELECT * FROM kandidati WHERE username = ?";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new Exception("Not existing candidate!");
            }

            result = new Candidate(
                    rs.getInt("id"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("email"),
                    rs.getString("telefon"),
                    rs.getInt("radno_iskustvo_godine"),
                    rs.getString("obrazovanje"),
                    rs.getString("sertifikati"),
                    rs.getString("jezici"),
                    rs.getDate("datum_registracije"),
                    rs.getString("status_prijave"),
                    rs.getString("lozinka"),
                    rs.getString("username")
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


    //UPDATE CANDIDATE

    public int updateCandidate(int candidateID, Candidate candidate) {
        Connection conn = null;
        int result = -1;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            /*String commandText = "UPDATE project" +
                                 "set name = ?," +
                                 "description = ?,"+
                                 "start_date = ?," +
                                 "end_date = ?," +
                                 "WHERE id = ?";*/



            String commandText = "UPDATE `sistem_za_regrutaciju`.`kandidati`" +
                    "SET" +
                    "`ime` = ?," +
                    "`prezime` = ?," +
                    "`email` = ?," +
                    "`telefon` = ?," +
                    "`radno_iskustvo_godine` = ?," +
                    "`obrazovanje` = ?," +
                    "`sertifikati` = ?," +
                    "`jezici` = ?," +
                    "`datum_registracije` = ?," +
                    "`status_prijave` = ? " +
                    "WHERE `id` = ?;";



            ps = conn.prepareStatement(commandText);
            ps.setString(1,candidate.getIme());
            ps.setString(2, candidate.getPrezime());
            ps.setString(3,candidate.getEmail());
            ps.setString(4, candidate.getTelefon());
            ps.setInt(5, candidate.getRadno_iskustvo_godine());
            ps.setString(6,candidate.getObrazovanje());
            ps.setString(7,candidate.getSertifikati());
            ps.setString(8,candidate.getJezici());
            ps.setDate(9, candidate.getDatum_registracije());
            ps.setString(10, candidate.getStatus_prijave());
            ps.setInt(11,candidateID);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
                throw new Exception("Error while updating project!");

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



    //INSERT
    public int insertCandidate(Candidate candidate) {
        Connection conn = null;
        int result = -1;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "INSERT INTO kandidati (ime,prezime,email,telefon,radno_iskustvo_godine,obrazovanje,sertifikati,jezici,lozinka,username) " +
                                 "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(commandText);
            ps.setString(1,candidate.getIme());
            ps.setString(2,candidate.getPrezime());
            ps.setString(3,candidate.getEmail());
            ps.setString(4,candidate.getTelefon());
            ps.setInt(5,candidate.getRadno_iskustvo_godine());
            ps.setString(6,candidate.getObrazovanje());
            ps.setString(7,candidate.getSertifikati());
            ps.setString(8,candidate.getJezici());
            ps.setString(9,candidate.getLozinka());
            ps.setString(10,candidate.getUsername());


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
