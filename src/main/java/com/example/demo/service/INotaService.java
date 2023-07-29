package com.example.demo.service;

import com.example.demo.repository.modelo.Nota;

public interface INotaService {
	
	public void ingresarNota(Nota nota);
	public Nota consultarNota(String materia);
	public void actualizarNota(Nota nota);
	public void eliminarNota(Integer id);

}
