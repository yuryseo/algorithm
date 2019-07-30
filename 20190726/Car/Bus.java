public class Bus extends Car {
	private int seat;

	public Bus() {

	}

	public Bus(String num, String model, int price, int seat) {
		super(num, model, price);
		setSeat(seat);
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		if (seat >= 0) {
			this.seat = seat;
		} else {
			System.out.println("좌석을 0이상으로 설정해주세요");
			this.seat=0;
		}
	}

	public String toString() {
		return super.toString() + " 좌석 수 :" + seat;
	}

}
