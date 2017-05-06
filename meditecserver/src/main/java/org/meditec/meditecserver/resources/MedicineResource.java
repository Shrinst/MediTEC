package org.meditec.meditecserver.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.meditec.meditecserver.model.Medicine;
import org.meditec.meditecserver.service.MedicineService;

@Path("medicinelist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MedicineResource {
	
	private MedicineService medicineService = new MedicineService();
	
	@GET
	public List<Medicine> getMedicines() {
		return medicineService.getAllMedicine();
	}
	
	@POST
	public Medicine addMedicine(Medicine medicine) {
		return medicineService.addMedicine(medicine);
	}
	
	@PUT
	@Path("{medicine}")
	public Medicine updateMedicine(@PathParam("medicine") String medicineName, Medicine medicine) {
		medicine.setName(medicineName);
		return medicineService.updateMedicine(medicine);
	}
	
	@DELETE
	@Path("{medicine}")
	public void deleteMedicine(@PathParam("medicine") String medicineName) {
		medicineService.removeMedicine(medicineName);
	}
	
	
	@GET
	@Path("{medicine}")
	public Medicine getMedicine(@PathParam("medicine") String medicineName) {
		return medicineService.getMedicine(medicineName);
	}
}
