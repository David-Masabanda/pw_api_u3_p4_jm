package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.INotaRepository;
import com.example.demo.repository.modelo.Nota;

@Service
public class NotaServiceImpl implements INotaService{
	
	@Autowired
	private INotaRepository notaRepository;

	@Override
	public void ingresarNota(Nota nota) {
		this.notaRepository.insertarNota(nota);
	}

	@Override
	public Nota consultarNota(String materia) {
		return this.notaRepository.buscarNota(materia);
	}

	@Override
	public void actualizarNota(Nota nota) {
		this.notaRepository.actualizarNota(nota);
	}

	@Override
	public void eliminarNota(Integer id) {
		this.notaRepository.borrarNota(id);
	}

}
