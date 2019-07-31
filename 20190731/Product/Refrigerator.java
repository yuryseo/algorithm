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
			System.out.println("?Å¨Í∏∞Î?? 0?ù¥?ÉÅ?úºÎ°? ?Ñ§?†ï?ï¥Ï£ºÏÑ∏?öî");
			this.size=0;
		}
	}

	public String toString() {
		return super.toString() + "?Éâ?û•Í≥? ?Å¨Í∏? : "+size;
	}

	
	
	
	
	
}
