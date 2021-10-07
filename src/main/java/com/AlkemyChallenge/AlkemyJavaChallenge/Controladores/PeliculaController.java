/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Controladores;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Pelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Personaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.PeliculaRequest;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.updateClasses.updatePelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.PeliculaRepositorio;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.PersonajeRepositorio;
import com.AlkemyChallenge.AlkemyJavaChallenge.Servicios.PeliculaServicio;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/movies")
public class PeliculaController {

    @Autowired
    PeliculaRepositorio pelicularep;
    @Autowired
    PeliculaServicio peliculaServicio;
    @Autowired
    PersonajeRepositorio personajerep;

    @GetMapping
    public List getPeliculas(@RequestParam(required = false) String order,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long idGenero) throws IOException {
        if (order != null) {
            if (order.equals("ASC")) {
                pelicularep.findAll(Sort.by("fechaCreacion").ascending());

            } else if (order.equals("DES")) {
                pelicularep.findAll(Sort.by("fechaCreacion").descending());

            }

        } else if (name != null) {
            return pelicularep.encontrarPorNombre(name);

//        } else if (idGenero != null) {
//            return pelicularep.peliculaGenero(idGenero);
        } else {
            return pelicularep.listarPelicula();
        }
        return null;
    }
    

    @GetMapping("/{id}")
    public Pelicula getPelicula(@PathVariable Long id) throws IOException {
        return pelicularep.findById(id).get();
    }

    @PostMapping
    public Pelicula crearPelicula(@RequestBody PeliculaRequest peliculaReq) throws IOException {
        return peliculaServicio.crearPelicula(peliculaReq);
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Long id, @RequestBody updatePelicula updatePelicula) throws IOException {
        return peliculaServicio.actualizarPersonaje(id, updatePelicula);
    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id) throws IOException {
        pelicularep.deleteById(id);
    }

    @PutMapping("/{moviesId}/characters/{charId}")
    public Pelicula agregarPersonaje(@PathVariable Long charId, @PathVariable Long moviesId) {
        Pelicula pelicula = pelicularep.findById(moviesId).get();
        Personaje personaje = personajerep.findById(charId).get();
        pelicula.getPersonaje().add(personaje);
        return pelicularep.save(pelicula);

    }

}
