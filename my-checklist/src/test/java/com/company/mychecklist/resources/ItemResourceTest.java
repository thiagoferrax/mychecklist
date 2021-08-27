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

import com.company.mychecklist.builders.ItemBuilder;
import com.company.mychecklist.services.ChecklistService;
import com.company.mychecklist.services.ItemService;


@RunWith(SpringRunner.class)
@WebMvcTest
class ItemResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemResource itemResource;
	
	@MockBean
	private ItemService service;
	
	@MockBean
	private ChecklistService checklistService;
	
	//@Test
	public void testFindAll() throws Exception {
		// Given
		Mockito.when(service.findAll())
				.thenReturn(List.of(ItemBuilder.getInstance().withId(1L).withTitle("Artifacts").now()));

		// When and Then
		this.mockMvc.perform(get("/items")).andExpect(status().isOk()).andExpect(content().json("[{\"id\": 1, \"title\": \"Artifacts\"}]"));
	}

}
