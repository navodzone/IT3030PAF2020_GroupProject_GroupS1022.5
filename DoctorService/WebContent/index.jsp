<%@ page import="model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%
  //Insert Doctor---------------------------------
    if (request.getParameter("dID") != null)
     {
     Doctor d1 = new Doctor();
     String stsMsg = d1.insertItem(request.getParameter("dID"),
     request.getParameter("dName"),
     request.getParameter("specialization"),
     request.getParameter("hName"));
     session.setAttribute("statusMsg", stsMsg);
     } 
   %> 
      <%  
      //Delete Doctor---------------------------------
   if (request.getParameter("dID") != null)
   {
	   Doctor d1 = new Doctor();
   String stsMsg = d1.deleteItem(request.getParameter("dID"));
   session.setAttribute("statusMsg", stsMsg);
   } 
      %> 

       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style.css">
<title>Doctor Management</title>
</head>
<body>
<h1>Add new Doctors</h1>
<div class="form-style-8">
<form method="post"  action="http://localhost:8080/DoctorService/rest/rest">
 Doctor ID: <input name="dID" type="text" ><br>
 Doctor name: <input name="dName" type="text" ><br>
Doctor specialization : <input name="specialization" type="text" ><br>
Doctor residing Hospital: <input name="hName" type="text" ><br>
 <input name="btnSubmit" type="submit" value="Save">
 <input type="reset" value="Reset" />
</form>
</div>
<br>
<a href="http://localhost:8080/DoctorService/rest/rest">View Doctors</a>
<%
 out.print(session.getAttribute("statusMsg"));
%>
<br>
<%
//Doctor itemObj = new Doctor();
//System.out.print(itemObj.readItems());
//System.out.println(itemObj.readItems());
//itemObj.readItems();
%>

</body>
</html>