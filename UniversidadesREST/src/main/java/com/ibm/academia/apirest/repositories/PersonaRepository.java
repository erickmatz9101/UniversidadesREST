package com.ibm.academia.apirest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer>
{

    @Query("Select p from Persona p where p.nombre=?1 and p.apellido=?2")
    public Optional<Persona>buscarPorNombreYApellido(String nombre, String Apellido);

    @Query("Select p from Persona p where p.dni=?1")
    public Optional<Persona>buscarPorDni(String dni);

    @Query("Select p from Persona p where p.apellido=%?1%")
    public Iterable<Persona>buscarPorApellido(String apellido);

    @Query("Select a from Alumno a where a.carrera.nombre=?1")
    Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);

    @Query(value = "select from universidad.personas where id= ?1",nativeQuery=true)
    public Persona buscarPorId(Integer id);


}
