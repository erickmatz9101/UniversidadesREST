package com.ibm.academia.apirest.utils;

import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.services.CarreraDAO;
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

        Carrera ingSistemas = new Carrera("Ingenieria en Sistemas", 50, 5);
        Carrera ingIndustrial = new Carrera("Ingenieria Industrial", 50, 5);
        Carrera ingAlimentos = new Carrera("Ingenieria en Alimentos", 50, 5);
        Carrera ingElectronica= new Carrera("Ingenieria en Electronica", 50, 5);
        Carrera licSistemas = new Carrera("Licenciatura en Sistemas", 50, 5);
        Carrera licTurismo = new Carrera("Licenciatura en Turismo", 50, 5);
        Carrera licYoga = new Carrera("Licenciatura en Yoga", 50, 5);
        Carrera licRecursos = new Carrera("Licenciatura en Recursos Humanos", 50, 5);

        carreraDao.guardar(ingSistemas);
        carreraDao.guardar(ingIndustrial);
        carreraDao.guardar(ingAlimentos);
        carreraDao.guardar(ingElectronica);
        carreraDao.guardar(licSistemas);
        carreraDao.guardar(licTurismo);
        carreraDao.guardar(licYoga);
        carreraDao.guardar(licRecursos);

        //Optional<Carrera>ingSistemas= carreraDao.buscarPorId(1);





    }
}
