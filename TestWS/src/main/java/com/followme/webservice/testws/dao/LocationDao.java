package com.followme.webservice.testws.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.followme.webservice.testws.model.Location;
import com.followme.webservice.testws.util.HibernateUtil;

/**
 * 
 * @author Alphan
 */
public class LocationDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Location getLocationById(int id) {
		Location Location = null;
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Location = (Location) session.createQuery("from Location p where p.id = :ID").setParameter("ID", id).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception ex) {

			if (session != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}

		}

		return Location;
	}

	public List<Location> getAllLocations() {
		List<Location> Locations = null;
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Locations = session.createQuery("from Location p").list();
			session.getTransaction().commit();
		} catch (Exception ex) {

			if (session != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}

		}

		return Locations;
	}

	// This method can insert a new Location
	public boolean saveLocation(Location Location) {

		Session session = null;
		boolean hasErrors = false;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(Location);
			session.getTransaction().commit();

		} catch (Exception ex) {

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
	
	public boolean updateLocation(Location Location) {

		Session session = null;
		boolean hasErrors = false;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.merge(Location);
			session.getTransaction().commit();

		} catch (Exception ex) {

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
