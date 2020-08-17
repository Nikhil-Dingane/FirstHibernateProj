package org.nikhil.krishagni.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.Attributes.Name;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue
	private int userId;
	private String userName;
	@ElementCollection
	private Set<Address> setOfAddresses = new HashSet<Address>();
	/*
	 * @Embedded private Address address;
	 */
	
	public Set<Address> getSetOfAddresses() {
		return setOfAddresses;
	}
	public void setSetOfAddresses(Set<Address> setOfAddresses) {
		this.setOfAddresses = setOfAddresses;
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
	/*
	 * public Address getAddress() { return address; } public void
	 * setAddress(Address address) { this.address = address; }
	 */
}
