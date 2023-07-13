package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Materia buscarMateria(String nombre) {
		TypedQuery<Materia> myQuery =this.entityManager.createQuery(
				"SELECT m FROM Materia m WHERE m.nombre=: datoMateria", 
				Materia.class);
		myQuery.setParameter("datoMateria", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertarMateria(Materia materia) {
		this.entityManager.persist(materia);
	}

}
