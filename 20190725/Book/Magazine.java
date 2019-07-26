package chapter04;

import java.util.Calendar;

public class Magazine extends Book{

	private int year;	//
	private int month;	//
	
	public Magazine() {}
	public Magazine(String isbn, String title, String author, String publisher, int price,
			String desc, int year, int month) {
		
		super(isbn,title,author,publisher,price,desc);
		
		this.year = year;
		setMonth(month);
		
	}


	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month<1 ||month>12) {
			System.out.println("잘못된 달을 설정했습니다. 이번달로 설정하겠습니다.");
			Calendar today = Calendar.getInstance();
			this.month = today.get(Calendar.MONTH)+1;
		}else {
			this.month = month;
		}
		
	}
	
	public String toString() {
		return super.toString() + year  + "\t| " + month  + "\t| " ;
	}
	

}
