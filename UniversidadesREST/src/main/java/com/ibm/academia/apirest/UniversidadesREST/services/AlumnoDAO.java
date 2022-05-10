package com.ibm.academia.apirest.UniversidadesREST.services;

import java.util.Optional;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;

public interface AlumnoDAO extends PersonaDAO
{
    public Iterable<Persona>buscarAlumnoPorNombreCarrera(String nombre);

    Persona actualizar(Persona persona, Persona alumno);
    Persona asociarCarreraAlumno(Persona alumno, Carrera carrera);
}
