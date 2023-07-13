package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

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
	
	

}
