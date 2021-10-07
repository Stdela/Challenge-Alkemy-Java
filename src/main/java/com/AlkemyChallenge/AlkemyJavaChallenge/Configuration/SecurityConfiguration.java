package com.AlkemyChallenge.AlkemyJavaChallenge.Configuration;

import com.AlkemyChallenge.AlkemyJavaChallenge.Servicios.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 *
 * @author delam
 */
@Configuration
@EnableWebSecurity
//@ComponentScan
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService serviciousuario;
    

   

//    @Autowired
//    JwtRequestFilter jwtRequestFilter;
//    @Autowired
//    JwtUtil jwtUtil;
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        
        
        http.authorizeRequests()
                 .antMatchers("/auth/register/**").permitAll()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("auth/login/").permitAll()
                .antMatchers("/error").permitAll()
                .antMatchers("/error/**").permitAll()
                .anyRequest().hasAnyRole("USER");
        http.formLogin().loginPage("/auth/register")
                .loginProcessingUrl("auth/register")
             .failureUrl("/login?error")
                .successForwardUrl("/auth/login");

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

    }

    @Autowired
    @Override
   
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(serviciousuario).passwordEncoder(passwordEncoder());
//        
//        auth.inMemoryAuthentication().withUser("Santiago").password(this.passwordEncoder().encode("hola")).roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
