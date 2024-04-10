package ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ait.model.Candidate;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
