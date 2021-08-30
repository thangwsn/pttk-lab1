package model;

public class Book {
	private int book_id;
	private String title, author;
	private float price;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int book_id, String title, String author, float price) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public Book(String title, String author, float price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
