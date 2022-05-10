package com.ibm.academia.apirest.UniversidadesREST.services.controllers;
import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;
import com.ibm.academia.apirest.UniversidadesREST.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoController
{
    @Autowired
    @Qualifier("alumnoDAOimpl")
    private PersonaDAO alumnoDao;

    /**
     * Endpoint para crear un objeto Persona de tipo alumno
     * @param alumno Objeto alumno con la informacion a crear
     * @return Retorna un Objeto Persona de tipo alumno con codigo http status 201
     * @author ErickMatz 10-05-22
     */
    @PostMapping
    public ResponseEntity<?>crearAlumno(@RequestBody Persona alumno){
        Persona alumnoGuardado=null;
        return  new ResponseEntity<Persona>(alumnoGuardado,HttpStatus.CREATED);

    }
}
