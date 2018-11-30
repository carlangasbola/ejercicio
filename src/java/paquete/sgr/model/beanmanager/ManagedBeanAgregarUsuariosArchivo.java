/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.model.beanmanager;

import java.io.File;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import paquete.sgr.entity.util.HibernateUtil;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import paquete.sgr.entity.pojos.DatosUsuario;
import paquete.sgr.entity.pojos.Roles;
import paquete.sgr.entity.pojos.Usuarios;
import paquete.sgr.entity.pojos.ListaGrupo;
import paquete.sgr.entity.pojos.UnidadGrupo;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.model.beanmanager.ManagedBeanUpload;
import paquete.sgr.beans.UtilPath;
import paquete.sgr.entity.pojos.Equipo;
import paquete.sgr.model.beanmanager.dropdownview.DropdownViewGrupoUnidades;
/**
 *
 * @author Jorge
 */
@Named(value = "managedBeanAgregarUsuariosArchivo")
@RequestScoped
public class ManagedBeanAgregarUsuariosArchivo {

    /**
     * Creates a new instance of ManagedBeanAgregarUsuariosArchivo
     */
    public ManagedBeanAgregarUsuariosArchivo() {
    }
    
    private Session hibernateSession;
    private Session hibernateSessionAux;
    
    //Parametros para la creación de un usuario    
    private String nombre;
    private String paterno;
    private String materno;
    private String telefono;
    private String correo;
    private String password;
    private String numeroSeguro;
    private String identificador;
    private String equipo[]= {"","","","","","","","","",""};//new String[10];
    private String num_Equipo;
    private String grupo = DropdownViewGrupoUnidades.id_Grupo;
    private String unidad_aprendizaje =DropdownViewGrupoUnidades.id_UnidadAprendizaje;
    private int tipousuario = 3;
    private int rol =3;
    private int idDatos =3;
    private String filename = ManagedBeanUpload.fileName;
    private Equipo equipor;
    
