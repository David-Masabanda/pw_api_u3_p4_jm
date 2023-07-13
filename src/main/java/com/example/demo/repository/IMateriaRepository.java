package com.example.demo.repository;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public Materia buscarMateria(String nombre);
	public void insertarMateria(Materia materia);

}
