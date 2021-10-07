
package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.updateClasses;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Personaje;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author delam
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class updatePelicula {
    private String imagen;
    private String titulo;
    @JsonFormat
      (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaCreacion;
    private Integer calificacion;
    @ManyToMany
    private List<Personaje> personaje = new ArrayList<>();
}
