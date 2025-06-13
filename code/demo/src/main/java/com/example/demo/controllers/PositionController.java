package com.example.demo.controllers;

import com.example.demo.models.Candidate;
import com.example.demo.models.CandidatePositions;
import com.example.demo.models.Position;
import com.example.demo.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private ProjectService _projectService;

    // Dependency injection
    public PositionController(ProjectService projectService){
        this._projectService = projectService;
    }

    // GET ALL
    @CrossOrigin
    @GetMapping()
    public List<Position> getAllProjects() {
        List<Position> result = this._projectService.getAllPositions();
        return result;
    }


    // GET BY ID
    @CrossOrigin
    @GetMapping(value = "/{positionID}")
    public Position getPositionByID(@PathVariable("positionID") int positionID){
        Position result = this._projectService.getPositionByID(positionID);
        return result;
    }

    // INSERT
    @CrossOrigin
    @PostMapping()
    public int insertPosition(@RequestBody Position position) {
        int result = this._projectService.insertPosition(position);
        return result;
    }

    // UPDATE
    @CrossOrigin
    @PutMapping(value = "/{positionID}")
    public int updatePosition(@PathVariable("positionID") int positionID, @RequestBody Position position){
        int result = this._projectService.updatePosition(positionID,position);
        return result;
    }




    // DELETE
    @CrossOrigin
    @DeleteMapping(value = "/{positionID}")
    public int deleteProject(@PathVariable("positionID") int positionID){
        int result = this._projectService.deletePosition(positionID);
        return result;
    }

    @CrossOrigin
    @GetMapping("/all-candidates/{positionID}")
    public List<Candidate> getAllCandiatesByPositionID(@PathVariable("positionID") int positionID){
        List<Candidate> result = this._projectService.getAllCandiatesByPositionID(positionID);
        return result;
    }

    @CrossOrigin
    @GetMapping("/all-positions/{firmaID}")
    public List<Position> getAllPositionsOfOneFirmByID(@PathVariable("firmaID") int firmaID){
        List<Position> result = this._projectService.getAllPositionsOfOneFirmByID(firmaID);
        return result;
    }

    @CrossOrigin
    @GetMapping("/all-candidate-positions/{username}")
    public List<CandidatePositions> getAllPositionsOfOneCandidateByUsername(@PathVariable("username") String username){
        List<CandidatePositions> result = this._projectService.getAllPositionsOfOneCandidateByUsername(username);
        return result;
    }



    @CrossOrigin
    @GetMapping("/all-positions-to-apply-to/{username}")
    public List<Position> getAllNewPositionsForCandidate(@PathVariable("username") String username){
        List<Position> result = this._projectService.getAllNewPositionsForCandidate(username);
        return result;
    }

}
