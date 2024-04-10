package ait.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ait.model.ApplyRequest;
import ait.model.JobApplication;
import ait.services.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    org.slf4j.Logger logger = LoggerFactory.getLogger(ApplicationController.class);	

    
    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/apply")
    public ResponseEntity<JobApplication> applyCandidateToJob(@RequestBody ApplyRequest applyRequest) {
    	try {
    		JobApplication application = applicationService.applyCandidateToJob(
                    applyRequest.getJobId(),
                    applyRequest.getCandidateId(),
                    applyRequest.getVendorId(),
                    applyRequest.getHiringManagerId());

            return new ResponseEntity<>(application, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateStatus/{applicationId}")
    public ResponseEntity<JobApplication> updateApplicationStatus(
            @PathVariable Long applicationId,
            @RequestParam String newStatus) {

        try {
            JobApplication updatedApplication = applicationService.updateApplicationStatus(applicationId, newStatus);

            if (updatedApplication != null) {
                return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/getapplicationsforCandidate/{candidateId}")
	public List<JobApplication> getApplicationsbyCandidateId(@PathVariable Long candidateId)
	{
		return applicationService.getApplicationsbyCandidateId(candidateId);
	}
    
    @GetMapping("/getapplicationsforJob/{jobId}")
   	public List<JobApplication> getApplicationsbyJobId(@PathVariable Long candidateId)
   	{
   		return applicationService.getApplicationsbyJobId(candidateId);
   	}
    @GetMapping("/getapplicationCountforCandidate/{candidateId}")
    public int countByCandidateId(@PathVariable Long candidateId)
	{
		return applicationService.countByCandidateId(candidateId);
	}
    @GetMapping("/getapplicationCountforJob/{jobId}")
	public int countByJobId(@PathVariable Long jobId)
	{
		return applicationService.countByJobId(jobId);
	}
}
