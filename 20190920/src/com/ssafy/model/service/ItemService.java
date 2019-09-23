package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Item;

public interface ItemService {
	public Item search(String name);
	public List<Item> searchAll();
	public List<Item> searchPrice(int price);
	public void add(Item item);
	public void update(Item item);
	public void remove(String id);
}
