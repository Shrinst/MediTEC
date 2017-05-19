package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Doctor;
import org.meditec.meditecserver.trees.SplayTreeDoctor;

public class DoctorService {
	
	private SplayTreeDoctor doctortree = DataBaseClass.getProfiles();
	
	public DoctorService() {
		
	}
	
	public List<Doctor> getAllProfiles() {		
		return this.getList();
	}
	
//	public List<Doctor> getAllDoctorPerID(String id) {
//		List<Doctor> doctorList =  new ArrayList<>();
//		
//		for (Doctor doctor : this.doctortree.values()) {			
//			if (doctor.getId().equals(id)) {
//				doctorList.add(doctor);
//			}
//		}
//		
//		return doctorList;
//	}
	
	public Doctor getProfile(String id) {
		Doctor doctor = doctortree.find(id);
		
		Doctor doctor2 = new Doctor(doctor.getId(), doctor.getProfileName(), doctor.getPoints());
		
		return doctor2;	
	}
	
	public Doctor addProfile(Doctor profile) {
		doctortree.insert(profile.getId(), profile.getProfileName(), profile.getPoints());
		return profile;
	}
	
	public Doctor updateProfile(Doctor profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		doctortree.update(profile.getId(), profile);
		return profile;
	}
	
	public void removeProfile(String id) {
		doctortree.remove(id);
	}
	
	private List<Doctor> getList() {
		List<Doctor> lista1 = doctortree.toArray();
		List<Doctor> lista2 = new ArrayList<>();				


		for (int i = 0; i < lista1.size(); i++) {
			Doctor doctor1 = new Doctor();	
			doctor1.setId(lista1.get(i).getId());
			doctor1.setProfileName((lista1.get(i).getProfileName()));
			doctor1.setPoints(lista1.get(i).getPoints());
			
			lista2.add(i, doctor1);
		}	
		
		return lista2;
	}
}
