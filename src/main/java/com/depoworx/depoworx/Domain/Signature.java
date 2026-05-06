package com.depoworx.depoworx.Domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class Signature {


    @Id
    @GeneratedValue
    private Long id;

    private String signedBy;
    private LocalDateTime signedAt;

    @Lob
    private String signatureData; // base64 or SVG

    @OneToOne
    @JoinColumn(name = "job_card_id")
    private JobCard jobCard;

}
