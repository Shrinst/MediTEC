package org.meditec.meditecserver.model;

/**
 * 
 * @author Emmanuelle, Alejandro
 *
 */

public class Appointment {

	private String symptomps;
	private String date;
	private String patientName;
	private int id;
	private String location;
	private String doctorId;
	private boolean pay;
	private Appointment _left;
	private Appointment _right;
	
	/**
	 * Setup variables
	 */

	public Appointment() {

	}

	public Appointment(int id, String patientName, String doctorId, String location, String date, String symptomps, boolean pay) {
		this.id = id;
		this.doctorId = doctorId;
		this.date = date;
		this.location = location;
		this.patientName = patientName;
		this.symptomps = symptomps;
	}
	
	/**
	 * Constructor
	 * @param id,patient name, doctor Id, location, date, symptomps,pay
	 * 
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

	public String getDate() {
		return date;
	}
	/**
	 * @return date
	 */


	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * Set the Date
	 * @param date
	 */

	public String getPatientName() {
		return patientName;
	}
	
	/**
	 * @return patient name
	 */


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	/**
	 * Set the name of the patient
	 * @param patientName
	 */

	public Appointment get_left() {
		return _left;
	}
	/**
	 * Get the left
	 * @return _left
	 */


	public void set_left(Appointment _left) {
		this._left = _left;
	}
	
	/**
	 * Set the name of the patient
	 * @param patientName
	 */

	public Appointment get_right() {
		return _right;
	}
	/**
	 * Get the right
	 * @return _right
	 */	

	public void set_right(Appointment _right) {
		this._right = _right;
	}
	/**
	 * Set the name of the patient
	 * @param patientName
	 */

	public String getSymptomps() {
		return symptomps;
	}
	/**
	 * Get the symptomps
	 * @return symptomps
	 */

	public void setSymptomps(String symptomps) {
		this.symptomps = symptomps;
	}
	/**
	 * Set the name of the patient
	 * @param patientName
	 */

	public String getLocation() {
		return location;
	}
	/**
	 * Get the location
	 * @return location
	 */

	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * Set the name of the patient
	 * @param patientName
	 */

	public String getDoctorId() {
		return doctorId;
	}
	/**
	 * Get the doctor Id
	 * @return doctor Id
	 */

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * Set the doctor Id
	 * @param doctorId
	 * 
	 */

	public boolean isPay() {
		return pay;
	}
	/**
	 * @return pay
	 */

	public void setPay(boolean pay) {
		this.pay = pay;
	}	
	/**
	 * Set pay
	 * @param pay
	 */
}
