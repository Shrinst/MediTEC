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

import org.meditec.meditecserver.model.ClinicalCase;
import org.meditec.meditecserver.service.ClinicalCaseService;

@Path("clinicalcaselist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClinicalCaseResource {
	
	private ClinicalCaseService clinicalCaseService = new ClinicalCaseService();
	
	@GET
	public List<ClinicalCase> getClinicalCases(@QueryParam("patientName") String filterBean) {
		
		if (filterBean != null) {
			return clinicalCaseService.getAllClinicalCasePerPatient(filterBean);
		}
		
		return clinicalCaseService.getAllClinicalCase();
	}
	
	@POST
	public ClinicalCase addClinicalCase(ClinicalCase clinicalCase) {
		return clinicalCaseService.addClinicalCase(clinicalCase);
	}
	
	@PUT
	@Path("{clinicalCase}")
	public ClinicalCase updateClinicalCase(@PathParam("clinicalCase") String patientName, ClinicalCase clinicalCase) {
		clinicalCase.setPatientName(patientName);
		return clinicalCaseService.updateClinicalCase(clinicalCase);
	}
	
	@DELETE
	@Path("{clinicalCase}")
	public void deleteClinicalCase(@PathParam("clinicalCase") String patientName) {
		clinicalCaseService.removeClinicalCase(patientName);
	}
	
	
	@GET
	@Path("{clinicalCase}")
	public ClinicalCase getClinicalCase(@PathParam("clinicalCase") String patientName) {
		return clinicalCaseService.getClinicalCase(patientName);
	}
}
