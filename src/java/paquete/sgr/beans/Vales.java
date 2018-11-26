/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.beans;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author César
 */
public class Vales {
    public List<Materiales> listamaterial;
    public List<Equipos> listaequipo;
    public List<Reactivo> listareactivos;
    public String listam;
    public String listae;
    public String listar;
    public String m;
    public String e;
    public String r;
    public String EquipoAlumnos;
    public Date Fecha;
    public String Grupo;
    public String Unidad;
    

    public Vales() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.listamaterial);
        hash = 97 * hash + Objects.hashCode(this.listaequipo);
        hash = 97 * hash + Objects.hashCode(this.listareactivos);
        hash = 97 * hash + Objects.hashCode(this.listam);
        hash = 97 * hash + Objects.hashCode(this.listae);
        hash = 97 * hash + Objects.hashCode(this.listar);
        hash = 97 * hash + Objects.hashCode(this.m);
        hash = 97 * hash + Objects.hashCode(this.e);
        hash = 97 * hash + Objects.hashCode(this.r);
        hash = 97 * hash + Objects.hashCode(this.EquipoAlumnos);
        hash = 97 * hash + Objects.hashCode(this.Fecha);
        hash = 97 * hash + Objects.hashCode(this.Grupo);
        hash = 97 * hash + Objects.hashCode(this.Unidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vales other = (Vales) obj;
        if (!Objects.equals(this.listam, other.listam)) {
            return false;
        }
        if (!Objects.equals(this.listae, other.listae)) {
            return false;
        }
        if (!Objects.equals(this.listar, other.listar)) {
            return false;
        }
        if (!Objects.equals(this.m, other.m)) {
            return false;
        }
        if (!Objects.equals(this.e, other.e)) {
            return false;
        }
        if (!Objects.equals(this.r, other.r)) {
            return false;
        }
        if (!Objects.equals(this.EquipoAlumnos, other.EquipoAlumnos)) {
            return false;
        }
        if (!Objects.equals(this.Grupo, other.Grupo)) {
            return false;
        }
        if (!Objects.equals(this.Unidad, other.Unidad)) {
            return false;
        }
        if (!Objects.equals(this.listamaterial, other.listamaterial)) {
            return false;
        }
        if (!Objects.equals(this.listaequipo, other.listaequipo)) {
            return false;
        }
        if (!Objects.equals(this.listareactivos, other.listareactivos)) {
            return false;
        }
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        return true;
    }
    
    //Getters y setters

    public List<Materiales> getListamaterial() {
        return listamaterial;
    }

    public void setListamaterial(List<Materiales> listamaterial) {
        this.listamaterial = listamaterial;
    }

    public List<Equipos> getListaequipo() {
        return listaequipo;
    }

    public void setListaequipo(List<Equipos> listaequipo) {
        this.listaequipo = listaequipo;
    }

    public List<Reactivo> getListareactivos() {
        return listareactivos;
    }

    public void setListareactivos(List<Reactivo> listareactivos) {
        this.listareactivos = listareactivos;
    }

    public String getListam() {
        return listam;
    }

    public void setListam(String listam) {
        this.listam = listam;
    }

    public String getListae() {
        return listae;
    }

    public void setListae(String listae) {
        this.listae = listae;
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getEquipoAlumnos() {
        return EquipoAlumnos;
    }

    public void setEquipoAlumnos(String EquipoAlumnos) {
        this.EquipoAlumnos = EquipoAlumnos;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public String getUnidad() {
        return Unidad;
    }

    public void setUnidad(String Unidad) {
        this.Unidad = Unidad;
    }

    
    
}
