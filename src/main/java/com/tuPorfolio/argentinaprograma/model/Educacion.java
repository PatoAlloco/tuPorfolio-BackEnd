package com.tuPorfolio.argentinaprograma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String instituto;
    private String titulo;
    private Date inicio;
    private Date fin;

    public Educacion(String instituto, String titulo, Date inicio, Date fin) {
        this.instituto = instituto;
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Educacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Educacion)) return false;
        Educacion educacion = (Educacion) o;
        return Objects.equals(id, educacion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
