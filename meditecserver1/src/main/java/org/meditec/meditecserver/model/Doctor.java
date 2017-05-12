package org.meditec.meditecserver.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor {
	
	private long id;
	private String profileName;	
	private int points;
	
	
	public Doctor() {
		
	}
	
	public Doctor(long id, String profileName, int points) {
		this.id = id;
		this.profileName = profileName;		
		this.points = points;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
