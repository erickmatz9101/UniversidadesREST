package com.ibm.academia.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;

import java.util.Optional;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer>

{


    void deleteAll(Integer id);

    Optional<Carrera> findAllById(Integer id);
}
