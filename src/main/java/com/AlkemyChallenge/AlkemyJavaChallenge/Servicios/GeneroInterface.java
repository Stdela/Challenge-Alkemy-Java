/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.GeneroRequest;
import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Genero;
import java.io.IOException;

/**
 *
 * @author delam
 */
public interface GeneroInterface {
    Genero crearGenero(GeneroRequest generoRequest) throws IOException;
    Genero updateGenero(Long id, GeneroRequest generoRequest) throws IOException;
    
}
