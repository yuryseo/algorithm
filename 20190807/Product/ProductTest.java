package Product;

public class ProductTest {

	public static void main(String[] args) {

		ProductMgrImpl pm = ProductMgrImpl.getinstance();
		try {
		/*	pm.add(new TV("tv23", "mul", 3000000, 3, 30));
			pm.add(new Refrigerator("wLOT", "baba", 150000, 3, 200));
			pm.add(new TV("tv93", "hana", 2000000, 3, 25));
			pm.add(new TV("t456", "haha", 8000000, 3, 100));
			pm.add(new TV("t88", "coco", 500000, 3, 60));
			pm.add(new Refrigerator("RT73", "berry", 800000, 5, 470));
			pm.add(new Refrigerator("F2873", "H2D4", 80000, 1, 470));
			pm.add(new Refrigerator("rF3", "moomin", 250000, 10, 450));
			*/pm.print(pm.FindOnlyRefrigerator());
			pm.print(pm.FindOnlyTV());
			pm.print(pm.FindByName("ha"));
			pm.print(pm.FindByProductnum("t88"));
			//pm.print(pm.FindByProductnum("t998"));
			pm.print(pm.FindRefrigerator400());
			pm.print(pm.FindTV50());

			pm.print(pm.searchAll());
			pm.send();

		} /*catch (DuplicateException e) {

			e.printStackTrace();
		}
*/
		catch (ProductNotFoundException e) {

			e.printStackTrace();
		} catch (CodeNotFoundException e) {

			e.printStackTrace();
		}finally {
			//pm.close();
		}

	}

}
