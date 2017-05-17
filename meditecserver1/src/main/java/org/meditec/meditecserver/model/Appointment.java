package org.meditec.meditecserver.model;

public class Appointment {

	private String symptomps;
	private String date;
	private String patientName;
	private int id;
	private String location;
	private long Id;
	private boolean pay;
	private Appointment _left;
	private Appointment _right;

	public Appointment() {

	}

	public Appointment(int id, String patientName, long Id, String location, String date, String symptomps, boolean pay) {
		this.id = id;
		this.Id = Id;
		this.date = date;
		this.location = location;
		this.patientName = patientName;
		this.symptomps = symptomps;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Appointment get_left() {
		return _left;
	}

	public void set_left(Appointment _left) {
		this._left = _left;
	}

	public Appointment get_right() {
		return _right;
	}

	public void set_right(Appointment _right) {
		this._right = _right;
	}

	public String getSymptomps() {
		return symptomps;
	}

	public void setSymptomps(String symptomps) {
		this.symptomps = symptomps;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getDoctorId() {
		return Id;
	}

	public void setDoctorId(long doctorId) {
		this.Id = doctorId;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}	
}
