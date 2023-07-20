package com.example.HelloWorld.Configuration;

import com.example.HelloWorld.Service.StudentService;
import org.apache.coyote.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration implements WebSecurityConfigureAdapter {
    @Autowired

    private StudentService StudentService;







    @Override
    public void init(Adapter builder) throws Exception {

    }

    @Override
    public void configure(Adapter builder) throws Exception {

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(StudentService);

    }
  @override
    protected void configure(HttpSecurity http) throws Exception{
            http.csrf().disable() .authorizeRequests().dispatcherTypeMatchers("/upload","auth").permitAll().anyRequest().authenticated();}
@Bean

   public PasswordEncoder passwordEncoder(){

        return NoOpPasswordEncoder.getInstance();
   }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
@Bean
    @Override
public AuthenticationManager authenticationManagerBean() throws  Exception{
        return super.authenticationManagerBean();
}

}
