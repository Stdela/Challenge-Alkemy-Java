
package com.AlkemyChallenge.AlkemyJavaChallenge.Clases.requestModels.dtoModels;


import javax.validation.constraints.Email;
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

public class UsuarioDTO {
@NotNull

@Email
private String email;
@NotNull

private String username;
@NotNull

private String password;

}
