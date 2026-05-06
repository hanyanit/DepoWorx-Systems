package com.depoworx.depoworx.service;

import java.util.List;

import com.depoworx.depoworx.Domain.JobCard;
import com.depoworx.depoworx.Domain.SparesUsed;
import com.depoworx.depoworx.Domain.WorkItems;
import com.depoworx.depoworx.Domain.WorkPerformed;
import com.depoworx.depoworx.Domain.jobStatus;

public interface jobCardService {

    
    JobCard createJobCard(JobCard jobCard);
    JobCard getJobCardById(Long Id);
    List<JobCard> getAllJobCards();

    JobCard addWorkItem(Long jobCardId, WorkItems item);

    JobCard addSpareUsed(Long jobCardId, SparesUsed spare);

    JobCard addWorkPerformed(Long jobCardId, WorkPerformed workPerformed);

    JobCard updateStatus(Long jobCardId, jobStatus status);

    JobCard closeJobCard(Long jobCardId);

}
