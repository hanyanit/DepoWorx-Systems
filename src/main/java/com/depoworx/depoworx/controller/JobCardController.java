package com.depoworx.depoworx.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.depoworx.depoworx.Domain.JobCard;
import com.depoworx.depoworx.service.JobCardImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JobCardController {

    private final JobCardImpl jobCardImpl;

    public JobCardController(JobCardImpl jobCardImpl){
        this.jobCardImpl=jobCardImpl;
    }

     @PostMapping("/createJobCard")
    public JobCard createJobCard(@RequestBody JobCard jobCard){
        return jobCardImpl.createJobCard(jobCard);
    }


}
