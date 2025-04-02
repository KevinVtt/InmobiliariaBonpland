package com.project.imuebles.bondpland.inmobiliaria_bonpland.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.imuebles.bondpland.inmobiliaria_bonpland.models.Inmueble;
import com.project.imuebles.bondpland.inmobiliaria_bonpland.models.enumerator.Estado;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble,Long> {
    // Implementar querys para los filtrados.
    @Query("SELECT i FROM Inmueble i WHERE " +
    "i.cantidadAmbientes = :cantidadAmbientes AND " +
    "i.pais = :pais AND " +
    "i.ciudad = :ciudad AND " +
    "i.metrosCuadrados >= :metrosCuadradosMin AND " +
    "i.metrosCuadrados <= :metrosCuadradosMax AND " +
    "i.precio <= :precioMax AND " +
    "i.estado = :estado")
List<Inmueble> filtrados(
 @Param("cantidadAmbientes") int cantidadAmbientes,
 @Param("pais") String pais,
 @Param("ciudad") String ciudad,
 @Param("metrosCuadradosMin") float metrosCuadradosMin,
 @Param("metrosCuadradosMax") float metrosCuadradosMax,
 @Param("precioMax") float precioMax, // Cambiado a float para coincidir con el tipo de precio
 @Param("estado") Estado estado
);

    List<Inmueble> findByPais(String pais);

    @Query("SELECT distinct pais FROM Inmueble i ")
    List<String> findAllPais();

    @Query("SELECT MIN(i.precio) FROM Inmueble i")
    Float precioMinimo();

    @Query("SELECT MAX(i.precio) FROM Inmueble i")
    Float precioMaximo();

    @Query("SELECT DISTINCT i.cantidadAmbientes FROM Inmueble i order by i.cantidadAmbientes asc")
    List<Integer> cantidadAmbientes();

    @Query("SELECT DISTINCT ciudad FROM Inmueble i")
    List<String> findAllCiudad();

    @Query("SELECT MIN(i.metrosCuadrados) FROM Inmueble i")
    Float metrosCuadradosMinimo();

    @Query("SELECT MAX(i.metrosCuadrados) FROM Inmueble i")
    Float metrosCuadradosMaximo();

}
