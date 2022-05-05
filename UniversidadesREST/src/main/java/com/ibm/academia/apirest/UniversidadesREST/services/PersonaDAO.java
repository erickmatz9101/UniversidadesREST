package com.ibm.academia.apirest.UniversidadesREST.services;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;

import java.util.Optional;

public interface PersonaDAO
{
    Optional<Persona> buscarPorId(Integer id);

    Persona guardar(Persona persona);

    Iterable<Persona> buscarTodos();

    void eliminarPorId(Integer id);

}
