package com;

import model.Patient;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//For REST Service import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Patient")
public class PatientService {
	Patient pObj = new Patient();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPatient() {
		return pObj.readPatient();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(
			@FormParam("FirstName") String FName, 
			@FormParam("LastName") String LName,
			@FormParam("NIC") String NIC,
			@FormParam("DOB") String DOB,
			@FormParam("Email") String Email,
			@FormParam("Mobile") String Mobile,
			@FormParam("Address") String Address,
			@FormParam("BloodGroup") String BloodGroup,
			@FormParam("Allergy") String Allergy,
			@FormParam("Gender") String Gender,
			@FormParam("password") String password,
			@FormParam("ConfirmPassword") String ConfirmPassword) 
	{
		String output = pObj.insertPatient(FName, LName, NIC, DOB, Email, Mobile, Address,BloodGroup, Allergy, Gender, password, ConfirmPassword);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String PatientData) { // Convert the input string to a JSON object
		JsonObject pObject = new JsonParser().parse(PatientData).getAsJsonObject();

		// Read the values from the JSON object
		String Patient_ID = pObject.get("Patient_ID").getAsString();
		String FName = pObject.get("FirstName").getAsString();
		String LName = pObject.get("LastName").getAsString();
		String NIC = pObject.get("NIC").getAsString();
		String DOB = pObject.get("DOB").getAsString();
		String Email = pObject.get("Email").getAsString();
		String Mobile = pObject.get("Mobile").getAsString();
		String Address = pObject.get("Address").getAsString();
		String BloodGroup = pObject.get("BloodGroup").getAsString();
		String Allergy = pObject.get("Allergy").getAsString();
		String Gender = pObject.get("Gender").getAsString();
		String password = pObject.get("password").getAsString();
		String ConfirmPassword = pObject.get("ConfirmPassword").getAsString();
		
		String output = pObj.updatePatient(Patient_ID,FName, LName, NIC, DOB, Email, Mobile, Address,BloodGroup, Allergy, Gender, password, ConfirmPassword);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String PatientData) 
	{ 
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(PatientData, "", Parser.xmlParser()); 
		
		//Read the value from the element <itemID> 
		String Patient_ID = doc.select("Patient_ID").text();

		String output = pObj.deletePatient(Patient_ID);

		return output;
	}
}