package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Horario;

public interface IHorarioRepository {

	public Horario buscarPorParalelo(String paralelo);
	
	public void insertarHorario(Horario horario);
	
	public void actualizarHorario(Horario horario);
	
	public void actualizarParcial(String actual, String nuevo);

	public void borrar(Integer id);
	
	public Horario buscarPorId(Integer id);
	
	public List<Horario> buscarTodos(String materia);
}
