package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {
	
	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping(path="/consultar")
	public Materia consultarPorNombre() {
		String materia="Literatura";
		return this.materiaService.consultarMateria(materia);
	}
	
	@PostMapping(path="/guardar")
	public void ingresarMateria(@RequestBody Materia materia) {
		this.materiaService.guardarMateria(materia);
	}

}
