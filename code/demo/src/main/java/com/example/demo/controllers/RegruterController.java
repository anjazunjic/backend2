package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/regruteri")
public class RegruterController {

    private ProjectService _projectService;

    // Dependency injection
    public RegruterController(ProjectService projectService){
        this._projectService = projectService;
    }

    @CrossOrigin
    @GetMapping(value = "/{username}")
    public Regruter getRegruterByUsername(@PathVariable("username") String username){
        Regruter result = this._projectService.getRegruterByUsername(username);
        return result;
    }


    // INSERT
    @CrossOrigin
    @PostMapping("/schedule-an-inteview")
    public int scheduleAnInterview(@RequestBody Interview interview) {
        int result = this._projectService.scheduleAnInterview(interview);
        return result;
    }

    // GET BY ID
    @CrossOrigin
    @GetMapping(value = "/get-interviews-by-candidate_username/{candidate_username}")
    public List<Interview> getAllInterviewsByCandidateUsername(@PathVariable("candidate_username") String candidate_username){
        List<Interview> result = this._projectService.getAllInterviewsByCandidateUsername(candidate_username);
        return result;
    }

    // GET BY regruter_username
    @CrossOrigin
    @GetMapping(value = "/get-interviews-by-regruter_username/{regruter_username}")
    public List<Interview> getAllInterviewsByRegruterUsername(@PathVariable("regruter_username") String regruter_username){
        List<Interview> result = this._projectService.getAllInterviewsByRegruterUsername(regruter_username);
        return result;
    }


    @CrossOrigin
    @GetMapping(value = "/get-candidates-for-interviews/{regruter_username}")
    public List<CandidateInterview> getCandidateForInterviews(@PathVariable("regruter_username") String regruter_username) {
        List<CandidateInterview> result = this._projectService.getCandidateForInterviews(regruter_username);
        return result;
    }


    @CrossOrigin
    @GetMapping(value = "/get-interviews-by-date/{regruter_username}/{datum}")
    public List<Interview> getInterviewsByDate(@PathVariable("regruter_username") String regruter_username,
                                               @PathVariable("datum") String datum) {
        try {
            // Parsiranje String datuma u java.util.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(datum);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            return this._projectService.getInterviewsByDate(regruter_username, sqlDate);

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    @CrossOrigin
    @PutMapping(value = "/update-link/{interviewID}")
    public int updatePosition(@PathVariable("interviewID") int interviewID, @RequestBody String link){
        int result = this._projectService.updateLink(interviewID,link);
        return result;
    }

}
