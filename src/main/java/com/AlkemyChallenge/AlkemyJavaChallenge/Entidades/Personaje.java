package com.AlkemyChallenge.AlkemyJavaChallenge.Entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author delam
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje extends AbstractPersistable<Long> {

    @NotNull

    private String imagen;
    @NotNull
    
    private String nombre;
    @NotNull
    
    private Integer edad;
    @NotNull
    
    private Integer peso;
    @NotNull
    
    private String historia;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Pelicula> pelicula = new ArrayList<>();
    

}
