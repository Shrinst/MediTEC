package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Appointment;

public class AppointmentService {
	
	private Map<String, Appointment> appointment = DataBaseClass.getAppoinmentList();
	
	public AppointmentService() {
		appointment.put("Daniela", new Appointment(1L, "Daniela", 1212, "Cartago", "21/4/2018", "Hola!Hola"));
		appointment.put("Gabriel", new Appointment(2L, "Gabriel", 1313, "Cartago", "21/3/2018", "Adios!Adios"));
		appointment.put("Gabriel", new Appointment(2L, "Gabriela", 1314, "Cartago", "22/3/2018", "Adios!Adios"));
	}
	
	public List<Appointment> getAllAppoinment() {
		return new ArrayList<Appointment>(appointment.values());
	}
	
	public List<Appointment> getAllAppointmentPerID(int id) {
		List<Appointment> appointmentID =  new ArrayList<>();
		
		for (Appointment appointment : this.appointment.values()) {			
			if (appointment.getId() == id) {
				appointmentID.add(appointment);
			}
		}
		
		return appointmentID;
	}
	
	public Appointment getAppointment(String patientName) {
		return appointment.get(patientName);
	}
	
	public Appointment addAppointment(Appointment appointmentList) {		
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
