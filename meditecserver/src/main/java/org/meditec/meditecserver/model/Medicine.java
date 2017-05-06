package org.meditec.meditecserver.model;

public class Medicine {
	
	private String name;
	private String effect;
	private String schedule;
	
	public Medicine() {
		
	}
	
	public Medicine(String name, String effect, String schedule) {
		this.name = name;
		this.effect = effect;
		this.schedule = schedule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
