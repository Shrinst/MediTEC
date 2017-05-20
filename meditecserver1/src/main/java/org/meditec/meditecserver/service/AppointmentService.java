package org.meditec.meditecserver.service;

/**
 * 
 * @author Emmanuelle, Alejandro
 *
 */

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
	/**
	 * Constructor
	 * 
	 */
	
	public List<Appointment> getAllAppoinment() {
		return new ArrayList<Appointment>(appointment.values());
	}
	/**
	 * Get all the appointments
	 * @return ArrayList<Appointment>
	 * 
	 */
	
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
	/**
	 * Search  all the appointments by patient
	 * @param patientName
	 * @return appointmentPatientName
	 * 
	 */
	
	public Appointment getAppointment(int id) {
		return appointment.get(id);
	}
	/**
	 * Search  all the appointments by patient
	 * @param id
	 * @return id
	 * 
	 */
	
	
	public Appointment addAppointment(Appointment appointmentList) {		
		appointment.put(appointmentList.getId(), appointmentList);
		return appointmentList;
	}
	/**
	 * Add the appointments to a list
	 * @param appointmentList
	 * @return appointmentList
	 * 
	 */
	
	public Appointment updateAppointment(Appointment appointmentList) {
		if (appointmentList.getPatientName().isEmpty()) {
			return null;
		}
		appointment.put(appointmentList.getId(), appointmentList);
		return appointmentList;
	}
	/**
	 * Refresh the appointments
	 * @param appointmentList
	 * @return appointmentList
	 * 
	 */
	
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
	/**
	 * Remove an appointment from the list
	 * @param appointmentName
	 * @return appointment
	 * 
	 */
}
