package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Medicine;
import org.meditec.meditecserver.trees.BinarySearchMedicineTree;

public class MedicineService {
	
	private BinarySearchMedicineTree medicinetree = DataBaseClass.getMedicineTree();
	
	public MedicineService() {
	
	}
	
	public List<Medicine> getAllMedicine() {
		List<Medicine> lista1 = medicinetree.toArray();
		List<Medicine> lista2 = new ArrayList<>();		


		for (int i = 0; i < lista1.size(); i++) {
			Medicine medicine1 = new Medicine();	
			medicine1.setName(lista1.get(i).getName());
			medicine1.setEffect(lista1.get(i).getEffect());
			medicine1.setSchedule(lista1.get(i).getSchedule());
			
			lista2.add(i, medicine1);
		}	
		
		System.out.println(medicinetree.getSize());

		return lista2;
	}
	
	public Medicine getMedicine(String medicine) {
		Medicine find = medicinetree.find(medicine);	
		Medicine aux = new Medicine(find.getName(), find.getEffect(), find.getSchedule());
		return aux;
	}
	
	public Medicine addMedicine(Medicine medicine) {		
		medicinetree.insert(medicine.getName(), medicine);
		return medicine;
	}
	
	public Medicine updateMedicine(Medicine medicine) {
		if (medicine.getName().isEmpty()) {
			return null;
		}
		medicinetree.update(medicine.getName(), medicine);
		return medicine;
	}
	
	public void removeMedicine(String medicine) {
		medicinetree.delete(medicine);
	}
}
