public class Car {
	private String num;
	private String model;
	private int price;

	public Car() {
	}

	public Car(String num, String model, int price) {
		this.num = num;
		this.model = model;
		this.price = price;
	}

	public String getNum() {
		return num;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		} else {
			System.out.println("가격을 0월 이상으로 설정해 주세요");
			this.price =0;
		}
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String toString() {
		return "차량번호:" + num + " 모델명:" + model + " 가격:" + price;
	}

}
