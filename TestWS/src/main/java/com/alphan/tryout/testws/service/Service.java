/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphan.tryout.testws.service;

import com.alphan.tryout.testws.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
    
    // should simulate a 'database'
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
    
    // Insert test data in simulated database
    
    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("Random Guy " + id);
            person.setAge(new Random().nextInt(40) + 1);
            
            persons.put(id, person);
        }
    }
    
    // method which shoiuld return a single person object in XML format
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id")int id) { // pathparam is used to accept user defined parameters
        return persons.get(id);
    }
    
    // method which should return a single person object in JSON format
    @GET
    @Path("/getPersonByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam("id")int id) { // pathparam is used to accept user defined parameters
        return persons.get(id);
    }
    
    // method which should return a list of all person objects in XML format
    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() { 
        return new ArrayList<Person>(persons.values());
    }
    
    
}
