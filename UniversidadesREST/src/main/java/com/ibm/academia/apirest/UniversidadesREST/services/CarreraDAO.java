package com.ibm.academia.apirest.UniversidadesREST.services;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CarreraDAO
{


    @Transactional(readOnly = true)
    Optional<Carrera> buscarPorId(Integer id);

    Carrera guardar(Carrera finanzas);

    @Transactional(readOnly = true)
    Iterable<Carrera> buscarTodos();

    @Transactional
    void eliminarPorId(Integer id);
}
