package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.Item;
import com.ssafy.util.DBUtil;

public class ItemDAOImp implements ItemDAO {
	public Item search(String name) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from items where name = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Item(rs.getInt("no"),
						rs.getString("name"),
						rs.getInt("price"),
						rs.getString("des"));
			}
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
		return null;
	}

	public List<Item> searchAll() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from items  ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Item> items = new LinkedList<Item>();
			while(rs.next()) {
				items.add(new Item(rs.getInt("no"),
									rs.getString("name"),
									rs.getInt("price"),
									rs.getString("des")));
			}
			return items;
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
	}
	public void add(Item item) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into items(name,price,des) "
					   + " values(?,?,?) ";
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, item.getName());		
			stmt.setInt(idx++, item.getPrice());		
			stmt.setString(idx++, item.getDesc());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void update(Item item) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update items set name=?, price=?, des=? where name=? " ;
			
			stmt = con.prepareStatement(sql);
			int idx = 1;	
			stmt.setString(idx++, item.getName());		
			stmt.setInt(idx++, item.getPrice());		
			stmt.setString(idx++, item.getDesc());	
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	
	public void remove(String name) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from items where name=? " ;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}







