package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.models.entities.Alumno;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoDAOimpl extends GenericoDAOimpl<Persona, PersonaRepository > implements AlumnoDAO
{

	@Autowired

	public AlumnoDAOimpl(@Qualifier("repositorioAlumnos") PersonaRepository repository ) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre) {
		return repository.buscarAlumnoPorNombreCarrera(nombre);
	}

	@Override
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
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

	public Persona actualizar(Persona alumnoEncontrado, Persona alumno){
		Persona alumnoActualizado=null;
		alumnoEncontrado.setNombre(alumno.getNombre());
		alumnoEncontrado.setApellido(alumno.getApellido());
		alumnoEncontrado.setDireccion(alumno.getDireccion());
		alumnoActualizado = repository.save(alumnoEncontrado);
		return alumnoActualizado;
	}

	@Override
	@Transactional
	public Persona asociarCarreraAlumno(Persona alumno, Carrera carrera) {
		((Alumno)alumno).setCarrera(carrera);
		return repository.save(alumno);
	}
}


