
package com.AlkemyChallenge.AlkemyJavaChallenge.Clases;

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
public class Usuario extends AbstractPersistable<Long>{
//@NotNull
//@NotEmpty
//@Email  
private String email;
//@NotNull
//@NotEmpty
private String username;
//@NotNull
//@NotEmpty
private String password;

}
