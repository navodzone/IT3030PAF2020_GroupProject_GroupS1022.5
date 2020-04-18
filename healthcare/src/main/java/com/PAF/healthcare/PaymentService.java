package com.PAF.healthcare;

import java.util.Arrays;
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


@Path("payments")
public class PaymentService {
	
	PaymentDB repo = new PaymentDB();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Payment> getPayment()
	{
		System.out.println("Successfully Connected and Running");
		return repo.getPayments();
	}
	
	//Search view by Payment ID
	
	@GET
	@Path("payment/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Payment getPayments(@PathParam("id") int id)
	{
		System.out.println("Search by ID Successful");
		return repo.getPayment(id);
	}
	
	//Inserting/adding new payment
	
	@POST
	@Path("payment")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Payment  createPayment(Payment a1)
	{
		System.out.println(a1);
		repo.create(a1);
		
		System.out.println("Payment Successful");
		return a1;
	}
	
	//Update pending payment
	
	@PUT
	@Path("payment")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Payment updatePayment(Payment a1)
	{
		System.out.println(a1);
		if(repo.getPayment(a1.getId()).getId()==0) {
			repo.create(a1);
		}
		else {
			repo.update(a1);
		}
		
		System.out.println("Updated Pending Payment");
		return a1;
	}
	
	//Delete pending payment
	
	@DELETE
	@Path("payment/{id}")
	public Payment killPayment(@PathParam("id") int id) {
		
		Payment a = repo.getPayment(id);
		
		if(a.getId()!=0)
		repo.delete(id);
		
		System.out.println("Deleted Pending Payment");
		return a;
	}
	
	

}
