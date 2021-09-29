/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Controladores;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Pelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Personaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.PersonajeRepositorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author delam
 */
@Controller
public class PersonajeController {

    @Autowired
    PersonajeRepositorio prep;

    @GetMapping("/characters")
    public String personajesLista(Model model) {
        model.addAttribute("personaje", prep.findAll());
        return "personajes";
    }

    @GetMapping("/characters/{id}")
    public String personaje(@RequestParam Long id, Model model) {
        model.addAttribute("personaje", prep.findById(id));
        return "personaje";
    }

    @PostMapping("/characters")
    public String crear(@RequestParam("imagen") MultipartFile imagen, @RequestParam String nombre, @RequestParam Integer edad, @RequestParam Double peso, @RequestParam String historia) throws IOException {
        Personaje personaje = new Personaje();
        personaje.setImagen(imagen.getBytes());
        personaje.setNombre(nombre);
        personaje.setHistoria(historia);
        personaje.setEdad(edad);
        personaje.setPeso(peso);
        List<Pelicula> pelicula = new ArrayList<>();
        personaje.setPelicula(pelicula);
        return "redirect:/characters";
    }

}
