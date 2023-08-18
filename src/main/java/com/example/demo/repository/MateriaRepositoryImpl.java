package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public List<Materia> buscarPorCedulaEstudiante(String cedula) {
		TypedQuery<Materia> myQuery=this.entityManager.createQuery(
				"SELECT m FROM Materia m WHERE m.estudiante.cedula =: datoCedula",
				Materia.class);
	    myQuery.setParameter("datoCedula", cedula);
		return myQuery.getResultList();
	}


	@Override
	public Materia buscarMateriaId(Integer id) {
		return this.entityManager.find(Materia.class, id);
	}

}
