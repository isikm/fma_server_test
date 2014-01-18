/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.followme.webservice.testws.service;

import com.followme.webservice.testws.dao.LocationDao;
import com.followme.webservice.testws.dao.PersonDao;
import com.followme.webservice.testws.model.Location;
import com.followme.webservice.testws.model.Person;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Alphan
 */
@Path("service")
public class Service {
        
    private PersonDao personDao = new PersonDao();
    private LocationDao locationDao = new LocationDao();
    
    // method which should return a single person object in XML format
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id")int id) { // pathparam is used to accept user defined parameters
        return personDao.getPersonById(id);
    }
    
    // method which should return a single person object in JSON format
    @GET
    @Path("/getPersonByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam("id")int id) { // pathparam is used to accept user defined parameters
        return personDao.getPersonById(id);
    }
    
    // method which should return a list of all person objects in XML format
    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() { 
        return personDao.getAllPersons();
    }
    
    //inserts new person  - returns JSON ok or not ok response
    @GET
    @Path("/saveNewPerson/{fullName}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveNewPerson(@PathParam("fullName") String fullName, @PathParam("age") int age) {
        Person person = new Person();
        person.setFullName(fullName);
        person.setAge(age);
        
        if (personDao.savePerson(person)) {
            return "{\"status\":\"ok\"}";
        }
        else {
            return "{\"status\":\"not ok\"}";     
        }   
               
    }
    
    //updates an already existing person  - returns JSON ok or not ok response
    @GET
    @Path("/updatePerson/{id}/{fullName}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePerson(@PathParam("id") int id, @PathParam("fullName") String fullName, @PathParam("age") int age) {
    	Person updatedPerson = personDao.getPersonById(id);
    	updatedPerson.setId(id);
    	updatedPerson.setFullName(fullName);
    	updatedPerson.setAge(age);
        
        if (personDao.updatePerson(updatedPerson)) {
            return "{\"status\":\"ok\"}";
        }
        else {
            return "{\"status\":\"not ok\"}";     
        }   
               
    }
    
    @GET
    @Path("/setPersonLocation/{id}/{locationId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String setPersonLocation(@PathParam("id") int id, @PathParam("locationId") int locationId) {
        Person updatedPerson = personDao.getPersonById(id);
        updatedPerson.setUserLocation(locationDao.getLocationById(locationId));
        
        if (personDao.updatePerson(updatedPerson)) {
            return "{\"status\":\"ok\"}";
        }
        else {
            return "{\"status\":\"not ok\"}";     
        }   
               
    }
    
    @GET
    @Path("/addFollower/{id}/{followerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addFollower(@PathParam("id") int id, @PathParam("followerId") int followerId) {
        Person updatedPerson = personDao.getPersonById(id);
        if (updatedPerson.addFollower(personDao.getPersonById(followerId)) && personDao.updatePerson(updatedPerson)) {
            return "{\"status\":\"ok\"}";
        }
        else {
            return "{\"status\":\"not ok\"}";     
        }   
               
    }
    
    @GET
    @Path("/removeFollower/{id}/{followerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeFollower(@PathParam("id") int id, @PathParam("followerId") int followerId) {
        Person updatedPerson = personDao.getPersonById(id);
        if (updatedPerson.removeFollower(personDao.getPersonById(followerId)) && personDao.updatePerson(updatedPerson)) {
        	return "{\"status\":\"ok\"}";
        }
        else {
            return "{\"status\":\"not ok\"}";     
        }   
               
    }
    
    
	// method which should return a single Location object in XML format
    @GET
    @Path("/getLocationByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Location getLocationByIdXML(@PathParam("id")int id) { // pathparam is used to accept user defined parameters
        return locationDao.getLocationById(id);
    }
    
    // method which should return a single Location object in JSON format
    @GET
    @Path("/getLocationByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Location getLocationByIdJSON(@PathParam("id")int id) { // pathparam is used to accept user defined parameters
        return locationDao.getLocationById(id);
    }
    
    // method which should return a list of all Location objects in XML format
    @GET
    @Path("/getAllLocationsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Location> getAllLocationsInXML() { 
        return locationDao.getAllLocations();
    }
    
    //inserts new Location  - returns JSON ok or not ok response
    @GET
    @Path("/saveLocation/{locationName}/{locationCoordinate}")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveNewLocation(@PathParam("locationName") String locationName, @PathParam("locationCoordinate") int locationCoordinate) {
        Location location = new Location();
        location.setLocationName(locationName);
        location.setLocationCoordinate(locationCoordinate);
        
        if (locationDao.saveLocation(location)) {
            return "{\"status\":\"ok\"}";
        }
        else {
            return "{\"status\":\"not ok\"}";     
        }   
               
    }
    
    //updates an already existing Location  - returns JSON ok or not ok response
    @GET
    @Path("/saveLocation/{id}/{locationName}/{locationCoordinate}")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveNewLocation(@PathParam("id") int id, @PathParam("locationName") String locationName, @PathParam("locationCoordinate") int locationCoordinate) {
        Location location = new Location();
        location.setId(id);
        location.setLocationName(locationName);
        location.setLocationCoordinate(locationCoordinate);
        
        if (locationDao.saveLocation(location)) {
            return "{\"status\":\"ok\"}";
        }
        else {
            return "{\"status\":\"not ok\"}";     
        }   
               
    }
    
}
