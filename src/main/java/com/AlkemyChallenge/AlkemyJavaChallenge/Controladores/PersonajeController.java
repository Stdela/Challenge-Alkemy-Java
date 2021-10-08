/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Controladores;

import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Pelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Personaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.PersonajeRequest;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.updateModels.updatePersonaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.PeliculaRepositorio;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.PersonajeRepositorio;
import com.AlkemyChallenge.AlkemyJavaChallenge.Servicios.PersonajeServicio;
import java.io.IOException;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author delam
 */
@RestController
@RequestMapping("/characters")
public class PersonajeController {

    @Autowired
    PersonajeRepositorio personajerep;
    @Autowired
    PersonajeServicio personajeServicio;
    @Autowired
    PeliculaRepositorio pelicularep;

    @GetMapping
    public List getPersonajes(@RequestParam(required = false) Integer age,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long idMovie) throws IOException {

        if (age != null) {
            return personajerep.encontrarPorEdad(age);
        } else if (name != null) {
            return personajerep.encontrarPorNombre(name);
        } else if (idMovie != null) {
            return personajerep.encontrarPorPeliculaId(idMovie);

        } else {
            return personajerep.listarPersonaje();
        }

    }
//(consumes = MediaType.IMAGE_JPEG_VALUE, produces = "image/png")

    @PostMapping
    public Personaje postPersonaje(@RequestBody PersonajeRequest personajeReq) throws IOException {

        return personajeServicio.crearPersonaje(personajeReq);

    }

    @PutMapping("/{id}")
    public Personaje actualizarPersonaje(@PathVariable Long id, @RequestBody updatePersonaje updatePersonaje) throws IOException {

        return personajeServicio.actualizarPersonaje(id, updatePersonaje);

    }

    @GetMapping("/{id}")
    public Optional<Personaje> getPersonaje(@PathVariable Long id) throws IOException {
        return personajerep.findById(id);

    }

    @DeleteMapping("/{id}")
    public void deletePersonaje(@PathVariable Long id) throws IOException {
        personajerep.deleteById(id);
    }

    @PutMapping("/{charId}/movies/{moviesId}")
    public Personaje agregarPelicula(@PathVariable Long charId, @PathVariable Long moviesId) {
        Pelicula pelicula = pelicularep.findById(moviesId).get();
        Personaje personaje = personajerep.findById(charId).get();
        personaje.getPelicula().add(pelicula);
        return personajerep.save(personaje);

    }
}
