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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.meditec.meditecserver.model.MedicalTest;
import org.meditec.meditecserver.service.MedicalTestService;


@Path("medicaltestlist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MedicalTestResources {
	
	private MedicalTestService medicalTestService = new MedicalTestService();
	
	@GET
	public List<MedicalTest> getMedicalTests(@QueryParam("patientName") String filter) {
		
		if (filter != null) {
			return medicalTestService.getAllMedicalServicePerName(filter);
		}
		
		return medicalTestService.getAllMedicalTest();
	}
	
	@POST
	public MedicalTest addMedicalTest(MedicalTest medicalTest) {
		return medicalTestService.addMedicalTest(medicalTest);
	}
	
	@PUT
	@Path("{medicaltestid}")
	public MedicalTest updateMedicalTest(@PathParam("medicaltestid") String patientName, MedicalTest medicalTest) {
		medicalTest.setPatientName(patientName);
		return medicalTestService.updateMedicalTest(medicalTest);
	}
	
	@DELETE
	@Path("{medicaltestid}")
	public void deleteMedicalTest(@PathParam("medicaltestid") String patientName) {
		medicalTestService.removeMedicalTest(patientName);
	}
	
	
	@GET
	@Path("{medicaltestid}")
	public MedicalTest getProfile(@PathParam("medicaltestid") String patientName) {
		return medicalTestService.getMedicalTest(patientName);
	}

}
