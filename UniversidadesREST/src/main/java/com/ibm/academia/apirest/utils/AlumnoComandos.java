package com.ibm.academia.apirest.utils;

import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnoComandos implements CommandLineRunner
{
    @Autowired
    private CarreraDAO carreraDAO;

    @Override
    public void run(String... args) throws Exception {

        Optional<Carrera> sistemas = carreraDAO.buscarPorId(1);




    }
}
