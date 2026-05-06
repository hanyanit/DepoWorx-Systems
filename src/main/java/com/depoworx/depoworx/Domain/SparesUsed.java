package com.depoworx.depoworx.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class SparesUsed {

      @Id
    @GeneratedValue
    private Long id;

    private String signedBy;

    @OneToOne
    @JoinColumn(name = "job_card_id")
    private JobCard jobCard;

    

    public void setJobCard(JobCard jobCard){
        this.jobCard=jobCard;
    }

}
