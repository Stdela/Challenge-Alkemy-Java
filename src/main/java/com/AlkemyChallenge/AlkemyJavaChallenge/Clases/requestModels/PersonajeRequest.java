package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels;

import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Pelicula;
import java.util.ArrayList;
import java.util.List;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeRequest extends AbstractPersistable<Long> {
// @Lob
//    @Basic(fetch = FetchType.LAZY)
//    private byte[] imagen;

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
    @ManyToMany
    List<Pelicula> pelicula = new ArrayList<>();
}
