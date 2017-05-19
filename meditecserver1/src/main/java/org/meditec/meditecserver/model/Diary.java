package org.meditec.meditecserver.model;

import java.util.Date;

public class Diary {
	
	private String author;
	private Date date;
	private String text;
	
	private Diary next;
	
	public Diary() {
		
	}
	
	public Diary(String author, String text) {
		this.author = author;
		this.text = text;
		this.date = new Date();
		this.next = null;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Diary getNext() {
		return next;
	}

	public void setNext(Diary next) {
		this.next = next;
	}	
}
