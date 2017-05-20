package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.XMLHandler;
import org.meditec.meditecserver.database.XMLParser;
import org.meditec.meditecserver.model.ClinicalCase;
import org.meditec.meditecserver.model.MedicalTest;
import org.meditec.meditecserver.trees.BinarySearchClinicalTree;
import org.meditec.meditecserver.trees.SplayTreeDoctor;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<MedicalTest> medicalTest = (ArrayList<MedicalTest>) XMLParser.getNodes();
		ArrayList<MedicalTest> list = new ArrayList<>();
		
		list.add(new MedicalTest("Alejandro", "Gripe", "Good", 10));
		list.add(new MedicalTest("Daniel", "Gripe", "Good", 10));
		
		//XMLHandler.writeXML(list);
		
		for (MedicalTest test : medicalTest) {
			System.out.println(test.getPatientName());
		}
		
	}
}
