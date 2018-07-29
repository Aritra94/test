package org.aritra.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
@Id	@GeneratedValue
private int userId;
private String userName;
@Lob
private String description;
@OneToMany(cascade=CascadeType.PERSIST)
private Collection<Vehicle> vehicle= new ArrayList<Vehicle>();



public Collection<Vehicle> getVehicle() {
	return vehicle;
}
public void setVehicle(Collection<Vehicle> vehicle) {
	this.vehicle = vehicle;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


public UserDetails() {
	
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
}
