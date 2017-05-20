package org.meditec.meditecserver.model;

/**
 * 
 * @author Vinicio
 *
 */

import java.util.Date;

public class Diary {
	
	private String author;
	private Date date;
	private String text;
	
	public Diary() {
		
	}
	
	public Diary(String author, String text) {
		this.author = author;
		this.text = text;
		this.date = new Date();
	}
	/**
	 * Constructor
	 * @param author, text
	 * 
	 */

	public String getAuthor() {
		return author;
	}
	/**
	 * Get the Author
	 * @return author
	 */

	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * Set the Author 
	 * @param author
	 */
	

	public Date getDate() {
		return date;
	}
	/**
	 * Get the date
	 * @return date
	 */

	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Set the date
	 * @param date
	 */

	public String getText() {
		return text;
	}
	/**
	 * @return text
	 */

	public void setText(String text) {
		this.text = text;
	}
	/**
	 * Set text
	 * @param text
	 */
}
