package com.PAF.healthcare;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment{

	//Variables assign
	
	private int Id;  
	private String appointmentID;
	private double paymentAmount;
	private String paymentDate;
	private String paymentType;
	private String cardNumber;
	private String expDate;
	private int cvv;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "Payment [Id=" + Id + ", appointmentID=" + appointmentID + ", paymentAmount=" + paymentAmount
				+ ", paymentDate=" + paymentDate + ", paymentType=" + paymentType + ", cardNumber=" + cardNumber
				+ ", expDate=" + expDate + ", cvv=" + cvv + "]";
	}
	
	
	
	
}
