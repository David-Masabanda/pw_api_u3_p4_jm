package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Nota;
import com.example.demo.service.INotaService;

@RestController
@RequestMapping("/notas")
public class NotaControllerRestFul {
	
	@Autowired
	private INotaService notaService;
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void ingresarNota(@RequestBody Nota nota) {
		this.notaService.ingresarNota(nota);
	}
	
	@GetMapping(path="/{materia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Nota consultarPorMateria(@PathVariable String materia) {
		return this.notaService.consultarNota(materia);
	}
	
	@PutMapping(path="/{identificador}")
	public void actualizarNota(@RequestBody Nota nota, @PathVariable Integer identificador) {
		nota.setId(identificador);
		this.notaService.actualizarNota(nota);
	}
	
	@DeleteMapping(path="/{id}")
	public void borrarNota(@PathVariable Integer id) {
		this.notaService.eliminarNota(id);
	}

}