    public void LeerArchivosExcel(){
        
        ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
        String realPath = UtilPath.getUrlDefinida(ec.getRealPath("/"));
        System.out.println(filename);
        String archivoDestino = realPath + File.separator + "web" + File.separator + "ExcelUpload" + File.separator + filename;
        int contador=1;
        
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        
        try{
            Workbook archivoExcel=Workbook.getWorkbook(new File(archivoDestino));
            
            //Recorre cada hoja
            for(int hojas=0;hojas<archivoExcel.getNumberOfSheets();hojas++){
                Sheet hoja=archivoExcel.getSheet(hojas);
                int x=0;
                int ideq=0;
                int numColumnas=hoja.getColumns();
                int numFilas=hoja.getRows();
                String dato;
                //Recorre cada fila de la hoja
                for(int fila=1;fila<numFilas;fila++){
                    for(int columna =1; columna<numColumnas;columna++){
                        dato=hoja.getCell(columna,fila).getContents();
                        System.out.print(dato+" ");
                        //Intruccion switch que evalua la variable contador
                        switch(contador){
                            case 1:
                                identificador = dato;
                                contador++;
                                break;
                            case 2:
                                nombre = dato;
                                contador++;
                                break;
                            case 3:
                                paterno = dato;
                                contador++;
                                break;
                            case 4:
                                materno = dato;
                                contador++;
                                break;
                           case 5:
                                num_Equipo = dato;
                                contador=1;
                                break;
                            //case 6:
                                //password = dato;
                                //contador++;
                                //break;
                            //case 7:
                                //numeroSeguro = dato;
                               //contador++;
                                //break;
                            //case 8:
                                //identificador = dato;
                                //contador=1;
                                //break;    
                        }
                        
                    }
                    
                    hibernateSession.beginTransaction();
                    ListaGrupo listgroup = new ListaGrupo();
                    Usuarios user = new Usuarios();
                    DatosUsuario datauser = new DatosUsuario();
                    Equipo eq = new Equipo();
                    Roles roles = new Roles();
                    ConsultasHQL consulta = new ConsultasHQL();

                    
                    List<UnidadGrupo> ug = consulta.crearSelectidUnidadGrupo("FROM UnidadGrupo WHERE unidadAprendizaje = " + unidad_aprendizaje +" AND grupo = " + grupo) ;
                    int idug = ug.get(0).getIdUnidadGrupo();
                    //System.out.println("idunidadgrupo" + idug);
                    // Obetener el rol
                    roles.setIdRol(rol);
                    //El login y el password sera con el identificador
                    user.setLogin(identificador);
                    user.setPasssword(identificador);
                    user.setRoles(roles);
                    //Guardamos el usuario en la base de datos
                    hibernateSession.save(user);
                    
                    //Llenamos la tabala de datos de usuario
                    datauser.setNombre(nombre);
                    datauser.setApellidoPaterno(paterno);
                    datauser.setApellidoMaterno(materno);
                    //datauser.setTelefono(telefono);
                    //datauser.setCorreo(correo);
                    //datauser.setNumeroSeguro(numeroSeguro);
                    datauser.setIdentificador(identificador);
                    // Hacemos la relacion de los datos de usuario con la tabla usuario
                    datauser.setUsuarios(user);
                    //Guardamos los datos del usuario
                    hibernateSession.save(datauser);
                    

                    /*
                    int variableEquipo=0;
                    for(int i=0; i<equipo.length;i++){
                        if(equipo[i].equals(num_Equipo) ){
                            variableEquipo=1;
                        System.out.println("variable 1");
                        }

                    }
                    
                    if(variableEquipo==1){
 
                        eq.setNombre(num_Equipo);
                        eq.setUnidadGrupo(ug.get(0));
                        hibernateSession.saveOrUpdate(eq);   
                    
                        List<Equipo> equipoor = consulta.crearSelectidUnidadGrupo("FROM Equipo WHERE nombre = " + num_Equipo ) ;
                        listgroup.setEquipo(eq);
                        listgroup.setUsuarios(user);
                        listgroup.setUnidadGrupo(ug.get(0));
                        hibernateSession.save(listgroup);
                    }

                    if(variableEquipo==0){
                        equipo[x]=num_Equipo;
                        x++;
                        eq.setNombre(num_Equipo);
                        eq.setUnidadGrupo(ug.get(0));
                        hibernateSession.save(eq);
                        equipor=eq;
                        listgroup.setEquipo(eq);
                        listgroup.setUsuarios(user);
                        listgroup.setUnidadGrupo(ug.get(0));
                        hibernateSession.save(listgroup);
                    }*/
                    
                    hibernateSession.getTransaction().commit();
                    
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Agregados con éxito"));
            }
        }catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "No se completo la acción, inténtelo más tarde"));
            System.out.println("ExepcionAlumno : " + e);
        }
    }
    
    public void crearUsuario() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        try {
            hibernateSession.beginTransaction();
            Usuarios user = new Usuarios();
            DatosUsuario datauser = new DatosUsuario();
            Roles roles = new Roles();

            // Obetener el rol
            roles.setIdRol(rol);
            //El login sera con el correo y la password dada
            user.setLogin(correo);
            user.setPasssword(password);
            user.setRoles(roles);
            //Guardamos el usuario en la base de datos
            hibernateSession.save(user);

            //Llenamos la tabala de datos de usuario
            datauser.setNombre(nombre);
            datauser.setApellidoPaterno(paterno);
            datauser.setApellidoMaterno(materno);
            datauser.setTelefono(telefono);
            datauser.setCorreo(correo);
            datauser.setNumeroSeguro(numeroSeguro);
            // Hacemos la relacion de los datos de usuario con la tabla usuario
            datauser.setUsuarios(user);
            //Guardamos los datos del usuario
            hibernateSession.save(datauser);
            hibernateSession.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Agregado con éxito"));
        } catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "Algo salio mal :v"));
            System.out.println("Exepcion : " + e);
        }

    }

    // Obtenemos el Id del usuario en sesión
    public int getIdUsuarioSession() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        return (int) sessionMap.get("UserId");
    }

    public Session getHibernateSession() {
        return hibernateSession;
    }

    public void setHibernateSession(Session hibernateSession) {
        this.hibernateSession = hibernateSession;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(String numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public int getRol() {
        return rol;
    }

    /* Valores para crear un solo Usuario */
    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getIdDatos_usuario() {
        return idDatos;
    }

    public void setIdDatos_usuario(int idDatos_usuario) {
        this.idDatos = idDatos_usuario;
    }

}
