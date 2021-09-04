package com.company.mychecklist;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.mychecklist.builders.ChecklistBuilder;
import com.company.mychecklist.builders.ItemBuilder;
import com.company.mychecklist.models.Checklist;
import com.company.mychecklist.models.Item;

@SpringBootApplication
public class MyChecklistApplication implements CommandLineRunner {

	/*
	 * @Autowired private ItemRepository itemRepository;
	 * 
	 * @Autowired private ChecklistRepository checklistRepository;
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(MyChecklistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Item artifacts = ItemBuilder.getInstance().withTitle("Artifacts").now();
		Item roles = ItemBuilder.getInstance().withTitle("Roles").now();

		List<Item> items = List.of(artifacts, roles);
		Checklist scrumChecklist = ChecklistBuilder.getInstance().withName("Scrum Checklist").withItems(items).now();
		
		artifacts.setChecklist(scrumChecklist);
		roles.setChecklist(scrumChecklist);
		
		//checklistRepository.save(scrumChecklist);
		//itemRepository.saveAll(items);

	}

}
