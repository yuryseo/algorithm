package chapter04;

import java.util.Arrays;

public class BookManager {
	/*
	 * private String isbn; private String title; private String author; private
	 * String publisher; private int price;
	 */
	private Book[] books;
	private int bookindex;

	public BookManager() {
		books = new Book[15];
	}
	public int findIndex(String isbn) {
		if (isbn != null) {
			for (int i = 0; i < bookindex; i++) {
				if (isbn.equals(books[i].getIsbn())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	
	/**   1    */
	public void add(Book book) {	
		// �迭�� å �߰��ϱ�
		System.out.println("===å ���===");
		if (book != null) {
			String isbn = book.getIsbn();
			int index = findIndex(isbn);
			if (index > -1) {
				System.out.println("�̹� ��ϵ� å�Դϴ�.");
			} else {
				if (bookindex >= books.length) {
					books = Arrays.copyOf(books, bookindex + 5);
				}
				books[bookindex++] = book;
			}
		}
	}
	/**   2    */
	public void print() {
		System.out.println("========��� å �˻�========");
		for (int i = 0; i < bookindex; i++) {
			System.out.println(books[i].toString());
		}
	}
	


	/**   3    */
	public void FindByIsbn(String isbn) {
		boolean isFind = false;
		System.out.println("========ISBN���� �˻�========");
		if (isbn != null) {
			for (int i = 0; i < bookindex; i++) {
				if (isbn.equals(books[i].getIsbn())) {
					System.out.println(books[i].toString());
					isFind =true;
				}
			}
		}
		if(!isFind) {
			System.out.println("��ġ�ϴ� å�� �����ϴ�.");
		}
	}
	/**   4    */
	public void FindByTitle(String title) {
		System.out.println("========�̸����� �˻�========");
		boolean isFind = false;
		if (title != null) {
			for (int i = 0; i < bookindex; i++) {
				if (books[i].getTitle().contains(title)) {
					System.out.println(books[i].toString());
				isFind = true;
				}
			}
			if(!isFind) {
				System.out.println("��ġ�ϴ� å�� �����ϴ�.");
			}
		} else {
			System.out.println("ã�� ������ �Է��ϼ���");
		}
		
	}
	/**   5    */
	public void FindOnlyBook(){
		System.out.println("========å �˻�========");
		for (int i = 0; i < bookindex; i++) {
			if (!(books[i] instanceof Magazine)) {
				System.out.println(books[i].toString());
			}
		}
	}
	/**   6    */
	public void FindOnlyMagazine(){
		System.out.println("========���� �˻�========");
		for (int i = 0; i < bookindex; i++) {
			if (books[i] instanceof Magazine) {
				System.out.println(books[i].toString());
			}
		}
	}
	/**   8    */
	public void FindByPublisher(String publisher) {
		boolean isFind = false;
		if (publisher != null) {
			for (int i = 0; i < bookindex; i++) {
				if (books[i].getTitle().contains(publisher)) {
					System.out.println(books[i].toString());
				isFind = true;
				}
			}
			if(!isFind) {
				System.out.println("��ġ�ϴ� å�� �����ϴ�.");
			}
		} else {
			System.out.println("ã�� ���ǻ縦 �Է��ϼ���");
		}
		
	}
	/**   9    */
	public void FindByMoney(int money) {
		System.out.println("=======�������� �˻�=======");
	
		boolean isFind = false;
		for (int i = 0; i < bookindex; i++) {
			if (books[i].getPrice()<=money) {
				System.out.println(books[i].toString());
				isFind = true;
			}
			
		}
		if(!isFind) {
			System.out.println("��ġ�ϴ� å�� �����ϴ�.");
		}
	}
	/**   9    */
	public void PriceSum() {
		System.out.println("=====����� ��� ������ �հ�=====");
		int sum=0;
		for (int i = 0; i < bookindex; i++) {
			sum+=books[i].getPrice();
			
		}
		System.out.println("����� ��� ������ ���� �հ� : "+sum);
	}
	/**   10    */
	public void PriceAverage() {

		int sum=0;
		for (int i = 0; i < bookindex; i++) {
			sum+=books[i].getPrice();
		}
		double ave = (double)sum/bookindex;
		System.out.println("����� ��� ������ ���� ��� : "+ave);
	}
}