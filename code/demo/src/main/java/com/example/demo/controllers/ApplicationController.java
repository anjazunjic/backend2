package com.example.demo.controllers;

import com.example.demo.models.Application;
import com.example.demo.models.Position;
import com.example.demo.models.User;
import com.example.demo.services.ProjectService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    private ProjectService _projectService;

    // Dependency injection
    public ApplicationController(ProjectService projectService){
        this._projectService = projectService;
    }

    @CrossOrigin
    @GetMapping(value = "/{positionID}/{candidateID}")
    public Application getApplicationByID(@PathVariable("positionID") int positionID , @PathVariable("candidateID") int candidateID){
        Application result = this._projectService.getApplicationByID(positionID,candidateID);
        return result;
    }

    @CrossOrigin
    @PutMapping(value = "/{applicationID}")
    public int updateApplicationByID(@PathVariable("applicationID") int applicationID, @RequestBody Application application){
        int result = this._projectService.updateApplicationByID(applicationID,application);
        return result;
    }

    // INSERT
    @CrossOrigin
    @PostMapping()
    public int insertApplication(@RequestBody Application application) {
        int result = this._projectService.insertApplication(application);
        return result;
    }

}
