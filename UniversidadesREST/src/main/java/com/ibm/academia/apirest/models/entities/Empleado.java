package com.ibm.academia.apirest.models.entities;

import com.ibm.academia.apirest.enums.TipoEmpleado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@Entity
//@Table(name = "empleados", schema = "universidad")
@Table(name = "empleados")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona
{
    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @Column(name = "tipo_empleado")
    @Enumerated(EnumType.STRING)
    private TipoEmpleado tipoEmpleado;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "pabellon_id"))
    private Pabellon pabellon;

    public Empleado(BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "\n Empleado{" +
                "sueldo=" + sueldo +
                ", tipoEmpleado=" + tipoEmpleado +
                '}';
    }

    private static final long serialVersionUID = 36683798116221411L;
}
