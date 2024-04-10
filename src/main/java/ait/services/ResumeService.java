package ait.services;

import java.io.IOException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ait.FileStorageException;
import ait.model.Candidate;
import ait.model.ResponseMessage;
import ait.model.ResumeFile;
import ait.repository.CandidateRepository;
import ait.repository.ResumeRepository;
import org.springframework.util.StringUtils;


@Service
public class ResumeService {
	
	 @Autowired
	 private ResumeRepository resumeRepository;
	 
	 @Autowired
	 private CandidateRepository candidateRepository;
	
	 
//	 public ResumeFile storeFile(MultipartFile file, Long candidateId) {
//	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//	        try {
//	            Optional<Candidate> optionalCandidate = candidateRepository.findById(candidateId);
//
//	            if (optionalCandidate.isPresent()) {
//	                Candidate candidate = optionalCandidate.get();
//	                ResumeFile dbFile = new ResumeFile(fileName, file.getContentType(), file.getBytes(), candidate);
//
//	                return resumeRepository.save(dbFile);
//	            } else {
//	                throw new CandidateNotFoundException("Candidate with ID " + candidateId + " not found.");
//	            }
//	        } catch (IOException ex) {
//	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//	        }
//	    }
//	 
//	 public List<ResumeFile> getFile(Long candidateId) {
//	        return resumeRepository.findByCandidateId(candidateId);
//	    }
//	 public ResumeFile store(MultipartFile file,Long candidateId) throws IOException {
//		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		    Optional<Candidate> optionalCandidate =  candidateRepository.findById(candidateId);
//
//            if (optionalCandidate.isPresent()) {
//            Candidate candidate = optionalCandidate.get();
//            ResumeFile dbFile = new ResumeFile(fileName, file.getContentType(), file.getBytes(), candidate);
//
//            return resumeRepository.save(dbFile);
//		  }
//	 }
	 
	 public ResponseMessage store(MultipartFile file, Long candidateId) throws IOException {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		    if (candidateId != null) {
		        Optional<Candidate> optionalCandidate = candidateRepository.findById(candidateId);

		        if (optionalCandidate.isPresent()) {
		            Candidate candidate = optionalCandidate.get();
		            ResumeFile dbFile = new ResumeFile(fileName, file.getContentType(), file.getBytes(), candidate);
		            resumeRepository.save(dbFile);

		            return new ResponseMessage("Resume has been added to Candidate ID: " + candidateId);
		        } else {
		            return new ResponseMessage("Candidate with ID " + candidateId + " not found.");
		        }
		    } else {
		        // For cases where no candidate ID is provided
		        ResumeFile dbFile = new ResumeFile(fileName, file.getContentType(), file.getBytes());
		        resumeRepository.save(dbFile);

		        return new ResponseMessage("Resume has just been added.");
		    }
		}

	    @Transactional
		  public List<ResumeFile> getFiles(Long id) {
		    return resumeRepository.findByCandidateId(id);
		  }

	 @Transactional
	 public ResumeFile getFileById(Long candidateId, Long resumeId)
	 {
		 return resumeRepository.findByCandidateIdAndResumeID(candidateId, resumeId);
	 }

}
