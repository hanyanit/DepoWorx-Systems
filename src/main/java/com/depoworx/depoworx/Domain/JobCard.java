package com.depoworx.depoworx.Domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
//@NoArgsConstructor
@Entity
public class JobCard {

    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String jobCardNo;

    @Enumerated(EnumType.STRING)
    private jobStatus status;
    private LocalDate date;
    private String vehicleMake;
    private String regNumber;
    private double km;
    private String trailerDetails;
    private String driverName;

    @OneToMany(mappedBy = "jobCard", cascade = CascadeType.ALL)
    private List<WorkItems>  workToBeDone= new ArrayList<>();

    

    @OneToMany(mappedBy = "jobCard", cascade = CascadeType.ALL)
    private List<WorkPerformed> workPerformed= new ArrayList<>();

    @OneToMany(mappedBy = "jobCard", cascade = CascadeType.ALL)
    private List<SparesUsed> sparesUsed= new ArrayList<>();

    @OneToOne(mappedBy = "jobCard", cascade = CascadeType.ALL)
    private Signature signature;
    
    
    private LocalDateTime closedAt;


    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public JobCard(){};

    public void setStatus(jobStatus status){
        this.status=status;
    }

    public jobStatus getStatus(){
        return status;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }

    public List<SparesUsed> getSparesUsed(){
        return  sparesUsed;
    }

    public void setWorkPerformed(List<WorkPerformed> workPerformed){
        this.workPerformed=workPerformed;
    }

    public List<WorkPerformed> getWorkPerformed(){
        return workPerformed;
    }

    public List<WorkItems> getWorkToBeDone() {
        return workToBeDone;
    }

    public void setWorkToBeDone(List<WorkItems> workToBeDone) {
        this.workToBeDone = workToBeDone;
    }

    






}
