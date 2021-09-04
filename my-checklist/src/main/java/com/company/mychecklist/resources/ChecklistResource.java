package com.company.mychecklist.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.mychecklist.models.Checklist;
import com.company.mychecklist.services.ChecklistService;

@RestController
@RequestMapping(value = "/checklists")
public class ChecklistResource {

	@Autowired
	private ChecklistService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Checklist> find(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<Checklist>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@PostMapping
	public ResponseEntity<Checklist> create(@RequestBody Checklist checklist) {
		Checklist myChecklist = service.create(checklist);

		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(myChecklist.getId()).toUri()).build();

	}
}
