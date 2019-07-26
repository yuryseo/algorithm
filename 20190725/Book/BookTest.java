package chapter04;

public class BookTest {
	public static void main(String[] args) {
		BookManager bmanager = new BookManager();
		
		bmanager.add(new Book("2", "Java Pro", "감하나", "Jaen.kr", 15000, "Java 기본 문법"));
		bmanager.add(new Magazine("4", "Java world", "편집부", "java.com",7000, "달", 2018, 2 ));
		bmanager.add(new Magazine("6", "Eclipse", "후추", "java.com",12000, "첫걸음", 2017, 12 ));
		bmanager.add(new Book("1", "분석 설계", "소나무", "Jaen.kr", 30000, "SW 모델링"));
		bmanager.FindByTitle("Java");
		bmanager.print();
		bmanager.FindOnlyBook();
		bmanager.FindOnlyMagazine();
		bmanager.FindByIsbn("3");
		bmanager.FindByIsbn("2");
		bmanager.FindByMoney(12000);
		bmanager.PriceSum();
		bmanager.PriceAverage();
		
/*		System.out.println("===============================도서 목록===============================");
		Book book1 = new Book("21424", "Java Pro", "감하나", "Jaen.kr", 15000, "Java 기본 문법");
		Book book2 = new Book("35355", "분석 설계", "소나무", "Jaen.kr", 30000, "SW 모델링");
		Magazine maga1 = new Magazine("35355", "Java world", "편집부", "java.com", 2018, 2, 7000, "첫걸음");
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(maga1.toString());

*/
	}
}
