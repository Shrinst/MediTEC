package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Doctor;

public class DoctorService {
	
	private Map<String, Doctor> profiles = DataBaseClass.getProfiles();
	
	public DoctorService() {
		profiles.put("TOBE", new Doctor(1L, "TOBE", "Sebastian", "Aguilar"));
	}
	
	public List<Doctor> getAllProfiles() {		
		return new ArrayList<Doctor>(profiles.values());
	}
	
	public Doctor getProfile(String profileName) {
		return profiles.get(profileName);	
	}
	
	public Doctor addProfile(Doctor profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Doctor updateProfile(Doctor profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Doctor removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
