package chapter04;

public class ProductTest {

	public static void main(String[] args) {
		// (productnum, name, price, num, size)
		

		ProductMgr pm = new ProductMgr();
		pm.add(new TV("tv138", "D024", 50000, 6, 20));
		pm.add(new TV("tv23", "mul", 300000, 3, 30));
		pm.add(new Refrigerator("wLOT", "baba", 150000, 3, 200));
		pm.add(new TV("tv93", "hana", 200000, 3, 25));
		pm.add(new TV("t88", "haha", 200000, 3, 25));

		pm.print();

		pm.add(new Refrigerator("F2873", "H2D4", 80000, 1, 270));
		pm.add(new Refrigerator("rF3", "moomin", 250000, 10, 450));

		pm.FindOnlyRefrigerator();

		pm.remove("tv93");
		pm.FindOnlyTV();
		pm.FindByName("ha");
		pm.FindByProductnum("3");
		
		
		
	}

}
