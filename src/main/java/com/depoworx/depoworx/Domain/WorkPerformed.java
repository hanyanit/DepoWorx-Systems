package com.depoworx.depoworx.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkPerformed {

    @Id
    @GeneratedValue
    private Long ID ;

    private String description;

    @ManyToOne
    @JoinColumn(name = "job_card_id")
    private JobCard jobCard;

    public JobCard getJobCard() {
        return jobCard;
    }

    public void setJobCard(JobCard jobCard) {
        this.jobCard = jobCard;
    }

}
