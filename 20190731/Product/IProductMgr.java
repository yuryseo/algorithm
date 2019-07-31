package Product;

import java.util.List;

public interface IProductMgr {

	int findIndex(String productnum);

	void add(Product product);

	List<Product> searchAll();

	void print(List<Product> list);

	Product FindByProductnum(String productnum);

	List<Product> FindByName(String name);

	List<Product> FindOnlyTV();

	List<Product> FindOnlyRefrigerator();

	List<Product> FindTV50();

	List<Product> FindRefrigerator400();

	void update(String productnum, int price);

	void remove(String productnum);

	int PriceSum();

}