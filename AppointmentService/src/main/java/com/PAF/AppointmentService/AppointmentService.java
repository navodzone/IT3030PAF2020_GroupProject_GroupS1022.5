package com.PAF.AppointmentService;

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



@Path("appointments")
public class AppointmentService {
	
	AppointmentDBA repo = new AppointmentDBA();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Appointment> getAppointment()
	{
		System.out.println("Successfully Connected and Running");
		return repo.getAppointments();
	}
	
	@GET
	@Path("appointment/{appointId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Appointment getAppointments(@PathParam("appointId") int appointId)
	{
		System.out.println("Appoinment Search by ID Successful");
		return repo.getAppointment(appointId);
	}
	
	@POST
	@Path("appointment")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Appointment  createAppointment(Appointment a1)
	{
		System.out.println(a1);
		repo.create(a1);
		
		System.out.println("Appoinment sucessfully created");
		return a1;
	}
	
	@PUT
	@Path("appointment")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Appointment updateAppointment(Appointment a1)
	{
		System.out.println(a1);
		if(repo.getAppointment(a1.getAppointId()).getAppointId()==0) {
			repo.create(a1);
		}
		else {
			repo.update(a1);
		}
		
		System.out.println("Appoinment Update Successful");
		return a1;
	}
	
	@DELETE
	@Path("appointment/{appointId}")
	public Appointment cancelAppointment(@PathParam("appointId") int appointId) {
		
		Appointment a = repo.getAppointment(appointId);
		
		if(a.getAppointId()!=0)
		repo.delete(appointId);
		
		System.out.println("Appoinment Cancel Successful");
		return a;
	}

}
