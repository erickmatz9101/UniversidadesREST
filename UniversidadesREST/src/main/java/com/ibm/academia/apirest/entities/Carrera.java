package com.ibm.academia.apirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
//@Table(name ="carreras", schema = "universidad")
@Table(name ="carreras")
public class Carrera implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "No puede ser vacio")
    @NotNull(message = "No puede ser nulo")
    @Size(min = 5,max = 80)//minimo y maximo de caracteres
    @Column(name="nombre", unique = true,nullable = false, length = 80)
    private String nombre;

    @Positive(message = "Debe ser mayor a cero")
    @Column(name = "cantidad_materias")
    private Integer cantidadMaterias;

    @Positive(message = "Debe ser mayor  a cero")
    @Column(name="cantidad_anios")
    private Integer cantidadAnios;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @OneToMany(mappedBy ="carrera", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"carrera"})
    private Set<Alumno> alumnos;

    @ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"carreras"})
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

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadMaterias=" + cantidadMaterias +
                ", cantidadAnios=" + cantidadAnios +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
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
