package com.ibm.academia.apirest.datos;

import com.ibm.academia.apirest.entities.*;
import com.ibm.academia.apirest.enums.TipoEmpleado;

import java.math.BigDecimal;

public class DatosDummy
{
    public static Carrera carrea01()
    {
        return new Carrera("Ingenieria en Sistemas", 50, 5);
    }

    public static Carrera carrera02()
    {
        return new Carrera("Licenciatura en Sistemas", 45, 4);

    }

    public static Carrera carrera03()
    {

        return new Carrera("Ingenieria Industrial", 60,5 );

    }

    public static Persona empleado01()
    {
        return new Empleado(new BigDecimal("46750.70"), TipoEmpleado.ADMINISTRATIVO);
    }

    public static Persona empleado02()
    {
        return new Empleado(new BigDecimal("46750.70"), TipoEmpleado.MANTENIMIENTO);
    }

    public static Persona profesor01()
    {
        return new Profesor(null,"Martin","Lugona","3308461", new Direccion(),new BigDecimal("60000.00"));

    }

    public static Persona alumno01()
    {
    
    	return new Alumno(null,"Joohn","Benitez","4523715", new Direccion());
        
    }


    public static Alumno alumno02() {
        return new Alumno(null,"Pedro","Buendia","4523716", new Direccion());
    }

    public static Alumno alumno03() {
        return new Alumno(null,"Pablo","Garcia","4823716", new Direccion());
    }
}
