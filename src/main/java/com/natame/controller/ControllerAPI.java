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
import com.natame.service.ServicesDaoImpl;
import com.natame.service.VentaRango;
import com.natame.util.RHException;




@RestController
@RequestMapping(value = "/api")
public class ControllerAPI {
	
	
	@Autowired
	private ServicesDaoImpl serviciosDao;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	/*
	 * PAISES
	 * REALIZADO CON FINES DE PRUEBA
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/pais", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPaises(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException{

	return objectMapper.writeValueAsString(this.serviciosDao.verPaises(auth));

	}
	
	@CrossOrigin
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPais(@PathVariable int id, @RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.buscarPais(id,auth));
	}
	
	@CrossOrigin
	@RequestMapping(value = "/pais", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String insertarPais(@RequestBody Pais pais, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.incluirPais(pais, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	
	@CrossOrigin
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String borrarPais(@PathVariable int id, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.borrarPais(id, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	
	/*
	POST BODY LIKE :
	{
	    "nombrepais": "nombredelpais"
	}
	*/
	
	/*CASO DE USO
	 * REGISTRAR RERESENTANTE DE VENTAS
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	@CrossOrigin
	@RequestMapping(value = "/representante", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String registrarRepresentanteVentas(@RequestBody RepresentanteVentas rp, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.registrarRepresentanteVentas(rp, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	
	/*
	 * POST BODY LIKE :
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
	@RequestMapping(value = "/representante", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarRepresentanteVentas(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.buscarRepresentanteVentas(auth));
	}
	
	@CrossOrigin
	@RequestMapping(value = "/cliente", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarCliente( @RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.buscarCliente(auth));
	}
	
	@CrossOrigin
	@RequestMapping(value = "/cliente", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String registrarCliente(@RequestBody Cliente cliente, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.registrarCliente(cliente, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
	}
	/*
	 POST LIKE
	{
    "identificacion":1,
    "tipoid":"CC"
    "nombre":"test",
    "apellido":"cliente",
    "correoelectronico":"test@",
    "telefono":"1",
    "direccion":"cll 40 a",
    "ciudad":"Bogotá",
    "username":"testc1"
	}
	*/

	
	
	/*CASO DE USO
	 * VENDER PRODUCTOS
	 * 
	 * 
	 * 
	 * 
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/categoria", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String verCategorias(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(this.serviciosDao.obtenerCategorias(auth));
	}
	
	@CrossOrigin
	@RequestMapping(value = "/region", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String verRegiones(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(this.serviciosDao.verRegiones(auth));
	}
	
	//Muestra todos los productos disponibles 
	//descripción, precio y cantidad disponible de la regional seleccionada
	@CrossOrigin
	@RequestMapping(value = "/productoregion/{region}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarProductoxRegion(@PathVariable int region, @RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(this.serviciosDao.buscarProductosxRegion(region, auth));
	}
	
	@CrossOrigin
	@RequestMapping(value = "/pedido", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String registrarPedido(@RequestBody ClientePedido cp, @RequestHeader(value="Authorization",required=false) String auth) throws RHException {
		serviciosDao.realizarPedido(cp, auth);
		return "{\"resultado\":\"transacción finalizada con exito\"}";
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/representante/cliente", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String listarClientesXRV(@RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.listarClientexRV(auth));
	}
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/venta", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerComision(@RequestBody VentaRango vr, @RequestHeader(value="Authorization",required=false) String auth) throws JsonProcessingException, RHException {
		return objectMapper.writeValueAsString(serviciosDao.obtenerComision(vr.getFINICIAL(), vr.getFFINAL(), auth));
	}
	
	/*
	@CrossOrigin
	@RequestMapping(value = "/vtotal/{representante}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerTotal(@PathVariable int representante, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return "{\"total\":\""+serviciosDao.obtenerValorTotal(representante, auth)+"\"}";
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
		
	}
	
	*/
	
	
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

	
	


	

}
