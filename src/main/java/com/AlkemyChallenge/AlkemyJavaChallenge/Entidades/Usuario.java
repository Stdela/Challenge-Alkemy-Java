package com.AlkemyChallenge.AlkemyJavaChallenge.Entidades;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
public class Usuario extends AbstractPersistable<Long> {

    @NotNull(message = "email can't be null")
   
    @Email
    private String email;
    @NotNull(message = " username can't be null")
  
    private String username;
    @NotNull(message = "password can't be null")
  
    private String password;

}
