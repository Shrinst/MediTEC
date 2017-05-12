package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.ClinicalCase;
import org.meditec.meditecserver.model.MedicalTest;
import org.meditec.meditecserver.model.Medicine;
import org.meditec.meditecserver.trees.BinarySearchClinicalTree;
import org.meditec.meditecserver.trees.BinarySearchMedicalTestTree;
import org.meditec.meditecserver.trees.BinarySearchMedicineTree;

public class ClinicalCaseService {
	
	private BinarySearchClinicalTree clinicalcasetree = DataBaseClass.getClinicalCaseTree();
	private BinarySearchMedicalTestTree medicaltesttree = DataBaseClass.getMedicalTestTree();
	private BinarySearchMedicineTree  medicinetree = DataBaseClass.getMedicineTree();
	
	public ClinicalCaseService() {
		
	}

	public List<ClinicalCase> getAllClinicalCase() {	
			
		List<ClinicalCase> list = this.getList();
		
		return list;		
	}
	
	public List<ClinicalCase> getAllClinicalCasePerPatient(String patientName) {
		List<ClinicalCase> clinicalCases =  new ArrayList<>();
		List<ClinicalCase> list = this.getList();
		
		for (ClinicalCase case1 : list) {			
			if (case1.getPatientName().equals(patientName)) {
				clinicalCases.add(case1);
			}
		}
		
		return clinicalCases;
	}

	public ClinicalCase getClinicalCase(String clinicalCase) {		
		ClinicalCase find = clinicalcasetree.find(clinicalCase);	
		ClinicalCase aux = new ClinicalCase(find.getPatientName(), find.getMedicalTest(), find.getMedicine());
		return aux;
	}

	public ClinicalCase addClinicalCase(ClinicalCase clinicalCase) {
		
		Medicine medicine = new Medicine(clinicalCase.getPatientName(), "No asignado", 0, "No asignado", "No asignado");
		MedicalTest medicalTest = new MedicalTest(0, clinicalCase.getPatientName(), "No asignado", "No asignado", 0);
		
		medicinetree.insert(medicine.getPatient(), medicine);
		medicaltesttree.insert(medicalTest.getPatientName(), medicalTest);
		
		clinicalCase.setMedicalTest("http://localhost:8080/meditecserver/webapi/medicaltestlist?patientName=" + 
				medicalTest.getPatientName());
		clinicalCase.setMedicine("http://localhost:8080/meditecserver/webapi/medicinelist?patientName=" + 
				medicalTest.getPatientName());
		
		clinicalcasetree.insert(clinicalCase.getPatientName(), clinicalCase);		
		return clinicalCase;
	}

	public ClinicalCase updateClinicalCase(ClinicalCase clinicalCase) {
		if (clinicalCase.getPatientName().isEmpty()) {
			return null;
		}
		clinicalcasetree.update(clinicalCase.getPatientName(), clinicalCase);
		return clinicalCase;
	}
	

	public void removeClinicalCase(String clinicalCase) {
		medicaltesttree.delete(clinicalCase);
		medicinetree.delete(clinicalCase);
		clinicalcasetree.delete(clinicalCase);
	}
	
	private List<ClinicalCase> getList() {
		List<ClinicalCase> lista1 = clinicalcasetree.toArray();
		List<ClinicalCase> lista2 = new ArrayList<>();				


		for (int i = 0; i < lista1.size(); i++) {
			ClinicalCase case1 = new ClinicalCase();	
			case1.setPatientName(lista1.get(i).getPatientName());
			case1.setMedicalTest(lista1.get(i).getMedicalTest());
			case1.setMedicine(lista1.get(i).getMedicine());
			
			lista2.add(i, case1);
		}	
		
		return lista2;
	}
}
