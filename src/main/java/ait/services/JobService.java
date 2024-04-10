package ait.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import ait.Application;
import ait.controller.HiringManagerController;
import ait.model.JobApplication;
import ait.model.Candidate;
import ait.model.HiringManager;
import ait.model.Job;
import ait.model.Vendor;
import ait.repository.ApplicationRespository;
import ait.repository.CandidateRepository;
import ait.repository.HiringManagerRepository;
import ait.repository.JobRepository;

@Service
public class JobService {
    
	@Autowired
    private final JobRepository jobRepository;
    
    @Autowired
    private final HiringManagerController hiringManagerController;

    public JobService(JobRepository jobRepository,HiringManagerController hiringManagerRepository) {
        this.jobRepository = jobRepository;
		this.hiringManagerController = hiringManagerRepository;
    }
    
    @Transactional
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
   
    @Transactional
    public Job saveJob(Job job) {
    	 HiringManager hiringManager = hiringManagerController.findOrCreateByName(job.getHiringManagerName());
    	    job.setHiringManager(hiringManager);
        return jobRepository.save(job);
    }

    @Transactional
    public List<Job> getJobBySkill(String mainSkill) {
 
    	List<Job> allJobs = getAllJobs();
    	List<Job> searchedBySkillJobs = new ArrayList<Job>();
    	for (Job job : allJobs) {
    		if(job.getSkills().contains(mainSkill))
    		{
    			searchedBySkillJobs.add(job);
    		}
    	}
        return searchedBySkillJobs;
    }
    @Transactional
    public List<Job> getJobByVendor(String vendorName) {
    	
    	List<Job> allJobs = getAllJobs();
    	List<Job> searchedBySkillJobs = new ArrayList<Job>();
    	for (Job job : allJobs) {
    		List<Vendor> allvendor = job.getVendor_details();
    		for(Vendor vendor: allvendor)
    		{
    			if(vendor.getName().equals(vendorName))
    			{
    				searchedBySkillJobs.add(job);
    			}
    			
    		}
    	}
        return searchedBySkillJobs;   
    }
    @Transactional
    public List<Job> getAllSubmissionBasedJobs(Boolean isOpen) {
        
    	List<Job> allJobs = getAllJobs();
    	List<Job> searchedBySkillJobs = new ArrayList<Job>();
    	for (Job job : allJobs) {
    		
    		if(job.getIsOpen() == isOpen)
    		{
    			searchedBySkillJobs.add(job);
    		}
    	}
    	return searchedBySkillJobs;
    }

	public List<Job> getAllJobsSearchByHiringManager(String hiringManagerName) {
		List<Job> allJobs = getAllJobs();
    	List<Job> searchedByHiringManager = new ArrayList<Job>();
    	for (Job job : allJobs) {
    		
    		if(job.getHiringManagerName() != null && job.getHiringManagerName().equals(hiringManagerName))
    		{
    			searchedByHiringManager.add(job);
    		}
    	}
    	return searchedByHiringManager;
    	
	}
	
	public List<Job> getAllroleBasedJobs(String role) {
		List<Job> allJobs = getAllJobs();
		List<Job> searchedByRole = new ArrayList<>();
		for(Job job:allJobs)
		{
			if(job.getRole().equals(role))
			{
				searchedByRole.add(job);
			}
		}
		return searchedByRole;
	}
	
	@Autowired
	private ApplicationRespository applicationRespository;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private HiringManagerRepository hiringManagerRepository;

	public JobApplication applyCandidate(@PathVariable Long jobId, @PathVariable Long candidateId,@PathVariable Long hiringManagerId) {
	    Job job = jobRepository.getById(jobId);
	    Candidate candidate = candidateRepository.getById(candidateId);
	    HiringManager hiringManager =  hiringManagerRepository.getById(hiringManagerId);

	    JobApplication application = new JobApplication();
	    application.setJob(job);
	    application.setCandidate(candidate);
	    application.setHiringManager(hiringManager);
	    application.setApplicationDate(new Date()); 

	    return applicationRespository.save(application);
	}
	
}
