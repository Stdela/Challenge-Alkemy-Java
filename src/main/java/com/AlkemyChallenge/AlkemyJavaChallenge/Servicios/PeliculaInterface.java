/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Pelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.PeliculaRequest;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.updateClasses.updatePelicula;
import java.io.IOException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author delam
 */
public interface PeliculaInterface {
    Pelicula crearPelicula(PeliculaRequest peliculaReq) throws IOException;
    Pelicula actualizarPersonaje(@PathVariable Long id, @RequestBody updatePelicula updatePelicula) throws IOException;
}
