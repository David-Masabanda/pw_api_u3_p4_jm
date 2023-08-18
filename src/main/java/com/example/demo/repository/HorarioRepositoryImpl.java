package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Horario;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Horario buscarPorParalelo(String paralelo) {
		TypedQuery<Horario> myQuery =this.entityManager.createQuery(
				"SELECT h FROM Horario h WHERE h.paralelo=: datoParalelo", 
				Horario.class);
		myQuery.setParameter("datoParalelo", paralelo);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertarHorario(Horario horario) {
		this.entityManager.persist(horario);		
	}

	@Override
	public void actualizarHorario(Horario horario) {
		this.entityManager.merge(horario);
	}

	@Override
	public void actualizarParcial(String actual, String nuevo) {
		Query myQuery=this.entityManager.createQuery(
				"UPDATE Horario h SET h.paralelo=:datoCedula WHERE h.paralelo=:datoCondicion");
		myQuery.setParameter("datoCedula", nuevo);
		myQuery.setParameter("datoCondicion", actual);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		Horario horario=this.buscarPorId(id);
		this.entityManager.remove(horario);
	}

	@Override
	public Horario buscarPorId(Integer id) {
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public List<Horario> buscarTodos(String materia) {
		TypedQuery<Horario> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Horario h WHERE e.materia=:datoMateria", 
				Horario.class);
		myQuery.setParameter("datoMateria", materia);
		return myQuery.getResultList();
	}

}
