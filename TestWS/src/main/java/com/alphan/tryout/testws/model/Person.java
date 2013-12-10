/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphan.tryout.testws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alphan
 */
@XmlRootElement(name = "person") // the name that defines the root element name (RESTFUL)
@XmlType(propOrder = {"id","fullName","age"}) // sort order of the xml elements
public class Person {
    
    private int id;
    private String fullName;
    private int age;

    @XmlElement // defines a child element of the root
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
