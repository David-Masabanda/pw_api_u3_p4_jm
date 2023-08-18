package com.example.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {
	

	@Id
	@Column(name="mate_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="mate_id_seq" )
	@SequenceGenerator(name="mate_id_seq", sequenceName = "mate_id_seq", allocationSize =1 )
	private Integer id;
	
	@Column(name="mate_nombre")
	private String nombre;
	
	@Column(name="mate_area")
	private String area;
	
	@Column(name="mate_creditos")
	private Integer creditos;
	
	@ManyToOne
	@JoinColumn(name="mate_id_estudiante")
	private Estudiante estudiante;
	
	
	//SET GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getCreditos() {
		return creditos;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
	
	

}
