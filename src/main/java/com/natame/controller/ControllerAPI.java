package com.natame.controller;






import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natame.model.Cliente;
import com.natame.model.ClientePedido;
import com.natame.model.Pais;
import com.natame.model.RepresentanteVentas;
import com.natame.model.UsuarioPagos;
import com.natame.service.ServicesDaoImpl;
import com.natame.service.VentaRango;
import com.natame.util.RHException;




@RestController
@RequestMapping(value = "/api")
public class ControllerAPI {
	
	
	@Autowired
	private ServicesDaoImpl serviciosDao;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	/*===============================================================
	 * NATAME
	 * 
	 * TODOS LAS PETICIONES RETORNAN FORMATO JSON
	 * 
	 * 
	 * ===========================================================
	 */
	
	
	/*
	 * SE OBTIENEN LOS PAISES REGISTRADOS EN LA BD
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/pais", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPaises(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException{
		return objectMapper.writeValueAsString(this.serviciosDao.verPaises(auth));
	}
	
	
	/*
	 * SE OBTIENE UN PAIS ESPECIFICO DE LA BD
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPais(@PathVariable int id, @RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.buscarPais(id,auth));
	}
	
	
	/*
	 * SE REGISTRA UN NUEVO PAIS EN LA BD
	 *
		 {
		    "nombrepais": "United States of America"
		 }
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/pais", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String insertarPais(@RequestBody Pais pais, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.incluirPais(pais, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	
	
	/*
	 * SE BORRA UN PAIS ESPECIFICO DE LA BD
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String borrarPais(@PathVariable int id, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.borrarPais(id, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	
	
	/*CASO DE USO
	 * REGISTRAR RERESENTANTE DE VENTAS
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	/*
	 * SE REGISTRA UN NUEVO REPRESENTANTE DE VENTAS PD: LA CONTRASEÑA ES LA IDENTIFICACIÓN DEL USUARIO
	 * RVMID Y RVMTIPOID REFIEREN AL REPRESENTANTE DE VENTAS MASTER QUE LO REGISTRA
	 *
		{
			"identificacion":2,
			"tipoid":"CC",
			"nombre":"testrv1",
			"correoelectronico":"testrv1@",
			"genero":"A",
			"fechanacimiento":"27-02-1997",
			"fechacontrato":"30-06-2019",
			"telefonocontacto":"3103018563",
			"direccion":"cll 40 a",
			"esdirector":"N",
			"grado":"MASTER",
			"region":1,
			"rvmid":1,
			"rvmtipoid":"CC",
			"usuario":"testrv1"
		}
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/representante", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String registrarRepresentanteVentas(@RequestBody RepresentanteVentas rp, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.registrarRepresentanteVentas(rp, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	
	
	/*
	 * OBTENER LISTADO DE REPRESENTANTES DE VENTAS 
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/representante", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarRepresentanteVentas(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.buscarRepresentanteVentas(auth));
	}
	
	
	/*
	 * OBTENER LISTADO DE CLIENTES
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/cliente", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarCliente( @RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.buscarCliente(auth));
	}
	
	
	/*
	 * REGISTRAR UN CLIENTE A LA BD
	 * 
		{
		   "identificacion":1,
		   "tipoid":"CC",
		   "nombre":"test",
		   "apellido":"cliente",
		   "correoelectronico":"test@",
		   "telefono":"1",
		   "direccion":"cll 40 a",
		   "ciudad":"Bogotá",
		   "username":"testc1"
		}
	*/
	
