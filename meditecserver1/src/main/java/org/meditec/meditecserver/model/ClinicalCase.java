package org.meditec.meditecserver.model;

/**
 * 
 * @author David
 *
 */

public class ClinicalCase {
	
	private String patientName;
	private String medicalTestLink;
	private String medicineLink;	
	private ClinicalCase _left;
	private ClinicalCase _right;
	// Lista medicamentos
	// citas
	
	public ClinicalCase() {
		
	}
	
	public ClinicalCase(String patientName, String medicalTest, String medicine) {
		this.patientName = patientName;
		this.medicalTestLink = medicalTest;
		this.medicineLink = medicine;
		this._left = null;
		this._right = null;
	}
	/**
	 * Constructor
	 * @param patientName, medicalTest, medicine
	 * 
	 */

	public String getPatientName() {
		return patientName;
	}
	/**
	 * @return patientName
	 */


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * Set the ClientName
	 * @param clientName
	 */

	public String getMedicalTest() {
		return medicalTestLink;
	}
	/**
	 * @return medicalTestLink
	 */


	public void setMedicalTest(String doctorName) {
		this.medicalTestLink = doctorName;
	}
	/**
	 * Set the ClientName
	 * @param clientName
	 */

	public String getMedicine() {
		return medicineLink;
	}
	/**
	 * @return medicineLink
	 */


	public void setMedicine(String diseases) {
		this.medicineLink = diseases;
	}
	/**
	 * Set Medicine
	 * @param diseases
	 */

	public ClinicalCase get_left() {
		return _left;
	}
	/**
	 * @return _left
	 */


	public void set_left(ClinicalCase _left) {
		this._left = _left;
	}
	/**
	 * Set the ClientName
	 * @param clientName
	 */

	public ClinicalCase get_right() {
		return _right;
	}
	/**
	 * @return _right
	 */


	public void set_right(ClinicalCase _right) {
		this._right = _right;
	}
	/**
	 * Set the right clinical case
	 * @param _right
	 */
	
	public int compareTo(ClinicalCase clinicalCase) {
		return this.getPatientName().compareTo(clinicalCase.getPatientName());
	}
	/**
	 * Compares the clinical case
	 * @return -1,0,1
	 */

}
