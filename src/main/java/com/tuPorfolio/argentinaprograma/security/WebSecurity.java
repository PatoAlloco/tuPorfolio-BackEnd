package com.tuPorfolio.argentinaprograma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private AuthenticationConfig authenticationConfig;
    private RestAuthEntryPoint restAuthEntryPoint;

    @Autowired
    public WebSecurity(AuthenticationConfig authenticationConfig, RestAuthEntryPoint restAuthEntryPoint) {
        this.authenticationConfig = authenticationConfig;
        this.restAuthEntryPoint = restAuthEntryPoint;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /*
         * 1. Se desactiva el uso de cookies
         * 2. Se activa la configuración CORS con los valores por defecto
         * 3. Se desactiva el filtro CSRF
         * 4. Se indica que el login no requiere autenticación
         * 5. Se indica que el resto de URLs esten securizadas
         */
        httpSecurity
                .csrf().disable().authorizeRequests()
                .anyRequest().authenticated().and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .exceptionHandling()
                .authenticationEntryPoint(this.restAuthEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        HeadersConfigurer<HttpSecurity> headers = httpSecurity.headers();
        headers.cacheControl();
        headers.frameOptions();
        headers.xssProtection();
        for (String header : cors().getHeaders().keySet()) {
            headers.addHeaderWriter(new StaticHeadersWriter(header, cors().getHeaders().get(header)));
        }

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
        auth.userDetailsService(this.authenticationConfig).passwordEncoder(passwordEncoder());
    }

    @Bean
    public HeadersCorsConfig cors() {
        return new HeadersCorsConfig();
    }

}
