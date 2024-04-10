package ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ait.model.JobApplication;
import ait.Application;
import ait.model.Job;
import ait.services.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
	private final JobService jobService;

	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping
	public List<Job> getAllJobs() {
		return jobService.getAllJobs();
	}

	@PostMapping
	public Job saveJob(@RequestBody Job job) {
		return jobService.saveJob(job);
	}

	@GetMapping("/skill/{mainSkill}")
	public List<Job> getJobBySkill(@PathVariable String mainSkill) {
		return jobService.getJobBySkill(mainSkill);
	}

	@GetMapping("/vendor/{vendorName}")
	public List<Job> getJobByVendor(@PathVariable String vendorName) {
		return jobService.getJobByVendor(vendorName);
	}

	@GetMapping("/submission/{submission}")
	public List<Job> getAllSubmissionBasedJobs(@PathVariable Boolean submission) {
		return jobService.getAllSubmissionBasedJobs(submission);
	}
	
	@GetMapping("/hiringManager/{hiringManagerName}")
	public List<Job> getAllJobsSearchByHiringManager(@PathVariable String hiringManagerName)
	{
		return jobService.getAllJobsSearchByHiringManager(hiringManagerName);
	}
	
	@PostMapping("/apply/{jobId}/{candidateId}")
	public JobApplication applyCandidate(@PathVariable Long jobId, @PathVariable Long candidateId, @PathVariable Long hiringManagerId) {
	return jobService.applyCandidate(jobId, candidateId,hiringManagerId);
	}
	
	@GetMapping("/role/{roleName}")
	public List<Job> getAllroleBasedJobs(@PathVariable String role)
	{
		return jobService.getAllroleBasedJobs(role);
	}
	
	
}
