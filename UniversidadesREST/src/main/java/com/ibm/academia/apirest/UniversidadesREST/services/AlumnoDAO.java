package com.ibm.academia.apirest.UniversidadesREST.services;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;

public interface AlumnoDAO extends PersonaDAO
{
    public Iterable<Persona>buscarAlumnoPorNombreCarrera(String nombre);

}
