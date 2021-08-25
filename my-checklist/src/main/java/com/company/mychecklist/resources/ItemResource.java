package com.company.mychecklist.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.mychecklist.entities.Item;
import com.company.mychecklist.services.ItemService;

@RestController
@RequestMapping(value="/items")
public class ItemResource {
	
	@Autowired
	private ItemService service;

	@GetMapping
	public ResponseEntity<List<Item>> findAll() {
		List<Item> items = service.findAll();
		return ResponseEntity.ok(items);
	}
}
