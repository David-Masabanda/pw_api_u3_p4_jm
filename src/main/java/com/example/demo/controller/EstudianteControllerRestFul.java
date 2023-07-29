package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping(path="/{cedula}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.consultarPorCedula(cedula);
	}
	
	
	@GetMapping(path="/status/{cedula}")
	public ResponseEntity<Estudiante> consultarPorCedulaStatus(@PathVariable String cedula) {
		return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.consultarPorCedula(cedula));
	}
	
	
	//Para el post existe una excepcion, no haria falta un path 
//	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
//	public void ingresarEstudiante(@RequestBody Estudiante estudiante) {
//		this.estudianteService.guardarEstudiante(estudiante);
//	}
	
	
	
	
	
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
	
//	@GetMapping()
//	public ResponseEntity<List<Estudiante>> consultarEstudiantes() {
//		//buscarTodos?provincia=pichincha
//		
//		List<Estudiante> lista=null;
//		HttpHeaders cabeceras=new HttpHeaders();
//		cabeceras.add("detalleMensaje", "Ciudadanos consultados exitosamente");
//		cabeceras.add("valorAPI", "Incalculable");
////		System.out.println(this.estudianteService.buscarTodos(provincia));
//		return new ResponseEntity<>(lista,cabeceras,228);
//	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Estudiante guardarRevisar (@RequestBody Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
		Estudiante e1=this.estudianteService.buscarPorId(estudiante.getId());
		return e1;
	}
	
	
	@GetMapping(path = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodosHATEOAS() {
		List<EstudianteTO> lista=this.estudianteService.buscarTodos();
		
		for(EstudianteTO e : lista) {
			Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class).buscarPorEstudiante(e.getCedula())).withRel("materias");
			e.add(myLink);
		}
		return new ResponseEntity<>(lista,null,300);
	}
	
	@GetMapping(path = "/{cedula}/materias" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> buscarPorEstudiante (@PathVariable String cedula){
		List<MateriaTO> mat = this.materiaService.buscarPorCedulaEstudiante(cedula);
		
		for(MateriaTO m : mat) {
			Link myLink = linkTo(methodOn(MateriaControllerRestFul.class).buscarPorId(m.getId())).withSelfRel();
			m.add(myLink);
		}
		
		return new ResponseEntity<>(mat,null,302);
	}
	
	
	
	
	
}
