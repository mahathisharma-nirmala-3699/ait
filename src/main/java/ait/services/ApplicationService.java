package ait.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import ait.model.JobApplication;
import ait.Application;
import ait.model.Candidate;
import ait.model.HiringManager;
import ait.model.Job;
import ait.model.Vendor;
import ait.repository.ApplicationRespository;
import ait.repository.CandidateRepository;
import ait.repository.HiringManagerRepository;
import ait.repository.JobRepository;
import ait.repository.VendorRepository;

@Service
public class ApplicationService {

    private final JobRepository jobRepository;
    private final CandidateRepository candidateRepository;
    private final ApplicationRespository applicationRepository;
    private final VendorRepository vendorRepository;
    private final HiringManagerRepository hiringManagerRepository;
    
    @Autowired
    public ApplicationService(
            JobRepository jobRepository,
            CandidateRepository candidateRepository,
            ApplicationRespository applicationRepository,VendorRepository vendorRepository,HiringManagerRepository hiringManagerRepository) {
        this.jobRepository = jobRepository;
        this.candidateRepository = candidateRepository;
        this.applicationRepository = applicationRepository;
        this.vendorRepository = vendorRepository;
        this.hiringManagerRepository = hiringManagerRepository;
    }

    public JobApplication applyCandidateToJob(Long jobId, Long candidateId, Long vendorId,Long hiringManagerId) {
    	Job job = jobRepository.findById(jobId).orElseThrow(() -> new EntityNotFoundException("Job not found"));
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new EntityNotFoundException("Vendor not found"));
        HiringManager hiringManager = hiringManagerRepository.findById(hiringManagerId).orElseThrow(() -> new EntityNotFoundException("Hiring Manager not found"));

        JobApplication application = new JobApplication();
        application.setJob(job);
        application.setCandidate(candidate);
        application.setApplicationDate(new Date());
        application.setHiringManager(hiringManager);
        if(job.getVendor_details().size() > 1)
        {
            application.setVendor(vendor);
        }
        else if(vendorId == null && job.getVendor_details().size() ==1)
        {
        	application.setVendor(job.getVendor_details().get(0));
        }
        application.setStatus("Submitted");
        
        return applicationRepository.save(application);
    }
    
    public JobApplication updateApplicationStatus(Long applicationId, String newStatus) {
        Optional<JobApplication> optionalApplication = applicationRepository.findById(applicationId);

        if (optionalApplication.isPresent()) {
            JobApplication application = optionalApplication.get();
            application.setStatus(newStatus);
            return applicationRepository.save(application);
        } else {
            return null; 
        }
    }
    
	public List<JobApplication> getApplicationsbyCandidateId(Long candidateId) {
        return applicationRepository.findByCandidateId(candidateId);
	}
	
	public List<JobApplication> getApplicationsbyJobId(Long jobId)
	{
		return applicationRepository.findByJobId(jobId);
	}
	
	public int countByCandidateId( Long candidateId)
	{
		return applicationRepository.countBycandidate_id(candidateId);
	}
	
	public int countByJobId( Long jobId)
	{
		return applicationRepository.countByjob_id(jobId);
	}
    
   
}
