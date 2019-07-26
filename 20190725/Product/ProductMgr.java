package chapter04;

import java.util.Arrays;

public class ProductMgr {
	private Product[] products;
	private int productsindex;

	public ProductMgr() {
		products = new Product[15];
	}

	public int findIndex(String productnum) {
		if (productnum != null) {
			for (int i = 0; i < productsindex; i++) {
				if (productnum.equals(products[i].getProductnum())) {
					return i;
				}
			}
		}
		return -1;
	}

	
	public void add(Product product) {

		if (product != null) {
			String productnum = product.getProductnum();
			int index = findIndex(productnum);
			if (index > -1) {
				System.out.println("이미 존재하는 상품입니다.");
			} else {
				if (productsindex >= products.length) {
					products = Arrays.copyOf(products, productsindex + 5);
				}
				products[productsindex++] = product;
				System.out.println("상품을 등혹했습니다");
			}
		}
	}

	public void print() {
		System.out.println("========전체 상품========");
		for (int i = 0; i < productsindex; i++) {
			System.out.println(products[i].toString());
		}
	}


	public void FindByProductnum(String productnum) {
		boolean isFind = false;
		System.out.println("========제품번호로 검색========");
		if (productnum != null) {
			for (int i = 0; i < productsindex; i++) {
				if (products[i].getProductnum().contains(productnum)) {
					System.out.println(products[i].toString());
					isFind = true;
				}
			}
			if (!isFind) {
				System.out.println("제품번호가 일치하는 상품이 없습니다.");
			}
		}else {
			System.out.println("제품번호를 입력하여 주세요");
		}
	}

	public void FindByName(String name) {
		boolean isFind = false;
		System.out.println("========제품명으로 검색========");
		if (name != null) {
			for (int i = 0; i < productsindex; i++) {
				if (products[i].getName().contains(name)) {
					System.out.println(products[i].toString());
					isFind = true;
				}

			}
			if (!isFind) {
				System.out.println("제품명이 일치하는 상품이 없습니다.");
			}
		}else {
			System.out.println("제품명을 입력하여 주세요");
		}

	}


	public void FindOnlyTV(){
		System.out.println("=======TV 검색=======");
		for (int i = 0; i < productsindex; i++) {
			if (products[i] instanceof TV) {
				System.out.println(products[i].toString());
			}
		}
	}
	
	
	public void FindOnlyRefrigerator(){
		System.out.println("=======Refrigerator 검색=========");
		for (int i = 0; i < productsindex; i++) {
			if (products[i] instanceof Refrigerator) {
				System.out.println(products[i].toString());
			}
		}
	}
	
	public void remove(String productnum){
		
		int index  = findIndex(productnum);
		if(index>-1) {
			products[index] = products[--productsindex];
			System.out.println("선택제품을 삭제하였습니다");
		}else {
			System.out.println("일치하는 제품이 없습니다.");
		}
	}
	
	
	public void PriceSum() {
		System.out.println("=====전체 재고 상품 금액=====");
		int sum=0;
		for (int i = 0; i < productsindex; i++) {
			sum+=(products[i].getPrice())*(products[i].getNum());
			
		}
		System.out.println("전체 재고 상품 금액  : "+sum);
	}
}
