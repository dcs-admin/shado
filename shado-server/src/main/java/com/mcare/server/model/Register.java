package com.mcare.server.model;

 

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "register")
//extends org.springframework.security.core.userdetails.User
public class Register  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	 
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long  id ; 
	@Id 
	@Column private Long  mobileNumber ; 
	@Column private String  name ; 
	@Column  private String  email ; 
	@Column  private String  otp ; 
	 
	@Column private  String desc; 
	@Column private  String address_line1;
	@Column private  String address_line2;
	@Column private  String city;
	@Column private  String state;
	@Column private  String zipcode; 
	@Column private  Date dob; 
	@Column private  String aadhar;
	@Column private  String drivingLicense;
	@Column private  String emergency; 
	@Column private  String gender; 
	@Column private  Date date;  
	@Column private  String  comments;
	//@JsonIgnore
	@Column private String password	; 
	@Column private String status ="N"	;  
	@Column private String role ="C"	;  
	@Transient private String  errMsg ; 
	@Column private  Date updDate;
	
	@Column private  Date  lastOnline;

	
	public Register(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		//super(username, password, authorities);
	}
	
	public Register() {
		//super("", "", null);
	}
 
	
	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
 

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	 
 

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public Date getLastOnline() {
		return lastOnline;
	}


	public void setLastOnline(Date lastOnline) {
		this.lastOnline = lastOnline;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Register [mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", otp=");
		builder.append(otp);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", address_line1=");
		builder.append(address_line1);
		builder.append(", address_line2=");
		builder.append(address_line2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zipcode=");
		builder.append(zipcode);
		builder.append(", dob=");
		builder.append(dob); 
		builder.append(", aadhar=");
		builder.append(aadhar);
		builder.append(", drivingLicense=");
		builder.append(drivingLicense);
		builder.append(", emergency=");
		builder.append(emergency);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", date=");
		builder.append(date); 
		builder.append(", password=******"); 
		builder.append(", status=");
		builder.append(status);
		builder.append(", errMsg=");
		builder.append(errMsg);
		builder.append(", updDate=");
		builder.append(updDate);
		builder.append("]");
		return builder.toString();
	}
	
	 
	 
}
