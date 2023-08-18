package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;


@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		TypedQuery<Estudiante> myQuery =this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=: datoCedula", Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		this.entityManager.persist(estudiante);		
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		this.entityManager.merge(estudiante);		
	}

	@Override
	public void actualizarParcial(String cedulaActual, String cedulaNueva) {
		Query myQuery=this.entityManager.createQuery(
				"UPDATE eEstudiente e SET e.cedula=:datoCedula WHERE e.cedula=:datoCondicion");
		myQuery.setParameter("datoCedula", cedulaNueva);
		myQuery.setParameter("datoCondicion", cedulaActual);
		myQuery.executeUpdate();		
	}

	@Override
	public void borrar(Integer id) {
		Estudiante estudiante=this.buscarPorId(id);
		this.entityManager.remove(estudiante);		
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.entityManager.find(Estudiante.class, id);	}

	@Override
	public List<Estudiante> buscarTodos(String provincia) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.provincia=:datoProvincia", Estudiante.class);
		myQuery.setParameter("datoProvincia", provincia);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarAll() {

		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e ORDER BY e.id ASC ", Estudiante.class);
		return myQuery.getResultList();
	}
	

	
	
//	@Override
//	public List<Estudiante> buscarTodos() {
//		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery(
//				"SELECT e FROM Estudiante e, Estudiante.class);
//		return myQuery.getResultList();
//	}

}
