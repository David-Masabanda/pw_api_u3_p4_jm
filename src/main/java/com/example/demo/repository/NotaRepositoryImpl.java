package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Nota;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class NotaRepositoryImpl implements INotaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarNota(Nota nota) {
		this.entityManager.persist(nota);
	}

	@Override
	public Nota buscarNota(String materia) {
		TypedQuery<Nota> myQuery = this.entityManager.createQuery(
				"SELECT n FROM Nota n WHERE n.materia =: datoNota",
				Nota.class);
		myQuery.setParameter("datoNota", materia);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizarNota(Nota nota) {
		this.entityManager.merge(nota);
	}

	@Override
	public void borrarNota(Integer id) {
		Nota nota=this.buscarId(id);
		this.entityManager.remove(nota);
	}

	@Override
	public Nota buscarId(Integer id) {
		return this.entityManager.find(Nota.class, id);
	}

}
