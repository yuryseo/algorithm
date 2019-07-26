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
		// 배열에 책 추가하기
		System.out.println("===책 등록===");
		if (book != null) {
			String isbn = book.getIsbn();
			int index = findIndex(isbn);
			if (index > -1) {
				System.out.println("이미 등록된 책입니다.");
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
		System.out.println("========모든 책 검색========");
		for (int i = 0; i < bookindex; i++) {
			System.out.println(books[i].toString());
		}
	}
	


	/**   3    */
	public void FindByIsbn(String isbn) {
		boolean isFind = false;
		System.out.println("========ISBN으로 검색========");
		if (isbn != null) {
			for (int i = 0; i < bookindex; i++) {
				if (isbn.equals(books[i].getIsbn())) {
					System.out.println(books[i].toString());
					isFind =true;
				}
			}
		}
		if(!isFind) {
			System.out.println("일치하는 책이 없습니다.");
		}
	}
	/**   4    */
	public void FindByTitle(String title) {
		System.out.println("========이름으로 검색========");
		boolean isFind = false;
		if (title != null) {
			for (int i = 0; i < bookindex; i++) {
				if (books[i].getTitle().contains(title)) {
					System.out.println(books[i].toString());
				isFind = true;
				}
			}
			if(!isFind) {
				System.out.println("일치하는 책이 없습니다.");
			}
		} else {
			System.out.println("찾을 제목을 입력하세요");
		}
		
	}
	/**   5    */
	public void FindOnlyBook(){
		System.out.println("========책 검색========");
		for (int i = 0; i < bookindex; i++) {
			if (!(books[i] instanceof Magazine)) {
				System.out.println(books[i].toString());
			}
		}
	}
	/**   6    */
	public void FindOnlyMagazine(){
		System.out.println("========잡지 검색========");
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
				System.out.println("일치하는 책이 없습니다.");
			}
		} else {
			System.out.println("찾을 출판사를 입력하세요");
		}
		
	}
	/**   9    */
	public void FindByMoney(int money) {
		System.out.println("=======가격으로 검색=======");
	
		boolean isFind = false;
		for (int i = 0; i < bookindex; i++) {
			if (books[i].getPrice()<=money) {
				System.out.println(books[i].toString());
				isFind = true;
			}
			
		}
		if(!isFind) {
			System.out.println("일치하는 책이 없습니다.");
		}
	}
	/**   9    */
	public void PriceSum() {
		System.out.println("=====저장된 모든 도서의 합계=====");
		int sum=0;
		for (int i = 0; i < bookindex; i++) {
			sum+=books[i].getPrice();
			
		}
		System.out.println("저장된 모든 도서의 가격 합계 : "+sum);
	}
	/**   10    */
	public void PriceAverage() {

		int sum=0;
		for (int i = 0; i < bookindex; i++) {
			sum+=books[i].getPrice();
		}
		double ave = (double)sum/bookindex;
		System.out.println("저장된 모든 도서의 가격 평균 : "+ave);
	}
}