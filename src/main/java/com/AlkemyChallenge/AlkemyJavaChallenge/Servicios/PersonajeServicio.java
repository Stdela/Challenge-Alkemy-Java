package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Pelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Personaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.PersonajeRequest;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.dtoClasses.PersonajeDTO;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.updateClasses.updatePersonaje;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.PersonajeRepositorio;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
