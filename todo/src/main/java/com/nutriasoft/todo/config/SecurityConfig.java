package com.nutriasoft.todo.config;

// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@Component
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .sessionManagement( sessionManagementn -> sessionManagementn.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(auth -> {
                    auth.jwt(jwt -> {});
                });
                // .httpBasic(withDefaults())
                // .formLogin(withDefaults());
        return http.build();
    }

    // @Bean
    // SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    //     return httpSecurity
    //             .csrf(csrf -> csrf.disable())
    //             .authorizeHttpRequests(http -> http.anyRequest())
    //             .oauth2ResourceServer(oAuth2RS -> {
    //                 oAuth2RS.jwt(jwt -> {
    //                 });
    //             })
    //             .sessionManagement(
    //                     sessionManagementn -> sessionManagementn.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    //             .build();
    // }

}
