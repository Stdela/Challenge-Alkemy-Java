package com.AlkemyChallenge.AlkemyJavaChallenge.Entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
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
public class Genero extends AbstractPersistable<Long> {

    @NotNull
    private String nombre;
    @NotNull
    private String imagen;
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pelicula> peliculaGen = new ArrayList<>();
}
