package ait.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ait.model.JobApplication;
import ait.model.ResumeFile;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeFile, Long> {

	
	@Query("SELECT rf FROM ResumeFile rf WHERE rf.candidate.id = :candidateId")
    List<ResumeFile> findByCandidateId(Long candidateId);
	
	@Query("SELECT rf FROM ResumeFile rf WHERE rf.candidate.id = :candidateId AND rf.id = :resumeId")
	ResumeFile findByCandidateIdAndResumeID(Long candidateId, Long resumeId);

}
