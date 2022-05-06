package com.ibm.academia.apirest.UniversidadesREST.services;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>
{
    public Optional<Persona>buscarPorNombreYApellido(String nombre, String apellido);

    public Optional<Persona>buscarPorDni(String dni);

    public Iterable<Persona>buscarPorApellido(String apellido);



}
