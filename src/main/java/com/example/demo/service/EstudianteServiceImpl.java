package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante consultarPorCedula(String cedula) {
		return this.estudianteRepository.seleccionarPorCedula(cedula);	}

	@Override
	public void guardarEstudiante(Estudiante estudiante) {
		this.estudianteRepository.insertarEstudiante(estudiante);		
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		this.estudianteRepository.actualizarEstudiante(estudiante);		
	}

	@Override
	public void actualizarParcial(String cedulaActual, String cedulaNueva) {
		this.estudianteRepository.actualizarParcial(cedulaActual, cedulaNueva);		
	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepository.borrar(id);		
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.estudianteRepository.buscarPorId(id);	}

	@Override
	public List<Estudiante> buscarTodos(String provincia) {
		return this.estudianteRepository.buscarTodos(provincia);	}

}
