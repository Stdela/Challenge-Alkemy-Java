
package com.AlkemyChallenge.AlkemyJavaChallenge.Clases;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
private String nombre;
@Lob
 @Basic(fetch = FetchType.LAZY)
private String imagen;
@OneToMany
private List<Pelicula> pelicula= new ArrayList<>();
}
