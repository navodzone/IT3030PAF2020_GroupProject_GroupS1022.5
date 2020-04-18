package com.PAF.AppointmentService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Appointment {
	
	private String appointId;
	private String patientId;
	private String patientName;
	private String appointDate;
	private String appointTime;
	private String appointDoct;
	private String hospital;
	private String specialization;
	public String getAppointId() {
		return appointId;
	}
	public void setAppointId(String appointId) {
		this.appointId = appointId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}
	public String getAppointTime() {
		return appointTime;
	}
	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}
	public String getAppointDoct() {
		return appointDoct;
	}
	public void setAppointDoct(String appointDoct) {
		this.appointDoct = appointDoct;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	@Override
	public String toString() {
		return "Appointment [appointId=" + appointId + ", patientId=" + patientId + ", patientName=" + patientName
				+ ", appointDate=" + appointDate + ", appointTime=" + appointTime + ", appointDoct=" + appointDoct
				+ ", hospital=" + hospital + ", specialization=" + specialization + "]";
	}

}
