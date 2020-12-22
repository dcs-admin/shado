package com.shado.server.model;

public class UserSubscription {
	
	private UaaUser user;
	private UaaSubscription subscription;
	 
	
	
	public UserSubscription() {
		super();
		this.user = new UaaUser();
		this.subscription = new UaaSubscription();
	}
	
	
	public UaaUser getUser() {
		return user;
	}
	
	public void setUser(UaaUser user) {
		this.user = user;
	}
	
	public UaaSubscription getSubscription() {
		return subscription;
	}
	
	public void setSubscription(UaaSubscription subscription) {
		this.subscription = subscription;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserSubscription [user=");
		builder.append(user);
		builder.append(", subscription=");
		builder.append(subscription);
		builder.append("]");
		return builder.toString();
	}
	
	

}
