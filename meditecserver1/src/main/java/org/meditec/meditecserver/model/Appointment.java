package org.meditec.meditecserver.model;

public class Appointment {

	private String symptomps;
	private String date;
	private String patientName;
	private long id;
	private String location;
	private long doctorId;
	private Appointment _left;
	private Appointment _right;

	public Appointment() {

	}

	public Appointment(long id, String patientName, long doctorId, String location, String date, String symptomps) {
		this.id = id;
		this.doctorId = doctorId;
		this.date = date;
		this.location = location;
		this.patientName = patientName;
		this.symptomps = symptomps;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}	
}
