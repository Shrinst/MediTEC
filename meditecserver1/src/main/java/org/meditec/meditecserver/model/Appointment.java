package org.meditec.meditecserver.model;


public class Appointment{

	private String symptomps;
	private String date;
	private String patientName;
	private int id;
	private String location;
	private String doctorId;
	private boolean pay;
	private boolean is_Active;
	private Appointment _left;
	private Appointment _right;
	private int _depth;
	
	public Appointment() {
		
	}
	

	public Appointment(String patientName, Appointment left, Appointment right, int id , String doctorId,
			String location, String date, String symptomps, boolean pay, boolean is_Active) {
		this.id = id;
		this.doctorId = doctorId;
		this.date = date;
		this.location = location;
		this.patientName = patientName;
		this.symptomps = symptomps;
		this._left = left;
		this._right = right;
		this.pay = pay;
		this.is_Active = is_Active;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}

	public boolean isIs_Active() {
		return is_Active;
	}

	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
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

	public Appointment getLeft() {
		return _left;
	}

	public void setLeft(Appointment left) {
		_left = left;
	}

	public Appointment getRight() {
		return _right;
	}

	public void setRight(Appointment right) {
		_right = right;
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

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}	
	
	public int getDepth() {
		return _depth;
	}

	
	public void setDepth(int depth) {
		_depth = depth;
	}
	
}
