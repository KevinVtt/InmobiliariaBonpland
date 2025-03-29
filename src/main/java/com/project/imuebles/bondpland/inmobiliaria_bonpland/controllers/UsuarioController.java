package com.project.imuebles.bondpland.inmobiliaria_bonpland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
