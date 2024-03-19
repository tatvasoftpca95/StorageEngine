package com.tatva.Filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tatva.utils.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication) {
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder().setIssuer("Tatvasoft").setSubject("JWT Token")
                    .claim("username", authentication.getName())
                    .claim("authorities", populateAuthorities(authentication.getAuthorities()))
                    //do not include the password
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + 30000000))
                    .signWith(key).compact();
            System.out.print("jwt token: "+jwt);
            response.setHeader(SecurityConstants.JWT_HEADER, jwt);
        }
       

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {//this jwt generator filter will not execute for this url
    	//only be generate when user logging in
        return !request.getServletPath().equals("/user");
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }

}
