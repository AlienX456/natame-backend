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


import com.fasterxml.jackson.databind.ObjectMapper;
import com.natame.model.Cliente;
import com.natame.model.ClientePedido;
import com.natame.model.Pais;
import com.natame.model.RepresentanteVentas;
import com.natame.service.ServicesDaoImpl;




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
	public String obtenerPaises(@RequestHeader(value="Authorization",required=false) String auth){
		try {
			return objectMapper.writeValueAsString(this.serviciosDao.verPaises(auth));
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPais(@PathVariable int id, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return objectMapper.writeValueAsString(serviciosDao.buscarPais(id,auth));
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/pais", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String insertarPais(@RequestBody Pais pais, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			serviciosDao.incluirPais(pais, auth);
			return "{\"resultado\":\"transacción finalizada con exito\"}";
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String borrarPais(@PathVariable int id, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			serviciosDao.borrarPais(id, auth);
			return "{\"resultado\":\"transacción finalizada con exito\"}";
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
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
	public String registrarRepresentanteVentas(@RequestBody RepresentanteVentas rp, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			serviciosDao.registrarRepresentanteVentas(rp, auth);
			return "{\"resultado\":\"transacción finalizada con exito\"}";
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
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
	public String buscarRepresentanteVentas(@RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return objectMapper.writeValueAsString(serviciosDao.buscarRepresentanteVentas(auth));
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/cliente/{cedula}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarCliente(@PathVariable int cedula, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return objectMapper.writeValueAsString(serviciosDao.buscarCliente(cedula, auth));
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/cliente", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String registrarCliente(@RequestBody Cliente cliente, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			serviciosDao.registrarCliente(cliente, auth);
			return "{\"resultado\":\"transacción finalizada con exito\"}";
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	/*
	 POST LIKE
	{
    "cedula":1030675823,
    "nombrecliente":"Esteban",
    "apellidocliente":"Romero",
    "correoelectronico":"estebanelias27",
    "telefono":"3103018563",
    "direccion":"cll 40 a",
    "ciudad":"Bogotá"
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
	@RequestMapping(value = "/region", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String verRegiones(@RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return objectMapper.writeValueAsString(this.serviciosDao.verRegiones(auth));
		}  catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	//Muestra todos los productos disponibles con su imagen, 
	//descripción, precio y cantidad disponible de la regional seleccionada
	@CrossOrigin
	@RequestMapping(value = "/productoregion/{region}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarProductoxRegion(@PathVariable int region, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return objectMapper.writeValueAsString(this.serviciosDao.buscarProductosxRegion(region, auth));
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/pedido", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String registrarPedido(@RequestBody ClientePedido cp, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			serviciosDao.realizarPedido(cp, auth);
			return "{\"resultado\":\"transacción finalizada con exito\"}";
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/comision/{representante}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerComision(@PathVariable int representante, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return "{\"comision\":\""+serviciosDao.obtenerComision(representante,auth)+"\"}";
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
		
	}
	
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

	
	/*
	 {
	"cedula":1234,
	"pd":[
		{"idproductoregion":5,"cantidad":10},
		{"idproductoregion":11,"cantidad":200}
	]
	}
	 */
	
	


	

}
