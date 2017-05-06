package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Appointment;

public class AppointmentService {
	
	private Map<String, Appointment> appointment = DataBaseClass.getAppoinmentList();
	
	public AppointmentService() {
		appointment.put("Daniela", new Appointment(1L, "Daniela", "Alejandro", "21/4/2018"));
		appointment.put("Gabriel", new Appointment(2L, "Gabriel", "Alejandro", "21/3/2018"));
	}
	
	public List<Appointment> getAllAppoinment() {
		return new ArrayList<Appointment>(appointment.values());
	}
	
	public Appointment getAppointment(String patientName) {
		return appointment.get(patientName);
	}
	
	public Appointment addAppointment(Appointment appointmentList) {
		appointmentList.setId(appointment.size() + 1);
		appointment.put(appointmentList.getPatientName(), appointmentList);
		return appointmentList;
	}
	
	public Appointment updateAppointment(Appointment appointmentList) {
		if (appointmentList.getPatientName().isEmpty()) {
			return null;
		}
		appointment.put(appointmentList.getPatientName(), appointmentList);
		return appointmentList;
	}
	
	public Appointment removeAppointment(String appointmentName) {
		return appointment.remove(appointmentName);
	}
}
