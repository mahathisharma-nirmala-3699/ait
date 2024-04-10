package ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ait.model.Candidate;
import ait.model.JobApplication;
import ait.services.CandidateService;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @PostMapping
    public Candidate saveCandidate(@RequestBody Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }

    @GetMapping("/skills/{skill}")
    public List<Candidate> getCandidatesBySkills(@PathVariable String skill) {
        return candidateService.getCandidatesBySkills(skill);
    }

    @GetMapping("/experience/{experience}")
    public List<Candidate> getCandidatesByExperience(@PathVariable String experience) {
        return candidateService.getCandidatesByExperience(experience);
    }

    @GetMapping("/location-requirement")
    public List<Candidate> getCandidatesByLocationRequirement(@PathVariable String location) {
        return candidateService.getCandidatesByLocationRequirement(location);
    }

    @GetMapping("/onsite")
    public List<Candidate> getCandidatesCanGoOnsite(Boolean onsite) {
        return candidateService.getCandidatesCanGoOnsite(onsite);
    }

    @GetMapping("/visa-status/{visaStatus}")
    public List<Candidate> getCandidatesByVisaStatus(@PathVariable String visaStatus) {
        return candidateService.getCandidatesByVisaStatus(visaStatus);
    }

    @GetMapping("/visa-status-and-employer/{visaStatus}/{employer}")
    public List<Candidate> getCandidatesByVisaStatusAndEmployer(
            @PathVariable String visaStatus,
            @PathVariable String employer) {
        return candidateService.getCandidatesByVisaStatusAndEmployer(visaStatus, employer);
    }

    @GetMapping("/employer/{employer}")
    public List<Candidate> getCandidatesByEmployer(@PathVariable String employer) {
        return candidateService.getCandidatesByEmployer(employer);
    }

    @GetMapping("/on-bench")
    public List<Candidate> getOnBenchCandidates(Boolean onBench) {
        return candidateService.getOnBenchCandidates(onBench);
    }
    
    @GetMapping("/allapplications")
    public List<JobApplication> getAllApplications(Long candidateId){
		return null;
    	
    }   
}
