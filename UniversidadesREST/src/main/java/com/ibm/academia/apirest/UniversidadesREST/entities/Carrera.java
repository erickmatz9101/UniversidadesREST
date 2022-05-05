package com.ibm.academia.apirest.UniversidadesREST.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name ="carreras", schema = "universidad")
public class Carrera implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre", unique = true,nullable = false, length = 80)
    private String nombre;

    @Column(name = "cantidad_materias")
    private Integer cantidadMaterias;

    @Column(name="cantidad_anios")
    private Integer cantidadAnios;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @OneToMany(mappedBy ="carrera", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos;

    @ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY)
    private Set<Profesor>profesores;



    public Carrera(String nombre, int i, int i1) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.cantidadAnios = cantidadAnios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return Objects.equals(id, carrera.id) && Objects.equals(nombre, carrera.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @PrePersist
    private void antesPersistir(){
        this.fechaAlta=new Date();

    }
    @PreUpdate
    private void antesActualizar(){
        this.fechaModificacion=new Date();

    }

    private static final long serialVersionUID = 8999302310484457619L;
}
