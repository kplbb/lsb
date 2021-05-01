package com.lsb.dto;

public class AddressVO {
	private String zipcode;
	private String street; /*sido*/
	private String state;
	private String providence;
	private String country;
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProvidence() {
		return providence;
	}
	public void setProvidence(String providence) {
		this.providence = providence;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "AddressVO [zipcode=" + zipcode + ", street=" + street + ", state=" + state + ", providence="
				+ providence + ", country=" + country + "]";
	}
}
