package com.project.imuebles.bondpland.inmobiliaria_bonpland.services;

import java.util.List;
import java.util.Optional;
import com.project.imuebles.bondpland.inmobiliaria_bonpland.models.Inmueble;

public interface InmuebleService{
    List<Inmueble> findAll();
    Optional<Inmueble> findById(Long id);
    Inmueble save(Inmueble inmueble);
    void deleteById(Long id);
}
