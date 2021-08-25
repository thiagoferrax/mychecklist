package com.company.mychecklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.mychecklist.entities.Item;
import com.company.mychecklist.repositories.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository repository;
	
	public List<Item> findAll() {
		return repository.findAll();
	}
}
