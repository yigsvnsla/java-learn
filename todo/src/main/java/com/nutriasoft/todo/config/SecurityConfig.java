package com.nutriasoft.todo.config;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(http -> http.anyRequest())
                .oauth2ResourceServer(oAuth2RS -> {
                    oAuth2RS.jwt(jwt -> {
                    });
                })
                .sessionManagement(
                        sessionManagementn -> sessionManagementn.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}