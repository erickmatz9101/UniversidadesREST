package com.ibm.academia.apirest.UniversidadesREST.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoDAOimpl implements AlumnoDAO 
{
	@Autowired
	@Qualifier("repositorioAlumnos")
	private PersonaRepository personaRepository;

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> buscarPorId(Integer id) {
		return personaRepository.findById(id);
	}

	@Override
	@Transactional
	public Persona guardar(Persona persona) {
		return personaRepository.save(persona);
	}



	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> buscarTodos() {
		return personaRepository.findAll() ;
	}

	@Override
	@Transactional
	public void eliminarPorId(Integer id) {

		personaRepository.deleteById(id);
		
	} 
	

}
