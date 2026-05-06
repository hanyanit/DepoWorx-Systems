package com.depoworx.depoworx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.depoworx.depoworx.Domain.WorkPerformed;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public interface WorkPerformedRepository extends JpaRepository<WorkPerformed,Id> {

}
