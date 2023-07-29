package com.example.demo.repository;

import com.example.demo.repository.modelo.Nota;

public interface INotaRepository {
	
	public void insertarNota(Nota nota);
	public Nota buscarNota(String materia);
	public void actualizarNota(Nota nota);
	public void borrarNota(Integer id);
	
	public Nota buscarId(Integer id);
}
