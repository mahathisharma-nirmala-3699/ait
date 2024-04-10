package ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ait.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    
}
