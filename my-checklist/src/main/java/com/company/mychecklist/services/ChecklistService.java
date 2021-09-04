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
	@Autowired
	private ChecklistRepository repository;

	@Autowired
	private ItemService itemService;

	public List<Checklist> findAll() {
		return repository.findAll();
	}

	public Checklist create(Checklist checklist) {
		List<Item> items = checklist.getItems();
		if (!CollectionUtils.isEmpty(items)) {
			checklist.setItems(itemService.createAll(items));
		}

		return repository.save(checklist);
	}

	public Checklist findById(Long id) {
		Checklist checklist = repository.findById(id).orElse(null);

		if (checklist == null) {
			throw new ObjectNotFoundException("Checklist nao encontrado para o id " + id);
		}

		return checklist;
	}
}
