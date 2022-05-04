package com.ibm.academia.apirest.UniversidadesREST.entities;

import com.ibm.academia.apirest.UniversidadesREST.enums.TipoEmpleado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class Empleado extends Persona
{
    private BigDecimal sueldo;
    private TipoEmpleado tipoEmpleado;

    public Empleado(BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }

    private static final long serialVersionUID = 36683798116221411L;
}
