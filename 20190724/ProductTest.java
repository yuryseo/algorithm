package chapter4;

public class ProductTest {
	//TV의정보(int제품번호, String제품이름, int가격, int수량,int인치, String디스플레이타입)
	//냉장고정보(int제품번호, String제품이름, int가격, int수량,int용량)
	public static void main(String[] args) {
		TV tv1 = new TV("1234","tvtv",200000,4,40,"C");
		System.out.println(tv1.toString());
		TV tv2 = new TV("432","tvtv2",500000,-2,40,"D");
		System.out.println(tv2.toString());
		TV tv3 = new TV("5332","333tvtv",150000,40,20,"$");
		System.out.println(tv3.toString());
		Refrigerator re1 = new Refrigerator("432","re1",50000,7,40);
		System.out.println(re1.toString());
		Refrigerator re2 = new Refrigerator("6672","re2",100000,11,100);
		System.out.println(re2.toString());
		
		
	}

}
