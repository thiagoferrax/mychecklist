package com.company.mychecklist.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.company.mychecklist.builders.ChecklistBuilder;
import com.company.mychecklist.models.Checklist;
import com.company.mychecklist.services.ChecklistService;
import com.company.mychecklist.services.exceptions.ObjectNotFoundException;

@RunWith(SpringRunner.class)
@WebMvcTest
class ChecklistResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemResource itemResource;

	@MockBean
	private ChecklistService service;

	@Test
	void testFindAll() throws Exception {
		// Given
		Mockito.when(service.findAll())
				.thenReturn(List.of(ChecklistBuilder.getInstance().withId(1L).withName("Scrum Checklist").now()));

		// When and Then
		this.mockMvc.perform(get("/checklists")).andExpect(status().isOk())
				.andExpect(content().json("[{\"id\": 1, \"name\": \"Scrum Checklist\"}]"));
	}
	
	@Test
	void testFindById() throws Exception {
		// Given
		Mockito.when(service.findById(1L))
				.thenReturn(ChecklistBuilder.getInstance().withId(1L).withName("Scrum Checklist").now());

		// When and Then
		this.mockMvc.perform(get("/checklists/1")).andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1, \"name\": \"Scrum Checklist\"}"));
	}
	
	@Test
	void testFindByIdWithNoFoundChecklist() throws Exception {
		// Given
		Mockito.when(service.findById(0L))
				.thenThrow(new ObjectNotFoundException(ChecklistService.CHECKLIST_NOT_FOUND + 0));

		// When and Then
		this.mockMvc.perform(get("/checklists/0")).andExpect(status().isNotFound());
	}

	@Test
	void testCreateChecklistWithNameOnly() throws Exception {
		// Given
		String inputJson = "{\"name\":\"Scrum Checklist\"}";

		Checklist checklist = ChecklistBuilder.getInstance().withName("Scrum Checklist").now();
		
		// When 
		Checklist createdChecklist = ChecklistBuilder.getInstance().withName("Scrum Checklist").withId(1L).now();
		Mockito.when(service.create(checklist)).thenReturn(createdChecklist);
		
		// Then
		this.mockMvc.perform(post("/checklists").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andExpect(status().isCreated())
				.andExpect(header().string(HttpHeaders.LOCATION, "http://localhost/checklists/" + 1));

	}

	
	@Test
	void testCreateChecklistWithNameAndOneItem() throws Exception {
		// Given
		String inputJson = "{\r\n"
				+ "    \"name\":\"Scrum Checklist\",\r\n"
				+ "    \"items\": [\r\n"
				+ "        {\r\n"
				+ "            \"title\": \"Roles\",\r\n"
				+ "            \"description\": \"Roles of Scrum\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";

		Checklist checklist = ChecklistBuilder.getInstance().withName("Scrum Checklist").now();
		
		// When 
		Checklist createdChecklist = ChecklistBuilder.getInstance().withName("Scrum Checklist").withId(1L).now();
		Mockito.when(service.create(checklist)).thenReturn(createdChecklist);
		
		// Then
		this.mockMvc.perform(post("/checklists").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andExpect(status().isCreated())
				.andExpect(header().string(HttpHeaders.LOCATION, "http://localhost/checklists/" + createdChecklist.getId()));

	}
}
