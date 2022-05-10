package com.ibm.academia.apirest.UniversidadesREST.services;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera>
{
     Iterable<Carrera> findCarrerasByNombreContains(String nombre);
     Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
     Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
     Carrera actualizar(Carrera carreraEncontrada, Carrera carrera);

}
