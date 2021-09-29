package com.AlkemyChallenge.AlkemyJavaChallenge.Clases;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
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
public class Personaje extends AbstractPersistable<Long> {

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] imagen;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    @ManyToMany
    List<Pelicula> pelicula = new ArrayList<>();

}
