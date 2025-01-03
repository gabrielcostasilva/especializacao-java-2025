package br.edu.utfpr.cp.espjava.crudcidades;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager configure() throws Exception {
        UserDetails john = User.withUsername("john")
                    .password(cifrador().encode("test123"))
                    .roles("listar")
                    .build();
        
        UserDetails anna = User.withUsername("anna")
                    .password(cifrador().encode("test123"))
                    .roles("admin")
                    .build();

        return new InMemoryUserDetailsManager(john, anna);
    }

    @Bean
    public PasswordEncoder cifrador() {
        return new BCryptPasswordEncoder();
    }
}

