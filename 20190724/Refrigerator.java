package chapter4;

public class Refrigerator {	
	//���������(��ǰ��ȣ, ��ǰ�̸�, ����, ����,�뷮)��ǥ���ϱ�����Ŭ����
	private String product;
	private String name;
	private int price;
	private int num;	//����
	private int size;	//�뷮
	
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if (size >= 0) {
			this.size = size;
		} else {
			System.out.println("�뷮�� 0 �̻����� �����ϼ���");
			this.size=0;
		}
	}

	public String toString() {
		return "Refrigerator [product=" + product + ", name=" + name + ", price=" + price + ", num=" + num + ", size="
				+ size + "]";
	}

	
	
	
	
	
}
