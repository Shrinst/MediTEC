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

import org.meditec.meditecserver.service.DoctorService;
import org.meditec.meditecserver.model.Doctor;

@Path("doctorlist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorResource {
	
	private DoctorService profileService = new DoctorService();
	
	@GET
	public List<Doctor> getProfiles(@QueryParam("id") int filter) {
		
		if (filter > 0) {
			return profileService.getAllDoctorPerID(filter);
		}
		
		return profileService.getAllProfiles();
	}
	
	@POST
	public Doctor addProfile(Doctor profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("{profileName}")
	public Doctor updateProfile(@PathParam("profileName") long id, Doctor profile) {
		profile.setId(id);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("{profileName}")
	public void deleteProfile(@PathParam("profileName") long id) {
		profileService.removeProfile(id);
	}
	
	
	@GET
	@Path("{profileName}")
	public Doctor getProfile(@PathParam("profileName") long id) {
		return profileService.getProfile(id);
	}
	
	@GET
	@Path("{1}/{2}")
	public String getHola(@PathParam("1") int n1, @PathParam("2") int n2) {
		return "Hola" + n1 + ";" + n2;
	}
	
}
