package org.meditec.meditecserver.model;

public class ClinicalCase {
	
	private String patientName;
	private String doctorName;
	private String diseases;
	private ClinicalCase _left;
	private ClinicalCase _right;
	// Lista medicamentos
	// citas
	
	public ClinicalCase() {
		
	}
	
	public ClinicalCase(String patientName, String doctorName, String diseases) {
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.diseases = diseases;
		this._left = null;
		this._right = null;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDiseases() {
		return diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
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
