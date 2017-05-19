package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Appointment;
import org.meditec.meditecserver.trees.AVLTreeAppointment;

public class AppointmentService {
	
	private AVLTreeAppointment appointmentTree = DataBaseClass.getAppointmentTree();
	
	public AppointmentService() {

	}
	
	public List<Appointment> getAllAppoinment() {
		
		System.out.println(this.getList().size());
		return this.getList();
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
		
		List<Appointment> appointments =  new ArrayList<>();
		List<Appointment> list = this.getList();
		
		for (Appointment appointment1 : list) {			
			if (appointment1.getPatientName().equals(patientName)) {
				appointments.add(appointment1);
			}
		}
		
		System.out.println(this.getList().size());
		
		return appointments;
	}
	
	public Appointment getAppointment(int id) {
		return appointmentTree.search(id);
	}	
	
	public Appointment addAppointment(Appointment appointmentList) {		
		appointmentTree.insert(appointmentList.getId(), appointmentList.getPatientName(), appointmentList.getDoctorId(),
				appointmentList.getLocation(), appointmentList.getDate(), appointmentList.getSymptomps(), appointmentList.isPay(),
				appointmentList.isIs_Active());
		return appointmentList;
	}
	
	public Appointment updateAppointment(Appointment appointmentList) {
		if (appointmentList.getPatientName().isEmpty()) {
			return null;
		}
		Appointment appointment = appointmentTree.search(appointmentList.getId());
		appointment.setPatientName(appointmentList.getPatientName());
		appointment.setDoctorId(appointmentList.getDoctorId());
		appointment.setLocation(appointmentList.getLocation());
		appointment.setDate(appointmentList.getDate());
		appointment.setSymptomps(appointmentList.getSymptomps());
		appointment.setPay(appointmentList.isPay());
		appointment.setIs_Active(appointmentList.isIs_Active());
		appointmentTree.update(appointmentList.getId(), appointmentList);
		return appointmentList;
	}		
	
	private List<Appointment> getList() {
		List<Appointment> lista1 = appointmentTree.toArray();
		List<Appointment> lista2 = new ArrayList<>();				


		for (int i = 0; i < lista1.size(); i++) {
			Appointment appointment1 = new Appointment();	
			appointment1.setId(lista1.get(i).getId());
			appointment1.setPatientName(lista1.get(i).getPatientName());
			appointment1.setDoctorId(lista1.get(i).getDoctorId());
			appointment1.setLocation(lista1.get(i).getLocation());
			appointment1.setDate(lista1.get(i).getDate());
			appointment1.setSymptomps(lista1.get(i).getSymptomps());
			appointment1.setPay(lista1.get(i).isPay());
			appointment1.setIs_Active(lista1.get(i).isIs_Active());
			
			lista2.add(i, appointment1);
		}	
		
		return lista2;
	}
}
