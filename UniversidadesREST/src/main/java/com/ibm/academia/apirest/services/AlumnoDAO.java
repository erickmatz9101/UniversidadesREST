package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;

public interface AlumnoDAO extends PersonaDAO
{
    public Iterable<Persona>buscarAlumnoPorNombreCarrera(String nombre);

    Persona actualizar(Persona persona, Persona alumno);
    Persona asociarCarreraAlumno(Persona alumno, Carrera carrera);
}
