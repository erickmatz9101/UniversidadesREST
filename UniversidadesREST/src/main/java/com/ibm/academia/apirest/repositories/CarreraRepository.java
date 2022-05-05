package com.ibm.academia.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer>

{
	

}
