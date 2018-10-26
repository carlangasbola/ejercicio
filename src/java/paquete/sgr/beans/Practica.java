package paquete.sgr.beans;
import java.util.List;
import java.util.Objects;

public class Practica {
    //Primera parte creacionPractica1.xhtml
    private String semestre;
    private int numeropractica ;
    private String titulopractica;
    public String autor;
    private String editor;
    public String introduccion;
    private String objetivos;
    private String actividadesprevias;
    //Segunta parte creacionPractica2.xhtml
    public List<Material> listamaterial;
    public List<Equipo> listaequipo;
    public List<Reactivos> listareactivos;
    private String competencias;
    //Tercera parte creacionPractica3.xhtml
    private String desarrolloexperimental;
    private String registrodedatos;
    private String resultados;
    private String analisisderesultados;
    private String referencias;
    private String nomenclatura;
    private String anexos;
    //Cuarta parte parte creacionPractica3.xhtml
    private String protocolosdeactuacion;
    private String recomendaciones;
    private String semaforo;

    public Practica(){

    }
    
    public void imprime(){
        System.out.println("Semestre: " + getSemestre());
        System.out.println("Numero de practica: " + getNumeropractica());
        System.out.println("titulo de practica: " + getTitulopractica());
        System.out.println("Autor: " + getAutor());
        System.out.println("Editor: " + getEditor());
        System.out.println("Objetivos: " + getObjetivos());
        System.out.println("Actividades previas: " + getActividadesprevias());
        System.out.println("Introduccion: " + getIntroduccion());
        for(Material item:getListamaterial())
            System.out.println("Cantidad: " + item.getCantidad() + " Material: " + item.getNombre());
        for(Equipo item:getListaequipo())
            System.out.println("Cantidad: " + item.getCantidad() + " Equipo: " + item.getNombre());
        for(Reactivos item:getListareactivos())
            System.out.println("Cantidad: " + item.getCantidad() + " Reactivo: " + item.getNombre());
        System.out.println("Competencias: " + getCompetencias());
        System.out.println("Desarrollo experimental: " + getDesarrolloexperimental());
        System.out.println("Registro de datos: " + getRegistrodedatos());
        System.out.println("Resultados: " + getResultados());
        System.out.println("Analisis de resultados: " + getAnalisisderesultados());
        System.out.println("Referencias: " + getReferencias());
        System.out.println("Nomenclatura: " + getNomenclatura());
        System.out.println("Anexos: " + getAnexos());
        System.out.println("Protocolos de actuacion: " + getProtocolosdeactuacion());
        System.out.println("Recomendaciones: " + getRecomendaciones());
        System.out.println("Semaforo: " + getSemaforo());
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.semestre);
        hash = 29 * hash + this.numeropractica;
        hash = 29 * hash + Objects.hashCode(this.titulopractica);
        hash = 29 * hash + Objects.hashCode(this.autor);
        hash = 29 * hash + Objects.hashCode(this.editor);
        hash = 29 * hash + Objects.hashCode(this.objetivos);
        hash = 29 * hash + Objects.hashCode(this.actividadesprevias);
        hash = 29 * hash + Objects.hashCode(this.introduccion);
        hash = 29 * hash + Objects.hashCode(this.listamaterial);
        hash = 29 * hash + Objects.hashCode(this.listaequipo);
        hash = 29 * hash + Objects.hashCode(this.listareactivos);
        hash = 29 * hash + Objects.hashCode(this.competencias);
        hash = 29 * hash + Objects.hashCode(this.desarrolloexperimental);
        hash = 29 * hash + Objects.hashCode(this.registrodedatos);
        hash = 29 * hash + Objects.hashCode(this.resultados);
        hash = 29 * hash + Objects.hashCode(this.analisisderesultados);
        hash = 29 * hash + Objects.hashCode(this.referencias);
        hash = 29 * hash + Objects.hashCode(this.nomenclatura);
        hash = 29 * hash + Objects.hashCode(this.anexos);
        hash = 29 * hash + Objects.hashCode(this.protocolosdeactuacion);
        hash = 29 * hash + Objects.hashCode(this.recomendaciones);
        hash = 29 * hash + Objects.hashCode(this.semaforo);
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
        if (!Objects.equals(this.semestre, other.semestre)) {
            return false;
        }
        if (!Objects.equals(this.titulopractica, other.titulopractica)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.editor, other.editor)) {
            return false;
        }
        if (!Objects.equals(this.objetivos, other.objetivos)) {
            return false;
        }
        if (!Objects.equals(this.actividadesprevias, other.actividadesprevias)) {
            return false;
        }
        if (!Objects.equals(this.introduccion, other.introduccion)) {
            return false;
        }
        if (!Objects.equals(this.competencias, other.competencias)) {
            return false;
        }
        if (!Objects.equals(this.desarrolloexperimental, other.desarrolloexperimental)) {
            return false;
        }
        if (!Objects.equals(this.registrodedatos, other.registrodedatos)) {
            return false;
        }
        if (!Objects.equals(this.resultados, other.resultados)) {
            return false;
        }
        if (!Objects.equals(this.analisisderesultados, other.analisisderesultados)) {
            return false;
        }
        if (!Objects.equals(this.referencias, other.referencias)) {
            return false;
        }
        if (!Objects.equals(this.nomenclatura, other.nomenclatura)) {
            return false;
        }
        if (!Objects.equals(this.anexos, other.anexos)) {
            return false;
        }
        if (!Objects.equals(this.protocolosdeactuacion, other.protocolosdeactuacion)) {
            return false;
        }
        if (!Objects.equals(this.recomendaciones, other.recomendaciones)) {
            return false;
        }
        if (!Objects.equals(this.semaforo, other.semaforo)) {
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
        return true;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getNumeropractica() {
        return numeropractica;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public String getActividadesprevias() {
        return actividadesprevias;
    }

    public void setActividadesprevias(String actividadesprevias) {
        this.actividadesprevias = actividadesprevias;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }

    public List<Material> getListamaterial() {
        return listamaterial;
    }

    public void setListamaterial(List<Material> listamaterial) {
        this.listamaterial = listamaterial;
    }

    public List<Equipo> getListaequipo() {
        return listaequipo;
    }

    public void setListaequipo(List<Equipo> listaequipo) {
        this.listaequipo = listaequipo;
    }

    public List<Reactivos> getListareactivos() {
        return listareactivos;
    }

    public void setListareactivos(List<Reactivos> listareactivos) {
        this.listareactivos = listareactivos;
    }

    public String getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public String getDesarrolloexperimental() {
        return desarrolloexperimental;
    }

    public void setDesarrolloexperimental(String desarrolloexperimental) {
        this.desarrolloexperimental = desarrolloexperimental;
    }

    public String getRegistrodedatos() {
        return registrodedatos;
    }

    public void setRegistrodedatos(String registrodedatos) {
        this.registrodedatos = registrodedatos;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getAnalisisderesultados() {
        return analisisderesultados;
    }

    public void setAnalisisderesultados(String analisisderesultados) {
        this.analisisderesultados = analisisderesultados;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }

    public String getProtocolosdeactuacion() {
        return protocolosdeactuacion;
    }

    public void setProtocolosdeactuacion(String protocolosdeactuacion) {
        this.protocolosdeactuacion = protocolosdeactuacion;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(String semaforo) {
        this.semaforo = semaforo;
    }

    public void add(Object clone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}