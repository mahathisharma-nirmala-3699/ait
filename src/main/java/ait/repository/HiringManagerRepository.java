package ait.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ait.model.HiringManager;

@Repository
public interface HiringManagerRepository extends JpaRepository<HiringManager, Long> {
	Optional<HiringManager> findByName(String name);

}
