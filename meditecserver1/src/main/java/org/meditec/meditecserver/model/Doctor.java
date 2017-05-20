package org.meditec.meditecserver.model;

/**
 * 
 * @author Emmanuelle
 *
 */

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor {
	
	private String id;
	private String profileName;	
	private int points;
	
	
	public Doctor() {
		
	}
	
	public Doctor(String id, String profileName, int points) {
		this.id = id;
		this.profileName = profileName;		
		this.points = points;
	}
	/**
	 * Constructor
	 * @param id, profileName, points
	 * 
	 */

	
	public String getId() {
		return id;
	}
	/**
	 * Get the Id
	 * @return id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Set the Id 
	 * @param id
	 */
	public String getProfileName() {
		return profileName;
	}
	/**
	 * Get the profileName
	 * @return profileName
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	/**
	 * Set the profile name
	 * @param profileName
	 */

	public int getPoints() {
		return points;
	}
	/**
	 * Get the points
	 * @return points
	 */

	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * Set the points 
	 * @param points
	 */
}
