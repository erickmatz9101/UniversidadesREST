package com.ibm.academia.apirest.UniversidadesREST.services;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
import com.ibm.academia.apirest.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CarreraDAOimpl extends GenericoDAOimpl<Carrera,CarreraRepository> implements CarreraDAO
{
    @Autowired
    public CarreraDAOimpl(CarreraRepository repository) {
        super(repository);
    }
}
