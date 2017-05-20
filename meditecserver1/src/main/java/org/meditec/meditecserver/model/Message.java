package org.meditec.meditecserver.model;

/**
 * 
 * @author Emmanuelle
 *
 */


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date created;
	private String author;	
	
	public Message() {
		
	}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	/**
	 * Constructor
	 * @param id, message, author
	 * 
	 */
	
	public long getId() {
		return id;
	}
	/**
	 * Get the Id
	 * @return id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Set the Id
	 * @param id
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Get the message 
	 * @return message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Set the message
	 * @param message
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * Get the created date 
	 * @return created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * Set a created date
	 * @param created
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * Get the author 
	 * @return author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * Set the author
	 * @param author
	 */
}
