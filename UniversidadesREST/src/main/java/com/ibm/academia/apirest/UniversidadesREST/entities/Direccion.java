package com.ibm.academia.apirest.UniversidadesREST.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.PreUpdate;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Direccion implements Serializable
{
    private String calle;
    private String numero;
    private String codigoPostal;
    private String departamento;
    private String piso;
    private String localidad;


    private static final long serialVersionUID = 7577756951415065190L;
}
