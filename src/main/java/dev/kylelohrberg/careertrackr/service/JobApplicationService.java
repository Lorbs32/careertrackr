package dev.kylelohrberg.careertrackr.service;

import dev.kylelohrberg.careertrackr.entity.JobApplication;
import dev.kylelohrberg.careertrackr.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    @Autowired
    public JobApplicationService(JobApplicationRepository repository){
        this.repository = repository;
    }

    public List<JobApplication> getAllApplications(){
        return repository.findAll();
    }

    public Optional<JobApplication> getApplicationById(Long id){
        return repository.findById(id);
    }

    public JobApplication createApplication(JobApplication jobApplication) {
        return repository.save(jobApplication);
    }

    public void deleteApplication(Long id){
        repository.deleteById(id);
    }

    public JobApplication updateApplication(Long id, JobApplication updatedApp) {
        return repository.findById(id)
                .map(existing -> {
            existing.setCompanyName(updatedApp.getCompanyName());
            existing.setPositionTitle(updatedApp.getPositionTitle());
            existing.setStatus(updatedApp.getStatus());
            existing.setAppliedDate(updatedApp.getAppliedDate());
            existing.setLocation(updatedApp.getLocation());
            existing.setNotes(updatedApp.getNotes());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Job application not found"));
    }
}
