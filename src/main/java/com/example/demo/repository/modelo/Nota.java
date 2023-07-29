package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="nota")
public class Nota {
	
	@Id
	@Column(name="nota_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="nota_id_seq" )
	@SequenceGenerator(name="nota_id_seq", sequenceName = "nota_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="nota_materia")
	private String materia;
	
	@Column(name="nota_semestre")
	private String semestre;
		
	@Column(name="nota_calificacion")
	private Integer calificacion;
	
	@Column(name="nota_estado")
	private String estado;

	//SET GET
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

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	


}
