package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public class GenericoDAOimpl <E, R extends CrudRepository<E, Integer> > implements GenericoDAO<E>
{
	protected  final R repository;

	public GenericoDAOimpl(R repository){
		this.repository=repository;
	}

	@Override
	public Optional<E> buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public E guardar(E entidad) {
		// TODO Auto-generated method stub
		return repository.save(entidad);
	}

	@Override
	public Iterable<E> buscarTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}
    
}
 