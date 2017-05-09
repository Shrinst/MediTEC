package org.meditec.meditecserver.model;

public class Client {
	
	private String clientName;
	private int id;
	private String location;
	private String photo;
	private boolean isRegister;
	
	public Client() {
		
	}
	
	public Client(String clientName, int id, String location, String photo, boolean isRegister) {
		this.clientName = clientName;
		this.id = id;
		this.location = location;
		this.photo = photo;
		this.isRegister = isRegister;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isRegister() {
		return isRegister;
	}

	public void setRegister(boolean isRegister) {
		this.isRegister = isRegister;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
