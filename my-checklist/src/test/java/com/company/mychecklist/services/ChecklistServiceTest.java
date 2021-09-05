package com.company.mychecklist.services;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.only;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.company.mychecklist.builders.ChecklistBuilder;
import com.company.mychecklist.builders.ItemBuilder;
import com.company.mychecklist.models.Checklist;
import com.company.mychecklist.models.Item;
import com.company.mychecklist.repositories.ChecklistRepository;

@TestInstance(Lifecycle.PER_CLASS)
class ChecklistServiceTest {

	@InjectMocks
	private ChecklistService service;
	
	@Mock
	private ItemService itemService;
	
	@Mock
	private ChecklistRepository repository;

	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		// Given and When
		service.findAll();

		// Then
		Mockito.verify(repository, only()).findAll();
	}

	@Test
	void testCreateChecklistWithItemWithChildren() {
		// Given
		Item removingImpediments = ItemBuilder.getInstance().withTitle("Focused on removing impediments").now();
		Item scrumMaster = ItemBuilder.getInstance().withTitle("Scrum Master")
				.withChildren(List.of(removingImpediments)).now();
		Item roles = ItemBuilder.getInstance().withTitle("Roles").withChildren(List.of(scrumMaster)).now();
		Checklist checklist = ChecklistBuilder.getInstance().withTitle("Scrum Checklist").withItems(List.of(roles))
				.now();

		Checklist checklistCreated = ChecklistBuilder.getInstance().withId(1L).withTitle("Scrum Checklist")
				.withItems(List.of(roles)).now();
		
		// When
		Mockito.when(repository.save(checklist)).thenReturn(checklistCreated);
		Mockito.when(itemService.createAll(List.of(roles))).thenReturn(List.of(roles));
		Mockito.when(itemService.createAll(List.of(scrumMaster))).thenReturn(List.of(scrumMaster));
		Mockito.when(itemService.createAll(List.of(removingImpediments))).thenReturn(List.of(removingImpediments));

		// Then
		service.create(checklist);

		Mockito.verify(itemService, atLeast(1)).createAll(List.of(roles));
		Mockito.verify(itemService, atLeast(1)).createAll(List.of(scrumMaster));
		Mockito.verify(itemService, atLeast(1)).createAll(List.of(removingImpediments));
	}

}
