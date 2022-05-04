package com.ibm.academia.apirest.UniversidadesREST.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Alumno extends Persona
{
    public Alumno(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }

    private static final long serialVersionUID = 2058022305918195892L;
}
