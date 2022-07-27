package com.tuPorfolio.argentinaprograma.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix="seguridad.cors")
public class HeadersCorsConfig {

    private Map<String,String> headers = new HashMap<String, String>();

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }



}
