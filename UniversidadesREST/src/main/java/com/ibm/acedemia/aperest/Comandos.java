package com.ibm.acedemia.aperest;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
import com.ibm.academia.apirest.UniversidadesREST.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Comandos implements CommandLineRunner
{

    @Autowired
    private CarreraDAO carreraDao;

    @Override
    public void run(String... args) throws Exception {

        Carrera finanzas = new Carrera("Ingenieria en finanzas",20,3);

        Carrera carreraGuardada= carreraDao.guardar(finanzas);

        System.out.println(carreraGuardada.toString());

    }
}
