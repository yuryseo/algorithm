package Product;

import java.util.List;

public interface IProductMgr {
	void add(Product product) throws DuplicateException;

	List<Product> searchAll();

	void print(List<Product> list);

	Product FindByProductnum(String productnum) throws CodeNotFoundException;

	List<Product> FindByName(String name);

	List<Product> FindOnlyTV();

	List<Product> FindOnlyRefrigerator();

	List<Product> FindTV50() throws ProductNotFoundException;

	List<Product> FindRefrigerator400() throws ProductNotFoundException;

	void update(String productnum, int price)  throws ProductNotFoundException;

	void remove(String productnum)  throws ProductNotFoundException;

	int PriceSum();

}