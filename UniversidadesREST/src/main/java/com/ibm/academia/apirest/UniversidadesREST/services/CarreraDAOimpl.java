package com.ibm.academia.apirest.UniversidadesREST.services;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
import com.ibm.academia.apirest.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraDAOimpl extends GenericoDAOimpl<Carrera,CarreraRepository> implements CarreraDAO
{
    @Autowired
    public CarreraDAOimpl(CarreraRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repository.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarrerasByNombreIgnoreCase(nombre);
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
        return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
    }

    @Override
    @Transactional
    public Carrera actualizar(Carrera carreraEncontrada, Carrera carrera) {
        Carrera carreraActualizada = null;
        carreraEncontrada.setCantidadAnios(carrera.getCantidadAnios());
        carreraEncontrada.setCantidadMaterias(carrera.getCantidadMaterias());
        carreraActualizada=repository.save(carreraEncontrada);

        return carreraActualizada;
    }


}
