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
        headerTodasPaginas = "<header> <nav class='navbar navbar-expand-lg navbar-custom '> <a class='navbar-brand' href='#'>Inicio</a> <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'><span class='navbar-toggler-icon'></span></button> <div class='collapse navbar-collapse justify-content-end' id='navbarSupportedContent'> <ul class='navbar-nav '> <li class='nav-item active'> <a class='nav-link' href='#'> <i class='fas fa-home'></i> Inicio </a> </li><li class='nav-item'> <a class='nav-link' href='#'> <i class='fas fa-comment-alt'></i> Notificaciones <span class='badge badge-primary '>" +  numeroNotificaciones + "</span> </a> </li><li class='nav-item'> <a class='nav-link' href='#'> <i class='fas fa-phone'></i> Directorio Teléfonico </a> </li><li class='nav-item'> <a class='nav-link disabled' href='#'> <i class='fas fa-envelope-square'></i> Buzón de sugerencias </a> </li><li> <form jsf:id='formlogout1'> <button class='btn btn-sm colorverde rounded' type='submit' jsf:action='#{managedBeanLogin.logout()}' ><i class='fas fa-sign-out-alt'></i> Cerrar sesión</button> </form> </li></ul> </div></nav></header> ";
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

}
