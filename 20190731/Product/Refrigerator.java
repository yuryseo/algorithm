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
			System.out.println("?¬κΈ°λ?? 0?΄??Όλ‘? ?€? ?΄μ£ΌμΈ?");
			this.size=0;
		}
	}

	public String toString() {
		return super.toString() + "??₯κ³? ?¬κΈ? : "+size;
	}

	
	
	
	
	
}
