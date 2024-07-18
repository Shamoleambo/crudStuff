package com.tidz.crudStuff.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.tidz.crudStuff.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;

	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		this.entityManager.persist(instructor);
	}

}