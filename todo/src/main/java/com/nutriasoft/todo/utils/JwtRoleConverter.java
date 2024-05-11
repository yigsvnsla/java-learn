package com.nutriasoft.todo.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;


@Component
public class JwtRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    @SuppressWarnings("unchecked")
    public Collection<GrantedAuthority> convert(@NonNull Jwt source) {
        if (source.getClaims() == null) {
            return List.of();
        }

        var resource_claims = (Map<String, List<String>>) source.getClaim("resource_access");
        var resource = (Map<String, List<String>>) resource_claims.get("todoAppClient");
        return resource
                .get("roles")
                .stream()
                .map(t -> "ROLE_" + t)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}