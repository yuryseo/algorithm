package Product;


public class Refrigerator extends Product{	
	
	private int size;	
	
	public Refrigerator() {}
	public Refrigerator(String productnum, String name, int price, int num, int size) {
		super(productnum, name, price, num);
		setSize(size);
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if (size >= 0) {
			this.size = size;
		} else {
			System.out.println("냉장고의 크기를 0이상으로 입력해주세요");
			this.size=0;
		}
	}

	public String toString() {
		return super.toString() + "냉장고 크기 : "+size;
	}

	
	
	
	
	
}
