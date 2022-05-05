package com.ibm.academia.apirest.UniversidadesREST.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public class GenericoDAOimpl <E, R extends CrudRepository<E, Integer> > implements GenericoDAO<E>
{
    protected final R repository;

    public  GenericoDAOimpl(R repository){
        this.repository = repository;
    }

	@Override
	@Transactional(readOnly = true)
	public Optional<E> buscarPorId(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public E guardar(E entidad) {
		return repository.save(entidad);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> buscarTodos() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void eliminarPorId(Integer id) {
		repository.deleteById(id);
	}
    
}
