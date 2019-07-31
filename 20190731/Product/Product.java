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
			System.out.println("ê°?ê²©ì„ 0?› ?´?ƒ?œ¼ë¡? ?…? ¥?•´ì£¼ì„¸?š”");
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
			System.out.println("ê°œìˆ˜ë¥? 0?´?ƒ?œ¼ë¡? ?…? ¥?•´ì£¼ì„¸?š”");
			this.num=0;
		}
	}
	public String toString() {
		return "? œ?’ˆë²ˆí˜¸:" + productnum + " ? œ?’ˆëª?:" + name + " ê°?ê²?:" + price + " ?¬ê³?:" + num;
	}

	
}




