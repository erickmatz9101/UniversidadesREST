package com.ibm.academia.apirest.UniversidadesREST.services;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;

import java.util.Optional;

public interface GenericoDAO<E>
{

    Optional<E> buscarPorId(Integer id);

    E guardar(E entidad);

    Iterable<E> buscarTodos();

    void eliminarPorId(Integer id);

}
