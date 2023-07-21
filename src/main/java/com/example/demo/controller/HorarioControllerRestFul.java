package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.repository.modelo.Horario;
import com.example.demo.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestFul {
	
	@Autowired
	private IHorarioService horarioService;
	
	@GetMapping(path="/{paralelo}")
	
	public ResponseEntity<Horario> consultarPorCedula(@PathVariable String paralelo) {
		return ResponseEntity.status(HttpStatus.OK).body(this.horarioService.consultarPorParalelo(paralelo));
	}
	
	//Para el post existe una excepcion, no haria falta un path 
	@PostMapping()
	public void insertar(@RequestBody Horario horario) {
		this.horarioService.guardarHorario(horario);
	}
	
	
	@PutMapping(path="/{identificador}")
	public void actualizarHorario(@RequestBody Horario horario, @PathVariable Integer identificador) {
		horario.setId(identificador); 
		this.horarioService.actualizarHorario(horario);
	}
	
	@PatchMapping(path="/{identificador}")
	public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer identificador) {
		Horario hora1=this.horarioService.buscarPorId(identificador);
		hora1.setParalelo(horario.getParalelo());
		this.horarioService.actualizarHorario(horario);
	}
	
	
	@DeleteMapping(path="/{id}")
	public void borrarEstudiante(@PathVariable Integer id) {
		this.horarioService.borrar(id);
		
	}
	
	@GetMapping()
	public List<Horario> consultarEstudiantes(@RequestParam String materia) {
		//buscarTodos?provincia=pichincha
		//System.out.println(this.estudianteService.buscarTodos(provincia));
		return this.horarioService.buscarTodos(materia);
	}
}
