package org.meditec.meditecserver.model;

public class Appointment {

	private long id;
	private String author;
	private String date;
	private String patientName;
	private Appointment _left;
	private Appointment _right;

	public Appointment() {

	}

	public Appointment(long id, String patientName, String author, String date) {
		this.id = id;
		this.author = author;
		this.date = date;
		this.patientName = patientName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
}
