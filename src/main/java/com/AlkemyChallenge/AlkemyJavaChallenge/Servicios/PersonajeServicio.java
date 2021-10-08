package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Personaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.PersonajeRequest;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.updateModels.updatePersonaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.PersonajeRepositorio;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author delam
 */
@Service
public class PersonajeServicio implements PersonajeInterface {

    @Autowired
    PersonajeRepositorio personajerep;

    @Override
    public Personaje crearPersonaje(PersonajeRequest personajeReq) throws IOException {

        Personaje personaje = new Personaje();
        personaje.setImagen(personajeReq.getImagen());
        personaje.setNombre(personajeReq.getNombre());
        personaje.setEdad(personajeReq.getEdad());
        personaje.setPeso(personajeReq.getPeso());
        personaje.setHistoria(personajeReq.getHistoria());
        personaje.setPelicula(personajeReq.getPelicula());
        personajerep.save(personaje);
        return personaje;

        /// NOTE : Originally, images were set as byte[] type. This is some of the stuff that didn't work at the time of trying to create objects.
//        String b = Arrays.toString(file.getBytes());
//        personajeReq.getImagen()
//        byte[] s = b.getBytes(StandardCharsets.UTF_8);
// try {
//            personaje.setImagen(file.getBytes());
//        } catch (IOException ex) {
//            
//            Logger.getLogger(PersonajeServicio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            personaje.setImagen(file.getBytes());
//        } catch (IOException ex) {
//            
//            Logger.getLogger(PersonajeServicio.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public Personaje actualizarPersonaje(Long id, updatePersonaje updatePersonaje) throws IOException {
        Personaje personaje = personajerep.findById(id).get();
        personaje.setImagen(updatePersonaje.getImagen());
        personaje.setNombre(updatePersonaje.getNombre());
        personaje.setEdad(updatePersonaje.getEdad());
        personaje.setPeso(updatePersonaje.getPeso());
        personaje.setHistoria(updatePersonaje.getHistoria());
        personaje.setPelicula(updatePersonaje.getPelicula());
        personajerep.save(personaje);
        return personaje;
    }

}
