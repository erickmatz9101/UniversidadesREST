package com.ibm.acedemia.apirest;
import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;
import com.ibm.academia.apirest.UniversidadesREST.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Comandos implements CommandLineRunner
{

    @Autowired
    private CarreraDAO carreraDao;

    @Override
    public void run(String... args) throws Exception {

       /* Carrera ingSistemas = new Carrera("Ingenieria en Sistemas",60,5 );
        Carrera ingIndustrial = new Carrera("Ingenieria Industrial",55,5 );
        Carrera ingAlimentos = new Carrera("Ingenieria en Alimentos",53,5 );
        Carrera ingElectronica= new Carrera("Ingenieria en Electronica",45,5 );
        Carrera licSistemas = new Carrera("Licenciatura en Sistemas",40,4 );
        Carrera licTurismo = new Carrera("Licenciatura en Turismo",42,4 );
        Carrera licYoga = new Carrera("Licenciatura en Yoga",25,3 );
        Carrera licRecursos = new Carrera("Licenciatura en Recursos Humanos",33,3 );

        carreraDao.guardar(ingSistemas);
        carreraDao.guardar(ingIndustrial);
        carreraDao.guardar(ingAlimentos);
        carreraDao.guardar(ingElectronica);
        carreraDao.guardar(licSistemas);
        carreraDao.guardar(licTurismo);
        carreraDao.guardar(licYoga);
        carreraDao.guardar(licRecursos);*/

        Optional<Carrera>ingSistemas= carreraDao.buscarPorId(1);





    }
}
