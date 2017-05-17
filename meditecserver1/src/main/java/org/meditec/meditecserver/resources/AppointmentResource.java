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

import org.meditec.meditecserver.model.Appointment;
import org.meditec.meditecserver.service.AppointmentService;

@Path("appointmentlist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AppointmentResource {
	
	private AppointmentService appointmentListService = new AppointmentService();
	
	@GET
	public List<Appointment> getProfiles(@QueryParam("id") long filterBean, @QueryParam("patientName") String patientName) {
		
		if (filterBean > 0) {
			return appointmentListService.getAllAppointmentPerID((int) filterBean);
		}
		
		if (patientName != null) {
			return appointmentListService.getAllAppointmentPerPatient(patientName);
		}
		
		return appointmentListService.getAllAppoinment();
	}
	
	@POST
	public Appointment addProfile(Appointment appointment) {
		return appointmentListService.addAppointment(appointment);
	}
	
	@PUT
	@Path("{appointmentName}")
	public Appointment updateProfile(@PathParam("appointmentName") String patientName, Appointment appointment) {
		appointment.setPatientName(patientName);
		return appointmentListService.updateAppointment(appointment);
	}
	
	@DELETE
	@Path("{appointmentName}")
	public void deleteProfile(@PathParam("appointmentName") String patientName) {
		appointmentListService.removeAppointment(patientName);
	}
	
	
	@GET
	@Path("{appointmentName}")
	public Appointment getProfile(@PathParam("appointmentName") String patientName) {
		return appointmentListService.getAppointment(patientName);
	}
}
