package com.ibm.academia.apirest.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {
    private Integer id;

    @NotEmpty(message = "No puede ser vacio")
    @NotNull(message = "No puede ser nulo")
    @Size(min = 5, max = 80)//minimo y maximo de caracteres
    private String nombre;

    @Positive(message = "Debe ser mayor a cero")
    private Integer cantidadMaterias;

    @Positive(message = "Debe ser mayor  a cero")
    private Integer cantidadAnios;

}