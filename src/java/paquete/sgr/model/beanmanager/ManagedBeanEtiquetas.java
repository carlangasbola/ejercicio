package paquete.sgr.model.beanmanager;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author iron1
 */
@Named(value = "Etiquetas")
@RequestScoped
public class ManagedBeanEtiquetas {

    private String headerIndex;
    private String headerTodasPaginas;
    private String metaTagsLinkTagsIndex;
    private String metaTagsLinkTags;
    private String numeroNotificaciones;
    private String navegacionAdministrador;
    
    public ManagedBeanEtiquetas() {
        // Establecemos el numero de notificaciones
        numeroNotificaciones = "0";
        /*
            Esta etiqueta contine las siguientes etiquetas meta y links
            <!-- Viewport y UTF-8 --> META 
            <!-- Bootstrap CSS CORE --> LINK
            <!-- Iconos de FONT AWESOME --> LINK 
            <!-- Fuente ligera ROBOTO DE GOOGLE--> LINK
            <!-- ESTILOS PROPIOS DE LA PAGINA --> Ruta del archivo misestilos/estiloC.css LINK
            !! NO CONTIENE LA ETIQUETA TITLE ESA SE AGREGA MANUAL ¡¡
         */
        metaTagsLinkTags = " <meta charset='utf-8'/> <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'/> <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'/> <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.2.0/css/all.css' integrity='sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ' crossorigin='anonymous'/> <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,500&amp;subset=latin-ext' rel='stylesheet'/> <link href='../misestilos/estiloC.css' rel='stylesheet' type='text/css'/>";
        metaTagsLinkTagsIndex = " <meta charset='utf-8'/> <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'/> <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'/> <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.2.0/css/all.css' integrity='sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ' crossorigin='anonymous'/> <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,500&amp;subset=latin-ext' rel='stylesheet'/> <link href='misestilos/estiloC.css' rel='stylesheet' type='text/css'/> ";

        /*
            Estas variables las inyectamos en el index y las paginas html para un mejor control
         */
        // Codigo minificado para, poder leerlo bien busque un desminifier y pege la etiqueta
        headerIndex = "<header> <nav class='navbar navbar-expand-lg navbar-custom mb-4'> <a class='navbar-brand' href='#'>IPN</a> <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'><span class='navbar-toggler-icon'></span></button> <div class='collapse navbar-collapse justify-content-end' id='navbarSupportedContent'> <ul class='navbar-nav '> <li class='nav-item '> <a class='nav-link active' href='#'>Tutorial de uso del sistema<span class='sr-only'>(current)</span></a> </li><li class='nav-item'> <a class='nav-link' href='#'>Directorio Teléfonico</a> </li><li class='nav-item'> <a class='nav-link disabled' href='#'>Buzón de sugerencias</a> </li></ul> </div></nav> </header>";
        headerTodasPaginas = "<header> <nav class='navbar navbar-expand-lg navbar-custom '> <a class='navbar-brand' href='Administrador/administrador.xhtml'>Inicio</a> <button class='btn btn-link btn-sm text-white order-1 order-sm-0' id='sidebarToggle' href='#'> <i class='fas fa-bars'></i> </button> <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'><span class='navbar-toggler-icon'></span></button> <div class='collapse navbar-collapse justify-content-end' id='navbarSupportedContent'> <ul class='navbar-nav '> <li class='nav-item active'> <a class='nav-link' href='#'> <i class='fas fa-home'></i> Inicio </a> </li><li class='nav-item'> <a class='nav-link' href='#'> <i class='fas fa-comment-alt'></i> Notificaciones <span class='badge badge-primary '>" +  numeroNotificaciones + "</span> </a> </li><li class='nav-item'> <a class='nav-link' href='Administrador/telefonos.xhtml'> <i class='fas fa-phone'></i> Directorio Teléfonico </a> </li><li class='nav-item'> <a class='nav-link disabled' href='Administrador/buzon.xhtml'> <i class='fas fa-envelope-square'></i> Buzón de sugerencias </a> </li><li> <form jsf:id='formlogout1'> <button class='btn btn-sm colorverde rounded' type='submit' jsf:action='#{managedBeanLogin.logout()}' ><i class='fas fa-sign-out-alt'></i> Cerrar sesión</button> </form> </li></ul> </div></nav></header> ";
        
        // Naveación 
        navegacionAdministrador = "<ul class='sidebar navbar-nav'>\n" +
"                <li class='nav-item'>\n" +
"                    <a class='nav-link' href='Administrador/administrador.xhtml'>\n" +
"                        <i class='fas fa-fw fa-tachometer-alt'></i>\n" +
"                        <span>Página principal</span>\n" +
"                    </a>\n" +
"                </li>\n" +
"                <li class='nav-item dropdown'>\n" +
"                    <a class='nav-link ' href='#' id='pagesDropdown' role='button' data-toggle='dropdown'\n" +
"                       aria-expanded='false'>\n" +
"                        <i class='fas fa-users'></i>\n" +
"                        <span class='mr-2'>Módulo de usuarios</span>\n" +
"                        <i class='fas fa-caret-down '></i>\n" +
"                    </a>\n" +
"                    <div class='dropdown-menu' aria-labelledby='pagesDropdown'>\n" +
"                        <h6 class='dropdown-header'>Selecciona una opción:</h6>\n" +
"                        <a class='dropdown-item' href='Administrador/ registrarUsuarios.xhtml'>Registrar Usuarios</a>\n" +
"                        <a class='dropdown-item' href='Administrador/ administracionUsuarios.xhtml'>Ver todos Usuarios</a>\n" +
"                    </div>\n" +
"                </li>\n" +
"\n" +
"                <li class='nav-item dropdown'>\n" +
"                    <a class='nav-link ' href='#' id='pagesDropdown' role='button' data-toggle='dropdown'\n" +
"                       aria-expanded='false'>\n" +
"                        <i class='far fa-file-alt'></i>\n" +
"                        <span class='mr-2'>Módulo de prácticas</span>\n" +
"                        <i class='fas fa-caret-down '></i>\n" +
"                    </a>\n" +
"                    <div class='dropdown-menu' aria-labelledby='pagesDropdown'>\n" +
"                        <h6 class='dropdown-header'>Selecciona una opción:</h6>\n" +
"                        <a class='dropdown-item' href='Administrador/moduloPractica.xhtml'>Crear práctica</a>\n" +
"                        <a class='dropdown-item' href='#'>Ver todas las prácticas</a>\n" +
"                        <a class='dropdown-item' href='#'>Asignar prácticas</a>\n" +
"                    </div>\n" +
"                </li>\n" +
"\n" +
"                <li class='nav-item dropdown'>\n" +
"                    <a class='nav-link ' href='#' id='pagesDropdown' role='button' data-toggle='dropdown'\n" +
"                       aria-expanded='false'>\n" +
"                        <i class='fas fa-chalkboard-teacher'></i>\n" +
"                        <span class='mr-2'>Módulo de grupos y unidad de aprendizaje</span>\n" +
"                        <i class='fas fa-caret-down '></i>\n" +
"                    </a>\n" +
"                    <div class='dropdown-menu' aria-labelledby='pagesDropdown'>\n" +
"                        <h6 class='dropdown-header'>Selecciona una opción:</h6>\n" +
"                        <a class='dropdown-item' href='modGrupos.xhtml'>Crear y ver grupos</a>\n" +
"                        <a class='dropdown-item' href='unidadAprendizaje.xhtml'>Crear unidad de aprendizaje</a>\n" +
"                        <a class='dropdown-item' href='modGrupoUnidadesAprendizaje.xhtml'>Asignar unidades de aprendizaje</a>\n" +
"                    </div>\n" +
"                </li>\n" +
"\n" +
"\n" +
"                <li class='nav-item dropdown'>\n" +
"                    <a class='nav-link ' href='#' id='pagesDropdown' role='button' data-toggle='dropdown'\n" +
"                       aria-expanded='false'>\n" +
"                        <i class='fas fa-prescription-bottle'></i>\n" +
"                        <span class='mr-2'>Módulo de insumos</span>\n" +
"                        <i class='fas fa-caret-down '></i>\n" +
"                    </a>\n" +
"                    <div class='dropdown-menu' aria-labelledby='pagesDropdown'>\n" +
"                        <h6 class='dropdown-header'>Selecciona una opción:</h6>\n" +
"                        <a class='dropdown-item' href='#'>Administración de materiales</a>\n" +
"                        <a class='dropdown-item' href='#'>Administración de reactivos</a>\n" +
"                        <a class='dropdown-item' href='#'>Administración de equipo</a>\n" +
"                        <h6 class='dropdown-header'>Prestamo de material:</h6>\n" +
"                        <a class='dropdown-item' href='404.html'>Prestar Material</a>\n" +
"                    </div>\n" +
"                </li>\n" +
"\n" +
"                <li class='nav-item dropdown'>\n" +
"                    <a class='nav-link ' href='#' id='pagesDropdown' role='button' data-toggle='dropdown'\n" +
"                       aria-expanded='false'>\n" +
"                        <i class='fas fa-trash-alt'></i>\n" +
"                        <span class='mr-2'>Módulo de residuos</span>\n" +
"                        <i class='fas fa-caret-down '></i>\n" +
"                    </a>\n" +
"                    <div class='dropdown-menu' aria-labelledby='pagesDropdown'>\n" +
"                        <h6 class='dropdown-header'>Selecciona una opción:</h6>\n" +
"                        <a class='dropdown-item' href='404.html'>Administración</a>\n" +
"                        <a class='dropdown-item' href='#'> Generar informes</a>\n" +
"                    </div>\n" +
"                </li>\n" +
"\n" +
"                <li class='nav-item dropdown'>\n" +
"                    <a class='nav-link ' href='#' id='pagesDropdown' role='button' data-toggle='dropdown'\n" +
"                       aria-expanded='false'>\n" +
"                        <i class='fas fa-exclamation-triangle'></i>\n" +
"                        <span class='mr-2'>Módulo de incidencias</span>\n" +
"                        <i class='fas fa-caret-down '></i>\n" +
"                    </a>\n" +
"                    <div class='dropdown-menu' aria-labelledby='pagesDropdown'>\n" +
"                        <h6 class='dropdown-header'>Selecciona una opción:</h6>\n" +
"                        <a class='dropdown-item' href='#'>Registro de incidencias </a>\n" +
"                        <a class='dropdown-item' href='#'> Seguimiento </a>\n" +
"                    </div>\n" +
"                </li>\n" +
"            </ul>";
        
    }

