/**
 * Author:  iron1
 * Created: 6/11/2018
 */

CREATE DEFINER=`root`@`localhost` PROCEDURE `SaveUpdateDatosUsuario`(
 IN Id_Usuario int,
 IN Identificador varchar(45),
 IN Nombre varchar(45),
 IN Apellido_Paterno varchar(45),
 IN Apellido_Materno varchar(45),
 IN Telefono varchar(25),
 IN Correo varchar(45),
 IN Numero_Seguro varchar(45)
 )
BEGIN
	-- Si existe en la base se hace el insert
	IF EXISTS ( SELECT  idDatos_usuario from datos_usuario where idUsuarios = Id_Usuario) 
    THEN 
		BEGIN
			UPDATE datos_usuario as du 
			SET du.Identificador = Identificador, du.Nombre = Nombre,
			du.Apellido_Paterno = Apellido_Paterno, du.Apellido_Materno =Apellido_Materno,
			du.Telefono = Telefono, du.Correo = Correo, du.Numero_Seguro = Numero_Seguro
			where du.idUsuarios = Id_Usuario;
            UPDATE usuarios as u SET Login = Correo WHERE u.idUsuarios = Id_Usuario;
        END;
    ELSE 
		INSERT INTO 
        datos_usuario (idUsuarios,Identificador,Nombre,Apellido_Paterno,Apellido_Materno,Telefono,Correo,Numero_Seguro)
        values (Id_Usuario,Identificador,Nombre,Apellido_Paterno,Apellido_Materno,Telefono,Correo,Numero_Seguro);
	END IF;
END

/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectAllDatosUsuarios`()
BEGIN
    select *from datos_usuario;
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectAlumnosGrupo`(IN id_Grupo int)
BEGIN

	SELECT u.idUsuarios, du.Nombre, du.Apellido_Paterno,du.Apellido_Materno 
    FROM Unidad_Grupo as ug
    INNER JOIN Lista_Grupo as lg
    ON ug.idUnidad_Grupo  = lg.idUnidad_Grupo 
    INNER JOIN Usuarios as u
    on u.idUsuarios = lg.idUsuario_Alumno
    INNER JOIN Datos_usuario as du
    on du.idUsuarios = u.idUsuarios
    WHERE ug.idGrupo = id_Grupo; 
    
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectDatosRol`(IN id int)
BEGIN
select *from datos_usuario as du
join usuarios as u on du.idUsuarios = u.idUsuarios
where u.idrol = id;
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectDatosUsuario`(IN id int)
BEGIN
	select *from datos_usuario where idusuarios = id;
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectDatoUsuario`(IN idDatos_usuario int)
BEGIN
    select *from datos_usuario where idusuarios = @idDatos_usuario;
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectGrupos`()
BEGIN
	select *from grupo;
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectGruposTienenUnidadAprendizaje`()
BEGIN
	select g.idgrupo, g.nombre as nombreGrupo, ua.idunidad_aprendizaje, ua.nombre as nombreUnidadAprendizaje
    from unidad_grupo as ug 
    inner join grupo as g
    on g.idgrupo = ug.idgrupo
    inner join unidad_aprendizaje as ua
    on ua.idunidad_aprendizaje = ug.idunidad_aprendizaje; 
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectGrupoUnidadAprendizaje`()
BEGIN
	select distinct g.idgrupo , g.nombre , g.cupo
    from unidad_grupo as ug 
    inner join grupo as g
    on g.idgrupo = ug.idgrupo
    inner join unidad_aprendizaje as ua
    on ua.idunidad_aprendizaje = ug.idunidad_aprendizaje;
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectUnidadesAprendizajeGrupo`(IN idGrupo int)
BEGIN
Select ua.idUnidad_Aprendizaje, ua.Nombre from Unidad_Grupo as ug join Unidad_Aprendizaje as ua
    on ug.idUnidad_Aprendizaje  = ua.idUnidad_Aprendizaje 
    where ug.idGrupo = idGrupo;
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectUnidadesTematicas`(IN id int)
BEGIN
	select ut.nombre as NombreUnidadTematica
from unidad_aprendizaje as ua join unidad_tematica as ut
on ua.idUnidad_Aprendizaje  = ut.idUnidad_Aprendizaje
where ua.idUnidad_Aprendizaje = id; 
END
/*************************************************************************************/
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectUsuarioSinGrupo`()
BEGIN
	select u.idUsuarios, du.Nombre, du.Apellido_Paterno,du.Apellido_Materno 
    from Lista_Grupo  as lu right join usuarios as u
    on u.idUsuarios = lu.idUsuario_Alumno 
    join Datos_usuario  as du
    on du.idUsuarios  = u.idUsuarios 
    where idRol = 4 and lu.idLista_Grupo is null;
END
/*************************************************************************************/

/*************************************************************************************/

/*************************************************************************************/

/*************************************************************************************/

/*************************************************************************************/

/*************************************************************************************/
select *from usuarios
select *from roles
/*************************************************************************************/
