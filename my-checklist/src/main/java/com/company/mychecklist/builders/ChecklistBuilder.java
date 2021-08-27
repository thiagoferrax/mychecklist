package com.company.mychecklist.builders;

import com.company.mychecklist.entities.Checklist;

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
	
	public ChecklistBuilder withName(String name) {
		checklist.setName(name);
		return this;
	}
	
	public Checklist now() {
		return checklist;
	}
}