package com.ek.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ek.entity.Cast;

@Repository
public class CastDao implements ICastDao{

	private Session session;
	private static SessionFactory sessionFactory;

	public CastDao() {
	}

	@SuppressWarnings("static-access")
	@Autowired
	public CastDao(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Transactional
	public void create(Cast cast) {
		try {
			session = sessionFactory.getCurrentSession();
			// Transaction tx = session.beginTransaction();
			session.persist(cast);
			// tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in Cast DAO create.");
			e.printStackTrace();
		}
	}

	@Transactional
	public void update(Cast cast) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cast);
	}

	@Transactional
	public Cast findCast(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cast cast = (Cast) session.get(Cast.class, id);
		return cast;
	}
	

	@Transactional
	public Cast getCastbyId(int castId) {
		Session session = sessionFactory.getCurrentSession();
		Cast cast = (Cast)session.get(Cast.class,castId);
		return cast;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cast> findAll() {
		session = sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("select a from Cast a");
		return query.list();
	}

	@Transactional
	public void delete(int castId) {
		session = sessionFactory.getCurrentSession();
		Cast cast = (Cast) session.get(Cast.class, castId);
		if(cast != null){
		session.delete(cast);
	}}

	

	
	

}