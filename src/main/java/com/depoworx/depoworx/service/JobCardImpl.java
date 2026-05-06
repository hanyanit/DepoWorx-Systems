package com.depoworx.depoworx.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.depoworx.depoworx.Domain.JobCard;
import com.depoworx.depoworx.Domain.SparesUsed;
import com.depoworx.depoworx.Domain.WorkItems;
import com.depoworx.depoworx.Domain.WorkPerformed;
import com.depoworx.depoworx.Domain.jobStatus;
import com.depoworx.depoworx.repository.JobCardRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobCardImpl implements jobCardService {

    private final JobCardRepository jobCardRepository;

    public JobCardImpl(JobCardRepository jobCardRepository) {
        this.jobCardRepository = jobCardRepository;
    }

    @Override
    public JobCard createJobCard(JobCard jobCard) {
        jobCard.setStatus(jobStatus.OPEN);
        jobCard.setDate(LocalDate.now());
        return jobCardRepository.save(jobCard);
    }

    @Override
    public JobCard getJobCardById(Long Id) {
        return jobCardRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("JobCard not found"));
    }

    @Override
    public List<JobCard> getAllJobCards() {
        return jobCardRepository.findAll();
    }

    @Override
    public JobCard addWorkItem(Long jobCardId, WorkItems item) {
        JobCard jobCard = getJobCardById(jobCardId);

        if (jobCard.getStatus() == jobStatus.CLOSED) {
            throw new RuntimeException("Cannot modify a closed job card");
        }

        item.setJobCard(jobCard);
        jobCard.getWorkToBeDone().add(item);

        return jobCardRepository.save(jobCard);
    }

    @Override
    public JobCard addSpareUsed(Long jobCardId, SparesUsed spare) {
        JobCard jobCard = getJobCardById(jobCardId);

        spare.setJobCard(jobCard);
        jobCard.getSparesUsed().add(spare);

        return jobCardRepository.save(jobCard);
    }

    @Override
    public JobCard addWorkPerformed(Long jobCardId, WorkPerformed workPerformed) {
        JobCard jobCard = getJobCardById(jobCardId);

        workPerformed.setJobCard(jobCard);
        jobCard.getWorkPerformed().add(workPerformed);

        return jobCardRepository.save(jobCard);
    }

    @Override
    public JobCard updateStatus(Long jobCardId, jobStatus status) {
        JobCard jobCard = getJobCardById(jobCardId);
        jobCard.setStatus(status);
        return jobCardRepository.save(jobCard);
    }

    @Override
    public JobCard closeJobCard(Long jobCardId) {
        JobCard jobCard = getJobCardById(jobCardId);

        if (jobCard.getStatus() == jobStatus.CLOSED) {
            throw new RuntimeException("Job card already closed");
        }

        jobCard.setStatus(jobStatus.CLOSED);
        jobCard.setClosedAt(LocalDateTime.now());

        return jobCardRepository.save(jobCard);
    }
}

   

    

    

  


