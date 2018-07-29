package org.aritra.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {
private String street;
private String city;
private String pin;
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPin() {
	return pin;
}
public void setPin(String pin) {
	this.pin = pin;
}

}
