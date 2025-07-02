package com.example.demo.repositories;

import com.example.demo.DBUtil;
import com.example.demo.models.*;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

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
            ps.setString(1, username);
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


    // INSERT
    public int scheduleAnInterview(Interview interview) {
        Connection conn = null;
        int result = -1;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "INSERT INTO `sistem_za_regrutaciju`.`zakazi_intervju`" +
                    "(`naziv_pozicije`," +
                    "`kandidat_username`," +
                    "`regruter_username`," +
                    "`datum_intervjua`) " +
                    "VALUES " +
                    "(?,?,?,?)";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, interview.getNaziv_pozicije());
            ps.setString(2, interview.getUsernameKandidata());
            ps.setString(3, interview.getUsernameRegrutera());
            ps.setTimestamp(4, interview.getDatum_intervjua());


            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
                throw new Exception("Error while inserting interview!");

            result = 1;
            ps.close();
            conn.close();
        } catch (Exception ex) {
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


    public List<Interview> getAllInterviewsByCandidateUsername(String candidate_username) {
        Connection conn = null;
        List<Interview> result = new ArrayList<>();
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();

            String commandText =
                    "SELECT z.* " +
                            "FROM zakazi_intervju z " +
                            "JOIN kandidati k ON z.kandidat_username = k.username " +
                            "WHERE k.username = ?";

            ps = conn.prepareStatement(commandText);
            ps.setString(1, candidate_username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Interview interview = new Interview(
                        rs.getInt("id"),
                        rs.getString("naziv_pozicije"),
                        rs.getString("kandidat_username"),
                        rs.getString("regruter_username"),
                        rs.getTimestamp("datum_intervjua"),
                        rs.getString("link")
                );
                result.add(interview);
            }

        } catch (Exception ex) {
            System.out.println("Error fetching interviews for candidate: " + ex);
            result = null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                System.out.println("Cleanup error: " + ex);
            }
        }

        return result;
    }

    public List<Interview> getAllInterviewsByRegruterUsername(String regruter_username) {
        Connection conn = null;
        List<Interview> result = new ArrayList<>();
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();

            String commandText =
                    "SELECT z.* " +
                            "FROM zakazi_intervju z " +
                            "JOIN regruteri r ON z.regruter_username = r.username " +
                            "WHERE r.username = ?";

            ps = conn.prepareStatement(commandText);
            ps.setString(1, regruter_username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Interview interview = new Interview(
                        rs.getInt("id"),
                        rs.getString("naziv_pozicije"),
                        rs.getString("kandidat_username"),
                        rs.getString("regruter_username"),
                        rs.getTimestamp("datum_intervjua"),
                        rs.getString("link")
                );
                result.add(interview);
            }

        } catch (Exception ex) {
            System.out.println("Error fetching interviews by username: " + ex);
            result = null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                System.out.println("Cleanup error: " + ex);
            }
        }

        return result;
    }


    // GET CANDIDATE BY regruter_username
    public List<CandidateInterview> getCandidateForInterviews(String regruter_username) {
        Connection conn = null;
        ArrayList<CandidateInterview> result = null;
        PreparedStatement ps = null;


        try {
            conn = DBUtil.open();
            result = new ArrayList<CandidateInterview>();

            String commandText = "SELECT " +
                    "    k.ime," +
                    "    k.prezime," +
                    "    k.username, " +
                    "    p.naziv_pozicije," +
                    "    pr.status_prijave," +
                    "    pr.datum_prijave " +
                    "FROM " +
                    "    regruteri r " +
                    "JOIN " +
                    "    pozicije p ON r.firma_id = p.firma_id " +
                    "JOIN " +
                    "    prijave pr ON p.id = pr.pozicija_id " +
                    "JOIN " +
                    "    kandidati k ON pr.kandidat_id = k.id " +
                    "WHERE " +
                    "    pr.status_prijave = 'Poziv za intervju' " +
                    "    AND r.username = ?";

            ps = conn.prepareStatement(commandText);
            ps.setString(1, regruter_username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CandidateInterview c = new CandidateInterview(
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("username"),
                        rs.getString("naziv_pozicije"),
                        rs.getString("status_prijave"),
                        rs.getDate("datum_prijave")
                );
                result.add(c);
            }

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

    public List<Interview> getInterviewsByDate(String regruter_username, Date datum) {
        Connection conn = null;
        List<Interview> result = new ArrayList<>();
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();

            String commandText =
                    "SELECT * FROM zakazi_intervju " +
                            "WHERE regruter_username = ? " +
                            "AND datum_intervjua >= ? AND datum_intervjua < ?";

            ps = conn.prepareStatement(commandText);

            // Početak i kraj dana
            Calendar cal = Calendar.getInstance();
            cal.setTime(datum);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Timestamp startOfDay = new Timestamp(cal.getTimeInMillis());

            cal.add(Calendar.DATE, 1); // sledeći dan u 00:00
            Timestamp endOfDay = new Timestamp(cal.getTimeInMillis());

            ps.setString(1, regruter_username);
            ps.setTimestamp(2, startOfDay);
            ps.setTimestamp(3, endOfDay);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Interview interview = new Interview(
                        rs.getInt("id"),
                        rs.getString("naziv_pozicije"),
                        rs.getString("kandidat_username"),
                        rs.getString("regruter_username"),
                        rs.getTimestamp("datum_intervjua"),
                        rs.getString("link")
                );
                result.add(interview);
            }

        } catch (Exception ex) {
            System.out.println("Error fetching interviews: " + ex);
            result = null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                System.out.println("Cleanup error: " + ex);
            }
        }

        return result;
    }



    // INSERT
    public int updateLink(int interviewID,String link) {
        Connection conn = null;
        int result = -1;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();
            String commandText = "UPDATE `sistem_za_regrutaciju`.`zakazi_intervju`\n" +
                    "SET " +
                    "`link` = ?" +
                    "WHERE " +
                    "`id` = ?";
            ps = conn.prepareStatement(commandText);
            ps.setString(1, link);
            ps.setInt(2, interviewID);


            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
                throw new Exception("Error while inserting interview!");

            result = 1;
            ps.close();
            conn.close();
        } catch (Exception ex) {
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

/*
    public String getLink(int interviewID) {
        Connection conn = null;
        String result = "";
        PreparedStatement ps = null;

        try {
            conn = DBUtil.open();

            String commandText =  "SELECT link " +
                                  "FROM zakazi_intervju z " +
                                  "WHERE id = ?";

            ps = conn.prepareStatement(commandText);
            ps.setString(1, interviewID);
            ResultSet rs = ps.executeQuery();



        } catch (Exception ex) {
            System.out.println("Error fetching interviews for candidate: " + ex);
            result = null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                System.out.println("Cleanup error: " + ex);
            }
        }

        return result;
    }*/




}
