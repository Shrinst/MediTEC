package org.meditec.meditecserver.model;

public class MedicalTest {	
	
	private String patientName;	
	private long cost;	
	private String  type;
	private String result;
	private MedicalTest _left;
	private MedicalTest _right;
	
	public MedicalTest() {
		
	}
	
	public MedicalTest(String patientName, String type, String result, long cost) {		
		this.patientName = patientName;
		this.type = type;
		this.result = result;
		this.cost = cost;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
