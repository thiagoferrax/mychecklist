package com.company.mychecklist.services;

import static org.mockito.Mockito.only;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.company.mychecklist.repositories.ChecklistRepository;

@TestInstance(Lifecycle.PER_CLASS)
class ChecklistServiceTest {
	
	
	@InjectMocks
	private ChecklistService service;

	@Mock
	private ChecklistRepository repository;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		//Given and When
		service.findAll();
		
		//Then
		Mockito.verify(repository, only()).findAll();
	}

}
