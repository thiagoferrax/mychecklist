package com.company.mychecklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.mychecklist.entities.Checklist;
import com.company.mychecklist.repositories.ChecklistRepository;

@Service
public class ChecklistService {
	@Autowired
	private ChecklistRepository repository;
	
	public List<Checklist> findAll() {
		return repository.findAll();
	}
}
