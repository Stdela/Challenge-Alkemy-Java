/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Personaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.PersonajeRequest;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.updateClasses.updatePersonaje;
import java.io.IOException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author delam
 */
public interface PersonajeInterface {
    Personaje crearPersonaje(PersonajeRequest personajeReq) throws IOException;
    Personaje actualizarPersonaje(@PathVariable Long id, @RequestBody updatePersonaje updatePersonaje) throws IOException;
}
