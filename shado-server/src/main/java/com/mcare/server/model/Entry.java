package com.mcare.server.model;

 

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entry")
public  class Entry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id 
	@Column private Long  id ;
	@Column private boolean type;
	@Column private String category;
	@Column private int amount;
	@Column private Date updDate;
	@Column private Long userId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Entry [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", category=");
		builder.append(category);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", updDate=");
		builder.append(updDate);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	 
	 
}
