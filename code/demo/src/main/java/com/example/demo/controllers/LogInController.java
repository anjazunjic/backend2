package com.example.demo.controllers;

import com.example.demo.models.Position;
import com.example.demo.models.User;
import com.example.demo.services.ProjectService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LogInController {

    private ProjectService _projectService;

    // Dependency injection
    public LogInController(ProjectService projectService){
        this._projectService = projectService;
    }

    @CrossOrigin
    @GetMapping(value = "/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        User result = this._projectService.getUserByUsername(username);
        return result;
    }

    @CrossOrigin
    @PostMapping()
    public int insertUser(@RequestBody User user) {
        int result = this._projectService.insertUser(user);
        return result;
    }


}
