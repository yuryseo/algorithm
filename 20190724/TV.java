package chapter4;

public class TV {	
	//TV������(��ǰ��ȣ, ��ǰ�̸�, ����, ����,��ġ, ���÷���Ÿ��)��ǥ���ϱ�����Ŭ����
	private String product;
	private String name;
	private int price;
	private int num;	//����
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
			System.out.println("������ 0�� �̻����� �����ϼ���");
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
			System.out.println("������ 0�� �̻����� �����ϼ���");
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
			System.out.println("��ġ�� 0 �̻����� �����ϼ���");
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
