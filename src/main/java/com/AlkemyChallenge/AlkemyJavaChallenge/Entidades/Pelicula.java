package com.AlkemyChallenge.AlkemyJavaChallenge.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class Pelicula extends AbstractPersistable<Long> {

    @NotNull
    
    private String imagen;
    @NotNull
    
    private String titulo;
    @NotNull
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaCreacion;
    @NotNull
    
    @Min(value = 1, message = "Rating can't be less than one")
    @Max(value = 5, message = "Rating can't be more than five")
    private Integer calificacion;

    @JsonIgnoreProperties("pelicula")
    @ManyToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    private List<Personaje> personaje = new ArrayList<>();
    
    @ManyToOne (cascade = CascadeType.ALL  )
    @JsonBackReference
    public Genero genero;
}
