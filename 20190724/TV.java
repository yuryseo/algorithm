package chapter4;

public class TV {	
	//TV의정보(제품번호, 제품이름, 가격, 수량,인치, 디스플레이타입)를표현하기위한클래스
	private String product;
	private String name;
	private int price;
	private int num;	//수량
	private int inch;
	private String display;
	
	public TV() {}
	public TV(String product, String name, int price, int num, int inch, String display) {
		
		this.product = product;
		this.name = name;
		setPrice(price);
		setNum(num);
		setInch(inch);
		this.display = display;
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
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		if (inch >= 0) {
			this.inch = inch;
		} else {
			System.out.println("인치는 0 이상으로 설정하세요");
			this.inch=0;
		}
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	
	public String toString() {
		return "TV [product=" + product + ", name=" + name + ", price=" + price + ", num=" + num + ", inch=" + inch
				+ ", display=" + display + "]";
	}
	
	
	
	
	
}
