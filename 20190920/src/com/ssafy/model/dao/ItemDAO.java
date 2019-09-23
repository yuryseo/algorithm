package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Item;

public interface ItemDAO {
	public Item search(String name) throws SQLException;
	public List<Item> searchAll() throws SQLException;
	public List<Item> searchByPrice(int price) throws SQLException;
	public void add(Item item)	 throws SQLException;
	public void update(Item item)throws SQLException;
	public void remove(String name)    throws SQLException;
}












