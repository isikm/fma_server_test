/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.followme.webservice.testws.dao;

import com.followme.webservice.testws.model.Person;
import com.followme.webservice.testws.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Alphan
 */
public class PersonDao {
    
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public Person getPersonById(int id) {
        Person person = null;
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            person = (Person) session.createQuery("from Person p where p.id = :ID").setParameter("ID", id).uniqueResult();
            session.getTransaction().commit();
        } catch(Exception ex) {
            
            if (session != null) {
                session.getTransaction().rollback();
            }
            
        } finally {
            
            if (session != null) {
                session.close();
            }
            
        }
        
        return person;
    }
    
    public List<Person> getAllPersons() {
        List<Person> persons = null;
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            persons = session.createQuery("from Person p").list();
            session.getTransaction().commit();
        } catch(Exception ex) {
            
            if (session != null) {
                session.getTransaction().rollback();
            }
            
        } finally {
            
            if (session != null) {
                session.close();
            }
            
        }
        
        return persons;
    }
    
    // This method can both insert a new person and update existing one
    public boolean savePerson(Person person) {
        
        Session session = null;
        boolean hasErrors = false;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(person);
            session.getTransaction().commit();
            
        } catch (Exception ex){
            
            if (session != null) {
                session.getTransaction().rollback();
            }
            hasErrors = true;
            
        } finally {
            
            if (session != null) {
                session.close();
            }
            
        }       
        
        return !hasErrors;
        
    }
}
