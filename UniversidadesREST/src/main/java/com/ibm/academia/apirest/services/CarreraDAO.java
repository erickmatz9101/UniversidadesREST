package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera>
{
     Iterable<Carrera> findCarrerasByNombreContains(String nombre);
     Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
     Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
     Carrera actualizar(Carrera carreraEncontrada, Carrera carrera);

}
