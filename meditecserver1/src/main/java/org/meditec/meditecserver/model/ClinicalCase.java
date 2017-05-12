package org.meditec.meditecserver.model;

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

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getMedicalTest() {
		return medicalTestLink;
	}

	public void setMedicalTest(String doctorName) {
		this.medicalTestLink = doctorName;
	}

	public String getMedicine() {
		return medicineLink;
	}

	public void setMedicine(String diseases) {
		this.medicineLink = diseases;
	}

	public ClinicalCase get_left() {
		return _left;
	}

	public void set_left(ClinicalCase _left) {
		this._left = _left;
	}

	public ClinicalCase get_right() {
		return _right;
	}

	public void set_right(ClinicalCase _right) {
		this._right = _right;
	}
	
	public int compareTo(ClinicalCase clinicalCase) {
		return this.getPatientName().compareTo(clinicalCase.getPatientName());
	}
}
