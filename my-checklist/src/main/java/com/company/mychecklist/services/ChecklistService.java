package com.company.mychecklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.company.mychecklist.models.Checklist;
import com.company.mychecklist.models.Item;
import com.company.mychecklist.repositories.ChecklistRepository;
import com.company.mychecklist.services.exceptions.ObjectNotFoundException;

@Service
public class ChecklistService {
	public static final String CHECKLIST_NOT_FOUND = "Checklist not found for id ";

	@Autowired
	private ChecklistRepository repository;

	@Autowired
	private ItemService itemService;

	public List<Checklist> findAll() {
		return repository.findAll();
	}

	public Checklist create(Checklist checklist) {
		
		Checklist createdChecklist = repository.save(checklist);
		
		List<Item> items = checklist.getItems();
		if (!CollectionUtils.isEmpty(items)) {
			items.stream().forEach(item -> item.setChecklist(createdChecklist));
			checklist.setItems(itemService.createAll(items));
		}

		return createdChecklist;
	}

	public Checklist findById(Long id) {
		Checklist checklist = repository.findById(id).orElse(null);

		if (checklist == null) {
			throw new ObjectNotFoundException(CHECKLIST_NOT_FOUND + id);
		}

		return checklist;
	}
}
