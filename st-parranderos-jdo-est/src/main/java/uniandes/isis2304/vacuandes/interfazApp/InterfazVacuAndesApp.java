/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
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

package uniandes.isis2304.vacuandes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.vacuandes.negocio.CondicionPriorizacion;
import uniandes.isis2304.vacuandes.negocio.EPS;
import uniandes.isis2304.vacuandes.negocio.Estado;
import uniandes.isis2304.vacuandes.negocio.VOCiudadano;
import uniandes.isis2304.vacuandes.negocio.VOInfoUsuario;
import uniandes.isis2304.vacuandes.negocio.VOVacunacion;
import uniandes.isis2304.vacuandes.negocio.VacuAndes;

/**
 * Clase principal de la interfaz
 * @author Néstor González
 * @author Mariana Zamora
 */
@SuppressWarnings("serial")
public class InterfazVacuAndesApp extends JFrame implements ActionListener
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger( InterfazVacuAndesApp.class.getName() );
	
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
    private VacuAndes vacuAndes;
    
	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Panel de despliegue de interacción para los requerimientos
     */
    private PanelDatos panelDatos;
    
    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazVacuAndesApp( )
    {
        // Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);
        
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame ( );
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        vacuAndes = new VacuAndes (tableConfig);
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );        
    }
    
	/* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicación, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try {
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e) {
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
    
    /**
     * Método para configurar el frame principal de la aplicación
     */
    private void configurarFrame( )
    {
    	int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null ) {
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "VacuAndes APP Default";
			alto = 300;
			ancho = 500;
    	}
    	else {
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get( "title" ).getAsString();
			alto = guiConfig.get( "frameH" ).getAsInt();
			ancho = guiConfig.get( "frameW" ).getAsInt();
    	}
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );

        setTitle( titulo );
		setSize ( ancho, alto);        
    }

    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get( "menuTitle" ).getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray( "options" );
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get( "label" ).getAsString();
        		String event = jo.get( "event" ).getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }
    
	/* ****************************************************************
	 * 			Requerimientos Funcionales de Modificación
	 *****************************************************************/
    
    /**
     * Asigna un ciudadano a un único punto de vacunación
     * Se crea una nueva tupla de VACUNACION en la base de datos
     */
    public void adicionarVacunacion( )
    {
    	try 
    	{
    		VOInfoUsuario usuario = panelValidacionUsuario();
    		if ( usuario != null ) {
    			if ( !usuario.getId_roles().equals(2L) ) {
    				throw new Exception( "El usuario validado no tiene acceso a este requerimiento" );
    			}
    		}
    		else {
    			return;
    		}
    		String documento = JOptionPane.showInputDialog (this, "Ingrese el documento del ciudadano", "Adicionar vacunación", JOptionPane.QUESTION_MESSAGE);
    		String puntoVac = JOptionPane.showInputDialog (this, "Ingrese el identificador del punto de vacunación", "Adicionar vacunación", JOptionPane.QUESTION_MESSAGE);
    		if ( documento != null && !documento.trim().equals("") && puntoVac != null && !puntoVac.trim().equals("") )
    		{
    			documento = documento.trim();
    			puntoVac = puntoVac.trim();
    			VOCiudadano ciudadano = vacuAndes.darCiudadano( documento );
    			//TODO Asegurar que el punto de vacunación existe
    			VOVacunacion vac = vacuAndes.darVacunacion( documento, puntoVac );
    			if ( vac != null ) {
    				throw new Exception ("El ciudadano con documento " + documento + " ya se encuentra asignado al punto de vacunación con id " + puntoVac );
    			}
    			if ( ciudadano != null ) {
    				vac = vacuAndes.adicionarVacunacion( documento, ciudadano.getId_eps(), puntoVac );
    			}
        		if (vac == null)
        		{
        			throw new Exception ("No se pudo asignar al ciudadano " + documento + " al punto de vacunación " + puntoVac);
        		}
        		String resultado = "En adicionarVacunacion\n\n";
        		resultado += "Ciudadano asignado correctamente al punto de vacunación: " + vac;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    /**
     * Asigna un ciudadano a un único punto de vacunación
     * Se crea una nueva tupla de VACUNACION en la base de datos
     */
    public void registrarAvanceVacunacion( )
    {
    	try 
    	{
    		VOInfoUsuario usuario = panelValidacionUsuario();
    		if ( usuario != null ) {
    			if ( !usuario.getId_roles().equals(4L) ) {
    				throw new Exception( "El usuario validado no tiene acceso a este requerimiento" );
    			}
    		} 
    		else {
    			return;
    		}
    		String documento = JOptionPane.showInputDialog (this, "Ingrese el documento del ciudadano", "Registrar avance vacunación", JOptionPane.QUESTION_MESSAGE);
    		String idEstado = JOptionPane.showInputDialog (this, "Ingrese el identificador del nuevo estado", "Registrar avance vacunación", JOptionPane.QUESTION_MESSAGE);
    		if ( documento != null && !documento.trim().equals("") && idEstado != null && !idEstado.trim().equals("") )
    		{
    			VOCiudadano ciudadano = vacuAndes.darCiudadano( documento );
    			if ( ciudadano != null ) {
    				if ( ciudadano.getId_estado().equals(Long.parseLong(idEstado) ) ) {
    					throw new Exception( "El estado ingresado es igual al estado actual del ciudadano" );
    				}
    				ciudadano = vacuAndes.actualizarCiudadano( documento, ciudadano.getNombre(), ciudadano.getNacimiento(), ciudadano.getHabilitado(), Long.parseLong(idEstado), ciudadano.getId_eps(), ciudadano.getNumero_etapa() );
    			}
        		if (ciudadano == null)
        		{
        			throw new Exception ("No se pudo actualizar al ciudadano " + documento );
        		}
        		String resultado = "En registrarAvanceVacunacion\n\n";
        		resultado += "Ciudadano actualizado correctamente: " + ciudadano;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    /* ****************************************************************
	 * 			Requerimientos Funcionales de Consulta
	 *****************************************************************/
    
    /**
     * Consulta la base de datos para hallar el índice de vacunación para un grupo poblacional
     */
    public void mostrarIndiceGrupoPoblacional() 
    {
    	try 
    	{
    		VOInfoUsuario usuario = panelValidacionUsuario();
    		if ( usuario != null ) {
    			if ( !usuario.getId_roles().equals(1L) || !usuario.getId_roles().equals(2L)) {
    				throw new Exception( "El usuario validado no tiene acceso a este requerimiento" );
    			}
    		}
    		else {
    			return;
    		}
	    	Boolean region, eps, estado, grupo;
	    	List<String> selecRegion = null, selecEps = null;
	    	String selecEstado = null, selecGrupo = null;
	    	JList<String> list = new JList<>( new String[]{"Región","Eps","Estado","Grupo de priorización"} );
	    	JOptionPane.showMessageDialog(null, list, "Selecccione las opciones para filtrar el grupo poblacional (cmd o ctrl sostenido para seleeccionar varias)", JOptionPane.PLAIN_MESSAGE);
	    	List<String> seleccionados = list.getSelectedValuesList();
	    	region = seleccionados.contains("Región") ? true: false;
	    	eps = seleccionados.contains("Eps") ? true: false;
	    	estado = seleccionados.contains("Estado") ? true: false;
	    	grupo = seleccionados.contains("Grupo de priorización") ? true: false;
	    	
	    	if ( region ) {
	    		list = new JList<>( darRegiones() );
	            JOptionPane.showMessageDialog(null, list, "Selecccione la región (cmd o ctrl sostenido para seleeccionar varias)", JOptionPane.PLAIN_MESSAGE);
	            selecRegion = list.getSelectedValuesList();
	    	}
	    	if ( eps ) {
	    		list = new JList<>( darTodasEps() );
	            JOptionPane.showMessageDialog(null, list, "Selecccione la eps (cmd o ctrl sostenido para seleeccionar varias)", JOptionPane.PLAIN_MESSAGE);
	            selecEps = list.getSelectedValuesList();
	    	}
	    	if ( estado ) {
	    		list = new JList<>( darEstados() );
	            JOptionPane.showMessageDialog(null, list, "Selecccione el estado (uno solo)", JOptionPane.PLAIN_MESSAGE);
	            selecEstado = list.getSelectedValue().split(":")[0];
	    	}
	    	if ( grupo ) {
	    		list = new JList<>( darGruposDePriorizacion() );
	            JOptionPane.showMessageDialog(null, list, "Selecccione el grupo (uno solo)", JOptionPane.PLAIN_MESSAGE);
	            selecGrupo = list.getSelectedValue();
	    	}
	    	int answ = JOptionPane.showConfirmDialog(null, "¿Desea filtrar por fecha?", "Fecha", JOptionPane.YES_NO_OPTION);
	    	String fechaInicial = null, fechaFinal = null;
	    	if ( answ == JOptionPane.YES_OPTION ) {
	    		fechaInicial = JOptionPane.showInputDialog (this, "Ingrese la fecha inicial en formato DD-MM-YYYY", "Adicionar vacunación", JOptionPane.QUESTION_MESSAGE);
	    		fechaFinal = JOptionPane.showInputDialog (this, "Ingrese la fecha final en formato DD-MM-YYYY. Si solo desea consultar 1 fecha solo oprima OK", "Adicionar vacunación", JOptionPane.QUESTION_MESSAGE);
	    		if ( fechaFinal.equals("") ) {
	    			fechaFinal = null;
	    		}
	    	}
	    	Double respuesta = vacuAndes.darIndiceVacunacion(selecEps, selecEstado == null? null: Long.parseLong(selecEstado), selecGrupo, selecRegion, fechaInicial, fechaFinal);
	    	if ( respuesta == null ) {
	    		throw new Exception("No hay ningún ciudadano registrado en VacuAndes que pertenezca al grupo poblacional");
	    	}
	    	String resultado = "En Indice grupo poblacional\n\n";
			resultado += "Indice encontrado: " + respuesta;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
    	}
		catch (Exception e) {
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    	
    }

	/* ****************************************************************
	 * 			Métodos administrativos
	 *****************************************************************/
	/**
	 * Muestra el log de VacuAndes
	 */
	public void mostrarLogVacuAndes()
	{
		mostrarArchivo( "vacuandes.log" );
	}
	
	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo( "datanucleus.log" );
	}
	
	/**
	 * Limpia el contenido del log de vacuandes
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogVacuAndes()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo( "vacuandes.log" );

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de vacuandes ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia el contenido del log de datanucleus
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogDatanucleus()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia todas las tuplas de todas las tablas de la base de datos de parranderos
	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
	 */
	public void limpiarBD()
	{
		try 
		{
    		// Ejecución de la demo y recolección de los resultados
			Long eliminados [] = vacuAndes.limpiarVacuAndes();
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			resultado += eliminados [0] + " EPS eliminados\n";
			resultado += eliminados [1] + " ROLES eliminados\n";
			resultado += eliminados [2] + " ESTADOS eliminados\n";
			resultado += eliminados [3] + " ETAPAS eliminadas\n";
			resultado += eliminados [4] + " CONDICIONPRIORIZACION eliminadas\n";
			resultado += eliminados [5] + " PUNTOS eliminados\n";
			resultado += eliminados [6] + " VACUNAS eliminadas\n";
			resultado += eliminados [7] + " ASIGNADAS eliminadas\n";
			resultado += eliminados [8] + " CIUDADANOS eliminados\n";
			resultado += eliminados [9] + " VACUNACIONES eliminadas\n";
			resultado += eliminados [10] + " PRIORIZACIONES eliminadas\n";
			resultado += eliminados [11] + " INFOUSUARIOS eliminadas\n";
			resultado += eliminados [12] + " USUARIOS eliminados\n";
			resultado += eliminados [13] + " CITAS eliminadas\n";
			resultado += "\nLimpieza terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	/**
	 * Muestra la presentación general del proyecto
	 */
	public void mostrarPresentacionGeneral ()
	{
		mostrarArchivo ("data/00-ST-ParranderosJDO.pdf");
	}
	
	/**
	 * Muestra el modelo conceptual de Parranderos
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/Modelo Conceptual Parranderos.pdf");
	}
	
	/**
	 * Muestra el esquema de la base de datos de Parranderos
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD Parranderos.pdf");
	}
	
	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaParranderos.sql");
	}
	
	/**
	 * Muestra la arquitectura de referencia para Parranderos
	 */
	public void mostrarArqRef ()
	{
		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
	}
	
	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	public void mostrarJavadoc ()
	{
		mostrarArchivo ("doc/index.html");
	}
	
	/**
     * Muestra la información acerca del desarrollo de esta apicación
     */
    public void acercaDe ()
    {
		String resultado = "\n\n ************************************\n\n";
		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
		resultado += " * Licenciado	bajo	el	esquema	Academic Free License versión 2.1\n";
		resultado += " * \n";		
		resultado += " * Curso: isis2304 - Sistemas Transaccionales\n";
		resultado += " * Proyecto: VacuAndes\n";
		resultado += " * @version 1.0\n";
		resultado += " * @author Néstor González\n";
		resultado += " * @author Mariana Zamora\n";
		resultado += " * Abril de 2021\n";
		resultado += " * \n";
		resultado += "\n ************************************\n\n";

		panelDatos.actualizarInterfaz(resultado);		
    }
    

	/* ****************************************************************
	 * 			Métodos privados para la presentación de resultados y otras operaciones
	 *****************************************************************/

    private VOInfoUsuario panelValidacionUsuario() {
    	try {
	    	String login = JOptionPane.showInputDialog (this, "Ingrese el login del usuario", "Validar usuario", JOptionPane.QUESTION_MESSAGE);
	    	String clave = JOptionPane.showInputDialog (this, "Ingrese la constraseña del usuario", "Validar usuario", JOptionPane.QUESTION_MESSAGE);
	    	
	    	if ( login != null && !login.trim().equals("") && clave != null && !clave.trim().equals("") ) {
	    		VOInfoUsuario usuario = vacuAndes.darInfoUsuario( login );
	    		if ( usuario == null ) {
	    			throw new Exception( "El usuarion con el login " + login + " no está registrado" );
	    		}
	    		if ( !usuario.getClave().equals(clave.trim()) ) {
	    			throw new Exception( "La clave ingresada no corresponde al usuario con el login " + login );
	    		}
	    		String resultado = "En validar usuario\n\n";
        		resultado += "Usuario validado correctamente";
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    			return usuario;
	    	}
    	} catch (Exception e) {
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    	return null;
    }
    
    private String[] darRegiones() {
    	List<String> regiones = vacuAndes.darRegiones();
    	String[] retorno = new String[regiones.size()];
    	regiones.toArray(retorno);
    	return retorno;
    }
    
    private String[] darEstados() {
    	List<String> estados = new LinkedList<>();
    	for ( Estado actual: vacuAndes.darEstados()) {
    		estados.add( actual.getId() + ": " + actual.getDescripcion() );
    	}
    	String[] retorno = new String[estados.size()];
    	estados.toArray(retorno);
    	return retorno; 
    }
    
    private String[] darTodasEps() {
    	List<String> eps = new LinkedList<>();
    	for ( EPS actual: vacuAndes.darEPSs()) {
    		eps.add( actual.getId() );
    	}
    	String[] retorno = new String[eps.size()];
    	eps.toArray(retorno);
    	return retorno;
    }
    
    private String[] darGruposDePriorizacion() {
    	List<String> grupos = new LinkedList<>();
    	for ( CondicionPriorizacion actual: vacuAndes.darCondicionesPriorizacion()) {
    		grupos.add( actual.getDescripcion() );
    	}
    	String[] retorno = new String[grupos.size()];
    	grupos.toArray(retorno);
    	return retorno;
    }
    
    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
     */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y vacuandes.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     * @param pEvento - El evento del usuario
     */
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = InterfazVacuAndesApp.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}
    
	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazVacuAndesApp interfaz = new InterfazVacuAndesApp( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
