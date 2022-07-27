package com.tuPorfolio.argentinaprograma.security;

public class AuthenticatorDTO {

    private String mail;
    private String password;

    private String token;

    public AuthenticatorDTO(String mail, String password, String token){
        this.mail = mail;
        this.password = password;
        this.token = token;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
