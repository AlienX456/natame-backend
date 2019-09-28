package com.natame.controller;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.natame.model.Cliente;
import com.natame.model.Pais;
import com.natame.model.RepresentanteVentas;
import com.natame.service.ServicesDaoImpl;




@RestController
public class ControllerAPI {
	
	
	@Autowired
	private ServicesDaoImpl serviciosDao;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	/*
	 * PAISES
	 * REALIZADO CON FINES DE PRUEBA
	 */
	
	
	@RequestMapping(value = "/pais", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPaises(@RequestHeader(value="Authorization",required=false) String auth){
		try {
			return objectMapper.writeValueAsString(this.serviciosDao.verPaises(auth));
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPais(@PathVariable int id, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return objectMapper.writeValueAsString(serviciosDao.buscarPais(id,auth));
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
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
	    "idpais": 4,
	    "nombrepais": "Canada"
	}
	*/
	
	/*CASO DE USO
	 * REGISTRAR RERESENTANTE DE VENTAS
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	@RequestMapping(value = "/cliente/{cedula}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarCliente(@PathVariable int cedula, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return objectMapper.writeValueAsString(serviciosDao.buscarCliente(cedula, auth));
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
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
    "identificacion":1030675823,
    "nombre":"Esteban",
    "correoelectronico":"estebanelias27",
    "genero":"M",
    "fechanacimiento":"27-02-1997",
    "fechacontrato":"30-06-2019",
    "telefonocontacto":"3103018563",
    "direccion":"cll 40 a",
    "esdirector":"S",
    "grado":4,
    "region":1
	}
	 */
	
	@RequestMapping(value = "/representante/{identificacion}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarRepresentanteVentas(@PathVariable int identificacion, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return objectMapper.writeValueAsString(serviciosDao.buscarRepresentanteVentas(identificacion, auth));
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	
	/*CASO DE USO
	 * VENDER PRODUCTOS
	 * 
	 * 
	 * 
	 * 
	 */
	
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
	@RequestMapping(value = "/productoregion/{region}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarProductoxRegion(@PathVariable int region, @RequestHeader(value="Authorization",required=false) String auth) {
		try {
			return objectMapper.writeValueAsString(this.serviciosDao.buscarProductosxRegion(region, auth));
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	
	


	

}
