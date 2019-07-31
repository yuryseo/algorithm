package Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {

	private List<Product> products;

	public ProductMgrImpl() {
		products = new ArrayList<Product>();
	}

	public int findIndex(String productnum) {
		if (productnum != null) {
			for (int i = 0; i < products.size(); i++) {
				if (productnum.equals(products.get(i).getProductnum())) {
					return i;
				}
			}
		}
		return -1;
	}

	public void add(Product product) {
		if (product != null) {
			String num = product.getProductnum();
			int index = findIndex(num);
			if (index > -1) {
				System.out.println("?´ë¯? ?“±ë¡ëœ ì±…ì…?‹ˆ?‹¤.");
			} else {
				products.add(product);
			}
		}

	}

	public List<Product> searchAll() {
		System.out.println("======? „ì²´ëª©ë¡?======");
		return products;
	}

	public void print(List<Product> temp) {
		for (int i = 0; i < temp.size(); i++) {
			System.out.println(temp.get(i).toString());
		}
	}

	public void print(Product temp) {

		System.out.println(temp);
	}

	public Product FindByProductnum(String productnum) {
		System.out.println("======? œ?’ˆë²ˆí˜¸ ê²??ƒ‰======");
		int index = findIndex(productnum);
		if (productnum != null) {
			if (index > -1) {
				return products.get(index);
			} else {
				System.out.println("?“±ë¡ë˜ì§? ?•Š?? ? œ?’ˆë²ˆí˜¸?…?‹ˆ?‹¤.");
			}
		} else {
			System.out.println("? œ?’ˆë²ˆí˜¸ë¥? ?…? ¥?•˜?—¬ ì£¼ì„¸?š”");
		}
		return null;
	}

	public List<Product> FindByName(String name) {
		System.out.println("======"+name+"?´(ê°?) ?¬?•¨?œ ê²??ƒ‰======");
		List<Product> temp = new ArrayList<>();
		if (name != null) {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getName().contains(name)){
					temp.add(products.get(i));
				}
			}
		}
		return temp;
	}

	public List<Product> FindOnlyTV() {
		System.out.println("=======TV ê²??ƒ‰=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof TV) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}

	public List<Product> FindOnlyRefrigerator() {
		System.out.println("=======?ƒ‰?¥ê³? ê²??ƒ‰=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}

	public List<Product> FindTV50() {
		System.out.println("=======TV 50?¸ì¹? ?´?ƒ ê²??ƒ‰=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {

			if (products.get(i) instanceof TV) {
				if (((TV) (products.get(i))).getInch() >= 50) {
					temp.add(products.get(i));
				}
			}
		}
		return temp;
	}

	public List<Product> FindRefrigerator400() {
		System.out.println("=======?ƒ‰?¥ê³? 400ë¦¬í„° ?´?ƒ ê²??ƒ‰=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {

			if (products.get(i) instanceof Refrigerator) {
				if (((Refrigerator) (products.get(i))).getSize() >= 400) {
					temp.add(products.get(i));
				}
			}
		}
		return temp;
	}

	public void update(String productnum, int price) {

		if (productnum != null) {
			int index = findIndex(productnum);
			if (index > -1) {
				products.get(index).setPrice(price);
			} else {
				System.out.println("?ˆ˜? •?•  ? œ?’ˆë²ˆí˜¸ê°? ?“±ë¡ë˜ì§? ?•Š?•˜?Šµ?‹ˆ?‹¤.");
			}

		}

	}

	public void remove(String productnum) {
		if (productnum != null) {
			int index = findIndex(productnum);
			if (index > -1) {
				products.remove(index);
			} else {
				System.out.println("?‚­? œ?•  ? œ?’ˆë²ˆí˜¸ê°? ?“±ë¡ë˜ì§? ?•Š?•˜?Šµ?‹ˆ?‹¤.");
			}

		}
	}

	public int PriceSum() {
		System.out.println("=====? „ì²? ?¬ê³? ?ƒ?’ˆ ê¸ˆì•¡=====");
		int sum = 0;
		for (int i = 0; i < products.size(); i++) {
			sum += (products.get(i).getPrice()) * products.get(i).getNum();
		}
		return sum;
	}

}
