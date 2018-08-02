package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Practica {
    private int numeropractica ;
    private String titulopractica;
    private String competencias;
    private String semestre;
    private String creador;
    private String editor;
    private String objetivos;
    private List<Material> list;
    
    public int getNumeropractica() {
        return numeropractica;
    }

    public Practica(int numeropractica, String titulopractica, String competencias, String semestre, String creador, String editor, String objetivos, List<Material> list) {
        this.numeropractica = numeropractica;
        this.titulopractica = titulopractica;
        this.competencias = competencias;
        this.semestre = semestre;
        this.creador = creador;
        this.editor = editor;
        this.objetivos = objetivos;
        this.list = list;
    }
    
    
    public Practica() {
        list = new ArrayList<>();
    } 
    
    

    public void setNumeropractica(int numeropractica) {
        this.numeropractica = numeropractica;
    }

    public String getTitulopractica() {
        return titulopractica;
    }

    public void setTitulopractica(String titulopractica) {
        this.titulopractica = titulopractica;
    }

    public String getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public List<Material> getList() {
        return list;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.numeropractica;
        hash = 71 * hash + Objects.hashCode(this.titulopractica);
        hash = 71 * hash + Objects.hashCode(this.competencias);
        hash = 71 * hash + Objects.hashCode(this.semestre);
        hash = 71 * hash + Objects.hashCode(this.creador);
        hash = 71 * hash + Objects.hashCode(this.editor);
        hash = 71 * hash + Objects.hashCode(this.objetivos);
        hash = 71 * hash + Objects.hashCode(this.list);
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
        final Practica other = (Practica) obj;
        if (this.numeropractica != other.numeropractica) {
            return false;
        }
        if (!Objects.equals(this.titulopractica, other.titulopractica)) {
            return false;
        }
        if (!Objects.equals(this.competencias, other.competencias)) {
            return false;
        }
        if (!Objects.equals(this.semestre, other.semestre)) {
            return false;
        }
        if (!Objects.equals(this.creador, other.creador)) {
            return false;
        }
        if (!Objects.equals(this.editor, other.editor)) {
            return false;
        }
        if (!Objects.equals(this.objetivos, other.objetivos)) {
            return false;
        }
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        return true;
    }
    
    
}