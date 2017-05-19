package org.meditec.meditecserver.model;

public class Client {
	
	private String clientName;	
	private String photo;
	private boolean isRegister;
	
	public Client() {
		
	}
	
	public Client(String clientName, String photo, boolean isRegister) {
		this.clientName = clientName;		
		this.photo = photo;
		this.isRegister = isRegister;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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
