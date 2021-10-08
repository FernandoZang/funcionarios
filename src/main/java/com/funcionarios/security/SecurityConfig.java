package com.funcionarios.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ImplemUserDetailsService userDetailsService;
    
    //Autorização para os end points
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.httpBasic().and().authorizeRequests()
            .antMatchers("/funcionario/list").hasAnyRole("GUEST", "ADMIN", "RH")
            .antMatchers("/funcionario/get").hasAnyRole("GUEST", "ADMIN", "RH")
            .antMatchers("/funcionario/update").hasAnyRole("ADMIN", "RH")
            .antMatchers("/funcionario/add").hasAnyRole("ADMIN", "RH")
            .antMatchers("/funcionario/delete").hasAnyRole("ADMIN")
            .and()
            .csrf().disable();
    }
 
    
    //Autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("rh").password("1234").roles("RH");
        auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("guest").password("1234").roles("GUEST");
//        auth.userDetailsService(userDetailsService)
//            .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
