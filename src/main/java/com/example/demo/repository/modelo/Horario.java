package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {
	
	@Id
	@Column(name="hora_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="hora_id_seq" )
	@SequenceGenerator(name="hora_id_seq", sequenceName = "hora_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="hora_materia")
	private String materia;
	
	@Column(name="hora_paralelo")
	private String paralelo;
	
	@Column(name="hora_curso")
	private String curso;

	//GET SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getParalelo() {
		return paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	

}