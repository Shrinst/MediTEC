package org.meditec.meditecserver.model;

public class Client {
	
	private String clientName;
	private int id;
	private String location;	
	
	public Client() {
		
	}
	
	public Client(String clientName, int id, String location) {
		this.clientName = clientName;
		this.id = id;
		this.location = location;
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
}
