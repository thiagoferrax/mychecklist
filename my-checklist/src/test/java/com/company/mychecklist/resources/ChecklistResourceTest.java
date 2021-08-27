package com.company.mychecklist.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.company.mychecklist.builders.ChecklistBuilder;
import com.company.mychecklist.services.ChecklistService;


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
	public void testFindAll() throws Exception {
		// Given
		Mockito.when(service.findAll())
				.thenReturn(List.of(ChecklistBuilder.getInstance().withId(1L).withName("Scrum Checklist").now()));

		// When and Then
		this.mockMvc.perform(get("/checklists")).andExpect(status().isOk()).andExpect(content().json("[{\"id\": 1, \"name\": \"Scrum Checklist\"}]"));
	}

}
