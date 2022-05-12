package com.ibm.academia.apirest.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Setter
@Getter
//@Table(name = "alumnos", schema = "universidad")
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona
{

    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "alumnos"})
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    public Alumno(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }

    @Override
    public String toString() {
        return  super.toString() + "Alumno{}";
    }

    private static final long serialVersionUID = 2058022305918195892L;
}
