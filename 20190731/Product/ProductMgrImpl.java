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
				System.out.println("?���? ?��록된 책입?��?��.");
			} else {
				products.add(product);
			}
		}

	}

	public List<Product> searchAll() {
		System.out.println("======?��체목�?======");
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
		System.out.println("======?��?��번호 �??��======");
		int index = findIndex(productnum);
		if (productnum != null) {
			if (index > -1) {
				return products.get(index);
			} else {
				System.out.println("?��록되�? ?��?? ?��?��번호?��?��?��.");
			}
		} else {
			System.out.println("?��?��번호�? ?��?��?��?�� 주세?��");
		}
		return null;
	}

	public List<Product> FindByName(String name) {
		System.out.println("======"+name+"?��(�?) ?��?��?�� �??��======");
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
		System.out.println("=======TV �??��=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof TV) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}

	public List<Product> FindOnlyRefrigerator() {
		System.out.println("=======?��?���? �??��=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}

	public List<Product> FindTV50() {
		System.out.println("=======TV 50?���? ?��?�� �??��=======");
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
		System.out.println("=======?��?���? 400리터 ?��?�� �??��=======");
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
				System.out.println("?��?��?�� ?��?��번호�? ?��록되�? ?��?��?��?��?��.");
			}

		}

	}

	public void remove(String productnum) {
		if (productnum != null) {
			int index = findIndex(productnum);
			if (index > -1) {
				products.remove(index);
			} else {
				System.out.println("?��?��?�� ?��?��번호�? ?��록되�? ?��?��?��?��?��.");
			}

		}
	}

	public int PriceSum() {
		System.out.println("=====?���? ?���? ?��?�� 금액=====");
		int sum = 0;
		for (int i = 0; i < products.size(); i++) {
			sum += (products.get(i).getPrice()) * products.get(i).getNum();
		}
		return sum;
	}

}
