package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;



import com.AlkemyChallenge.AlkemyJavaChallenge.Clases.Usuario;
import com.AlkemyChallenge.AlkemyJavaChallenge.Repositorios.UserRepositorio;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author delam
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepositorio userrep;
    @Autowired 
    PasswordEncoder passEncoder;
    
    public Usuario registrar (@RequestBody Usuario usuario){

        userrep.save(usuario);
         loadUserByUsername(usuario.getUsername());
        return usuario;
        
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = userrep.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("No existe este usuario: " + username);
        }
        
            return new org.springframework.security.core.userdetails.User(
                    
                usuario.getUsername(),
                usuario.getPassword(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER")));  
    }
  
}
