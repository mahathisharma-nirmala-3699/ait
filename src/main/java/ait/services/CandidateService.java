package ait.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.model.JobApplication;
import ait.model.Candidate;
import ait.repository.ApplicationRespository;
import ait.repository.CandidateRepository;

@Service
public class CandidateService {
 @Autowired
 CandidateRepository candidateRepository;
 @Autowired
 Candidate candidate;
 
 ApplicationRespository applicationRespository;
 
	public Candidate saveCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	public List<Candidate> getAllCandidates() {
		return candidateRepository.findAll();
	}

	public List<Candidate> getCandidatesBySkills(String skill) {
		List<Candidate> allCandidates =  candidateRepository.findAll();
		List<Candidate> allCandidatesWithSkillsCandidates = new ArrayList<>();
		for(Candidate c: allCandidates)
		{
			if(c.getSkills().contains(skill))
			{
				allCandidatesWithSkillsCandidates.add(c);
			}
		}
		return allCandidatesWithSkillsCandidates;
	}

	public List<Candidate> getCandidatesByExperience(String experience) {
		List<Candidate> allCandidates =  candidateRepository.findAll();
		List<Candidate> allCandidatesWithexp = new ArrayList<>();
		for(Candidate c: allCandidates)
		{
			if(c.getCandidateExperience().equals(experience))
			{
				allCandidatesWithexp.add(c);
			}
		}
		return allCandidatesWithexp;

	}

	public List<Candidate> getCandidatesByLocationRequirement(String location) {
		List<Candidate> allCandidates =  candidateRepository.findAll();
		List<Candidate> allCandidatesWithLoc = new ArrayList<>();
		for(Candidate c: allCandidates)
		{
			if(c.getLocationRequirement().equals(location))
			{
				allCandidatesWithLoc.add(c);
			}
		}
		return allCandidatesWithLoc;		
	}

	public List<Candidate> getCandidatesCanGoOnsite(Boolean onsite) {
		List<Candidate> allCandidates =  candidateRepository.findAll();
		List<Candidate> allCandidatesWithOnSite = new ArrayList<>();
		for(Candidate c: allCandidates)
		{
			if(c.getCanGoOnsite()== onsite)
			{
				allCandidatesWithOnSite.add(c);
			}
		}
		return allCandidatesWithOnSite;	
	}

	public List<Candidate> getCandidatesByVisaStatus(String visaStatus) {
		List<Candidate> allCandidates =  candidateRepository.findAll();
		List<Candidate> allCandidatesWithVisaStatus = new ArrayList<>();
		for(Candidate c: allCandidates)
		{
			if(c.getVisaStatus().equals(visaStatus))
			{
				allCandidatesWithVisaStatus.add(c);
			}
		}
		return allCandidatesWithVisaStatus;	
	}

	public List<Candidate> getCandidatesByVisaStatusAndEmployer(String visaStatus, String employer) {
		List<Candidate> allCandidates =  candidateRepository.findAll();
		List<Candidate> allCandidatesWithVisaStatusandEmp = new ArrayList<>();
		for(Candidate c: allCandidates)
		{
			if(c.getVisaStatus().equals(visaStatus) && c.getEmployer().equals(employer) )
			{
				allCandidatesWithVisaStatusandEmp.add(c);
			}
		}
		return allCandidatesWithVisaStatusandEmp;	
	}

	public List<Candidate> getCandidatesByEmployer(String employer) {
		List<Candidate> allCandidates =  candidateRepository.findAll();
		List<Candidate> allCandidatesWithEmp = new ArrayList<>();
		for(Candidate c: allCandidates)
		{
			if(c.getEmployer().equals(employer) )
			{
				allCandidatesWithEmp.add(c);
			}
		}
		return allCandidatesWithEmp;	
	}

	public List<Candidate> getOnBenchCandidates(Boolean onBench) {
		List<Candidate> allCandidates =  candidateRepository.findAll();
		List<Candidate> allCandidatesWithOnBench = new ArrayList<>();
		for(Candidate c: allCandidates)
		{
			if(c.getOnBench()==onBench )
			{
				allCandidatesWithOnBench.add(c);
			}
		}
		return allCandidatesWithOnBench;	
	}
	
	public List<JobApplication> getAllApplications(Long candidateId) {
		List<JobApplication> applicationList = applicationRespository.findAll();
		for(JobApplication application : applicationList)
		{
			if(application.getCandidate().getId().equals(candidateId)) {
				applicationList.add(application);
			}
		}
		return applicationList;
		
	}
	


}
