package com.example.demo.services;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProjectService {

    private PositionRepository _positionRepository;
    private LogInRepository _logInRepository;
    private RegruterRepository _regruterRepository;
    private ApplicationRepository _applicationRepository;
    private CandidateRepository _candidateRepository;

    public ProjectService(PositionRepository positionRepository, LogInRepository logInRepository, RegruterRepository regruterRepository, ApplicationRepository applicationRepository , CandidateRepository candidateRepository){

        this._positionRepository = positionRepository;
        this._logInRepository = logInRepository;
        this._regruterRepository = regruterRepository;
        this._applicationRepository = applicationRepository;
        this._candidateRepository = candidateRepository;
    }

    public List<Position> getAllPositions(){
        List<Position> result = this._positionRepository.getAllPositions();
        return result;
    }

    // GET BY ID
    public Position getPositionByID(int positionID) {
        Position result= this._positionRepository.getPositionByID(positionID);
        return result;
    }


    // INSERT
    public int insertPosition(Position position){
        int result = this._positionRepository.insertPosition(position);
        return result;
    }

    public int updatePosition(int positionID, Position position){
        int result = this._positionRepository.updatePosition(positionID,position);
        return result;
    }

    public int deletePosition(int positionID){
        int result = this._positionRepository.deletePosition(positionID);
        return result;
    }


    //Get all candidates that apllied to one position
    public List<Candidate> getAllCandiatesByPositionID(int positionID) {
        List<Candidate> result = this._positionRepository.getAllCandiatesByPositionID(positionID);
        return result;
    }


    public List<Position> getAllPositionsOfOneFirmByID(int firmaID){
        List<Position> result = this._positionRepository.getAllPositionsOfOneFirmByID(firmaID);
        return result;
    }


    public User getUserByUsername(String username) {
        User result = this._logInRepository.getUserByUsername(username);
        return result;
    }



    public Regruter getRegruterByUsername(String username) {
        Regruter result = this._regruterRepository.getRegruterByUsername(username);
        return result;
    }


    public List<CandidatePositions> getAllPositionsOfOneCandidateByUsername(String username){
        List<CandidatePositions> result = this._positionRepository.getAllPositionsOfOneCandidateByUsername(username);
        return result;
    }


    public List<Position> getAllNewPositionsForCandidate(String username){
        List<Position> result = this._positionRepository.getAllNewPositionsForCandidate(username);
        return result;
    }


    public Application getApplicationByID(int positionID,int candidateID){
        Application result = this._applicationRepository.getApplicationByID(positionID,candidateID);
        return result;
    }

    public int updateApplicationByID(int applicationID, Application application){
        int result = this._applicationRepository.updateApplicationByID(applicationID,application);
        return result;
    }

    // INSERT
    public int insertUser(User user){
        int result = this._logInRepository.insertUser(user);
        return result;
    }

    public int insertApplication(Application application){
        int result = this._applicationRepository.insertApplication(application);
        return result;
    }

    //GET CANDIDATE BY ID
    public Candidate getCandidateByUsername(String username) {
        Candidate result= this._candidateRepository.getCandidateByUsername(username);
        return result;
    }

    //UPDATE CANDIDATE
    public int updateCandidateByID(int candidateID,Candidate candidate){
        int result = this._candidateRepository.updateCandidate(candidateID,candidate);
        return result;
    }


    // INSERT
    public int insertCandidate(Candidate candidate){
        int result = this._candidateRepository.insertCandidate(candidate);
        return result;
    }



    // INSERT
    public int scheduleAnInterview(Interview interview){
        int result = this._regruterRepository.scheduleAnInterview(interview);
        return result;
    }
    //GET CANDIDATE BY ID
    public List<Interview> getAllInterviewsByCandidateUsername(String candidate_username)  {
        List<Interview> result= this._regruterRepository.getAllInterviewsByCandidateUsername(candidate_username);
        return result;
    }

    public List<Interview> getAllInterviewsByRegruterUsername(String regruter_username){
        List<Interview>  result= this._regruterRepository.getAllInterviewsByRegruterUsername(regruter_username);
        return result;
    }

     public List<CandidateInterview> getCandidateForInterviews(String regruter_username){
         List<CandidateInterview> result = this._regruterRepository.getCandidateForInterviews(regruter_username);
         return result;
     }

    public List<Interview> getInterviewsByDate(String regruter_username, Date datum){
        List<Interview>  result= this._regruterRepository.getInterviewsByDate(regruter_username,datum);
        return result;
    }

    public int updateLink(int interviewID,String link){
        int result = this._regruterRepository.updateLink(interviewID,link);
        return result;
    }
}
