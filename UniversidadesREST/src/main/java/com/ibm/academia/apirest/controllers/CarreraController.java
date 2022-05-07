package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
import com.ibm.academia.apirest.UniversidadesREST.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carrera")

public class CarreraController
{
    @Autowired
    private CarreraDAO carreraDAO;

    public List<Carrera> buscarTodos(){
        List<Carrera> carreas = (List<Carrera>)carreraDAO.buscarTodos();

        return carreas;
    }


}
