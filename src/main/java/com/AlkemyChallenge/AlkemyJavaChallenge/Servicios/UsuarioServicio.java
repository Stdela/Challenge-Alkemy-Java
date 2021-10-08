package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Usuario;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.dtoModels.UsuarioDTO;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author delam
 */
@Service
public class UsuarioServicio {

    @Autowired
    UserRepositorio userrep;

    public Usuario crearUsuario(UsuarioDTO usuariodto) throws Exception {
        Usuario usuario = new Usuario();
        if (userrep.findByUsername(usuariodto.getUsername()) != null) {
            return userrep.findByUsername(usuariodto.getUsername());
        }
        usuario.setEmail(usuariodto.getEmail());
        usuario.setUsername(usuariodto.getEmail());
        usuario.setPassword(usuariodto.getPassword());
        userrep.save(usuario);
        return usuario;
    }
}
