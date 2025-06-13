package com.example.demo.controllers;

import com.example.demo.models.Regruter;
import com.example.demo.models.User;
import com.example.demo.services.ProjectService;
import org.springframework.web.bind.annotation.*;

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

}
