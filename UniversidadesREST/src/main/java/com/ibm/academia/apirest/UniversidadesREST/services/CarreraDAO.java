package com.ibm.academia.apirest.UniversidadesREST.services;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera>
{

    Carrera actualizar(Carrera id, Carrera carrera);

}
