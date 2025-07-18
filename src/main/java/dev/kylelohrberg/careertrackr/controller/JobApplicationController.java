package dev.kylelohrberg.careertrackr.controller;

import dev.kylelohrberg.careertrackr.entity.JobApplication;
import dev.kylelohrberg.careertrackr.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @Autowired
    public JobApplicationController(JobApplicationService jobApplicationService){
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping
    public JobApplication create(@RequestBody JobApplication jobApplication){
        return jobApplicationService.createApplication(jobApplication);
    }

    @GetMapping
    public List<JobApplication> getAll(){
        return jobApplicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Optional<JobApplication> getById(@PathVariable Long id){
        return jobApplicationService.getApplicationById(id);
    }

    @PutMapping("/{id}")
    public JobApplication update(@PathVariable Long id, @RequestBody JobApplication updatedApp){
        return jobApplicationService.updateApplication(id, updatedApp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        jobApplicationService.deleteApplication(id);
    }
}
