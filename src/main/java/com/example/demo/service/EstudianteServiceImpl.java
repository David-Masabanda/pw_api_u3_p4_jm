package com.example.demo.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante consultarPorCedula(String cedula) {
		return this.estudianteRepository.seleccionarPorCedula(cedula);	}

	@Override
	public void guardarEstudiante(Estudiante estudiante) {
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.estudianteRepository.insertarEstudiante(estudiante);		
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		this.estudianteRepository.actualizarEstudiante(estudiante);		
	}

	@Override
	public void actualizarParcial(String cedulaActual, String cedulaNueva) {
		this.estudianteRepository.actualizarParcial(cedulaActual, cedulaNueva);		
	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepository.borrar(id);		
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.estudianteRepository.buscarPorId(id);	}

	@Override
	public List<Estudiante> buscarTodos(String provincia) {
		return this.estudianteRepository.buscarTodos(provincia);	}

	@Override
	public List<EstudianteTO> buscarTodos() {
		List<Estudiante> lista=this.estudianteRepository.buscarAll();
		List<EstudianteTO> newLista=lista.stream().map(estudiante->this.convertir(estudiante)).collect(Collectors.toList());
		return newLista;
	}
	
	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estu=new EstudianteTO();
		estu.setId(estudiante.getId());
		estu.setNombre(estudiante.getNombre());
		estu.setApellido(estudiante.getApellido());
		estu.setCedula(estudiante.getCedula());
		estu.setFechaNacimiento(estudiante.getFechaNacimiento());
		estu.setProvincia(estudiante.getProvincia());
		
		return estu;
	}

}
