package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {
	public Estudiante consultarPorCedula(String cedula);
	
	public void guardarEstudiante(Estudiante estudiante);
	
	public void actualizarEstudiante(Estudiante estudiante);
	
	public void actualizarParcial(String cedulaActual, String cedulaNueva);
	
	
	public void borrar(Integer id);
	public Estudiante buscarPorId(Integer id);
	
	public List<Estudiante> buscarTodos(String provincia);
}
