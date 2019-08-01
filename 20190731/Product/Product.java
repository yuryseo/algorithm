package Product;


public class Product {
	private String productnum;	
	private String name;	
	private int price;
	private int num;
	
	public Product() {}
	public Product(String productnum, String name, int price, int num) {

		this.productnum = productnum;
		this.name = name;
		this.price = price;
		this.num = num;
	}
	
	public String getProductnum() {
		return productnum;
	}
	public void setProductnum(String productnum) {
		this.productnum = productnum;
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
			System.out.println("가격을 0원 이상으로 입력해주세요");
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
			System.out.println("갯수를 0원 이상으로 입력해주세요");
			this.num=0;
		}
	}
	public String toString() {
		return "제품번호:" + productnum + " 제품명:" + name + " 가격:" + price + " 재고수량:" + num;
	}

	
}




