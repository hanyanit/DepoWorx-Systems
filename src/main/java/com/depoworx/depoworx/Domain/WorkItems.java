package com.depoworx.depoworx.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkItems {

    @Id 
    @GeneratedValue
    private long ID;
    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "job_card_id")
    private JobCard jobCard;

        public void setJobCard(JobCard jobCard){
            this.jobCard=jobCard;
        }


}
