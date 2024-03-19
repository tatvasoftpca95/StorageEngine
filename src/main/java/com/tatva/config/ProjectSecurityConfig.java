package com.tatva.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.tatva.Filter.CsrfCookieFilter;
import com.tatva.Filter.JWTTokenGeneratorFilter;
import com.tatva.Filter.JWTTokenValidatorFilter;

import jakarta.servlet.http.HttpServletRequest;


@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        
        //cors
//            .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
//            @Override
//            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//                CorsConfiguration config = new CorsConfiguration();
//                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
//                config.setAllowedMethods(Collections.singletonList("*"));
//                config.setAllowCredentials(true);
//                config.setAllowedHeaders(Collections.singletonList("*"));
//                config.setExposedHeaders(Arrays.asList("Authorization"));
//                config.setMaxAge(3600L);
//                return config;
//            }
//                }))
        .csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/faculty-schedule/save-all", "/register","/course/byAllIds")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
           //filters
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
         //jwt filters
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
                
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers("/user", "/room/**","/academic/**","/faculty/**","/faculties/rooms","/year-type",
                        		"/program/**","/semester/**","/course/**").authenticated()
                 .requestMatchers("/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
