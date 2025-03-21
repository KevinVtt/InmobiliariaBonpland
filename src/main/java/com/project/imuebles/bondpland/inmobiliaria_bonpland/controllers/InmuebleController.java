package com.project.imuebles.bondpland.inmobiliaria_bonpland.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.imuebles.bondpland.inmobiliaria_bonpland.models.Inmueble;
import com.project.imuebles.bondpland.inmobiliaria_bonpland.services.InmuebleService;

@Controller
@Log4j2
@RequestMapping("/gestion/inmueble")
public class InmuebleController {

    private InmuebleService service;

    public InmuebleController(InmuebleService service) {
        this.service = service;
    }

    // Endpoints basicos -> Buscar todos, Buscar por ID, guardar / insertar inmueble, eliminar por id.

    @GetMapping
    public String list(Model model){
        model.addAttribute("listadoInmueble", service.findAll());
        model.addAttribute("title", "Listado de todos los inmuebles");
        return "list"; // Modificar el "list" por el nombre del html en donde queremos que se muestre
    }

    @GetMapping("/formInmueble")
    public String crearInmuebleForm(Model model){
        model.addAttribute("inmueble",new Inmueble());
        model.addAttribute("title","Crear inmueble");
        return "formInmueble";
    }

    @GetMapping("/mostrar/{id}")
    public String findById(Model model, @PathVariable Long id){ 
        Inmueble inmueble = service.findById(id).orElseThrow(() -> new RuntimeException("Inmueble no encontrado"));
        model.addAttribute("inmueblePorId", inmueble);
        return "inmueble";
    }

    @GetMapping("/form/{id}")
    public String editarInmuebleform(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Optional<Inmueble> optional = service.findById(id);

        if(optional.isPresent()){
            model.addAttribute("inmueble", optional.orElseThrow());
            model.addAttribute("title", "Editar inmueble");
            log.info(optional.orElseThrow());
            return "formInmueble";
        }else{
            redirect.addFlashAttribute("error","El inmueble con id " + id + " no existe en la base de datos");
            return "redirect:/gestion/inmueble";
        }

    }

    @PostMapping
    public String persistirDatosForm(@Valid Inmueble inmueble, BindingResult result, Model model, RedirectAttributes redirect){
        if(result.hasErrors()){
            model.addAttribute("title","Validando formulario inmueble");
            return "formInmueble";
        }

        String message = 
        (inmueble.getId() != null && inmueble.getId() > 0) 
                ? "El inmueble con id: " + inmueble.getId() + " ha sido actualizado con exito!"
                : "El inmueble ha sido creado con exito!"; 
        
        model.addAttribute("title", (inmueble.getId() != null && inmueble.getId() > 0) ? "Actualizar Inmueble" : "Agregar Inmueble");
        log.info("Inmueble persistirDato" + inmueble);
        service.save(inmueble);
        redirect.addFlashAttribute("message", message);
        return "redirect:/gestion/inmueble";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        service.deleteById(id);
        redirect.addFlashAttribute("message", "Inmueble eliminado con exito!");
        return "redirect:/gestion/inmueble";
    }

}