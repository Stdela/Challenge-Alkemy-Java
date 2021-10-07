
package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestClasses.dtoClasses;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
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

public class UsuarioDTO {
@NotNull
@NotEmpty
@Email
private String email;
@NotNull
@NotEmpty
private String username;
@NotNull
@NotEmpty
private String password;

}
