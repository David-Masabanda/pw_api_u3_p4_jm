package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;


@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	public Materia consultarMateria(String nombre) {
		return this.materiaRepository.buscarMateria(nombre);
	}

	@Override
	public void guardarMateria(Materia materia) {
		this.materiaRepository.insertarMateria(materia);
	}

}
