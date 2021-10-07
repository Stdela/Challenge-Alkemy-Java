
package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.updateClasses;

import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Pelicula;
import java.util.ArrayList;
import java.util.List;  
import javax.persistence.ManyToMany;
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
public class updatePersonaje extends AbstractPersistable<Long> {
    private String imagen;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    @ManyToMany
    List<Pelicula> pelicula = new ArrayList<>();
}
