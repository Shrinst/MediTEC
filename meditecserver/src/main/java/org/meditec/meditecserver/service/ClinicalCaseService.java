package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.ClinicalCase;
import org.meditec.meditecserver.trees.BinarySearchTree;

public class ClinicalCaseService {

	// private Map<String, ClinicalCase> clinicalcaselist =
	// DataBaseClass.getClinicalCaseList();
	private BinarySearchTree clinicalcasetree = DataBaseClass.getClinicalCaseTree();
	private List<ClinicalCase> clinicalCaseList = this.parseTree();

	public ClinicalCaseService() {
		clinicalcasetree.insert("Gabriela", new ClinicalCase("Gabriela", "Alejandra", "Gripa"));
		clinicalcasetree.insert("Gabriel", new ClinicalCase("Gabriel", "Alejandro", "Gripe"));
		clinicalcasetree.insert("Gabi", new ClinicalCase("Gabi", "Alejo", "Gri"));
		clinicalcasetree.insert("Ga", new ClinicalCase("Ga", "Ale", "Ge"));
	}

	public List<ClinicalCase> getAllClinicalCase() {	
		List<ClinicalCase> lista1 = clinicalcasetree.toArray();
		List<ClinicalCase> lista2 = new ArrayList<>();

		for (int i = 0; i < lista1.size(); i++) {
			String[] data = { lista1.get(i).getPatientName(), lista1.get(i).getDoctorName(),
					lista1.get(i).getDiseases() };
			lista2.add(new ClinicalCase(data[0], data[1], data[2]));
		}

		System.out.println(clinicalcasetree.toArray().size());

		return lista2;
	}

	public ClinicalCase getClinicalCase(String clinicalCase) {
		System.out.println(clinicalCase);
		System.out.println(clinicalCase.length());
		String hola = "";
		for (int i = 0; i < clinicalCase.length(); i++) {
			hola.concat(clinicalCase).charAt(i);
		}
		System.out.println(hola + "1");
		ClinicalCase find = clinicalcasetree.find("Gabi");
		System.out.println("Gabi".length());
		System.out.println(find == null);
		System.out.println(clinicalCase == null);
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

	private List<ClinicalCase> parseTree() {
		List<ClinicalCase> lista1 = clinicalcasetree.toArray();
		List<ClinicalCase> lista2 = new ArrayList<>();

		for (int i = 0; i < lista1.size(); i++) {
			String[] data = { lista1.get(i).getPatientName(), lista1.get(i).getDoctorName(),
					lista1.get(i).getDiseases() };
			lista2.add(new ClinicalCase(data[0], data[1], data[2]));
		}

		return lista2;
	}

	public void removeClinicalCase(String clinicalCase) {
		clinicalcasetree.delete(clinicalCase);
	}
}
