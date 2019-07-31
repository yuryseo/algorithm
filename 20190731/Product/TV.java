package Product;

public class TV extends Product{	
	
	private int inch;
	
	public TV() {}
	
	
	public TV(String productnum, String name, int price, int num, int inch) {
		super(productnum, name, price, num);
		setInch(inch);
	}
	public void setInch(int inch) {
		if (inch >= 0) {
			this.inch = inch;
		} else {
			System.out.println(" ?��기�??  0?��?��?���? ?��?��?��주세?��");
			this.inch=0;
		}
	}


	public int getInch() {
		return inch;
	}


	public String toString() {
		return super.toString()+" ?���?:" + inch;
	}
	
	
	
	
	
}
