/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.followme.webservice.testws.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Alphan
 */
@Entity
@Table(name = "PERSON")
@XmlRootElement(name = "person")
// the name that defines the root element name (RESTFUL)
@XmlType(propOrder = { "id", "fullName", "age", "idOfUserLocation",
		"idsOfFollowers" })
// sort order of the xml elements
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "FULL_NAME")
	private String fullName;
	@Column(name = "AGE")
	private int age;
	@ManyToOne
	@JoinColumn(name = "USER_LOCATION")
	private Location userLocation;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "FOLLOWERS", joinColumns = { @JoinColumn(name = "followedID") }, inverseJoinColumns = { @JoinColumn(name = "followerID") })
	private Set<Person> followers = new HashSet<Person>(0);

	@XmlTransient
	public Set<Person> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<Person> followers) {
		this.followers = followers;
	}
	
	public boolean addFollower(Person followerToAdd) {
		boolean found = false;
		for (Iterator<Person> follower = followers.iterator(); follower.hasNext();) {
			if (follower.next().getId() == followerToAdd.getId()) {
				found = true;
			}
		}
		if (!found) {
			followers.add(followerToAdd);
			return true;
		}
		return false;
	}
	
	public boolean removeFollower(Person followerToRemove) {
		for (Iterator<Person> follower = followers.iterator(); follower.hasNext();) {
			Person followerIter = follower.next();
			if (followerIter.getId() == followerToRemove.getId()) {
				return followers.remove(followerIter);
			}
		}	
		return false;
	}

	@XmlElement
	public Set<Integer> getIdsOfFollowers() {
		Set<Integer> idsOfFollowers = new HashSet<Integer>(0);

		for (Iterator<Person> follower = followers.iterator(); follower
				.hasNext();) {
			idsOfFollowers.add(follower.next().getId());
		}

		return idsOfFollowers;

	}

	@XmlTransient
	public Location getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(Location userLocation) {
		this.userLocation = userLocation;
	}

	@XmlElement
	public Set<Integer> getIdOfUserLocation() {
		Set<Integer> idOfUserLocation = new HashSet<Integer>(0);

		if (userLocation != null) {
			idOfUserLocation.add(userLocation.getId());
		}

		return idOfUserLocation;
	}

	@XmlElement
	// defines a child element of the root
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// engin cok maldir, mehmet can in da ondan asagi kalir yani yoktur :)

	@XmlElement
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@XmlElement
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	


}
