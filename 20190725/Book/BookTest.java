package chapter04;

public class BookTest {
	public static void main(String[] args) {
		BookManager bmanager = new BookManager();
		
		bmanager.add(new Book("2", "Java Pro", "���ϳ�", "Jaen.kr", 15000, "Java �⺻ ����"));
		bmanager.add(new Magazine("4", "Java world", "������", "java.com",7000, "��", 2018, 2 ));
		bmanager.add(new Magazine("6", "Eclipse", "����", "java.com",12000, "ù����", 2017, 12 ));
		bmanager.add(new Book("1", "�м� ����", "�ҳ���", "Jaen.kr", 30000, "SW �𵨸�"));
		bmanager.FindByTitle("Java");
		bmanager.print();
		bmanager.FindOnlyBook();
		bmanager.FindOnlyMagazine();
		bmanager.FindByIsbn("3");
		bmanager.FindByIsbn("2");
		bmanager.FindByMoney(12000);
		bmanager.PriceSum();
		bmanager.PriceAverage();
		
/*		System.out.println("===============================���� ���===============================");
		Book book1 = new Book("21424", "Java Pro", "���ϳ�", "Jaen.kr", 15000, "Java �⺻ ����");
		Book book2 = new Book("35355", "�м� ����", "�ҳ���", "Jaen.kr", 30000, "SW �𵨸�");
		Magazine maga1 = new Magazine("35355", "Java world", "������", "java.com", 2018, 2, 7000, "ù����");
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(maga1.toString());

*/
	}
}
