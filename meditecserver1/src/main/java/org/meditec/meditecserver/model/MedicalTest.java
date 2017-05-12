package org.meditec.meditecserver.model;

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
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	public MedicalTest get_left() {
		return _left;
	}

	public void set_left(MedicalTest _left) {
		this._left = _left;
	}

	public MedicalTest get_right() {
		return _right;
	}

	public void set_right(MedicalTest _right) {
		this._right = _right;
	}
}
