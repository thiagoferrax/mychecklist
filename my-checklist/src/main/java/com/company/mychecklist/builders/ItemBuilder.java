package com.company.mychecklist.builders;

import java.util.List;

import com.company.mychecklist.models.Checklist;
import com.company.mychecklist.models.Item;

public class ItemBuilder {

	private Item item;
	
	private ItemBuilder() {
	}
	
	public static ItemBuilder getInstance() {
		ItemBuilder builder = new ItemBuilder();
		builder.item = new Item();
		return builder;
	}
	
	public ItemBuilder withId(Long id) {
		item.setId(id);
		return this;
	}
	
	public ItemBuilder withTitle(String title) {
		item.setTitle(title);
		return this;
	}
	
	public ItemBuilder withChildren(List<Item> children) {
		item.setChildren(children);
		return this;
	}
	
	public ItemBuilder withChecklist(Checklist checklist) {
		item.setChecklist(checklist);
		return this;
	}
	
	public Item now() {
		return item;
	}
}