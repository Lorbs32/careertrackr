package dev.kylelohrberg.careertrackr.repository;

import dev.kylelohrberg.careertrackr.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}
