
package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels;

import com.AlkemyChallenge.AlkemyJavaChallenge.Entidades.Pelicula;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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
@NoArgsConstructor
@AllArgsConstructor
public class GeneroRequest  {
@NotNull

private String nombre;
@NotNull
private String imagen;
@OneToMany (mappedBy = "genero", cascade = CascadeType.ALL)
@JsonManagedReference
private List<Pelicula> peliculaGen= new ArrayList<>();
}
