package com.ibm.academia.apirest.UniversidadesREST.services.controllers;
import com.ibm.academia.apirest.UniversidadesREST.entities.Alumno;
import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
import com.ibm.academia.apirest.UniversidadesREST.entities.Persona;
import com.ibm.academia.apirest.UniversidadesREST.exceptions.NotFoundException;
import com.ibm.academia.apirest.UniversidadesREST.services.AlumnoDAO;
import com.ibm.academia.apirest.UniversidadesREST.services.CarreraDAO;
import com.ibm.academia.apirest.UniversidadesREST.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController
{
    @Autowired
    @Qualifier("alumnoDAOimpl")
    private PersonaDAO alumnoDao;

    @Autowired
    private CarreraDAO carreraDAO;

    /**
     * Endpoint para crear un objeto Persona de tipo alumno
     * @param alumno Objeto alumno con la informacion a crear
     * @return Retorna un Objeto Persona de tipo alumno con codigo http status 201
     * @author ErickMatz 10-05-22
     */
    @PostMapping
    public ResponseEntity<?>crearAlumno(@RequestBody Persona alumno){
        Persona alumnoGuardado= alumnoDao.guardar(alumno);
        return  new ResponseEntity<Persona>(alumnoGuardado,HttpStatus.CREATED);
    }

    /**
     * Endpoint para listar los alumnos
     * @return
     * @author ErickMatz-10-05-22
     */
    @GetMapping("/alumnos/lista")
    public ResponseEntity<?> obtenerTodos(){
        List<Persona> alumnos= (List<Persona>) alumnoDao.buscarTodos();

        if (alumnos.isEmpty())
            throw new NotFoundException("No existen alumnos");

        return new ResponseEntity<List<Persona>>(alumnos, HttpStatus.OK);
    }

    /**
     *
     * @param alumnoId
     * @return
     */

    @GetMapping("/alumnoId/alumnoId")
    public ResponseEntity<?>obtenerAlumnoPorId(@PathVariable Integer alumnoId){
        Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);

        if (!oAlumno.isPresent())
            throw new NotFoundException(String.format("Alumno con id %d no existe", alumnoId));
        return new ResponseEntity<Persona>(oAlumno.get(),HttpStatus.OK);
    }

    /**
     *
     * @param alumnoId
     * @param alumno
     * @return
     */

        public ResponseEntity<?> actualizarAlumno(@PathVariable Integer alumnoId, @RequestBody Persona alumno){
        Optional<Persona> oAlumno= alumnoDao.buscarPorId(alumnoId);

        if (!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno  con ID %d no existe", alumnoId));

        Persona alumnoActualizado = ((AlumnoDAO)alumnoDao).actualizar(oAlumno.get(), alumno);
        return new ResponseEntity<Persona>(alumnoActualizado, HttpStatus.OK);
        }

        @PutMapping("/alumnoId/(alumnoId)/carrera/(carreraId)")
        public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer carreraId, @PathVariable Integer alumnoId){

            Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);

            if (!oAlumno.isPresent())
                throw new NotFoundException(String.format("El alumno con el id %d no existe",alumnoId));


            Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
            if (!oCarrera.isPresent())
                throw new NotFoundException(String.format("La carrera con id %d no existe:", carreraId));
            Persona alumno = ((AlumnoDAO)alumnoDao).asociarCarreraAlumno(oAlumno.get(), oCarrera.get());
            return new ResponseEntity<Persona>(alumno,HttpStatus.OK);
        }

}
