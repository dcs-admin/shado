package com.shado.server.model;

 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerCare")
public  class CustomerCare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	 
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long  id ; 
	@Id 
	@Column private int  id ; 
	@Column private String  number ;  
	@Column private String  name ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerCare [id=");
		builder.append(id);
		builder.append(", number=");
		builder.append(number);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	} 
	
	
}
