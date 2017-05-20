package org.meditec.meditecserver.model;
/**
 * 
 * @author Álvaro
 *
 */

public class Medicine {
	
	private String patient;
	private String name;
	private long cost;
	private String effect;
	private String schedule;
	private Medicine _left;
	private Medicine _right;
	
	public Medicine() {
		
	}
	
	public Medicine(String patient, String name, long cost, String effect, String schedule) {
		this.patient = patient;
		this.name = name;
		this.cost = cost;
		this.effect = effect;
		this.schedule = schedule;
	}
	/**
	 * Constructor
	 * @param patient, name, cost, effect, schedule
	 * 
	 */

	public String getPatient() {
		return patient;
	}
	/**
	 * Get the patient 
	 * @return patient
	 */

	public void setPatient(String patient) {
		this.patient = patient;
	}
	/**
	 * Set the patient 
	 * @param patient
	 */

	public String getName() {
		return name;
	}
	/**
	 * Get the patient name
	 * @return patientName
	 */

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Set the name
	 * @param name
	 */

	public long getCost() {
		return cost;
	}
	/**
	 * Get the cost
	 * @return cost
	 */

	public void setCost(long cost) {
		this.cost = cost;
	}
	/**
	 * Set the cost
	 * @param cost
	 */

	public String getEffect() {
		return effect;
	}
	/**
	 * Get effect
	 * @return effect
	 */

	public void setEffect(String effect) {
		this.effect = effect;
	}
	/**
	 * Set the effect
	 * @param effect
	 */

	public String getSchedule() {
		return schedule;
	}
	/**
	 * Get the schedule
	 * @return schedule
	 */

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	/**
	 * Set the schedule
	 * @param schedule
	 */

	public Medicine get_left() {
		return _left;
	}
	/**
	 * Get the left medicine
	 * @return _left
	 */

	public void set_left(Medicine _left) {
		this._left = _left;
	}
	/**
	 * Set the left medicine
	 * @param _left
	 */

	public Medicine get_right() {
		return _right;
	}
	/**
	 * Get the right medicine
	 * @return _right
	 */

	public void set_right(Medicine _right) {
		this._right = _right;
	}
	/**
	 * Set right medicine
	 * @param _right
	 */
}
