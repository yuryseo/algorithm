package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.ItemDAO;
import com.ssafy.model.dao.ItemDAOImp;
import com.ssafy.model.dao.MemberDAOImp;
import com.ssafy.model.dto.Item;
import com.ssafy.model.dto.ItemException;

public class ItemServiceImp implements ItemService {
	private ItemDAO dao = new ItemDAOImp();
	public Item search(String name) {
		try {
			Item item = dao.search(name);
			if(item == null) {
				throw new ItemException("등록되지 않은 상품입니다.");
			}else {
			   return item;
			}
		} catch (Exception e) {
			throw new ItemException();
		}
	}

	public List<Item> searchAll() {
		try {
			return dao.searchAll();
		}catch (SQLException e) {
			throw new ItemException();
		}
	}

	public void add(Item item) {
		try {
			Item find = dao.search(item.getName());
			if(find != null) {
				throw new ItemException("이미 등록된 상품입니다.");
			}else {
				dao.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ItemException();
		}
	}
	
	public void update(Item item) {
		try {
			Item find = dao.search(item.getName());
			if(find == null) {
				throw new ItemException("수정할 상품 정보가 없습니다.");
			}else {
				dao.update(item);
			}
		} catch (SQLException e) {
			throw new ItemException();
		}
	}

	public void remove(String name) {
		try {
			Item find = dao.search(name);
			if(find == null) {
				throw new ItemException("삭제할 상품 정보가 없습니다.");
			}else {
				dao.remove(name);
			}
		} catch (SQLException e) {
			throw new ItemException();
		}
	}

}
