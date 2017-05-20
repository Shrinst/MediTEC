package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Medicine;
import org.meditec.meditecserver.trees.BinarySearchMedicineTree;

public class MedicineService {
	
	private BinarySearchMedicineTree medicinetree = DataBaseClass.getMedicineTree();
	
	/**
	 * Constructor
	 */
	public MedicineService() {
	
	}
	/**
	 * 
	 * @return lista de medicinas
	 */
	public List<Medicine> getAllMedicine() {
		
		List<Medicine> list = getList();
				
		return list;
	}
	
	/**
	 * Obtiene todas las medicionas por nombre
	 * @param medicineName
	 * @return lista de medicinas
	 */
	public List<Medicine> getAllMedicinePerName(String medicineName) {
		List<Medicine> medicineList =  new ArrayList<>();
		List<Medicine> list = this.getList();
		
		for (Medicine medicine : list) {			
			if (medicine.getPatient().equals(medicineName)) {
				medicineList.add(medicine);
			}
		}
		
		return medicineList;
	}
	
	/**
	 * 
	 * @param medicine
	 * @return specific medicine
	 */
	public Medicine getMedicine(String medicine) {
		Medicine find = medicinetree.find(medicine);	
		Medicine aux = new Medicine(find.getPatient(), find.getName(), find.getCost(), find.getEffect(), find.getSchedule());
		return aux;
	}
	
	/**
	 * Adds a medicine
	 * @param medicine
	 * @return new medicine
	 */
	public Medicine addMedicine(Medicine medicine) {		
		medicinetree.insert(medicine.getPatient(), medicine);
		return medicine;
	}
	
	/**
	 * Updates medicine
	 * @param medicine
	 * @return medicine updated
	 */
	public Medicine updateMedicine(Medicine medicine) {
		if (medicine.getPatient().isEmpty()) {
			return null;
		}
		medicinetree.update(medicine.getPatient(), medicine);
		return medicine;
	}
	
	/**
	 * Removes medicine
	 * @param medicine
	 */
	public void removeMedicine(String medicine) {
		medicinetree.delete(medicine);
	}
	
	/**
	 * gets list of medicine
	 * @return list of medicine
	 */
	private List<Medicine> getList() {
		List<Medicine> lista1 = medicinetree.toArray();
		List<Medicine> lista2 = new ArrayList<>();		


		for (int i = 0; i < lista1.size(); i++) {
			Medicine medicine1 = new Medicine();
			medicine1.setPatient(lista1.get(i).getPatient());
			medicine1.setName(lista1.get(i).getName());
			medicine1.setCost(lista1.get(i).getCost());
			medicine1.setEffect(lista1.get(i).getEffect());
			medicine1.setSchedule(lista1.get(i).getSchedule());
			
			lista2.add(i, medicine1);
		}
		
		return lista2;
	}
}
