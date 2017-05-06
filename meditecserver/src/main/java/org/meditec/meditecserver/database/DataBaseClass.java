package org.meditec.meditecserver.database;

import java.util.HashMap;
import java.util.Map;

import org.meditec.meditecserver.model.Message;
import org.meditec.meditecserver.trees.BinarySearchTree;
import org.meditec.meditecserver.model.Appointment;
import org.meditec.meditecserver.model.Client;
import org.meditec.meditecserver.model.ClinicalCase;
import org.meditec.meditecserver.model.Diary;
import org.meditec.meditecserver.model.Doctor;
import org.meditec.meditecserver.model.Medicine;

public class DataBaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Doctor> profiles = new HashMap<>();
	private static Map<String, Appointment> appoinmentlist = new HashMap<>();
	private static Map<String, Client> clientlist = new HashMap<>();
//	private static Map<String, ClinicalCase> clinicalcaselist = new HashMap<>();
	private static BinarySearchTree clinialtree = new BinarySearchTree();
	private static Map<String, Medicine> medicinelist = new HashMap<>();
	private static Map<String, Diary> diarylist = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Doctor> getProfiles() {
		return profiles;
	}
	
	public static Map<String, Appointment> getAppoinmentList() {
		return appoinmentlist;
	}
	
	public static Map<String, Client> getClientList() {
		return clientlist;
	}
	
//	public static Map<String, ClinicalCase> getClinicalCaseList() {
//		return clinicalcaselist;
//	}
	
	public static Map<String, Medicine> getMedicineList() {
		return medicinelist;
	}
	
	public static Map<String, Diary> getDiaryList() {
		return diarylist;
	}
	
	public static BinarySearchTree getClinicalCaseTree() {
		return clinialtree;		
	}
}
