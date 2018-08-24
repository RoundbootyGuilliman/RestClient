package client;


public class Book {
	
	private int id;
	private String title;
	private boolean pictures;
	
	public Book() {
	}
	
	public Book(int id, String title, boolean pictures) {
		this.id = id;
		this.title = title;
		this.pictures = pictures;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isPictures() {
		return pictures;
	}
	
	public void setPictures(boolean pictures) {
		this.pictures = pictures;
	}
	
	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", pictures=" + pictures +
				'}';
	}
}
