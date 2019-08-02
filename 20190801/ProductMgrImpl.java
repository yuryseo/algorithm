package Product;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ProductMgrImpl implements IProductMgr {

	private List<Product> products;
	
	private static ProductMgrImpl instance = new ProductMgrImpl();
	//private 
	
	private ProductMgrImpl() {
		//products = new ArrayList<Product>();
		//super();
		open();
	}
	public static ProductMgrImpl getinstance() {
		return instance;
	}
	
	
	
	private String filename ="Product.dat";
	public void open() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(filename);
			if (file.exists() && file.canRead()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				products = (List) ois.readObject();
			} else {
				products = new ArrayList<Product>();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ois!=null) try {ois.close();}catch (Exception e) {;}
			if(fis!=null) try {fis.close();}catch (Exception e) {;}
		}
		
		
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

	public void add(Product product) throws DuplicateException {
		if (product != null) {
			String num = product.getProductnum();
			int index = findIndex(num);
			if (index > -1) {
				String msg = String.format("%s번 제품번호는 이미 등록되어있습니다.", num);
				throw new DuplicateException(msg);
			} else {
				products.add(product);
				System.out.println("add");
			}
		}

	}

	public List<Product> searchAll() {
		System.out.println("======전체 제품 ======");
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

	public Product FindByProductnum(String productnum) throws CodeNotFoundException {
		System.out.println("======제품번호로 검색한 목록======");
		int index = findIndex(productnum);
		if (productnum != null) {
			if (index > -1) {
				return products.get(index);
			} else {
				throw new CodeNotFoundException();
			}
		} else {
			System.out.println("제품번호를 입력하여주세요");
		}
		return null;
	}

	public List<Product> FindByName(String name) {
		System.out.println("======"+name+"이 포함되는 제품 목록======");
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
		System.out.println("=======TV 검색 목록=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof TV) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}

	public List<Product> FindOnlyRefrigerator() {
		System.out.println("=======Refrigerator 검색 목록=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Refrigerator) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}

	public List<Product> FindTV50() throws ProductNotFoundException {
		System.out.println("=======TV 50인치 이상 검색=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {

			if (products.get(i) instanceof TV) {
				if (((TV) (products.get(i))).getInch() >= 50) {
					temp.add(products.get(i));
				}
			}
		}
		if (temp != null) {
			return temp;
		} else {
			throw new ProductNotFoundException();
		}
	}

	public List<Product> FindRefrigerator400() throws ProductNotFoundException {
		System.out.println("=======냉장고 400L 이상 검색=======");
		List<Product> temp = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {

			if (products.get(i) instanceof Refrigerator) {
				if (((Refrigerator) (products.get(i))).getSize() >= 400) {
					temp.add(products.get(i));
				}
			}
		}
		if (temp != null) {
			return temp;
		} else {
			throw new ProductNotFoundException();
		}
	}

	public void update(String productnum, int price) throws ProductNotFoundException {

		if (productnum != null) {
			int index = findIndex(productnum);
			if (index > -1) {
				products.get(index).setPrice(price);
			} else {
				throw new ProductNotFoundException();
			}

		}

	}

	public void remove(String productnum) throws ProductNotFoundException {
		if (productnum != null) {
			int index = findIndex(productnum);
			if (index > -1) {
				products.remove(index);
			} else {
				throw new ProductNotFoundException();
			}

		}
	}

	public int PriceSum() {
		System.out.println("=====총 제품 금액=====");
		int sum = 0;
		for (int i = 0; i < products.size(); i++) {
			sum += (products.get(i).getPrice()) * products.get(i).getNum();
		}
		return sum;
	}
	public void close()
	{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(products);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos!=null) try {oos.close();}catch (Exception e) {}
			if(fos!=null) try {fos.close();}catch (Exception e) {}
			
			System.exit(0);
		}
	}
}
