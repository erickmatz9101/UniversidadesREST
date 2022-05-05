package com.ibm.acedemia.apirest;
import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
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

        Carrera carrera= null;

        Optional <Carrera> oCarrerra = CarreraDAO.buscarPorId(2);
        if (oCarrerra.isPresent()){
            carrera = oCarrerra.get();
            System.out.println(carrera.toString());
        }else{
            System.out.println("Carrera no encontrada");

        }

        carrera.setCantidadAnios(7);
        carrera.setCantidadMaterias(66);
        carreraDao.guardar(carrera);

    }
}
