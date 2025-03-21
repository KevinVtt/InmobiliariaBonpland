package com.project.imuebles.bondpland.inmobiliaria_bonpland.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.imuebles.bondpland.inmobiliaria_bonpland.models.Inmueble;
import com.project.imuebles.bondpland.inmobiliaria_bonpland.repositories.InmuebleRepository;

@Service
public class InmuebleServiceImpl implements InmuebleService {

    private InmuebleRepository inmuebleRepository;

    public InmuebleServiceImpl(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    // -------------------------------------------------
    // Funciones basicas para las transaciones.
    // -------------------------------------------------
    @Transactional(readOnly = true)
    @Override
    public List<Inmueble> findAll(){
        return inmuebleRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    @Override
    public Optional<Inmueble> findById(Long id){
        return inmuebleRepository.findById(id);
    }
    
    @Transactional
    @Override
    public Inmueble save(Inmueble inmueble){
        return inmuebleRepository.save(inmueble);
    }
    
    @Transactional
    @Override
    public void deleteById(Long id){
        inmuebleRepository.deleteById(id);
    }
    // -------------------------------------------------

    


}
