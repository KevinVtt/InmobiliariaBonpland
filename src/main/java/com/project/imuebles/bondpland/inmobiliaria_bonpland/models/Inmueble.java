package com.project.imuebles.bondpland.inmobiliaria_bonpland.models;

import com.project.imuebles.bondpland.inmobiliaria_bonpland.models.enumerator.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "inmueble")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Inmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "cantidad_ambientes")
    private Integer cantidadAmbientes;

    @Column(name = "metros_cuadrados")
    private Float metrosCuadrados;

    private String pais;
    private String ciudad;
    private Float precio;

    @Enumerated(EnumType.STRING)
    private Estado estado;
}
