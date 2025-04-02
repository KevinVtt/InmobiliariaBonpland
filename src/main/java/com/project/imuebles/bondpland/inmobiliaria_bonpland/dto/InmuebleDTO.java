package com.project.imuebles.bondpland.inmobiliaria_bonpland.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InmuebleDTO {

    private String descripcion;
    private double precio;
    private int habitaciones;
    private String ubicacion;

}
