package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository	 
{
    public Iterable<Persona>buscarAlumnoPorNombreCarrera(String nombre);




}





	
	


