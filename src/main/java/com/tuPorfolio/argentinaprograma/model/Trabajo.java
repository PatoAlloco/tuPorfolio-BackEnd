package com.tuPorfolio.argentinaprograma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String empresa;
    private String puesto;
    private Date inicio;
    private Date fin;

    public Trabajo(String empresa, String puesto, Date inicio, Date fin) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Trabajo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
        if (!(o instanceof Trabajo)) return false;
        Trabajo trabajo = (Trabajo) o;
        return Objects.equals(id, trabajo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
