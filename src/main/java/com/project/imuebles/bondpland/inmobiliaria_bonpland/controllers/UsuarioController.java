package com.project.imuebles.bondpland.inmobiliaria_bonpland.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class UsuarioController {
    // Implementar el filtrado a los usuarios.
    public String filtradoInmobiliaria(){
        return "filtrado";
    }
}
