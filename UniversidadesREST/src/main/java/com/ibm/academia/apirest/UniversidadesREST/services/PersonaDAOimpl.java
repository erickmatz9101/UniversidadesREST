package com.ibm.academia.apirest.UniversidadesREST.services;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;

import java.util.Optional;

public class PersonaDAOimpl extends GenericoDAOimpl<Persona, PersonaRepository> implements PersonaDAO
{
    public PersonaDAOimpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {

        return repository.buscarPorNombreYApellido(nombre, apellido);
    }

    @Override
    public Optional<Persona> buscarPorDni(String dni) {
        return Optional.empty();
    }

    @Override
    public Iterable<Persona> buscarPorApellido(String apellido) {
        return null;
    }
}
