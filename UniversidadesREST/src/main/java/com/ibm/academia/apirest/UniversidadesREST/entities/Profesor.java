package com.ibm.academia.apirest.UniversidadesREST.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor
public class Profesor extends Persona
{
    private BigDecimal sueldo;

    public Profesor(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
    }

    private static final long serialVersionUID = -4672001542671045899L;
}
