package modelobase;
// Generated 3/10/2018 11:18:56 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DatosPractica generated by hbm2java
 */
public class DatosPractica  implements java.io.Serializable {


     private Integer idDatos;
     private Practica practica;
     private int numeroPractica;
     private String nombre;
     private String editor;
     private Date actualizacion;
     private String introducion;
     private String actividadesPrevias;
     private String objetivos;
     private String semaforo;
     private String recomendaciones;
     private String protocolos;
     private String desarrollo;
     private String registroDatos;
     private String resultados;
     private String analisisResultados;
     private String referencias;
     private String nomeclantura;
     private String anexos;
     private Set equipoUtilizados = new HashSet(0);
     private Set reactivosUtilizados = new HashSet(0);
     private Set materialUtilizados = new HashSet(0);

    public DatosPractica() {
    }

	
    public DatosPractica(Practica practica, int numeroPractica, String nombre, String introducion, String actividadesPrevias, String objetivos, String semaforo, String recomendaciones, String protocolos) {
        this.practica = practica;
        this.numeroPractica = numeroPractica;
        this.nombre = nombre;
        this.introducion = introducion;
        this.actividadesPrevias = actividadesPrevias;
        this.objetivos = objetivos;
        this.semaforo = semaforo;
        this.recomendaciones = recomendaciones;
        this.protocolos = protocolos;
    }
    public DatosPractica(Practica practica, int numeroPractica, String nombre, String editor, Date actualizacion, String introducion, String actividadesPrevias, String objetivos, String semaforo, String recomendaciones, String protocolos, String desarrollo, String registroDatos, String resultados, String analisisResultados, String referencias, String nomeclantura, String anexos, Set equipoUtilizados, Set reactivosUtilizados, Set materialUtilizados) {
       this.practica = practica;
       this.numeroPractica = numeroPractica;
       this.nombre = nombre;
       this.editor = editor;
       this.actualizacion = actualizacion;
       this.introducion = introducion;
       this.actividadesPrevias = actividadesPrevias;
       this.objetivos = objetivos;
       this.semaforo = semaforo;
       this.recomendaciones = recomendaciones;
       this.protocolos = protocolos;
       this.desarrollo = desarrollo;
       this.registroDatos = registroDatos;
       this.resultados = resultados;
       this.analisisResultados = analisisResultados;
       this.referencias = referencias;
       this.nomeclantura = nomeclantura;
       this.anexos = anexos;
       this.equipoUtilizados = equipoUtilizados;
       this.reactivosUtilizados = reactivosUtilizados;
       this.materialUtilizados = materialUtilizados;
    }
   
    public Integer getIdDatos() {
        return this.idDatos;
    }
    
    public void setIdDatos(Integer idDatos) {
        this.idDatos = idDatos;
    }
    public Practica getPractica() {
        return this.practica;
    }
    
    public void setPractica(Practica practica) {
        this.practica = practica;
    }
    public int getNumeroPractica() {
        return this.numeroPractica;
    }
    
    public void setNumeroPractica(int numeroPractica) {
        this.numeroPractica = numeroPractica;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEditor() {
        return this.editor;
    }
    
    public void setEditor(String editor) {
        this.editor = editor;
    }
    public Date getActualizacion() {
        return this.actualizacion;
    }
    
    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }
    public String getIntroducion() {
        return this.introducion;
    }
    
    public void setIntroducion(String introducion) {
        this.introducion = introducion;
    }
    public String getActividadesPrevias() {
        return this.actividadesPrevias;
    }
    
    public void setActividadesPrevias(String actividadesPrevias) {
        this.actividadesPrevias = actividadesPrevias;
    }
    public String getObjetivos() {
        return this.objetivos;
    }
    
    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }
    public String getSemaforo() {
        return this.semaforo;
    }
    
    public void setSemaforo(String semaforo) {
        this.semaforo = semaforo;
    }
    public String getRecomendaciones() {
        return this.recomendaciones;
    }
    
    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
    public String getProtocolos() {
        return this.protocolos;
    }
    
    public void setProtocolos(String protocolos) {
        this.protocolos = protocolos;
    }
    public String getDesarrollo() {
        return this.desarrollo;
    }
    
    public void setDesarrollo(String desarrollo) {
        this.desarrollo = desarrollo;
    }
    public String getRegistroDatos() {
        return this.registroDatos;
    }
    
    public void setRegistroDatos(String registroDatos) {
        this.registroDatos = registroDatos;
    }
    public String getResultados() {
        return this.resultados;
    }
    
    public void setResultados(String resultados) {
        this.resultados = resultados;
    }
    public String getAnalisisResultados() {
        return this.analisisResultados;
    }
    
    public void setAnalisisResultados(String analisisResultados) {
        this.analisisResultados = analisisResultados;
    }
    public String getReferencias() {
        return this.referencias;
    }
    
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
    public String getNomeclantura() {
        return this.nomeclantura;
    }
    
    public void setNomeclantura(String nomeclantura) {
        this.nomeclantura = nomeclantura;
    }
    public String getAnexos() {
        return this.anexos;
    }
    
    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }
    public Set getEquipoUtilizados() {
        return this.equipoUtilizados;
    }
    
    public void setEquipoUtilizados(Set equipoUtilizados) {
        this.equipoUtilizados = equipoUtilizados;
    }
    public Set getReactivosUtilizados() {
        return this.reactivosUtilizados;
    }
    
    public void setReactivosUtilizados(Set reactivosUtilizados) {
        this.reactivosUtilizados = reactivosUtilizados;
    }
    public Set getMaterialUtilizados() {
        return this.materialUtilizados;
    }
    
    public void setMaterialUtilizados(Set materialUtilizados) {
        this.materialUtilizados = materialUtilizados;
    }




}


