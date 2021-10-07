/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Controladores;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Usuario;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.dtoClasses.UsuarioDTO;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.UserRepositorio;
import com.AlkemyChallenge.AlkemyJavaChallenge.Servicios.MyUserDetailsService;
import com.AlkemyChallenge.AlkemyJavaChallenge.Servicios.UsuarioServicio;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author delam
 */
@RestController

public class RegistrationController {

    @Autowired
    UserRepositorio ur;
    @Autowired
    MyUserDetailsService userdetails;
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/auth/register")
//    HttpServletRequest request,
    public String usuario(@RequestBody Usuario usuario,  Errors errors) throws Exception {
//         usuarioServicio.crearUsuario(usuariodto);
//Usuario usuario = usuarioServicio.crearUsuario(usuariodto);
          userdetails.loadUserByUsername(usuario.getUsername());
        return "Success adding user";

    }

    @PostMapping("/auth/register")
//    @RequestBody  Usuario usuario
    public String crearUser(@RequestBody Usuario usuario) throws Exception {
        
//        usuarioServicio.crearUsuario(usuariodto);
    userdetails.registrar(usuario);
        return "Registrado";
    }

    @GetMapping("/auth/login")
    public String login(@RequestBody Usuario usuario) {
        userdetails.loadUserByUsername(usuario.getUsername());
        return "logeado";
    }

}
