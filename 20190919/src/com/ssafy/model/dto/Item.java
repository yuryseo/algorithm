package com.ssafy.model.dto;
public class Item{
	String name, des;
	int price,no;
	public Item() {}
	public Item(String name, int price, String des) {
		super();
		this.name = name;
		this.price = price;
		this.des = des;
	}
	public Item(int no, String name, int price, String des) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.des = des;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return des;
	}
	public void setDesc(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [name=").append(name).append(", price=").append(price).append(", des=").append(des)
				.append("]");
		return builder.toString();
	}
}