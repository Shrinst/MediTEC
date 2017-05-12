package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Doctor;

public class DoctorService {
	
	private Map<Long, Doctor> profiles = DataBaseClass.getProfiles();
	
	public DoctorService() {
		profiles.put(1212L, new Doctor(1212, "TOBE", 0));
	}
	
	public List<Doctor> getAllProfiles() {		
		return new ArrayList<Doctor>(profiles.values());
	}
	
	public List<Doctor> getAllDoctorPerID(long id) {
		List<Doctor> doctorList =  new ArrayList<>();
		
		for (Doctor doctor : this.profiles.values()) {			
			if (doctor.getId() == id) {
				doctorList.add(doctor);
			}
		}
		
		return doctorList;
	}
	
	public Doctor getProfile(long id) {
		return profiles.get(id);	
	}
	
	public Doctor addProfile(Doctor profile) {
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	public Doctor updateProfile(Doctor profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	public Doctor removeProfile(long id) {
		return profiles.remove(id);
	}
}
