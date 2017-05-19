package org.meditec.meditecserver.model;

public class Doctor {
	
    Doctor _left, _right, _parent;
	private String id;
	private String profileName;
	private int points;	
	

	public Doctor() {
		
	}
	
	public Doctor(String id, Doctor left, Doctor right, String profileName, int points) {
		this.id = id;
		this.profileName = profileName;	
		this.points = points;
		_left = _right = _parent = null;
	}
	
	public Doctor(String id, String profileName, int points) {
		this.id = id;
		this.profileName = profileName;
		this.points = points;		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}	
	
	public Doctor getLeft() {
		return _left;
	}

	public void setLeft(Doctor left) {
		_left = left;
	}

	public Doctor getRight() {
		return _right;
	}

	public void setRight(Doctor right) {
		_right = right;
	}

	public Doctor getParent() {
		return _parent;
	}

	public void setParent(Doctor parent) {
		_parent = parent;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
