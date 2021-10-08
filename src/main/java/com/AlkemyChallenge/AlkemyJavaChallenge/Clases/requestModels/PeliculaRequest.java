package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels;

import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Personaje;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class PeliculaRequest {

    @NotNull

    private String imagen;
    @NotNull

    private String titulo;
    @NotNull

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull

    private Date fechaCreacion;
    @NotNull

    private Integer calificacion;
    @ManyToMany
    private List<Personaje> personaje = new ArrayList<>();
}
