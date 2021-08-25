package com.company.mychecklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.mychecklist.entities.Checklist;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long>{
	
}
