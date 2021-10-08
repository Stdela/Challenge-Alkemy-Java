
package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.GeneroRequest;
import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Genero;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.GeneroRepositorio;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author delam
 */
@Service
public class GeneroServicio implements GeneroInterface{
    @Autowired
    GeneroRepositorio genrep;
    
    @Override
    public Genero crearGenero(GeneroRequest generoRequest) throws IOException{
    Genero genero = new Genero();
    genero.setImagen(generoRequest.getImagen());
    genero.setNombre(generoRequest.getNombre());
    genero.setPeliculaGen(generoRequest.getPeliculaGen());
    genrep.save(genero);
    return genero;
}
    @Override
    public Genero updateGenero(Long id, GeneroRequest generoRequest)throws IOException {
       Genero genero = genrep.findById(id).get();
       genero.setImagen(generoRequest.getImagen());
       genero.setNombre(generoRequest.getNombre());
       genero.setPeliculaGen(generoRequest.getPeliculaGen());
       genrep.save(genero);
       return genero;
    }
}
