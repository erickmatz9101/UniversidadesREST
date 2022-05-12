package com.ibm.academia.apirest.repositories;

import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.models.entities.Persona;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository	 
{
    public Iterable<Persona>buscarAlumnoPorNombreCarrera(String nombre);




}





	
	


