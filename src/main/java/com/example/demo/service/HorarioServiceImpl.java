package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHorarioRepository;
import com.example.demo.repository.modelo.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService{

	
	@Autowired
	private IHorarioRepository horarioRepository;
	
	@Override
	public Horario consultarPorParalelo(String cedula) {
		return this.horarioRepository.buscarPorParalelo(cedula);
	}

	@Override
	public void guardarHorario(Horario horario) {
		this.horarioRepository.insertarHorario(horario);
	}

	@Override
	public void actualizarHorario(Horario horario) {
		this.horarioRepository.actualizarHorario(horario);
	}

	@Override
	public void actualizarParcial(String actual, String nueva) {
		this.horarioRepository.actualizarParcial(actual, nueva);
	}

	@Override
	public void borrar(Integer id) {
		this.horarioRepository.borrar(id);
	}

	@Override
	public Horario buscarPorId(Integer id) {
		return this.horarioRepository.buscarPorId(id);
	}

	@Override
	public List<Horario> buscarTodos(String materia) {
		return this.horarioRepository.buscarTodos(materia);
	}

}
