package com.ibm.academia.apirest.UniversidadesREST.services.controllers;

import com.ibm.academia.apirest.UniversidadesREST.entities.Carrera;
import com.ibm.academia.apirest.UniversidadesREST.exceptions.BadRequestException;
import com.ibm.academia.apirest.UniversidadesREST.exceptions.NotFoundException;
import com.ibm.academia.apirest.UniversidadesREST.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("carrera")

public class CarreraController
{
    @Autowired
    private CarreraDAO carreraDAO;

    @GetMapping("/lista/carreras")
    public List<Carrera> buscarTodos(){
        List<Carrera> carreas = (List<Carrera>)carreraDAO.buscarTodos();

        if (carreas.isEmpty()){
            throw  new BadRequestException("No existen esas carreras");
        }
        return carreas;
    }

    public Carrera buscarCarreraPorId(@PathVariable Integer carreraId){

       /* Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
        if (!oCarrera.isPresent()){
            throw  new BadRequestException(String.format("La carrera con ID: %d no existe", carreraId));

        }
        return oCarrera.get();*/

        /*Otra forma de hacerlo es asi:*/

        Carrera carrera = carreraDAO.buscarPorId(carreraId).orElse(null);
        if (carrera==null){
            throw new BadRequestException(String.format("La carrera con ID: %d no existe", carreraId));
        }
        return  carrera;

    }

    @PostMapping
    public ResponseEntity<?>guardarCarrera(@Valid @RequestBody Carrera carrera, BindingResult result){

        Map<String, Object> validaciones = new HashMap<String, Object>();
        if (result.hasErrors()){
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: "+ errores.getField() + " " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista errores" , listaErrores);
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Carrera carreraGuardada = carreraDAO.guardar(carrera);

        return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
    }

    /**
     * Endpoint para actualizar  un objeto de tipo carrera
     * @param carreraId parametro para buscar la carrera
     * @param carrera objeto con la informacion a modificar
     * @return Retorna un objeto de tipo crarrera con la informacion actualizada
     * @NotFoundException En caso de que falle actualizando el obejeto carrera
     * @author Erick Martinez 10-05-21
     */

    @PutMapping("/upd/carreraId/(carreraId)")
    public ResponseEntity<?>actaualizarCarrera(@PathVariable Integer carreraId, @RequestBody Carrera carrera){

        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);

        if (!oCarrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID: %d no existe", carreraId));
        Carrera carreraActualizada= carreraDAO.actualizar(oCarrera.get(), carrera);

        return new ResponseEntity<Carrera>(carreraActualizada, HttpStatus.OK);

    }

   /* @DeleteMapping("/carreraId/(carreraID)")
    public ResponseEntity<?> eliminarCarrera(@PathVariable Integer carreraId);{

        Map<String, Object> respuesta = HashMap<String, Object>();
        Optional<Carrera> carrera= carreraDAO.buscarPorId(carreraId);

        if (!carrera.isPresent()){
            throw new NotFoundException(String.format("La carrera con Id: %d no existe", carreraId));

            carreraDAO.eliminarPorId(carreraId);
            respuesta.put("OK", "Carrera ID: " + carreraId+ "Eliminada Exitosamente");
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NO_CONTENT);
        }

}*/

}
