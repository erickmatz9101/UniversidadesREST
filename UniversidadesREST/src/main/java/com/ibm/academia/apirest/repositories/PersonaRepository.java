package com.ibm.academia.apirest.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer>
{

	static Optional<Persona> findBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
