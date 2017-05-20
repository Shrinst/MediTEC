package org.meditec.meditecserver.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.trees.AVLTreeAppointment;
import org.meditec.meditecserver.trees.BinarySearchClinicalTree;
import org.meditec.meditecserver.trees.BinarySearchMedicalTestTree;
import org.meditec.meditecserver.trees.BinarySearchMedicineTree;
import org.meditec.meditecserver.trees.SplayTreeDoctor;
import org.meditec.meditecserver.lists.DiaryList;
import org.meditec.meditecserver.model.*;

public class DataBaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static SplayTreeDoctor doctorTree = new SplayTreeDoctor();
	private static AVLTreeAppointment appoinmentTree = new AVLTreeAppointment();
	private static Map<String, Client> clientlist = new HashMap<>();
	private static BinarySearchClinicalTree clinialtree = new BinarySearchClinicalTree();	
	private static BinarySearchMedicineTree medicinetree = new BinarySearchMedicineTree();
	private static BinarySearchMedicalTestTree medicaltesttree = new BinarySearchMedicalTestTree();
	private static DiaryList diarylist = new DiaryList();	
	
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static SplayTreeDoctor getProfiles() {
		return doctorTree;
	}
	
	public static AVLTreeAppointment getAppointmentTree() {
		return appoinmentTree;
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
		
//		ArrayList<MedicalTest> list = (ArrayList<MedicalTest>) XMLParser.getNodes();
//		
//		System.out.println(list == null);
//		
//		for (MedicalTest medicalTest : list) {
//			medicaltesttree.insert(medicalTest.getPatientName(), medicalTest);
//		}
		
		return medicaltesttree;
	}
	
	public static DiaryList getDiaryList() {	
		
		return diarylist;
	}		
}
