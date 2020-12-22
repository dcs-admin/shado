package com.shado.server.model;

import java.io.Serializable;

/**
 * @author likhit
 *
 */
public class UaaUsersPasswords implements Serializable { 
	 
	private static final long serialVersionUID = 1L;
	
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UaaUsersPasswords [oldPassword=").append(oldPassword).append(", newPassword=")
				.append(newPassword).append(", confirmPassword=").append(confirmPassword).append("]");
		return builder.toString();
	}
	
	
}