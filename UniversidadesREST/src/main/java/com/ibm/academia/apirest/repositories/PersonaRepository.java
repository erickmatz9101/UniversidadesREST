package com.ibm.academia.apirest.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer>
{
    public Optional<Persona>buscarPorNombreYApellido(String nombre, String Apellido);

    public Optional<Persona>buscarPorDni(String dni);

    public Iterable<Persona>buscarPorApellido(String apellido);





}
