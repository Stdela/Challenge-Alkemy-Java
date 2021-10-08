package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.dtoModels;

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
public class PersonajeDTO {

    @NotNull

    private String imagen;
    @NotNull

    private String nombre;
}
