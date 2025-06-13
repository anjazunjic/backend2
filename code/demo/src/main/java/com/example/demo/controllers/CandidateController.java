package com.example.demo.controllers;

import com.example.demo.models.Application;
import com.example.demo.models.Candidate;
import com.example.demo.services.ProjectService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private ProjectService _projectService;

    // Dependency injection
    public CandidateController(ProjectService projectService){
        this._projectService = projectService;
    }

    @CrossOrigin
    @GetMapping(value = "/{username}")
    public Candidate getCandidateByUsername(@PathVariable("username") String username){
        Candidate result = this._projectService.getCandidateByUsername(username);
        return result;
    }

    //UPDATE
    @CrossOrigin
    @PutMapping(value = "/{candidateID}")
    public int updateCandidateByID(@PathVariable("candidateID") int candidateID, @RequestBody Candidate candidate){
        int result = this._projectService.updateCandidateByID(candidateID,candidate);
        return result;
    }

    //INSERT
    @CrossOrigin
    @PostMapping()
    public int insertCandidate(@RequestBody Candidate candidate) {
        int result = this._projectService.insertCandidate(candidate);
        return result;
    }



}
