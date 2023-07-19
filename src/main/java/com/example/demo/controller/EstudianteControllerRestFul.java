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
	
	
	@GetMapping(path="/{cedula}")
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.consultarPorCedula(cedula);
	}
	
	//Para el post existe una excepcion, no haria falta un path 
	@PostMapping()
	public void ingresarEstudiante(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
	}
	
	
	@PutMapping(path="/{identificador}")
	public void actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador); 
		this.estudianteService.actualizarEstudiante(estudiante);
	}
	
	@PatchMapping(path="/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		Estudiante estu1=this.estudianteService.buscarPorId(identificador);
		estu1.setCedula(estudiante.getCedula());
		this.estudianteService.actualizarEstudiante(estu1);
	}
	
	
	@DeleteMapping(path="/{id}")
	public void borrarEstudiante(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
		
	}
	
	@GetMapping()
	public List<Estudiante> consultarEstudiantes(@RequestParam String provincia) {
		//buscarTodos?provincia=pichincha
		System.out.println(this.estudianteService.buscarTodos(provincia));
		return this.estudianteService.buscarTodos(provincia);
	}
	
}
