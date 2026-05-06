package com.depoworx.depoworx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.depoworx.depoworx.Domain.WorkItems;

public interface WorkItemsRepository extends JpaRepository<WorkItems, Long> {

    
}



