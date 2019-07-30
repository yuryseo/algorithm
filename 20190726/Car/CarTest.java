import java.util.Arrays;

public class CarTest {

	public static void main(String[] args) {
	/**
	 * CarMgr m = new CarMgr(); =>CarMgr가 private 이기 때문에 호출불가
	 * 그러므로 instance를 static 으로.
	 * 근데 default이하면 CarMgr.instance=null;이렇게 할 수가 있어...
	 * 그래서 private을 붙여주고  getter를 만들어줘요
	 */
		
	/*	CarMgr m1 = CarMgr.getInstance();
		CarMgr m2 = CarMgr.getInstance();
		System.out.println(m1==m2);	//같은객체니깐.
		*/
		
		CarMgr m1 = CarMgr.getInstance();
		m1.add(new Car("2124","DW",20000));
		m1.add(new Car("9532","ES",15300));
		m1.add(new Truck("4234","UI",21700,2));
		
		m1.printCar(m1.Search());
		m1.printCar(m1.Search(21000));
		//System.out.println(Arrays.toString(m1.Search()));
		
		m1.add(new Bus("5755","YF",41000,50));
		m1.add(new Truck("5453","YF",41000,5));
		m1.add(new Car("3424","TY",29900));
		m1.add(new Car("1887","DW",45000));
		m1.add(new Truck("1865","JU",21000,4));
		m1.printCar(m1.Search());
		System.out.println(m1.TotalPrice());
		m1.Delete("3424");
		m1.Update("8888", 8000);
		System.out.println(m1.TotalPrice());
		m1.printCar(m1.FindBus());
	}

}
