import java.util.Arrays;

/** 차량정보를 관리하는 클래스 */
public class CarMgr {
	// 내부적으로 생성자를 호출.객체 생성. 생성자가 한번만 불리게된데.
	// 2. 객체를 1번 생성해서 참조변수에 저장한다.(참조변수는 static으로 작성)
	private static CarMgr instance = new CarMgr(); // 객체생성
	// 1. 생성자를 private로 만들

	private CarMgr() {
		super();
	}

	// 3. 참조변수가 private일 경우 getter 제공
	public static CarMgr getInstance() {// if instance가 null이면 객체를 못 가리키고 있는거지.
		return instance;
	}

	private Car[] cars = new Car[5];
	private int CarIndex;

	public int FindIndex(String num) {
		if (num != null) {
			for (int i = 0; i < CarIndex; i++) {
				if (num.equals(cars[i].getNum())) {
					return i;
				}
			}
		}
		return -1;
	}

	/* 차량정보를 배열에 저장 */
	public void add(Car c) {
		if (c != null) {
			String num = c.getNum();
			int index = FindIndex(num);
			if (index > -1) {
				System.out.println("이미 등록된 차량정보 입니다.");
			} else {
				if (CarIndex >= cars.length) {
					cars = Arrays.copyOf(cars, cars.length + 5);
				}
				// CarIndex++;
				cars[CarIndex] = c;
				CarIndex++;
				System.out.println("새로운 차량 정보를 등록하였습니다.");
			}

		}

	}

	/*
	 * public void Search() { System.out.println("=저장된 모든 차량 정보="); for (int i = 0;
	 * i < CarIndex; i++) { System.out.println(cars[i].toString()); } }
	 */
	public Car[] Search() {
		return cars;
	}

	public void printCar(Car[] car) {
		for (int i = 0; i < CarIndex; i++) {
			if (car[i] != null) {
				System.out.println(car[i]);
			}
		}
	}

	public Car Search(String num) {
		System.out.println("=번호로 검색된 차량정보=");

		for (int i = 0; i < CarIndex; i++) {
			if (cars[i].getNum().equals(num)) {
				// System.out.println(cars[i].toString());
				return cars[i];

			}
		}
		return null;
	}

	public Car[] Search(int price) {
		System.out.println("=" + price + "원 이하의  차량 정보=");
		Car[] searchcar = new Car[CarIndex];
		int count = 0;
		for (int i = 0; i < CarIndex; i++) {
			if (cars[i].getPrice() <= price) {
				searchcar[count++] = cars[i];
			}
		}
		return searchcar;

	}

	// 전달된 번호의 차량의 가격을 수정한다
	public void Update(String num, int price) {
		boolean isfind = false;
		if (num != null) {
			for (int i = 0; i < CarIndex; i++) {
				if (cars[i].getNum().equals(num)) {
					cars[i].setPrice(price);
					System.out.println("선택된 차량의 가격을 수정했습니다");
					isfind=true;
				} 
			}
			if(!isfind) {
				System.out.println("등록되지 않은 차량입니다.");
			}
		} else {
			System.out.println("차량번호를 입력해 주세요");
		}

	}

	public void Delete(String name) {
		int index = FindIndex(name);
		// 삭제할 인덱스의 자리에 맨 마지막 인덱스의 정보를 넣어줌
		if (index > -1) {
			cars[index] = cars[--CarIndex];
			cars[CarIndex + 1] = null;
		} else {
			System.out.println("삭제할 차량정보가 존재하지 않습니다");
		}

	}

	public int Size() {
		return CarIndex;
	}

	public int TotalPrice() {
		int sum = 0;
		for (int i = 0; i < CarIndex; i++) {
			sum += cars[i].getPrice();
		}
		return sum;
	}
	public Car[] FindTruck() {
		System.out.println("==트럭 출력==");
		Car[] searchcar = new Car[CarIndex];
		int count=0;
		for(int i=0;i<CarIndex;i++) {
			if(cars[i] instanceof Truck) {
				searchcar[count++] = cars[i];
			}
		}
		return searchcar;
	}
	public Car[] FindBus() {
		System.out.println("==버스 출력==");
		Car[] searchcar = new Car[CarIndex];
		int count=0;
		for(int i=0;i<CarIndex;i++) {
			if(cars[i] instanceof Bus) {
				searchcar[count++] = cars[i];
			}
		}
		return searchcar;
	}
	public Car[] FindCar() {
		System.out.println("==자동차 출력==");
		Car[] searchcar = new Car[CarIndex];
		int count=0;
		for(int i=0;i<CarIndex;i++) {
			if(!(cars[i] instanceof Truck)&&!(cars[i] instanceof Bus)) {
				searchcar[count++] = cars[i];
			}
		}
		return searchcar;
	}
}
