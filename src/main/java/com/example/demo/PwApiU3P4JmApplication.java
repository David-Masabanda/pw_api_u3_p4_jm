package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.EstudianteControllerRestFul;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class PwApiU3P4JmApplication implements CommandLineRunner{
	
	@Autowired
	private EstudianteControllerRestFul estudianteControllerRestFul;
	
	@Autowired
	private IEstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P4JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(this.estudianteControllerRestFul.consultarPorCedula());
		
	}

}
