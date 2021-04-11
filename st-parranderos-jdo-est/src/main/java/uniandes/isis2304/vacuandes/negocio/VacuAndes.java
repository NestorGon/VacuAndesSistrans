/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
@param documento - El documento de identificación del ciudadano * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: VacuAndes
 * @version 1.0
 * @author Néstor González
 * Abril de 2021
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.vacuandes.negocio;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;

import uniandes.isis2304.vacuandes.persistencia.PersistenciaVacuAndes;

/**
 * Clase principal del negocio
 *
 * @author Néstor González
 */
public class VacuAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger( VacuAndes.class.getName() );
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaVacuAndes pp;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public VacuAndes ()
	{
		pp = PersistenciaVacuAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public VacuAndes( JsonObject tableConfig )
	{
		pp = PersistenciaVacuAndes.getInstance( tableConfig );
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia()
	{
		pp.cerrarUnidadPersistencia();
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar las CITAS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una cita
	 * Adiciona entradas al log de la aplicación
	 * @param fechaHora - Fecha y hora de la cita
	 * @param finalizada - Si la cita ya se finalizó o no
	 * @param ciudadano - El documento de identificación del ciudadano asociado a la cita
	 * @return El objeto Cita adicionado. null si ocurre alguna Excepción
	 */
	public Cita adicionarCita( String fechaHora, String finalizada, String ciudadano, String punto )
	{
       log.info( "Adicionando Cita: " + fechaHora + " - " + ciudadano );
       Cita cita = pp.adicionarCita( fechaHora, finalizada, ciudadano, punto );		
       log.info( "Cita adicionada: " + cita );
       return cita;
	}
	
	/**
	 * Elimina una cita por su fecha y hora y el documento del ciudadano
	 * Adiciona entradas al log de la aplicación
	 * @param fechaHora - Fecha y hora de la cita
	 * @param documento - El documento de identificación del ciudadano asociado a la cita
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarCita( Date fechaHora, String ciudadano )
	{
		log.info( "Eliminando Cita: " + fechaHora + " - " + ciudadano  );
		Long resp = pp.eliminarCita( fechaHora, ciudadano );		
		log.info( "Cita eliminada: " + resp + " tuplas eliminadas" );
		return resp;
	}
	
	/**
	 * Encuentra todas las citas en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Cita con todas las citas que conoce la aplicación
	 */
	public List<Cita> darCitas()
	{
		log.info ("Consultando Citas");
		List<Cita> citas = pp.darCitas();	
		log.info ("Consultando Citas: " + citas.size() + " existentes");
		return citas;
	}

	/**
	 * Encuentra todas las citas en VacuAndes y las devuelve como una lista de VOCita
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOCita con todas las citas que conoce la aplicación
	 */
	public List<VOCita> darVOCitas()
	{
		log.info ("Generando los VO de Citas");        
       List<VOCita> voCitas = new LinkedList<VOCita>();
       for( Cita cita : pp.darCitas() ) {
    	   voCitas.add (cita);
       }
       log.info ("Generando los VO de Citas: " + voCitas.size() + " existentes");
       return voCitas;
	}

	/**
	 * Encuentra la cita en VacuAndes con la fecha y hora y ciudadano
	 * Adiciona entradas al log de la aplicación
	 * @param fechaHora - Fecha y hora de la cita
	 * @param documento - El documento de identificación del ciudadano asociado a la cita
	 * @return Un objeto Cita con la fecha y hora y ciudadano, lleno con su información básica
	 */
	public Cita darCita( Date fechaHora, String ciudadano )
	{
		log.info ("Buscando Cita: " + fechaHora + " - " + ciudadano);
		Cita cita = pp.darCita( fechaHora, ciudadano );
		return cita;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la PRIORIZACION
	 *****************************************************************/
	
	/**
	 * Adiciona de manera persistente una Priorizacion
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @param descripcion - La descripción de la condición de priorización
	 * @return El objeto Priorizacion adicionado. null si ocurre alguna Excepción
	 */
	public Priorizacion adicionarPriorizacion( String documento, String descripcion )
	{
       log.info( "Adicionando Priorización: " + documento + " - " + descripcion );
       Priorizacion prior = pp.adicionarPriorizacion( documento, descripcion );		
       log.info( "Priorización adicionada: " + prior );
       return prior;
	}
	
	/**
	 * Elimina una priorización por su documento y descripcion
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @param descripcion - La descripción de la condición de priorización
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarPriorizacion( String documento, String descripcion )
	{
		log.info( "Eliminando Priorización: " + documento + " - " + descripcion );
		Long resp = pp.eliminarPriorizacion( documento, descripcion );		
		log.info( "Priorización eliminada: " + resp + " tuplas eliminadas" );
		return resp;
	}
	
	/**
	 * Encuentra todas las priorizaciones en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Priorizacion con todas las priorizaciones que conoce la aplicación
	 */
	public List<Priorizacion> darPriorizaciones()
	{
		log.info ("Consultando Priorizaciones");
		List<Priorizacion> prior = pp.darPriorizaciones();	
		log.info ("Consultando Priorizaciones: " + prior.size() + " existentes");
		return prior;
	}

	/**
	 * Encuentra todas las priorizaciones en VacuAndes y las devuelve como una lista de VOPriorizacion
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOPriorizacion con todas las priorizaciones que conoce la aplicación
	 */
	public List<VOPriorizacion> darVOPriorizaciones()
	{
		log.info ("Generando los VO de Priorizaciones");        
       List<VOPriorizacion> voPriorizaciones = new LinkedList<VOPriorizacion>();
       for( Priorizacion prior : pp.darPriorizaciones() ) {
    	   voPriorizaciones.add( prior );
       }
       log.info ("Generando los VO de Priorizaciones: " + voPriorizaciones.size() + " existentes");
       return voPriorizaciones;
	}

	/**
	 * Encuentra la priorización en VacuAndes con el documento y descripcion
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @param descripcion - La descripción de la condición de priorización
	 * @return Un objeto Priorizacion con la priorización del documento y descripcion, lleno con su información básica
	 */
	public Priorizacion darPriorizacion( String documento, String descripcion )
	{
		log.info ("Buscando Priorizacion: " + documento + " - " + descripcion);
		Priorizacion prior = pp.darPriorizacion( documento, descripcion );
		return prior;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los ROLES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un rol
	 * Adiciona entradas al log de la aplicación
	 * @param id - El identificador del rol
	 * @param rol - La cadena de texto con el rol
	 * @return El objeto Rol adicionado. null si ocurre alguna Excepción
	 */
	public Rol adicionarRol( String rol )
	{
       log.info( "Adicionando Rol: " + rol );
       Rol rolObj = pp.adicionarRol( rol );		
       log.info( "Rol adicionado: " + rolObj );
       return rolObj;
	}
	
	/**
	 * Elimina un rol por su id
	 * Adiciona entradas al log de la aplicación
	 * @param id - El identificador del rol
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarRol( Long id )
	{
		log.info( "Eliminando Rol: " + id  );
		Long resp = pp.eliminarRol( id );		
		log.info( "Rol eliminado: " + resp + " tuplas eliminadas" );
		return resp;
	}
	
	/**
	 * Encuentra todos los roles en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Rol con todos los roles que conoce la aplicación
	 */
	public List<Rol> darRoles()
	{
		log.info ("Consultando Roles");
		List<Rol> roles = pp.darRoles();	
		log.info ("Consultando Roles: " + roles.size() + " existentes");
		return roles;
	}

	/**
	 * Encuentra todos los roles en VacuAndes y los devuelve como una lista de VORol
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VORol con todos los roles que conoce la aplicación
	 */
	public List<VORol> darVORoles()
	{
		log.info ("Generando los VO de Roles");        
		List<VORol> voRoles = new LinkedList<VORol>();
		for( Rol rol : pp.darRoles() ) {
			voRoles.add (rol);
		}
		log.info ("Generando los VO de Roles: " + voRoles.size() + " existentes");
		return voRoles;
	}

	/**
	 * Encuentra el rol en VacuAndes con el id
	 * Adiciona entradas al log de la aplicación
	 * @param id - El identificador del rol
	 * @return Un objeto Rol lleno con su información básica
	 */
	public Rol darRol( Long id )
	{
		log.info( "Buscando Rol: " + id );
		Rol rol = pp.darRol( id );
		return rol;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la INFORMACION DE LOS USUARIOS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente la información de un usuario
	 * Adiciona entradas al log de la aplicación
	 * @param login - El login del usuario
	 * @param trabajo - El trabajo del usuario
	 * @param roles - El rol del usuario en la aplicación
	 * @param punto - El punto de vacunación al que se encuentra asociado
	 * @return El objeto InfoUsuario adicionado. null si ocurre alguna Excepción
	 */
	public InfoUsuario adicionarInfoUsuario( String login, String clave, String trabajo, Long roles, String punto )
	{
       log.info( "Adicionando InfoUsuario: " + login + " - " + trabajo );
       InfoUsuario info = pp.adicionarInfoUsuario( login, clave, trabajo, roles, punto );		
       log.info( "InfoUsuario adicionada: " + info );
       return info;
	}
	
	/**
	 * Elimina la información de un usuario por su login
	 * Adiciona entradas al log de la aplicación
	 * @param login - El login único de un usuario
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarInfoUsuario( String login )
	{
		log.info( "Eliminando InfoUsuario: " + login );
		Long resp = pp.eliminarInfoUsuario( login );		
		log.info( "InfoUsuario eliminada: " + resp + " tuplas eliminadas" );
		return resp;
	}
	
	/**
	 * Encuentra toda la información de todos los usuarios en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos InfoUsuario con toda la información de los usuarios que conoce la aplicación
	 */
	public List<InfoUsuario> darInfoUsuarios()
	{
		log.info ("Consultando InfoUsuarios");
		List<InfoUsuario> infos = pp.darInfoUsuarios();	
		log.info ("Consultando InfoUsuarios: " + infos.size() + " existentes");
		return infos;
	}

	/**
	 * Encuentra toda la información de todos los usuarios en VacuAndes y las devuelve como una lista de VOInfoUsuario
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOInfoUsuario con toda la información de los usuarios que conoce la aplicación
	 */
	public List<VOInfoUsuario> darVOInfoUsuarios()
	{
		log.info ("Generando los VO de InfoUsuarios");        
       List<VOInfoUsuario> voInfos = new LinkedList<VOInfoUsuario>();
       for( InfoUsuario info : pp.darInfoUsuarios() ) {
    	   voInfos.add (info);
       }
       log.info ("Generando los VO de InfoUsuarios: " + voInfos.size() + " existentes");
       return voInfos;
	}

	/**
	 * Encuentra la cita en VacuAndes con la fecha y hora y ciudadano
	 * Adiciona entradas al log de la aplicación
	 * @param login - El login único de un usuario
	 * @return Un objeto Cita con la fecha y hora y ciudadano, lleno con su información básica
	 */
	public InfoUsuario darInfoUsuario( String login )
	{
		log.info( "Buscando InfoUsuario: " + login );
		InfoUsuario info = pp.darInfoUsuario( login );
		return info;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los ESTADOS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un estado
	 * Adiciona entradas al log de la aplicación
	 * @param descripcion - La descripción del estado
	 * @return El objeto Estado adicionado. null si ocurre alguna Excepción
	 */
	public Estado adicionarEstado( String descripcion )
	{
       log.info( "Adicionando Estado: " + descripcion );
       Estado estado = pp.adicionarEstado( descripcion );		
       log.info( "Estado adicionado: " + estado );
       return estado;
	}
	
	/**
	 * Elimina un estado por su id
	 * Adiciona entradas al log de la aplicación
	 * @param id - El identificador del estado
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarEstado( Long id )
	{
		log.info( "Eliminando Estado: " + id );
		Long resp = pp.eliminarEstado( id );		
		log.info( "Estado eliminado: " + resp + " tuplas eliminadas" );
		return resp;
	}
	
	/**
	 * Encuentra todos los estados en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Estado con todos los estados que conoce la aplicación
	 */
	public List<Estado> darEstados()
	{
		log.info ("Consultando Estados");
		List<Estado> estados = pp.darEstados();	
		log.info ("Consultando Estados: " + estados.size() + " existentes");
		return estados;
	}

	/**
	 * Encuentra todos los estados en VacuAndes y los devuelve como una lista de VOEstado
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOEstado con todos los estados que conoce la aplicación
	 */
	public List<VOEstado> darVOEstados()
	{
		log.info ("Generando los VO de Estados");        
       List<VOEstado> voEstados = new LinkedList<VOEstado>();
       for( Estado estado : pp.darEstados() ) {
    	   voEstados.add (estado);
       }
       log.info ("Generando los VO de Estados: " + voEstados.size() + " existentes");
       return voEstados;
	}

	/**
	 * Encuentra el estado en VacuAndes con el id
	 * Adiciona entradas al log de la aplicación
	 * @param id - El identificador del estado
	 * @return Un objeto Estado con el id, lleno con su información básica
	 */
	public Estado darEstado( Long id )
	{
		log.info ("Buscando Estado: " + id );
		Estado estado = pp.darEstado( id );
		return estado;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los CIUDADANOS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un ciudadano
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @param nombre - El nombre del ciudadano
	 * @param nacimiento - La fecha de nacimiento del ciudadano
	 * @param habilitado - Si el ciudadano está o no habilitado para vacunación
	 * @param estado - El id del estado en el que se encuentra el ciudadano en la vacunación
	 * @param eps - El id de la EPS a la que el ciuadano se encuentra afiliado
	 * @param etapa - El número de la etapa a la que el ciudadano pertenece
	 * @return El objeto Ciudadano adicionado. null si ocurre alguna Excepción
	 */
	public Ciudadano adicionarCiudadano( String documento, String nombre, Date nacimiento, String habilitado, Long estado, String eps, Integer etapa )
	{
       log.info( "Adicionando Ciudadano: " + documento + " - " + nombre );
       Ciudadano ciudadano = pp.adicionarCiudadano( documento, nombre, nacimiento, habilitado, estado, eps, etapa );		
       log.info( "Ciudadano adicionado: " + ciudadano );
       return ciudadano;
	}
	
	/**
	 * Actualiza de manera persistente un ciudadano
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @param nombre - El nombre del ciudadano
	 * @param nacimiento - La fecha de nacimiento del ciudadano
	 * @param habilitado - Si el ciudadano está o no habilitado para vacunación
	 * @param estado - El id del estado en el que se encuentra el ciudadano en la vacunación
	 * @param eps - El id de la EPS a la que el ciuadano se encuentra afiliado
	 * @param etapa - El número de la etapa a la que el ciudadano pertenece
	 * @return El objeto Ciudadano actualizado. null si ocurre alguna Excepción
	 */
	public Ciudadano actualizarCiudadano( String documento, String nombre, Date nacimiento, String habilitado, Long estado, String eps, Integer etapa )
	{
       log.info( "Actualizando Ciudadano: " + documento + " - " + nombre );
       Ciudadano ciudadano = pp.actualizarCiudadano( documento, nombre, nacimiento, habilitado, estado, eps, etapa );		
       log.info( "Ciudadano actualizado: " + ciudadano );
       return ciudadano;
	}
	
	/**
	 * Elimina un ciudadano por su documento
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarCiudadano( String documento )
	{
		log.info( "Eliminando Ciudadano: " + documento );
		Long resp = pp.eliminarCiudadano( documento );		
		log.info( "Ciudadano eliminado: " + resp + " tuplas eliminadas" );
		return resp;
	}
	
	/**
	 * Encuentra todos los ciudadanos en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Ciudadano con todos los ciudadanos que conoce la aplicación
	 */
	public List<Ciudadano> darCiudadanos()
	{
		log.info ("Consultando Ciudadanos");
		List<Ciudadano> ciudadanos = pp.darCiudadanos();	
		log.info ("Consultando Ciudadanos: " + ciudadanos.size() + " existentes");
		return ciudadanos;
	}

	/**
	 * Encuentra todos los ciudadanos en VacuAndes y los devuelve como una lista de VOCiudadano
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOCiudadano con todos los ciudadanos que conoce la aplicación
	 */
	public List<VOCiudadano> darVOCiudadanos()
	{
		log.info ("Generando los VO de Ciudadanos");        
       List<VOCiudadano> voCiudadanos = new LinkedList<VOCiudadano>();
       for( Ciudadano ciudadano : pp.darCiudadanos() ) {
    	   voCiudadanos.add (ciudadano);
       }
       log.info ("Generando los VO de Ciudadanos: " + voCiudadanos.size() + " existentes");
       return voCiudadanos;
	}

	/**
	 * Encuentra el ciudadano en VacuAndes con el documento
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @return Un objeto Ciudadano con el documento, lleno con su información básica
	 */
	public Ciudadano darCiudadano( String documento )
	{
		log.info ("Buscando Ciudadano: " + documento );
		Ciudadano ciudadano = pp.darCiudadano( documento );
		return ciudadano;
	}
	
	/** 
	 * Retorna la etapa de un ciudadano dado su id 
	 */ 
	public Long darEtapaCiudadano(String documento) 
	{ 
		log.info("Buscando etapa Ciudadano id: "+documento); 
		Long etapa = pp.darEtapaCiudadano(documento); 
		log.info("Etapa del ciudadano encontrada: "+etapa); 
		return etapa; 
	} 
	
	/* ****************************************************************
	 * 			Métodos para manejar los USUARIOS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un usuario
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @param login - El login del usuario
	 * @return El objeto Usuario adicionado. null si ocurre alguna Excepción
	 */
	public Usuario adicionarUsuario( String documento, String login )
	{
       log.info( "Adicionando Usuario: " + documento + " - " + login );
       Usuario usuario = pp.adicionarUsuario( documento, login );		
       log.info( "Usuario adicionado: " + usuario );
       return usuario;
	}
	
	/**
	 * Elimina un usuario por su documento
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarUsuario( String documento )
	{
		log.info( "Eliminando Usuario: " + documento );
		Long resp = pp.eliminarUsuario( documento );		
		log.info( "Usuario eliminado: " + resp + " tuplas eliminadas" );
		return resp;
	}
	
	/**
	 * Encuentra todos los usuarios en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Usuario con todos los usuarios que conoce la aplicación
	 */
	public List<Usuario> darUsuarios()
	{
		log.info ("Consultando Usuarios");
		List<Usuario> usuarios = pp.darUsuarios();	
		log.info ("Consultando Usuarios: " + usuarios.size() + " existentes");
		return usuarios;
	}

	/**
	 * Encuentra todos los usuarios en VacuAndes y los devuelve como una lista de VOUsuario
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOUsuario con todos los usuarios que conoce la aplicación
	 */
	public List<VOUsuario> darVOUsuarios()
	{
		log.info ("Generando los VO de Usuarios");        
       List<VOUsuario> voUsuarios = new LinkedList<VOUsuario>();
       for( Usuario usuario : pp.darUsuarios() ) {
    	   voUsuarios.add (usuario);
       }
       log.info ("Generando los VO de Usuarios: " + voUsuarios.size() + " existentes");
       return voUsuarios;
	}

	/**
	 * Encuentra el usuario en VacuAndes con el documento
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @return Un objeto Usuario con el documento, lleno con su información básica
	 */
	public Usuario darUsuario( String documento )
	{
		log.info ("Buscando Usuario: " + documento );
		Usuario usuario = pp.darUsuario( documento );
		return usuario;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la VACUNACION
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una vacunación
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @param eps - El identificador de la eps
	 * @param punto - El identificador del punto de vacunación
	 * @return El objeto Vacunacion adicionado. null si ocurre alguna Excepción
	 */
	public Vacunacion adicionarVacunacion( String documento, String eps, String punto )
	{
       log.info( "Adicionando Vacunacion: " + documento + " - " + eps );
       Vacunacion vacunacion = pp.adicionarVacunacion( documento, eps, punto );		
       log.info( "Vacunacion adicionada: " + vacunacion );
       return vacunacion;
	}
	
	/**
	 * Elimina una cita por su fecha y hora y el documento del ciudadano
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @param eps - El identificador de la eps
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarVacunacion( String documento, String eps )
	{
		log.info( "Eliminando Vacunacion: " + documento + " - " + eps  );
		Long resp = pp.eliminarVacunacion( documento, eps );		
		log.info( "Vacunacion eliminada: " + resp + " tuplas eliminadas" );
		return resp;
	}
	
	/**
	 * Encuentra todas las vacunaciones en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Vacunacion con todas las vacunaciones que conoce la aplicación
	 */
	public List<Vacunacion> darVacunaciones()
	{
		log.info ("Consultando Vacunaciones");
		List<Vacunacion> vacunaciones = pp.darVacunaciones();	
		log.info ("Consultando Vacunaciones: " + vacunaciones.size() + " existentes");
		return vacunaciones;
	}

	/**
	 * Encuentra todas las vacunaciones en VacuAndes y las devuelve como una lista de VOVacunacion
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOVacunacion con todas las vacunaciones que conoce la aplicación
	 */
	public List<VOVacunacion> darVOVacunaciones()
	{
		log.info ("Generando los VO de Vacunaciones");        
       List<VOVacunacion> voVacunaciones = new LinkedList<VOVacunacion>();
       for( Vacunacion vacunacion : pp.darVacunaciones() ) {
    	   voVacunaciones.add (vacunacion);
       }
       log.info ("Generando los VO de Vacunaciones: " + voVacunaciones.size() + " existentes");
       return voVacunaciones;
	}

	/**
	 * Encuentra la vacunación en VacuAndes con el documento y eps
	 * Adiciona entradas al log de la aplicación
	 * @param documento - El documento de identificación del ciudadano
	 * @param eps - El identificador de la eps
	 * @return Un objeto Vacunacion con el documento y eps, lleno con su información básica
	 */
	public Vacunacion darVacunacion( String documento, String eps )
	{
		log.info ("Buscando Vacunacion: " + documento + " - " + eps );
		Vacunacion vacunacion = pp.darVacunacion( documento, eps );
		return vacunacion;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar el PUNTO
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un punto de vacunacion
	 * Adiciona entradas al log de la aplicación
	 * @param id - Id del punto de vacunacion
	 * @param region - Region del punto de vacunacion
	 * @param direccion - Direccion del putno de vacunacion
	 * @param aplicadas - Numero de vacunas aplicadas en el punto de vacunacion
	 * @param capacidad -Capacidad del punto de vacunacion
	 * @param id_eps - Id de la eps a la que pertenece el punto de vacunacion
	 * @return El objeto Punto adicionado. -1 si ocurre alguna Excepción
	 */
	public Long adicionarPunto( String id, String region, String direccion, Long aplicadas, Long capacidad, String id_eps )
	{
       log.info( "Adicionando Punto: " + id + " - " + region+" -"+ direccion+" - "+ aplicadas+" - "+ capacidad+ " - "+id_eps );
       Long resp = pp.adicionarPunto( id, region, direccion, aplicadas, capacidad, id_eps );		
       log.info( "Punto adicionado: "  + id + " - " + region+" -"+ direccion+" - "+ aplicadas+" - "+ capacidad+ " - "+id_eps);
       return resp;
	}
	
	/**
	 * Elimina un punto por su id
	 * Adiciona entradas al log de la aplicación
	 * @param id - id del punto de vacunacion
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarPunto( String id )
	{
		log.info( "Eliminando Punto: " + id );
		Long numero = pp.eliminarPunto( id );		
		log.info( "Punto eliminado: " + numero + " tuplas eliminadas" );
		return numero;
	}
	
	/**
	 * Encuentra todas los puntos en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Punto con todos los puntos que conoce la aplicación
	 */
	public List<Punto> darPuntos()
	{
		log.info ("Consultando Punto");
		List<Punto> puntos = pp.darPuntos();	
		log.info ("Consultando Punto: " + puntos.size() + " existentes");
		return puntos;
	}

	/**
	 * Encuentra todas los puntos en VacuAndes y los devuelve como una lista de VOPunto
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOPunto contodos los puntos que conoce la aplicación
	 */
	public List<VOPunto> darVOPuntos()
	{
		log.info ("Generando los VO de Puntos");        
       List<VOPunto> voPuntos = new LinkedList<VOPunto>();
       for( Punto punto : pp.darPuntos() ) {
    	   voPuntos.add (punto);
       }
       log.info ("Generando los VO de los puntos: " + voPuntos.size() + " existentes");
       return voPuntos;
	}

	/**
	 * Encuentra el punto en VacuAndes con el id
	 * Adiciona entradas al log de la aplicación
	 * @param id - id del punto a buscar
	 * @return Un objeto Punto con el id, lleno con su información básica
	 */
	public Punto darPunto( String id )
	{
		log.info ("Buscando Punto: " + id );
		Punto punto = pp.darPunto( id );
		log.info ("Punto encontrado: " + id );
		return punto;
	}
	
	/** 
	 * Retorna la capacidad de un punto de vacunacion dado su id 
	 */ 
	public Long darCapacidad (String id) 
	{ 
		log.info("Buscando capacidad Punto id: "+id); 
		Long capacidad = pp.darCapacidadPunto(id); 
		log.info("Capacidad del punto encontrada: "+capacidad); 
		return capacidad; 
	} 
	 
	/** 
	 * Retorna la cantidad de citas activas de un punto de vacunacion dado su id 
	 */ 
	public Long darCitasActivasPunto(String id) 
	{ 
		log.info("Buscando cantidad de citas activas de un Punto id: "+id); 
		Long activas = pp.darCitasActivasPunto(id); 
		log.info("Citas activas del punto encontrada: "+activas); 
		return activas; 
	} 

	
	/* ****************************************************************
	 * 			Métodos para manejar la VACUNA
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una vacuna
	 * Adiciona entradas al log de la aplicación
	 * @param id - Id de la vacuna
	 * @param preservacion - Condiciones de preservacion de la vacuna 
	 * @param aplicada - Estado de aplicacion de la vacuna
	 * @param dosis - Numero de dosis de la vacuna
	 * @param tipo - Tipo de la vacuna
	 * @return El objeto Vacuna adicionado. -1 si ocurre alguna Excepción
	 */
	public Long adicionarVacuna( String id, String preservacion, String aplicada, Long dosis, String tipo )
	{
       log.info( "Adicionando Vacuna: " + id + " - " + preservacion+" -"+ aplicada+" - "+ dosis+" - "+ tipo );
       Long resp = pp.adicionarVacuna( id, preservacion, aplicada, dosis, tipo );		
       log.info( "Vacuna adicionada: "  + id + " - " + preservacion+" -"+ aplicada+" - "+ dosis+" - "+ tipo);
       return resp;
	}
	
	/**
	 * Elimina una vacuna por su id
	 * Adiciona entradas al log de la aplicación
	 * @param id - id de la vacuna
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarVacuna( String id )
	{
		log.info( "Eliminando Vacuna: " + id );
		Long numero = pp.eliminarVacuna( id );		
		log.info( "Vacuna eliminada: " + numero + " tuplas eliminadas" );
		return numero;
	}
	
	/**
	 * Encuentra todas las vacunas en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Vacuna con todas las vacunas que conoce la aplicación
	 */
	public List<Vacuna> darVacunas()
	{
		log.info ("Consultando Vacunas");
		List<Vacuna> vacunas = pp.darVacunas();	
		log.info ("Consultando Vacunas: " + vacunas.size() + " existentes");
		return vacunas;
	}

	/**
	 * Encuentra todas las vacunas en VacuAndes y las devuelve como una lista de VOVacuna
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOVacuna con todas las vacunas que conoce la aplicación
	 */
	public List<VOVacuna> darVOVacunas()
	{
		log.info ("Generando los VO de Vacunas");        
       List<VOVacuna> voVacunas = new LinkedList<VOVacuna>();
       for( Vacuna vacuna : pp.darVacunas() ) {
    	   voVacunas.add (vacuna);
       }
       log.info ("Generando los VO de las vacunas: " + voVacunas.size() + " existentes");
       return voVacunas;
	}

	/**
	 * Encuentra la vacuna en VacuAndes con el id
	 * Adiciona entradas al log de la aplicación
	 * @param id - id de la vacuna a buscar
	 * @return Un objeto Vacuna con el id, lleno con su información básica
	 */
	public Vacuna darVacuna( String id )
	{
		log.info ("Buscando Vacuna: " + id );
		Vacuna vacuna = pp.darVacuna( id );
		log.info ("Vacuna encontrada: " + id );
		return vacuna;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la ETAPA
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una etapa
	 * Adiciona entradas al log de la aplicación
	 * @param numero - Numero de la etapa de vacunacion
	 * @param descripcion - descripcion de la etapa
	 * @return El objeto Etapa adicionado. -1 si ocurre alguna Excepción
	 */
	public Long adicionarEtapa( Long numero, String descripcion )
	{
       log.info( "Adicionando Etapa: " + numero+ " - "+ descripcion );
       Long resp = pp.adicionarEtapa( numero,descripcion );		
       log.info( "Etapa adicionada: "  + numero+ " - "+ descripcion);
       return resp;
	}
	
	/**
	 * Elimina una etapa por su numero 
	 * Adiciona entradas al log de la aplicación
	 * @param numero - numero de la etapa
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarEtapa( Long numero )
	{
		log.info( "Eliminando Etapa: " + numero );
		Long resp = pp.eliminarEtapa( numero );		
		log.info( "Etapa eliminada: " + resp + " tuplas eliminadas" );
		return resp;
	}
	
	/**
	 * Encuentra todas las etapas en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Etapa con todas las etapas que conoce la aplicación
	 */
	public List<Etapa> darEtapas()
	{
		log.info ("Consultando Etapas");
		List<Etapa> etapas = pp.darEtapas();	
		log.info ("Consultando Etapas: " + etapas.size() + " existentes");
		return etapas;
	}

	/**
	 * Encuentra todas las etapas en VacuAndes y las devuelve como una lista de VOEtapa
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOEtapa con todas las etapas que conoce la aplicación
	 */
	public List<VOEtapa> darVOEtapas()
	{
		log.info ("Generando los VO de Etapas");        
       List<VOEtapa> voEtapas = new LinkedList<VOEtapa>();
       for( Etapa etapa : pp.darEtapas() ) {
    	   voEtapas.add (etapa);
       }
       log.info ("Generando los VO de las etapas: " + voEtapas.size() + " existentes");
       return voEtapas;
	}

	/**
	 * Encuentra la etapa en VacuAndes con el numero
	 * Adiciona entradas al log de la aplicación
	 * @param numero - el numero de la etapa a buscar
	 * @return Un objeto Etapa con el numero, lleno con su información básica
	 */
	public Etapa darEtapa( Long numero )
	{
		log.info ("Buscando Etapa: " + numero );
		Etapa etapa = pp.darEtapa( numero );
		log.info ("Etapa encontrada: " + numero );
		return etapa;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la CONDICIONPRIORIZACION
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una condicion de priorizacion
	 * Adiciona entradas al log de la aplicación
	 * @param numero_etapa - Numero de la etapa a la que pertenece la condicion de priorizacion
	 * @param descripcion - descripcion de la condicion de priorizacion
	 * @return El objeto Vacuna adicionado. -1 si ocurre alguna Excepción
	 */
	public Long adicionarCondicionPriorizacion( Long numero_etapa, String descripcion )
	{
       log.info( "Adicionando Condicion de Priorizacion: " + numero_etapa + " - " + descripcion );
       Long resp = pp.adicionarCondicionPriorizacion( numero_etapa, descripcion );		
       log.info( "Condicion de priorizacion adicionada: "  + numero_etapa + " - " + descripcion);
       return resp;
	}
	
	/**
	 * Elimina una condicion de priorizacion por su descripcion
	 * Adiciona entradas al log de la aplicación
	 * @param descripcion - decsripcion condicion de priorizacion
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarCondicionPriorizacion( String descripcion )
	{
		log.info( "Eliminando Condicion de priorizacion: " + descripcion );
		Long numero = pp.eliminarCondicionPriorizacion( descripcion );		
		log.info( "Condicion de priorizacion eliminada: " + numero + " tuplas eliminadas" );
		return numero;
	}
	
	/**
	 * Encuentra todas las condiciones de priorizacion en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos CondicionPriorizacion con todas las condiciones de priorizacion que conoce la aplicación
	 */
	public List<CondicionPriorizacion> darCondicionesPriorizacion()
	{
		log.info ("Consultando Condiciones de priorizacion");
		List<CondicionPriorizacion> condiciones = pp.darCondicionesPriorizacion();	
		log.info ("Consultando Condiciones de priorizacion: " + condiciones.size() + " existentes");
		return condiciones;
	}

	/**
	 * Encuentra todas las condiciones de priorizacion en VacuAndes y las devuelve como una lista de VOCondicionPriorizacion
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOCondicionPriorizacion con todas las condiciones de priorizacion que conoce la aplicación
	 */
	public List<VOCondicionPriorizacion> darVOCondicionPriorizacion()
	{
		log.info ("Generando los VO de las Condiciones de priorizaciones");        
       List<VOCondicionPriorizacion> voCondicionPriorizacion = new LinkedList<VOCondicionPriorizacion>();
       for( CondicionPriorizacion condicionPriorizacion : pp.darCondicionesPriorizacion() ) {
    	   voCondicionPriorizacion.add (condicionPriorizacion);
       }
       log.info ("Generando los VO de las Condiciones de Priorizacion: " + voCondicionPriorizacion.size() + " existentes");
       return voCondicionPriorizacion;
	}

	/**
	 * Encuentra la Condicion de Priorizacion en VacuAndes con la descripcion 
	 * Adiciona entradas al log de la aplicación
	 * @param descripcion - descripcion de la condicion de priorizacion
	 * @return Un objeto CondicionPriorizacion con la descripcion, lleno con su información básica
	 */
	public CondicionPriorizacion darCondicionPriorizacion( String descripcion )
	{
		log.info ("Buscando CondicionPriorizacion: " + descripcion );
		CondicionPriorizacion condicionPriorizacion = pp.darCondicionPriorizacion( descripcion );
		log.info ("CondicionPriorizacion encontrada: " + descripcion );
		return condicionPriorizacion;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la EPS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una eps
	 * Adiciona entradas al log de la aplicación
	 * @param id - id de la eps
	 * @param region - region en la que se encuentra la eps
	 * @param vacunas - cantidad de vacunas con la que cuenta la eps
	 * @return El objeto EPS adicionado. -1 si ocurre alguna Excepción
	 */
	public Long adicionarEps( String id, String descripcion, String region, Long vacunas )
	{
       log.info( "Adicionando EPS: " + id + " - " + descripcion+ " - "+ region + " - "+vacunas );
       Long resp = pp.adicionarEps( id, descripcion, region, vacunas );		
       log.info( "EPS adicionada: "  + id + " - " + descripcion+ " - "+ region + " - "+vacunas);
       return resp;
	}
	
	/**
	 * Elimina una EPS por su id
	 * Adiciona entradas al log de la aplicación
	 * @param id - id de la EPS
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarEPS( String id )
	{
		log.info( "Eliminando EPS: " + id );
		Long numero = pp.eliminarEps( id );		
		log.info( "EPS eliminada: " + numero + " tuplas eliminadas" );
		return numero;
	}
	
	/**
	 * Encuentra todas las regiones de las EPSs en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos String con todas las regiones de las EPSs que conoce la aplicación
	 */
	public List<String> darRegiones()
	{
		log.info ("Consultando Regiones");
		List<String> regiones = pp.darRegiones();	
		log.info ("Consultando Regiones: " + regiones.size() + " existentes");
		return regiones;
	}
	
	/**
	 * Encuentra todas las EPSs en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos EPS con todas las EPSs que conoce la aplicación
	 */
	public List<EPS> darEPSs()
	{
		log.info ("Consultando EPSs");
		List<EPS> epss = pp.darEPSs();	
		log.info ("Consultando EPSs: " + epss.size() + " existentes");
		return epss;
	}

	/**
	 * Encuentra todas las EPS en VacuAndes y las devuelve como una lista de VOEPS
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOEPS con todas las EPS que conoce la aplicación
	 */
	public List<VOEPS> darVOEPS()
	{
		log.info ("Generando los VO de EPS");        
       List<VOEPS> voEPS = new LinkedList<VOEPS>();
       for( EPS eps : pp.darEPSs() ) {
    	   voEPS.add (eps);
       }
       log.info ("Generando los VO de las EPS: " + voEPS.size() + " existentes");
       return voEPS;
	}

	/**
	 * Encuentra la EPS en VacuAndes con el id
	 * Adiciona entradas al log de la aplicación
	 * @param id - id de la EPS a buscar
	 * @return Un objeto EPS con el id, lleno con su información básica
	 */
	public EPS darEPS( String id )
	{
		log.info ("Buscando EPS: " + id );
		EPS eps = pp.darEPS( id );
		log.info ("EPS encontrada: " + id );
		return eps;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la ASIGNADA
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una vacuna ASIGNADA
	 * Adiciona entradas al log de la aplicación
	 * @param id_eps - Id de la eps a la que pertenece la vacuna
	 * @param id_punto - Id del punto al que pertenece la vacuna 
	 * @param id_vacuna - Id de la vacuna asignada
	 * @return El objeto Vacuna adicionado. -1 si ocurre alguna Excepción
	 */
	public Long adicionarAsignada( String id_eps, String id_punto, String id_vacuna )
	{
       log.info( "Adicionando Asignada: " + id_eps+ " - "+ id_punto+ " - "+id_vacuna );
       Long resp = pp.adicionarAsignada( id_eps, id_punto, id_vacuna );		
       log.info( "Vacuna adicionada: "  + id_eps+ " - "+ id_punto+ " - "+id_vacuna);
       return resp;
	}
	
	/**
	 * Elimina una asignada por su id
	 * Adiciona entradas al log de la aplicación
	 * @param id_vacuna - id de la vacuna asignada
	 * @param id_punto - id del punto de la vacuna asignada
	 * @return El número de tuplas eliminadas
	 */
	public Long eliminarAsignada( String id_punto, String id_vacuna )
	{
		log.info( "Eliminando Asignada: " + id_vacuna);
		Long numero = pp.eliminarAsignada( id_punto, id_vacuna );		
		log.info( "Asignada eliminada: " + numero + " tuplas eliminadas" );
		return numero;
	}
	
	/**
	 * Encuentra todas las vacunas asignadas en VacuAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Asignada con todas las vacunas asignadas que conoce la aplicación
	 */
	public List<Asignada> darAsignada()
	{
		log.info ("Consultando Asignadas");
		List<Asignada> asignadas = pp.darAsignadas();	
		log.info ("Consultando Asignadas: " + asignadas.size() + " existentes");
		return asignadas;
	}

	/**
	 * Encuentra todas las vacunas asignadas en VacuAndes y las devuelve como una lista de VOAsignada
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOAsignada con todas las vacunas asignadas que conoce la aplicación
	 */
	public List<VOAsignada> darVOAsignadas()
	{
		log.info ("Generando los VO de Asignada");        
       List<VOAsignada> voAsignadas = new LinkedList<VOAsignada>();
       for( Asignada asignada : pp.darAsignadas() ) {
    	   voAsignadas.add (asignada);
       }
       log.info ("Generando los VO de las asignadas: " + voAsignadas.size() + " existentes");
       return voAsignadas;
	}

	/**
	 * Encuentra la vacuna asignada en VacuAndes con el id
	 * Adiciona entradas al log de la aplicación
	 * @param id_vacuna - id de la vacuna asignada
	 * @param id_punto - id del punto de la vacuna asignada
	 * @return Un objeto Vacuna con el id, lleno con su información básica
	 */
	public Asignada darAsignada( String id_punto, String id_vacuna )
	{
		log.info ("Buscando Asignada: " + id_vacuna );
		Asignada asignada = pp.darAsignada( id_punto, id_vacuna );
		log.info ("Vacuna encontrada: " + id_vacuna );
		return asignada;
	}

	/* ****************************************************************
	 * 			Métodos para consultas
	 *****************************************************************/ 
	
	/**
	 * Consulta el índice de vacunación de un grupo poblacional
	 * @param pm - El manejador de persistencia
	 * @param eps - Lista con los id de las eps de interés
	 * @param estado - Id del estado de interés
	 * @param priorizacion - Descripción de la condición de priorización de interés
	 * @param regiones - Lista con los nombres de las regiones de interés
	 * @param fechaInicio - Fecha y hora de inicio de interés
	 * @param fechaFin - Fecha y hora de fin de interés
	 * @return El índice de vacunación para el grupo poblacional filtrado con los parámetros
	 */
	public Double darIndiceVacunacion( List<String> eps, Long estado, String priorizacion, List<String> regiones, String fechaInicio, String fechaFin )
	{
		log.info("Buscando índice de vacunación");
		Double resultado = pp.darIndiceVacunacion( eps, estado, priorizacion, regiones, fechaInicio, fechaFin);
		log.info("Indice de vacunación encontrado");
		return resultado;
	}
	
	/**
	 * Metodo que consulta los ciudadanos atentidos de puntos de una region en rangos de fechas
	 * @param region - region de los puntos
	 * @fecha1 - fecha inicial
	 * @fecha2 - fecha final
	 * @return - lista con documentos de ciudadanos
	 */
	public List<String> darAtendidosRegionFechas( String region, String fecha1, String fecha2 ){
		log.info("Buscando atentidos por regiones fechas");
		List<String> resultado = pp.darAtendidosRegionFechas( region, fecha1, fecha2);
		log.info("Atendidos por region fechas encontrados");
		return resultado;
	}
	
	/**
	 * Metodo que consulta los ciudadanos atentidos de puntos de una region en rangos de horas
	 * @param region - region de los puntos
	 * @param hora1 - hora inicial
	 * @param hora2 - hora final 
	 * @param min1 - min inicial
	 * @param min2 - min final
	 * @return - lista con documentos de ciudadanos
	 */
	public List<String> darAtendidosRegionHoras( String region, Long hora1, Long hora2, Long min1, Long min2 ){
		log.info("Buscando atentidos por regiones horas");
		List<String> resultado = pp.darAtendidosRegionHoras( region, hora1, hora2, min1, min2);
		log.info("Atendidos por region horas encontrados");
		return resultado;
	}
	
	/**
	 * Metodo que consulta los ciudadanos atentidos de un punto en rangos de fechas
	 * @param id - id del punto
	 * @fecha1 - fecha inicial
	 * @fecha2 - fecha final
	 * @return - lista con documentos de ciudadanos
	 */
	public List<String> darAtendidosPuntoFechas( String id, String fecha1, String fecha2 ){
		log.info("Buscando atentidos por punto fechas");
		List<String> resultado = pp.darAtendidosPuntoFechas( id, fecha1, fecha2);
		log.info("Atendidos por punto fechas encontrados");
		return resultado;
	}
	
	/**
	 * Metodo que consulta los ciudadanos atentidos de un punto en rangos de horas
	 * @param id - id del punto
	 * @param hora1 - hora inicial
	 * @param hora2 - hora final 
	 * @param min1 - min inicial
	 * @param min2 - min final
	 * @return - lista con documentos de ciudadanos
	 */
	public List<String> darAtendidosPuntoHoras( String id, Long hora1, Long hora2, Long min1, Long min2 ){
		log.info("Buscando atentidos por punto horas");
		List<String> resultado = pp.darAtendidosPuntoHoras( id, hora1, hora2, min1, min2);
		log.info("Atendidos por punto horas encontrados");
		return resultado;
	}
	
	/**
	 * Metodo que consulta los puntos efectivos en rangos de fechas
	 * @fecha1 - fecha inicial
	 * @fecha2 - fecha final
	 * @return - lista con documentos de ciudadanos
	 */
	public List<String> darPuntosEfectivosFechas( String fecha1, String fecha2 ){
		log.info("Buscando puntos efectivos fechas");
		List<String> resultado = pp.darPuntosEfectivosFechas(fecha1, fecha2);
		log.info("Puntos efectivos fechas encontrados");
		return resultado;
	}
	
	/**
	 * Metodo que consulta los puntos efectivos en rangos de horas
	 * @param hora1 - hora inicial
	 * @param hora2 - hora final 
	 * @param min1 - min inicial
	 * @param min2 - min final
	 * @return - lista con documentos de ciudadanos
	 */
	public List<String> darPuntosEfectivosHoras( Long hora1, Long hora2, Long min1, Long min2 ){
		log.info("Buscando puntos efectivos horas");
		List<String> resultado = pp.darPuntosEfectivosHoras( hora1, hora2, min1, min2);
		log.info("Puntos efectivos horas encontrados");
		return resultado;
	}

	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/

	/**
	 * Elimina todas las tuplas en las tablas de VacuAndes
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con 14 números que indican el número de tuplas borradas en las tablas EPS, ROLES, 
	 * ESTADO, ETAPA, CONDICIONPRIORIZACION, PUNTO, VACUNA, ASIGNADA, CIUDADANO, VACUNACION,
	 * PRIORIZACION, INFOUSUARIO, USUARIO, CITA
	 */
	public Long [] limpiarVacuAndes ()
	{
        log.info ("Limpiando la BD de VacuAndes");
        Long [] borrrados = pp.limpiarVacuAndes();	
        log.info ("Limpiando la BD de VacuAndes: Listo!");
        return borrrados;
	}
}
