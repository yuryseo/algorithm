package chapter04;

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
			System.out.println(" 크기를  0이상으로 입력해주세요");
			this.inch=0;
		}
	}


	public String toString() {
		return super.toString()+" 인치:" + inch;
	}
	
	
	
	
	
}
