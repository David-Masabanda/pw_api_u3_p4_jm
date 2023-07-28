package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula) {
		List<Materia> lista=this.materiaRepository.buscarPorCedulaEstudiante(cedula);
		List<MateriaTO> listaFinal=lista.stream().map(materia->this.convertir(materia)).collect(Collectors.toList());
		return listaFinal;
	}
	
	private MateriaTO convertir(Materia materia) {
		MateriaTO mat=new MateriaTO();
		mat.setId(materia.getId());
		mat.setNombre(materia.getNombre());
		mat.setArea(materia.getArea());
		mat.setCreditos(materia.getCreditos());
		
		return mat;
	
	}

	@Override
	public MateriaTO consultarMateriaId(Integer id) {
		Materia m= this.materiaRepository.buscarMateriaId(id);
		MateriaTO mat= this.convertir(m);
		return mat;
	}

}
