
package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.dtoClasses;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
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
    private String imagen;
    private String nombre;
}
