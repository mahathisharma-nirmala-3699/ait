package ait.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ait.model.JobApplication;

@Repository
public interface ApplicationRespository extends JpaRepository<JobApplication, Long> {

    //@Query("SELECT ja FROM JobApplication ja WHERE ja.candidate.id = :candidateId")
    List<JobApplication> findByCandidateId(Long candidateId);
    @Query("SELECT ja FROM JobApplication ja WHERE ja.job.id = :jobId")
    List<JobApplication> findByJobId(Long jobId);
   
    @Query("SELECT COUNT(ja) FROM JobApplication ja WHERE ja.candidate.id = :candidateId")
    int countBycandidate_id(Long candidateId);
    @Query("SELECT COUNT(ja) FROM JobApplication ja WHERE ja.job.id = :jobId")
    int countByjob_id(Long jobId);

    

}
