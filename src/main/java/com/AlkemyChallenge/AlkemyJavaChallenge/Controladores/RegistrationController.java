/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Controladores;

import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Usuario;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.UserRepositorio;
import com.AlkemyChallenge.AlkemyJavaChallenge.Servicios.MyUserDetailsService;
import com.AlkemyChallenge.AlkemyJavaChallenge.Servicios.SendEmail;
import com.AlkemyChallenge.AlkemyJavaChallenge.Servicios.UsuarioServicio;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    @Autowired
    SendEmail sendEmail;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/auth/register")
    public ResponseEntity<String> crearUser(@RequestBody Usuario usuario) throws IOException {
        String correo = usuario.getEmail();
        sendEmail.sendEmail(correo);
        userdetails.registrar(usuario);
        return ResponseEntity.ok().body("Usuario Creado");
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        userdetails.loadUserByUsername(usuario.getUsername());
        return ResponseEntity.ok().body("Usuario logeado");
    }

}
