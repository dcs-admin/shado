package com.shado.server.model;

import java.util.Date;

/**
 * @author ram
 *
 */ 
public class UaaSubscription { 
	  
	 private int id;
	 private String userName;
	 private Date validFrom;
	 private Date validTo;
	 private String type;
	 private String comments;
	 private Date createdDate;
	 private Date updatedDate;
	 
	 
	 
	public UaaSubscription() {
		super();
		this.id = -1;
		this.userName = "";
		this.validFrom = new Date();
		this.validTo = new Date();
		this.type = "";
		this.comments = "";
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Subscription [  ");
		builder.append(", id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userName);
		builder.append(", validFrom=");
		builder.append(validFrom);
		builder.append(", validTo=");
		builder.append(validTo);
		builder.append(", type=");
		builder.append(type);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append("]");
		return builder.toString();
	} 
	
	
	

}
