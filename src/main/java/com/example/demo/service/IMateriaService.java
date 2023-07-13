package com.example.demo.service;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {
	public Materia consultarMateria(String nombre);
	public void guardarMateria(Materia materia);

}
