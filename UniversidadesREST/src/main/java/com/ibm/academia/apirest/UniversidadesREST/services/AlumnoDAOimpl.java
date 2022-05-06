package com.ibm.academia.apirest.UniversidadesREST.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoDAOimpl extends PersonaDAOimpl implements AlumnoDAO
{

	@Autowired

	public AlumnoDAOimpl(@Qualifier("repositorioAlumnos") PersonaRepository repository ) {
		super(repository);
	}

	@Override
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String Apellido) {
		return Optional.empty();
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
