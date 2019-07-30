public class Truck extends Car {
	private int ton;

	public Truck() {

	}

	public Truck(String num, String model, int price, int ton) {
		super(num, model, price);
		setTon(ton);
	}

	public int getTon() {
		return ton;
	}

	public void setTon(int ton) {
		if (ton >= 0) {
			this.ton = ton;
		} else {
			System.out.println("0톤 이상으로 설정해주세요");
			this.ton = 0;
		}
	}

	public String toString() {
		return super.toString() + " 톤 :" + ton;
	}

}
