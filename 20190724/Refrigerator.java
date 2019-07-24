package chapter4;

public class Refrigerator {	
	//냉장고정보(제품번호, 제품이름, 가격, 수량,용량)를표현하기위한클래스
	private String product;
	private String name;
	private int price;
	private int num;	//수량
	private int size;	//용량
	
	public Refrigerator() {}
	public Refrigerator(String product, String name, int price, int num, int size) {
		this.product = product;
		this.name = name;
		setPrice(price);
		setNum(num);
		setSize(size);
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
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
		if (price >= 0) {
			this.price = price;
		} else {
			System.out.println("가격은 0원 이상으로 설정하세요");
			this.price=0;
		}
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		if (num >= 0) {
			this.num = num;
		} else {
			System.out.println("수량은 0원 이상으로 설정하세요");
			this.num=0;
		}
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if (size >= 0) {
			this.size = size;
		} else {
			System.out.println("용량은 0 이상으로 설정하세요");
			this.size=0;
		}
	}

	public String toString() {
		return "Refrigerator [product=" + product + ", name=" + name + ", price=" + price + ", num=" + num + ", size="
				+ size + "]";
	}

	
	
	
	
	
}
