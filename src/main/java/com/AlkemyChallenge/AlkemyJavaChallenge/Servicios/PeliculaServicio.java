
package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Pelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.PeliculaRequest;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.updateClasses.updatePelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.PeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author delam
 */
@Service
public class PeliculaServicio implements PeliculaInterface {
@Autowired 
        PeliculaRepositorio pelicularep;
    @Override
    public Pelicula crearPelicula(PeliculaRequest peliculaReq) {
        Pelicula pelicula = new Pelicula();
        pelicula.setImagen(peliculaReq.getImagen());
        pelicula.setTitulo(peliculaReq.getTitulo());
        pelicula.setCalificacion(peliculaReq.getCalificacion());
        pelicula.setFechaCreacion(peliculaReq.getFechaCreacion());
        pelicula.setPersonaje(peliculaReq.getPersonaje());
        pelicularep.save(pelicula);
        return pelicula;
    }

    @Override
    public Pelicula actualizarPersonaje(Long id, updatePelicula updatePelicula) {
        Pelicula pelicula = new Pelicula();
        pelicula.setImagen(updatePelicula.getImagen());
        pelicula.setTitulo(updatePelicula.getTitulo());
        pelicula.setCalificacion(updatePelicula.getCalificacion());
        pelicula.setFechaCreacion(updatePelicula.getFechaCreacion());
        pelicula.setPersonaje(updatePelicula.getPersonaje());
        pelicularep.save(pelicula);
        return pelicula;
    }

}
