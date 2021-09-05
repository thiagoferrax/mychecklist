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
		
		createAllItems(createdChecklist, null, checklist.getItems());
		
		return createdChecklist;
	}

	private void createAllItems(Checklist checklist, Item parent, List<Item> items) {
		if (!CollectionUtils.isEmpty(items)) {
			items.parallelStream().forEach(item -> setChecklistAndParent(item, checklist, parent));
	
			itemService.createAll(items);
		
			//To create the children items
			items.parallelStream().forEach(item -> createAllItems(checklist, item, item.getChildren()));
		}
	}

	private void setChecklistAndParent(Item item, Checklist checklist, Item parent) {
		item.setChecklist(checklist);
		item.setParent(parent);
	}

	public Checklist findById(Long id) {
		Checklist checklist = repository.findById(id).orElse(null);

		if (checklist == null) {
			throw new ObjectNotFoundException(CHECKLIST_NOT_FOUND + id);
		}

		return checklist;
	}
}
