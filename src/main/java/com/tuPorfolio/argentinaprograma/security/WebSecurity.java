package com.tuPorfolio.argentinaprograma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
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
        httpSecurity.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class); //permito que pasen las peticiones OPTIONS
        httpSecurity
                .csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/usuario/registro").permitAll() //permito post sin token

                .anyRequest().authenticated().and()                    //filtra todas las peticiones para validar toke
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .exceptionHandling()
                .authenticationEntryPoint(this.restAuthEntryPoint).and()     //si no pasa sale con error 401
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        HeadersConfigurer<HttpSecurity> headers = httpSecurity.headers();
        headers.cacheControl();
        headers.frameOptions();
        headers.xssProtection();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
        auth.userDetailsService(this.authenticationConfig).passwordEncoder(passwordEncoder());
    }
}
