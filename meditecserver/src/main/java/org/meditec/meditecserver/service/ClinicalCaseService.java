package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.ClinicalCase;
import org.meditec.meditecserver.trees.BinarySearchClinicalTree;

public class ClinicalCaseService {
	
	private BinarySearchClinicalTree clinicalcasetree = DataBaseClass.getClinicalCaseTree();
	
	public ClinicalCaseService() {
		
	}

	public List<ClinicalCase> getAllClinicalCase() {	
		List<ClinicalCase> lista1 = clinicalcasetree.toArray();
		List<ClinicalCase> lista2 = new ArrayList<>();				


		for (int i = 0; i < lista1.size(); i++) {
			ClinicalCase case1 = new ClinicalCase();	
			case1.setPatientName(lista1.get(i).getPatientName());
			case1.setDoctorName(lista1.get(i).getDoctorName());
			case1.setDiseases(lista1.get(i).getDiseases());
			
			lista2.add(i, case1);
		}		

		System.out.println(clinicalcasetree.getSize());
		return lista2;		
	}

	public ClinicalCase getClinicalCase(String clinicalCase) {		
		ClinicalCase find = clinicalcasetree.find(clinicalCase);	
		ClinicalCase aux = new ClinicalCase(find.getPatientName(), find.getDoctorName(), find.getDiseases());
		return aux;
	}

	public ClinicalCase addClinicalCase(ClinicalCase clinicalCase) {
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
		clinicalcasetree.delete(clinicalCase);
	}
}
