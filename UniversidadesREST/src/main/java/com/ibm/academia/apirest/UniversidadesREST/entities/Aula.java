package com.ibm.academia.apirest.UniversidadesREST.entities;

import com.ibm.academia.apirest.UniversidadesREST.enums.Pizarron;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="aulas", schema = "universidad")
public class Aula implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_aula", nullable = false)
    private Integer numeroAlua;
    @Column(name = "medidas")
    private String medidas;
    @Column(name = "cantidad_pupitres")
    private Integer cantidadPupitres;
    @Column(name="tipo_pizarron")
    @Enumerated(EnumType.STRING)
    private Pizarron pizarron;
    @Column(name = "fecha_alta")
    private Date fechaAlta;
    @Column(name="fecha_modificacion")
    private Date fechaModificacion;

    @ManyToOne (optional = true, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
    private Pabellon pabellon;

    public Aula(Integer id, Integer numeroAlua, String medidas, Integer cantidadPupitres, Pizarron pizarron) {
        this.id = id;
        this.numeroAlua = numeroAlua;
        this.medidas = medidas;
        this.cantidadPupitres = cantidadPupitres;
        this.pizarron = pizarron;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return Objects.equals(id, aula.id) && Objects.equals(numeroAlua, aula.numeroAlua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroAlua);
    }

    private static final long serialVersionUID = -4754860299762466972L;

    @PrePersist
    private void antesPersistir(){
        this.fechaAlta=new Date();

}
    @PreUpdate
    private void antesActualizar(){
        this.fechaModificacion=new Date();

    }


}


