package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Horario;

public interface IHorarioService {

	public Horario consultarPorParalelo(String cedula);
	
	public void guardarHorario(Horario horario);
	
	public void actualizarHorario(Horario horario);
	
	public void actualizarParcial(String actual, String nueva);
	
	
	public void borrar(Integer id);
	public Horario buscarPorId(Integer id);
	
	public List<Horario> buscarTodos(String materia);
}
