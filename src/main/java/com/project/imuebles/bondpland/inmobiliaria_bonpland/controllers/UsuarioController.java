package com.project.imuebles.bondpland.inmobiliaria_bonpland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.imuebles.bondpland.inmobiliaria_bonpland.dto.InmuebleDTO;
import com.project.imuebles.bondpland.inmobiliaria_bonpland.models.Inmueble;
import com.project.imuebles.bondpland.inmobiliaria_bonpland.services.InmuebleService;


@Controller
@RequestMapping("/cliente")
public class UsuarioController {

    @Autowired
    private InmuebleService inmuebleService;

    // Implementar el filtrado a los usuarios.
    @GetMapping
    public String filtradoInmobiliaria(Model model){
        model.addAttribute("listadoInmueble", inmuebleService.findAll());
        model.addAttribute("listadoInmueblePorPais", inmuebleService.findAllPais());
        model.addAttribute("listadoInmueblePorCiudad", inmuebleService.findAllCiudad());
        model.addAttribute("precioMinimo", inmuebleService.precioMinimo());
        model.addAttribute("precioMaximo", inmuebleService.precioMaximo());
        model.addAttribute("cantidadAmbientes", inmuebleService.cantidadAmbientes());
        model.addAttribute("metrosCuadradosMinimo", inmuebleService.metrosCuadradosMinimo());
        model.addAttribute("metrosCuadradosMaximo", inmuebleService.metrosCuadradosMaximo());
        return "filtros/filterList";
    }

    @GetMapping("/detalles/{id}")
    public String detalleInmueble(@PathVariable Long id,Model model){
        Inmueble inmueble = inmuebleService.findById(id).orElseThrow();
        InmuebleDTO inmuebleDTO = setearDto(inmueble);
        model.addAttribute("inmueble", inmuebleDTO);
        return "/inmueble/detalleInmueble";
    }

    private InmuebleDTO setearDto(Inmueble inmueble){
        InmuebleDTO inmuebleDTO = new InmuebleDTO();
        inmuebleDTO.setPrecio(inmueble.getPrecio());
        inmuebleDTO.setHabitaciones(inmueble.getCantidadAmbientes());
        StringBuilder sb = new StringBuilder();
        String ubicacion = sb.append("Pais: " + inmueble.getPais()).append(" Ciudad: ").append(inmueble.getCiudad()).toString();
        inmuebleDTO.setUbicacion(ubicacion);
        inmuebleDTO.setDescripcion("Inmueble de alta valoracion con " + inmueble.getMetrosCuadrados().toString() + " metros cuadrados");
        return inmuebleDTO;
    }
}
