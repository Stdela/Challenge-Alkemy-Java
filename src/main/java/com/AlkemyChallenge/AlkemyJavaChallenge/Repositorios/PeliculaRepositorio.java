/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Pelicula;
import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.dtoModels.PeliculaDTO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author delam
 */
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {

    @Query("SELECT p FROM Pelicula p WHERE p.titulo =:name")
    List<Pelicula> encontrarPorNombre(String name);

    @Query("SELECT p from Pelicula p where p.genero.id =:genre" )
    List<Pelicula> peliculaGenero(Long genre);
    @Query("SELECT new com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.dtoModels.PeliculaDTO(p.imagen, p.titulo, p.fechaCreacion) FROM Pelicula p")
    List<PeliculaDTO> listarPelicula();

}
