package org.nikhil.krishagni.dto;

import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue
	private int userId;
	private String userName;
	@ElementCollection
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name= "USER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "Address_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Address> setOfAddresses = new ArrayList<Address>();
	/*
	 * @Embedded private Address address;
	 */
	
	public int getUserId() {
		return userId;
	}
	public Collection<Address> getSetOfAddresses() {
		return setOfAddresses;
	}
	public void setSetOfAddresses(Collection<Address> setOfAddresses) {
		this.setOfAddresses = setOfAddresses;
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
