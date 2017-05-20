package org.meditec.meditecserver.model;

/**
 * 
 * @author Emmanuelle
 *
 */

public class Client {
	
	private String clientName;
	private int id;
	private String location;
	private String photo;
	private boolean isRegister;
	/**
	 * Setup variables
	 */
	
	public Client() {
		
	}
	
	public Client(String clientName, int id, String location, String photo, boolean isRegister) {
		this.clientName = clientName;
		this.id = id;
		this.location = location;
		this.photo = photo;
		this.isRegister = isRegister;
	}
	
	/**
	 * Constructor
	 * @param clientName, id, location, photo, isRegister
	 * 
	 */
	

	public String getClientName() {
		return clientName;
	}
	/**
	 * @return client name
	 */

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * Set the ClientName
	 * @param clientName
	 */
	

	public int getId() {
		return id;
	}
	/**
	 * @return id
	 */

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Set the ID
	 * @param id
	 */

	public String getLocation() {
		return location;
	}
	/**
	 * @return location
	 */

	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * Set  location
	 * @param location
	 */

	public boolean isRegister() {
		return isRegister;
	}
	/**
	 * @return isRegister
	 */

	public void setRegister(boolean isRegister) {
		this.isRegister = isRegister;
	}
	/**
	 * Set Register
	 * @param isRegister
	 */

	public String getPhoto() {
		return photo;
	}
	/**
	 * @return photo
	 */

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * Set the photo
	 * @param photo
	 */
}
