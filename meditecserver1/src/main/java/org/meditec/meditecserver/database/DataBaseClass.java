package org.meditec.meditecserver.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.meditec.meditecserver.model.Message;
import org.meditec.meditecserver.trees.BinarySearchClinicalTree;
import org.meditec.meditecserver.trees.BinarySearchMedicalTestTree;
import org.meditec.meditecserver.trees.BinarySearchMedicineTree;
import org.meditec.meditecserver.model.Appointment;
import org.meditec.meditecserver.model.Client;
import org.meditec.meditecserver.model.Diary;
import org.meditec.meditecserver.model.Doctor;

public class DataBaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Doctor> profiles = new HashMap<>();
	private static Map<Integer, Appointment> appoinmentlist = new HashMap<>();
	private static Map<String, Client> clientlist = new HashMap<>();
	private static BinarySearchClinicalTree clinialtree = new BinarySearchClinicalTree();	
	private static BinarySearchMedicineTree medicinetree = new BinarySearchMedicineTree();
	private static BinarySearchMedicalTestTree medicaltesttree = new BinarySearchMedicalTestTree();
	private static ArrayList<Diary> diarylist = new ArrayList<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Doctor> getProfiles() {
		return profiles;
	}
	
	public static Map<Integer, Appointment> getAppoinmentList() {
		return appoinmentlist;
	}
	
	public static Map<String, Client> getClientList() {
		return clientlist;
	}	
	
	public static BinarySearchClinicalTree getClinicalCaseTree() {
		return clinialtree;		
	}
	
	public static BinarySearchMedicineTree getMedicineTree() {
		return medicinetree;
	}
	
	public static BinarySearchMedicalTestTree getMedicalTestTree() {
		return medicaltesttree;
	}
	
	public static ArrayList<Diary> getDiaryList() {
		return diarylist;
	}		
}
