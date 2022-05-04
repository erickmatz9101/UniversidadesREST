package com.ibm.academia.apirest.UniversidadesREST.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name="nombre", nullable = false, length = 60)
    private String nombre;

    @Column(name="apellido",nullable = false,length = 60)
    private String apellido;

    @Column(name="dni",nullable = false, unique = true,length = 10)
    private String dni;

    @Column(name = "fecja_alta")
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="codigoPostal", column = @Column(name="codigo_postal")),
            @AttributeOverride(name="departamento", column = @Column(name="departamento"))
    })
    private Direccion direccion;

    public Persona(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id) && Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni);
    }


    @PrePersist
    private void antesPersistir(){
        this.fechaAlta=new Date();

    }
    @PreUpdate
    private void antesActualizar(){
        this.fechaModificacion=new Date();

    }

    private static final long serialVersionUID = -4018852219491565501L;
}
