package com.example.demo.repositories;

import com.example.demo.DBUtil;
import com.example.demo.models.Candidate;
import com.example.demo.models.CandidatePositions;
import com.example.demo.models.Position;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PositionRepository {
    // GET ALL
    public List<Position> getAllPositions(){
        Connection conn = null;
        ArrayList<Position> result = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            result = new ArrayList<Position>();

            String commandText = "SELECT * FROM pozicije";
            ps = conn.prepareStatement(commandText);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Position p = new Position(
                        rs.getInt("id"),
                        rs.getInt("firma_id"),
                        rs.getString("naziv_firme"),
                        rs.getString("naziv_pozicije"),
                        rs.getString("opis_posla"),
                        rs.getInt("zahtijevano_iskustvo"),
                        rs.getString("potrebne_kvalifikacije"),
                        rs.getString("lokacija"),
                        rs.getDate("datum_objave"),
                        rs.getDate("datum_isteka")
                );
                result.add(p);
            }

            ps.close();
            conn.close();
        }
        catch (Exception ex){
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

    // GET BY ID
    public Position getPositionByID(int positionID) {
        Connection conn = null;
        Position result = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "SELECT * FROM pozicije WHERE id = ?";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1, positionID);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new Exception("Not existing position!");
            }

            result = new Position(
                    rs.getInt("id"),
                    rs.getInt("firma_id"),
                    rs.getString("naziv_firme"),
                    rs.getString("naziv_pozicije"),
                    rs.getString("opis_posla"),
                    rs.getInt("zahtijevano_iskustvo"),
                    rs.getString("potrebne_kvalifikacije"),
                    rs.getString("lokacija"),
                    rs.getDate("datum_objave"),
                    rs.getDate("datum_isteka")
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

    // INSERT
    public int insertPosition(Position position) {
        Connection conn = null;
        int result = -1;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "INSERT INTO pozicije(firma_id,naziv_firme,naziv_pozicije, opis_posla, zahtijevano_iskustvo," +
                                 "                    potrebne_kvalifikacije,lokacija,datum_objave, datum_isteka)" +
                                "VALUES(?, ? , ? , ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(commandText);
            ps.setInt(1,position.getIdFirme());
            ps.setString(2,position.getNaziv_firme());
            ps.setString(3, position.getNaziv_pozicije());
            ps.setString(4, position.getOpis_posla());
            ps.setInt(5, position.getZahtijevano_iskustvo());
            ps.setString(6, position.getPotrebne_kvalifikacije());
            ps.setString(7,position.getLokacija());
            ps.setDate(8, position.getDatum_objave());
            ps.setDate(9, position.getDatum_isteka());


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


    //UPDATE
    public int updatePosition(int positionID, Position position) {
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



            String commandText = "UPDATE `sistem_za_regrutaciju`.`pozicije`" +
                                 "SET" +
                                 "`firma_id` = ?," +
                                 "`naziv_firme` = ?," +
                                 "`naziv_pozicije` = ?," +
                                 "`opis_posla` = ?," +
                                 "`zahtijevano_iskustvo` = ?," +
                                 "`potrebne_kvalifikacije` = ?," +
                                 "`lokacija` = ?," +
                                 "`datum_objave` = ?," +
                                 "`datum_isteka` = ?" +
                                 "WHERE `id` = ?;";



            ps = conn.prepareStatement(commandText);
            ps.setInt(1,position.getIdFirme());
            ps.setString(2,position.getNaziv_firme());
            ps.setString(3, position.getNaziv_pozicije());
            ps.setString(4, position.getOpis_posla());
            ps.setInt(5, position.getZahtijevano_iskustvo());
            ps.setString(6, position.getPotrebne_kvalifikacije());
            ps.setString(7,position.getLokacija());
            ps.setDate(8, position.getDatum_objave());
            ps.setDate(9, position.getDatum_isteka());
            ps.setInt(10,positionID);

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


    //DELETE
    public int deletePosition(int positionID) {
        Connection conn = null;
        int result = -1;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            //String commandText = "DELETE FROM project WHERE id = ?";
            String commandText = " DELETE FROM `sistem_za_regrutaciju`.`pozicije`" +
                                   "WHERE id = ?; ";

            ps = conn.prepareStatement(commandText);
            ps.setInt(1,positionID);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
                throw new Exception("Error while deleting project!");

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




    // GET BY ID
    public List<Candidate> getAllCandiatesByPositionID(int positionID) {
        Connection conn = null;
        ArrayList<Candidate> result = null;
        PreparedStatement ps = null;

        try{
        conn = DBUtil.open();
        result = new ArrayList<Candidate>();

        String commandText =  "SELECT " +
                "k.id AS id, " +  // Naziv kolone u ResultSet-u mora biti isti kao u rs.getInt("id")
                "k.ime, " +
                "k.prezime, " +
                "k.email, " +
                "k.telefon, " +
                "k.radno_iskustvo_godine, " +
                "k.obrazovanje, " +
                "k.sertifikati, " +
                "k.jezici, " +
                "k.datum_registracije, " +
                "k.status_prijave, " +  // dodaj razmak ovde
                "k.lozinka, " +  // dodaj razmak ovde
                "k.username " +  // dodaj razmak ovde
                "FROM kandidati k " +
                "JOIN prijave pr ON k.id = pr.kandidat_id " +
                "JOIN pozicije p ON pr.pozicija_id = p.id " +
                "WHERE p.id = ?";

        ps = conn.prepareStatement(commandText);
        ps.setInt(1,positionID);
        ResultSet rs = ps.executeQuery();



        while(rs.next()) {
            Candidate c = new Candidate(
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
            result.add(c);
        }

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


    public List<Position> getAllPositionsOfOneFirmByID(int firmaID) {
        Connection conn = null;
        ArrayList<Position> result = null;
        PreparedStatement ps = null;

        try{
            conn = DBUtil.open();
            result = new ArrayList<Position>();

            String commandText =   "SELECT " +
                    "p.id AS id, " +
                    "p.firma_id, " +
                    "f.naziv AS naziv_firme, " +
                    "p.naziv_pozicije, " +
                    "p.opis_posla, " +
                    "p.zahtijevano_iskustvo, " +
                    "p.potrebne_kvalifikacije, " +
                    "p.lokacija, " +
                    "p.datum_objave, " +
                    "p.datum_isteka " +  // <-- razmak na kraju!
                    "FROM pozicije p " +  // <-- razmak na kraju!
                    "JOIN firma f ON p.firma_id = f.id " +  // <-- razmak na kraju!
                    "WHERE p.firma_id = ?";  // <-- bez ;

            ps = conn.prepareStatement(commandText);
            ps.setInt(1,firmaID);
            ResultSet rs = ps.executeQuery();


            while(rs.next()) {
                Position p = new Position(
                        rs.getInt("id"),
                        rs.getInt("firma_id"),
                        rs.getString("naziv_firme"),
                        rs.getString("naziv_pozicije"),
                        rs.getString("opis_posla"),
                        rs.getInt("zahtijevano_iskustvo"),
                        rs.getString("potrebne_kvalifikacije"),
                        rs.getString("lokacija"),
                        rs.getDate("datum_objave"),
                        rs.getDate("datum_isteka")
                );
                result.add(p);
            }

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


    public List<CandidatePositions> getAllPositionsOfOneCandidateByUsername(String username) {
        Connection conn = null;
        ArrayList<CandidatePositions> result = null;
        PreparedStatement ps = null;

        try{
            conn = DBUtil.open();
            result = new ArrayList<CandidatePositions>();

            String commandText =  "SELECT " +
                                  "k.username," +
                                  "k.ime," +
                                  "k.prezime," +
                                  "p.naziv_pozicije," +
                                  "p.naziv_firme," +
                                  "p.lokacija," +
                                  "pr.status_prijave," +
                                  "pr.datum_prijave " +
                                  "FROM kandidati k " +
                                  "JOIN prijave pr ON k.id = pr.kandidat_id " +
                                  "JOIN pozicije p ON pr.pozicija_id = p.id " +
                                  "WHERE k.username = ? " +
                                  "ORDER BY pr.datum_prijave DESC;";

            ps = conn.prepareStatement(commandText);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();


            while(rs.next()) {
                CandidatePositions p = new CandidatePositions(
                        rs.getString("username"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("naziv_pozicije"),
                        rs.getString("naziv_firme"),
                        rs.getString("lokacija"),
                        rs.getString("status_prijave"),
                        rs.getDate("datum_prijave")
                );
                result.add(p);
            }

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



    public List<Position> getAllNewPositionsForCandidate(String username) {
        Connection conn = null;
        ArrayList<Position> result = null;
        PreparedStatement ps = null;

        try{
            conn = DBUtil.open();
            result = new ArrayList<Position>();

            String commandText =   "SELECT " +
                    "    p.* " +
                    "FROM pozicije p " +
                    "WHERE p.id NOT IN ( " +
                    "    SELECT pr.pozicija_id " +
                    "    FROM prijave pr " +
                    "    JOIN kandidati k ON pr.kandidat_id = k.id " +
                    "    WHERE k.username = ? " +
                    ");";

            ps = conn.prepareStatement(commandText);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();


            while(rs.next()) {
                Position p = new Position(
                        rs.getInt("id"),
                        rs.getInt("firma_id"),
                        rs.getString("naziv_firme"),
                        rs.getString("naziv_pozicije"),
                        rs.getString("opis_posla"),
                        rs.getInt("zahtijevano_iskustvo"),
                        rs.getString("potrebne_kvalifikacije"),
                        rs.getString("lokacija"),
                        rs.getDate("datum_objave"),
                        rs.getDate("datum_isteka")
                );
                result.add(p);
            }

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
