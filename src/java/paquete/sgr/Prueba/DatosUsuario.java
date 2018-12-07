
package paquete.sgr.Prueba;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "datos_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosUsuario.findAll", query = "SELECT d FROM DatosUsuario d")
    , @NamedQuery(name = "DatosUsuario.findByIdUsuarios", query = "SELECT d FROM DatosUsuario d WHERE d.idUsuarios = :idUsuarios")
    , @NamedQuery(name = "DatosUsuario.findByIdentificador", query = "SELECT d FROM DatosUsuario d WHERE d.identificador = :identificador")
    , @NamedQuery(name = "DatosUsuario.findByNombre", query = "SELECT d FROM DatosUsuario d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DatosUsuario.findByApellidoPaterno", query = "SELECT d FROM DatosUsuario d WHERE d.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "DatosUsuario.findByApellidoMaterno", query = "SELECT d FROM DatosUsuario d WHERE d.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "DatosUsuario.findByTelefono", query = "SELECT d FROM DatosUsuario d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "DatosUsuario.findByCorreo", query = "SELECT d FROM DatosUsuario d WHERE d.correo = :correo")
    , @NamedQuery(name = "DatosUsuario.findByNumeroSeguro", query = "SELECT d FROM DatosUsuario d WHERE d.numeroSeguro = :numeroSeguro")})
public class DatosUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarios")
    private Integer idUsuarios;
    @Size(max = 45)
    @Column(name = "Identificador")
    private String identificador;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Apellido_Paterno")
    private String apellidoPaterno;
    @Size(max = 45)
    @Column(name = "Apellido_Materno")
    private String apellidoMaterno;
    @Size(max = 25)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "Correo")
    private String correo;
    @Size(max = 45)
    @Column(name = "Numero_Seguro")
    private String numeroSeguro;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public DatosUsuario() {
    }

    public DatosUsuario(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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

    public String getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(String numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosUsuario)) {
            return false;
        }
        DatosUsuario other = (DatosUsuario) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "paquete.sgr.Prueba.DatosUsuario[ idUsuarios=" + idUsuarios + " ]";
    }

}
