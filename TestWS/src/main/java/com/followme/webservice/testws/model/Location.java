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
import javax.persistence.OneToMany;
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
@Table(name="LOCATION")
@XmlRootElement(name = "location") // the name that defines the root element name (RESTFUL)
@XmlType(propOrder = {"id","locationName","locationCoordinate", "idsOfAttendants"}) // sort order of the xml elements
public class Location {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="LOCATION_NAME")
    private String locationName;
    @Column(name="LOCATION_COORDINATE")
    private int locationCoordinate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userLocation", fetch=FetchType.EAGER)
    private Set<Person> attendants = new HashSet<Person>(0);
    
    @XmlTransient
    public Set<Person> getAttendants() {
		return attendants;
	}

	public void setAttendants(Set<Person> attendants) {
		this.attendants = attendants;
	}
	
	@XmlElement
	public Set<Integer> getIdsOfAttendants () {
		Set<Integer> idsOfFollowers = new HashSet<Integer>(0);
		
		for(Iterator<Person> attendant = attendants.iterator(); attendant.hasNext(); ) {
			idsOfFollowers.add(attendant.next().getId());
		}	
		
		return idsOfFollowers;
		
	}

	@XmlElement
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	@XmlElement
	public int getLocationCoordinate() {
		return locationCoordinate;
	}
	
	public void setLocationCoordinate(int locationCoordinate) {
		this.locationCoordinate = locationCoordinate;
	}    

}
