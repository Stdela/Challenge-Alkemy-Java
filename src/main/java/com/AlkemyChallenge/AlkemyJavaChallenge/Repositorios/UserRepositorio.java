/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios;


import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delam
 */
public interface UserRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
    Boolean existsByUsername(String username);
Boolean existsByEmail(String email);    

}
