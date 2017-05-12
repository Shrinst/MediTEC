package org.meditec.meditecserver.model;

public class Medicine {
	
	private String patient;
	private String name;
	private long cost;
	private String effect;
	private String schedule;
	private Medicine _left;
	private Medicine _right;
	
	public Medicine() {
		
	}
	
	public Medicine(String patient, String name, long cost, String effect, String schedule) {
		this.patient = patient;
		this.name = name;
		this.cost = cost;
		this.effect = effect;
		this.schedule = schedule;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Medicine get_left() {
		return _left;
	}

	public void set_left(Medicine _left) {
		this._left = _left;
	}

	public Medicine get_right() {
		return _right;
	}

	public void set_right(Medicine _right) {
		this._right = _right;
	}
}
