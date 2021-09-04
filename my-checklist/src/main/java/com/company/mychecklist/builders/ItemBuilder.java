package com.company.mychecklist.builders;

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
	
	public Item now() {
		return item;
	}
}