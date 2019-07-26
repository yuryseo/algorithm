package chapter04;

public class Book {

	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	public Book() {}
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		
		this.desc = desc;
		setPrice(price);
	}

	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		} else {
			System.out.println("å ������ 0�� �̻����� �����ϼ���");
			this.price=0;
		}
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String toString() {
		return isbn + "\t| " + title + "\t| " + author + "\t| " 
				+ publisher + "\t| " + price + "\t| " + desc+"\t| ";
	}



}
