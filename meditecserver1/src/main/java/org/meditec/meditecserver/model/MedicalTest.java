package org.meditec.meditecserver.model;

/**
 * 
 * @author Alejandro
 *
 */

public class MedicalTest {	
	
	private String patientName;
	private long id;
	private long cost;
	private String doctorName;
	private String diseases;
	private MedicalTest _left;
	private MedicalTest _right;
	
	public MedicalTest() {
		
	}
	
	public MedicalTest(long id, String patientName, String doctorName, String diseases, long cost) {
		this.id = id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.diseases = diseases;
		this.cost = cost;
	}
	/**
	 * Constructor
	 * @param id, patientName, doctorName, diseases, cost
	 * 
	 */
	
	
	public String getPatientName() {
		return patientName;
	}
	/**
	 * Get the patient name
	 * @return patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * Set the patient name
	 * @param patientName
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
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * Get the doctorName
	 * @return doctorName
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * Set the doctorName
	 * @param doctorName
	 */
	public String getDiseases() {
		return diseases;
	}
	/**
	 * Get diseases
	 * @return diseases
	 */
	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}
	/**
	 * Set the diseases
	 * @param diseases
	 */

	public MedicalTest get_left() {
		return _left;
	}
	/**
	 * Get the left MedicalTest
	 * @return _left
	 */

	public void set_left(MedicalTest _left) {
		this._left = _left;
	}
	/**
	 * Set the left MedicalTest
	 * @param _left
	 */

	public MedicalTest get_right() {
		return _right;
	}
	/**
	 * Get the right Medical Test
	 * @return _right
	 */

	public void set_right(MedicalTest _right) {
		this._right = _right;
	}
	/**
	 * Set the right MedicalTest
	 * @param _right
	 */
}
