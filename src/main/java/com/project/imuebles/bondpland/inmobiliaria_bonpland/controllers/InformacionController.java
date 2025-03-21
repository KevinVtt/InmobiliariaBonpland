package com.project.imuebles.bondpland.inmobiliaria_bonpland.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InformacionController {

    @GetMapping("/quienes-somos")
    public String quienesSomos(){
        return "info"; // Debes modificar el return por el nombre del archivo html.
    }

    @GetMapping("/nuestra-trayectoria")
    public String nuestraTrayectoria(){
        return "nuestra-trayectoria"; // Debes modificar el return por el nombre del archivo html.
    }

    @GetMapping("/bienvenidos")
    public String bienvenidos(){
        // Implementar los inmuebles destacados.
        return "bienvenido"; // Debes modificar el return por el nombre del archivo html.
    }

}
