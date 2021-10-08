package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.dtoModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

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
public class PeliculaDTO {

    @NotNull
    
    private String imagen;
    @NotNull
    
    private String titulo;
    @NotNull
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaCreacion;
}
