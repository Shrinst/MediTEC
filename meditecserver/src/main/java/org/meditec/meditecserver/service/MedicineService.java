package org.meditec.meditecserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.meditec.meditecserver.database.DataBaseClass;
import org.meditec.meditecserver.model.Medicine;

public class MedicineService {
	
	private Map<String, Medicine> medicinelist = DataBaseClass.getMedicineList();
	
	public MedicineService() {
		medicinelist.put("Aspirina", new Medicine("Aspirina", "No sé", "1 vez al día"));
		medicinelist.put("Pronol", new Medicine("Pronol", "No sé", "2 veces al día"));
	}
	
	public List<Medicine> getAllMedicine() {
		return new ArrayList<Medicine>(medicinelist.values());
	}
	
	public Medicine getMedicine(String medicine) {
		return medicinelist.get(medicine);
	}
	
	public Medicine addMedicine(Medicine medicine) {		
		medicinelist.put(medicine.getName(), medicine);
		return medicine;
	}
	
	public Medicine updateMedicine(Medicine medicine) {
		if (medicine.getName().isEmpty()) {
			return null;
		}
		medicinelist.put(medicine.getName(), medicine);
		return medicine;
	}
	
	public Medicine removeMedicine(String medicine) {
		return medicinelist.remove(medicine);
	}
}
