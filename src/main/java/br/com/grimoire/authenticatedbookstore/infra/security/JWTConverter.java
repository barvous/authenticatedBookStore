package br.com.grimoire.authenticatedbookstore.infra.security;

import java.util.Collection;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JWTConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    /*
     * By default, the spring security ROLES always have a prefix "ROLE_", so
     * a converter class necessary to read the JWT token and convert the roles. This
     * class is responsable for this functionality.
     */

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");

        Collection<String> roles = realmAccess.get("roles");

        var grants = roles
                .stream()
                .map(eachRole -> new SimpleGrantedAuthority("ROLE_" + eachRole))
                .toList();
        return new JwtAuthenticationToken(jwt, grants);

    }

}