	@CrossOrigin
	@RequestMapping(value = "/cliente", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String registrarCliente(@RequestBody Cliente cliente, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.registrarCliente(cliente, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}


	
	
	/*CASO DE USO
	 * VENDER PRODUCTOS
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	/*
	 * OBTENER LISTADO DE LAS CATEGORIAS DE PRODUCTOS
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/categoria", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String verCategorias(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(this.serviciosDao.obtenerCategorias(auth));
	}
	
	
	/*
	 * OBTENER LISTADO DE REGIONES
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/region", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String verRegiones(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(this.serviciosDao.verRegiones(auth));
	}
	

	/*
	 * OBTENER EL LISTADO DE LOS PRODUCTOS DISPONIBLES
	 * DESCRIPCIÓN, PRECIO Y CANTIDAD DISPONIBLE DE LA REGION (PARAMETRO)
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/productoregion/{region}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarProductoxRegion(@PathVariable int region, @RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(this.serviciosDao.buscarProductosxRegion(region, auth));
	}
	
	
	/*
	 *  GENERAR UN PEDIDO
	 *  IDENTIFICACION = ID DEL CLIENTE, INVENTARIO = RELACIÓN PRODUCTO-REGION-CANTIDAD
	 *  
		 {
		 	"identificacion":,
		 	"tipoid":"",
		 	"pd":[{"inventario":int,"cantidad":int},{"inventario":int,"cantidad":int}],
		 	"estado":"",
		 	"calificacion":int,
		 	"fechapedido":"",
		 	"mododepago":""
		 }
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/pedido", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String registrarPedido(@RequestBody ClientePedido cp, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.realizarPedido(cp, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	
	
	/*
	 * OBTENER EL LISTADO DE REPRESENTANTES DE VENTAS POR CLIENTES
	 * 
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/pedido", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPedidos(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.obtenerPedidos(auth));
	}
	
	
	/*
	 * CALFICAR PEDIDO
	 * 
	 * pedid -> id del pedido, calificacion -> calificacion del pedido
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/pedido/{pedid}/{calificacion}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String calificarPedido(@PathVariable int pedid, @PathVariable int calificacion,@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		serviciosDao.calificarPedido(pedid, calificacion, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	
	
	/*
	 * GENERA LA COMISION POR FECHAS
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/venta", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerComision(@RequestBody VentaRango vr, @RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.obtenerComision(vr.getFINICIAL(), vr.getFFINAL(), auth));
	}
	
	
	
	/*CASO DE USO
	 * SEGURIDAD
	 * 
	 * 
	 * 
	 * 
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/usrxrol", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerUsuariosXRol(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(this.serviciosDao.obtenerUsuariosXRol(auth));
	}
	
	@CrossOrigin
	@RequestMapping(value = "/rolxprivs", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPermisosXRol(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(this.serviciosDao.obtenerPermisosXRol(auth));
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String registrarPedido() {
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();
	   String date = dtf.format(now);
	   System.out.println(date);
	   return date;	
	}
	
	/*==
	 * Procedimientos, triggers y demás
	 * 
	 * 
	 * 
	 * ==
	 */
	
	/*
	 * Retorna el IVA, se envia  el parametro 
	 * PD: espacios con -
	 */
	
	
	@CrossOrigin
	@RequestMapping(value = "/funciones/calcularIVA/{nombrePro}", method = RequestMethod.GET)
	@ResponseBody
	public String calcularIVA(@PathVariable String nombrePro, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		nombrePro = nombrePro.replace("-", " ");
		Float res = serviciosDao.obtenerIvaProducto(nombrePro, auth);
		return "{\"resultado\":\""+res+"\"}";
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/funciones/factura/{idpedido}", method = RequestMethod.GET)
	@ResponseBody
	public String generarFactura(@PathVariable int idpedido, @RequestHeader(value="Authorization",required=false) String auth) throws RHException, JsonProcessingException {
		return objectMapper.writeValueAsString(this.serviciosDao.generarFactura(idpedido, auth));
	}
	/*===============================================================
	 * PAGOS
	 * 
	 * 
	 * 
	 * 
	 * ===========================================================
	 */
	
	
	/*
	 * REGISTRAR USUARIO NUEVO
	 *  
	 {
		"numidentificacion":,
		"nombre":"",
		"clave":"",
		"tipoidentificacion":""
	 }
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/usuariopagos", method = RequestMethod.POST)
	@ResponseBody
	public String registrarUsuarioPagos(@RequestBody UsuarioPagos up, @RequestHeader(value="Authorization",required=false) String auth) throws RHException{
		this.serviciosDao.registrarUsuarioPagos(auth, up);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/pagos/{idpedido}", method = RequestMethod.POST)
	@ResponseBody
	public String registrarPago(@PathVariable int idpedido, @RequestHeader(value="Authorization",required=false) String auth) throws RHException{
		return "{\"resultado\":\""+this.serviciosDao.registrarPago(auth, idpedido)+"\"}";
	}

	
	


	

}
