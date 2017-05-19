package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Appointment;

public class AppointmentService {
	
	private Map<Integer, Appointment> appointment = DataBaseClass.getAppoinmentList();
	
	public AppointmentService() {
		appointment.put(1, new Appointment(1, "Daniela", "1212AX", "Cartago", "21/4/2018", "Hola!Hola", false));
		appointment.put(2, new Appointment(2, "Gabriel", "1A313", "Cartago", "21/3/2018", "Adios!Adios", false));
		appointment.put(2, new Appointment(2, "Gabriela", "13ew14", "Cartago", "22/3/2018", "Adios!Adios", false));
	}
	
	public List<Appointment> getAllAppoinment() {
		return new ArrayList<Appointment>(appointment.values());
	}
	
//	public List<Appointment> getAllAppointmentPerID(int id) {
//		List<Appointment> appointmentID =  new ArrayList<>();
//		
//		for (Appointment appointment : this.appointment.values()) {			
//			if (appointment.getId() == id) {
//				appointmentID.add(appointment);
//			}
//		}
//		
//		return appointmentID;
//	}
	
	public List<Appointment> getAllAppointmentPerPatient(String patientName) {
		List<Appointment> appointmentPatientName =  new ArrayList<>();
		
		for (Appointment appointment : this.appointment.values()) {			
			if (appointment.getPatientName().equals(patientName)) {
				appointmentPatientName.add(appointment);
			}
		}
		
		return appointmentPatientName;
	}
	
	public Appointment getAppointment(int id) {
		return appointment.get(id);
	}	
	
	public Appointment addAppointment(Appointment appointmentList) {		
		appointment.put(appointmentList.getId(), appointmentList);
		return appointmentList;
	}
	
	public Appointment updateAppointment(Appointment appointmentList) {
		if (appointmentList.getPatientName().isEmpty()) {
			return null;
		}
		appointment.put(appointmentList.getId(), appointmentList);
		return appointmentList;
	}
	
	public void updateAppointmentPay(int id) {
		for (Appointment appointment : this.appointment.values()) {
			if (appointment.getId() == id) {
				appointment.setPay(true);
				break;
			}
		}		
	}
	
	public Appointment removeAppointment(int appointmentName) {
		return appointment.remove(appointmentName);
	}
}
