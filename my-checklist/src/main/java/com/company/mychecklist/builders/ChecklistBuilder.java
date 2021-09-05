package com.company.mychecklist.builders;

import java.util.List;

import com.company.mychecklist.models.Checklist;
import com.company.mychecklist.models.Item;

public class ChecklistBuilder {

	private Checklist checklist;
	
	private ChecklistBuilder() {
	}
	
	public static ChecklistBuilder getInstance() {
		ChecklistBuilder builder = new ChecklistBuilder();
		builder.checklist = new Checklist();
		return builder;
	}
	
	public ChecklistBuilder withId(Long id) {
		checklist.setId(id);
		return this;
	}
	
	public ChecklistBuilder withTitle(String title) {
		checklist.setTitle(title);
		return this;
	}
	
	public ChecklistBuilder withItems(List<Item> items) {
		checklist.setItems(items);
		return this;
	}
	
	public Checklist now() {
		return checklist;
	}
}