    // Getter Y Setters
    public String getHeaderIndex() {
        return headerIndex;
    }

    public void setHeaderIndex(String headerIndex) {
        this.headerIndex = headerIndex;
    }

    public String getHeaderTodasPaginas() {
        return headerTodasPaginas;
    }

    public void setHeaderTodasPaginas(String headerTodasPaginas) {
        this.headerTodasPaginas = headerTodasPaginas;
    }

    public String getMetaTagsLinkTags() {
        return metaTagsLinkTags;
    }

    public void setMetaTagsLinkTags(String metaTagsLinkTags) {
        this.metaTagsLinkTags = metaTagsLinkTags;
    }

    public String getNumeroNotificaciones() {
        return numeroNotificaciones;
    }

    public void setNumeroNotificaciones(String numeroNotificaciones) {
        this.numeroNotificaciones = numeroNotificaciones;
    }

    public String getMetaTagsLinkTagsIndex() {
        return metaTagsLinkTagsIndex;
    }

    public void setMetaTagsLinkTagsIndex(String metaTagsLinkTagsIndex) {
        this.metaTagsLinkTagsIndex = metaTagsLinkTagsIndex;
    }
    
    public String getNavegacionAdministrador() {
        return navegacionAdministrador;
    }

    public void setNavegacionAdministrador(String navegacionAdministrador) {
        this.navegacionAdministrador = navegacionAdministrador;
    }
    

}
