package com.depoworx.depoworx.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.depoworx.depoworx.Domain.JobCard;
import com.depoworx.depoworx.Domain.jobStatus;

public interface JobCardRepository extends JpaRepository<JobCard, Long> {

    Optional<JobCard> findByJobCardNo(String jobCardNumber);

    List<JobCard> findByStatus(jobStatus status);
}
