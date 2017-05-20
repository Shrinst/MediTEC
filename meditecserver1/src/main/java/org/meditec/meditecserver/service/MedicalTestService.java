package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.MedicalTest;
import org.meditec.meditecserver.trees.BinarySearchMedicalTestTree;

public class MedicalTestService {
	
private BinarySearchMedicalTestTree medicaltesttree = DataBaseClass.getMedicalTestTree();
	
	public MedicalTestService() {
		
	}
	
	public List<MedicalTest> getAllMedicalTest() {	
		
		List<MedicalTest> list = getList();
		
		return list;
	}
	
	public List<MedicalTest> getAllMedicalServicePerName(String patientName) {
		List<MedicalTest> clinicalCases =  new ArrayList<>();
		List<MedicalTest> list = this.getList();
		
		for (MedicalTest medicaltest1 : list) {			
			if (medicaltest1.getPatientName().equals(patientName)) {
				clinicalCases.add(medicaltest1);
			}
		}
		
		return clinicalCases;
	}
	
	public MedicalTest getMedicalTest(String patientName) {
		MedicalTest find = medicaltesttree.find(patientName);	
		MedicalTest aux = new MedicalTest(find.getId(), find.getPatientName(), find.getDoctorName(), find.getDiseases(),
												find.getCost());
		return aux;	
	}
	
	public MedicalTest addMedicalTest(MedicalTest medicalTest) {
		medicaltesttree.insert(medicalTest.getPatientName(), medicalTest);
		return medicalTest;
	}
	
	public MedicalTest updateMedicalTest(MedicalTest medicalTest) {
		if (medicalTest.getId() == 0) {
			return null;
		}
		medicaltesttree.update(medicalTest.getPatientName(), medicalTest);
		return medicalTest;
	}
	
	public void removeMedicalTest(String  patientName) {
		medicaltesttree.delete(patientName);
	}
	
	private List<MedicalTest> getList() {
		List<MedicalTest> lista1 = medicaltesttree.toArray();
		List<MedicalTest> lista2 = new ArrayList<>();		


		for (int i = 0; i < lista1.size(); i++) {
			MedicalTest medicaltest1 = new MedicalTest();	
			medicaltest1.setId(lista1.get(i).getId());
			medicaltest1.setCost(lista1.get(i).getCost());
			medicaltest1.setPatientName(lista1.get(i).getPatientName());
			medicaltest1.setDoctorName(lista1.get(i).getDoctorName());
			medicaltest1.setDiseases(lista1.get(i).getDiseases());
			
			lista2.add(i, medicaltest1);
		}
		
		return lista2;
	}

}
