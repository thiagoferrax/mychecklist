package com.company.mychecklist.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.mychecklist.entities.Checklist;
import com.company.mychecklist.services.ChecklistService;

@RestController
@RequestMapping(value = "/checklists")
public class ChecklistResource {

	@Autowired
	private ChecklistService service;

	@GetMapping
	public ResponseEntity<List<Checklist>> findAll() {
		List<Checklist> checklists = service.findAll();
		return ResponseEntity.ok(checklists);
	}

	@PostMapping
	public ResponseEntity<Checklist> create(@RequestBody Checklist checklist) {

		Checklist myChecklist = service.create(checklist);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(myChecklist.getId())
				.toUri();

		return ResponseEntity.created(uri).build();

	}
}
