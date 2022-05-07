package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository	 
{
    public Iterable<Persona>buscarAlumnoPorNombreCarrera(String nombre);




}





	
	


