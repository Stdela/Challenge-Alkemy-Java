/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Pelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Personaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.dtoClasses.PersonajeDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author delam
 */
public interface PersonajeRepositorio extends JpaRepository<Personaje,Long> {
   
    @Query("SELECT p FROM Personaje p WHERE p.nombre =:name")
   List <Personaje> encontrarPorNombre(String name);

   
   @Query("SELECT p from Personaje p where p.edad = :age")
   List<Personaje> encontrarPorEdad(int age);
   
   @Query("SELECT p from Personaje p join fetch p.pelicula m where m.id = : idMovie")
   List <Personaje> encontrarPorPeliculaId (Long idMovie);
    
   @Query("SELECT new com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.dtoClasses.PersonajeDTO(p.imagen, p.nombre)FROM Personaje p")
   List<PersonajeDTO> listarPersonaje();
}
