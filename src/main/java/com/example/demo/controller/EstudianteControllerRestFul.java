package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	
	@GetMapping(path="/buscar/{cedula}")
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.consultarPorCedula(cedula);
	}
	
	@PostMapping(path="/guardar")
	public void ingresarEstudiante(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
	}
	
	
	@PutMapping(path="/actualizar/{identificador}")
	public void actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador); 
		this.estudianteService.actualizarEstudiante(estudiante);
	}
	
	@PatchMapping(path="/actualizarParcial/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador); 
		String cedula="1234";
		Estudiante estu1=this.estudianteService.consultarPorCedula(cedula);
		estu1.setCedula(estudiante.getCedula());
		this.estudianteService.actualizarEstudiante(estu1);
	}
	
	
	@DeleteMapping(path="/borrar/{id}")
	public void borrarEstudiante(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
		
	}
	
	@GetMapping(path="/buscarTodos")
	public List<Estudiante> consultarEstudiantes(@RequestParam String provincia) {
		//buscarTodos?provincia=pichincha
		return this.estudianteService.buscarTodos(provincia);
	}
	
	
	

}
