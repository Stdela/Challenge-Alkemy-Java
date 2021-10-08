package com.AlkemyChallenge.AlkemyJavaChallenge.Configuration;

import com.AlkemyChallenge.AlkemyJavaChallenge.Filters.CustomAuthorizationFilter;
import com.AlkemyChallenge.AlkemyJavaChallenge.Filters.CustomAuthenticationFilter;
import com.AlkemyChallenge.AlkemyJavaChallenge.Servicios.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
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

/**
 *
 * @author delam
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@ComponentScan
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService serviciousuario;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/auth/login");
        http.
                csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/auth/register/**").permitAll()
                .antMatchers("auth/login/**").permitAll()
                .antMatchers("/error").permitAll()
                .antMatchers("/error/**").permitAll()
                .anyRequest().permitAll();
                
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), CustomAuthenticationFilter.class);

    }

    @Override
//    @Bean
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(serviciousuario).passwordEncoder(passwordEncoder());

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
