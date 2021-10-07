package com.AlkemyChallenge.AlkemyJavaChallenge.Clases;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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

    
    private String imagen;
    private String titulo;
    @JsonFormat
      (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaCreacion;
    private Integer calificacion;
    
    @JsonIgnoreProperties("pelicula")
    @ManyToMany (mappedBy= "pelicula", cascade = CascadeType.ALL)
    private List<Personaje> personaje = new ArrayList<>();

}
