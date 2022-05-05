package com.ibm.acedemia.apirest;

import com.ibm.academia.apirest.UniversidadesREST.entities.Alumno;
import com.ibm.academia.apirest.UniversidadesREST.entities.Direccion;
import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;
import com.ibm.academia.apirest.UniversidadesREST.services.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversidadRestApplication {
    @Autowired
    private AlumnoDAO alumnoDAO;

    public static void main(String[] args) {
        SpringApplication.run(UniversidadRestApplication.class, args);

    }
    @Bean
    public CommandLineRunner runner(){

        return args ->{
            Direccion direccion = new Direccion("calle 77", "11","123","1305","13","tijuana");

            Persona alumno = new Alumno("Maria", "De las Nieves", "5234587587", direccion);


        };
    }


}
