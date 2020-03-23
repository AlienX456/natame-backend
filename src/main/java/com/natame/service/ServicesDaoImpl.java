package com.natame.service;


import org.springframework.stereotype.Service;

import com.natame.auth.BasicAuthConfig;
import com.natame.auth.Usuario;
import com.natame.dao.CategoriaDaoOracle;
import com.natame.dao.ClienteDaoOracle;
import com.natame.dao.ClientePedidoDaoOracle;
import com.natame.dao.ComisionDaoOracle;
import com.natame.dao.ICategoriaDao;
import com.natame.dao.IClienteDao;
import com.natame.dao.IClientePedidoDao;
import com.natame.dao.IComisionDao;
import com.natame.dao.IPaisDao;
import com.natame.dao.IProductoRegionDao;
import com.natame.dao.IRegionDao;
import com.natame.dao.IRepresentanteVentasDao;
import com.natame.dao.ISeguridadDao;
import com.natame.dao.IUsuarioDao;
import com.natame.dao.PaisDaoOracle;
import com.natame.dao.ProductoRegionDaoOracle;
import com.natame.dao.RegionDaoOracle;
import com.natame.dao.RepresentanteVentasDaoOracle;
import com.natame.dao.SeguridadDaoOracle;
import com.natame.dao.IPedidoDao;
import com.natame.dao.PedidoDaoOracle;
import com.natame.dao.UsuarioDaoOracle;
import com.natame.model.Cliente;
import com.natame.model.ClientePedido;
import com.natame.model.NatameRolePrivs;
import com.natame.model.NatameUsrRole;
import com.natame.model.Pais;
import com.natame.model.Pedido;
import com.natame.model.ProductoRegion;
import com.natame.model.Region;
import com.natame.model.RepresentanteVentas;
import com.natame.model.Subcategoria;
import com.natame.model.Venta;
import com.natame.model.UsuarioPagos;
import com.natame.util.RHException;


@Service
public class ServicesDaoImpl {
	
	//INTERFACES DAO
	private IPaisDao ipais;
	private IClienteDao icliente;
	private IRepresentanteVentasDao irp;
	private IRegionDao iregion;
	private IProductoRegionDao ipr;
	private IClientePedidoDao icp;
	private IComisionDao ic;
	private ISeguridadDao is;
	private ICategoriaDao ict;
	private IUsuarioDao iud;
	private IPedidoDao ip;
	
	private BasicAuthConfig bauth;
	
	public ServicesDaoImpl(){
		this.ipais = new PaisDaoOracle();
		this.bauth = BasicAuthConfig.getInstance();
		this.icliente = new ClienteDaoOracle();
		this.irp = new RepresentanteVentasDaoOracle();
		this.iregion = new RegionDaoOracle();
		this.ipr = new ProductoRegionDaoOracle();
		this.icp = new ClientePedidoDaoOracle();
		this.ic = new ComisionDaoOracle();
		this.is = new SeguridadDaoOracle();
		this.ict = new CategoriaDaoOracle();
		this.iud = new UsuarioDaoOracle();
		this.ip = new PedidoDaoOracle();
		
	}
	
	
	/*
	 * PAIS
	 * 
	 * 
	 * 
	 * 
	 */
	
    public void incluirPais(Pais pais, String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
		ipais.incluirPais(pais, usuario);
    }
    
    
    public void modificarPais(int id, String nombre, String auth) throws RHException {
    	Pais actual = new Pais(id,nombre);
		Usuario usuario = bauth.getUserPassword(auth);
		ipais.modificarPais(actual,usuario);
    	
    }
    
    
    public Pais buscarPais(Integer pais_id, String auth) throws RHException {
    	Pais resultado;
    	Usuario usuario = bauth.getUserPassword(auth);
		resultado = ipais.buscarPais(pais_id, usuario);
		return resultado;
    }
    
    
    public void borrarPais(Integer pais_id, String auth) throws RHException {
		Usuario usuario = bauth.getUserPassword(auth);
		ipais.borrarPais(pais_id, usuario);

    }
    
    
    public Pais[] verPaises(String auth) throws RHException {
    		Usuario usuario = bauth.getUserPassword(auth);
			return ipais.verPaises(usuario);
    }
    
    /*
     * 
     * CLIENTE
     * 
     * 
     * 
     */
    
    public Cliente buscarCliente(String auth) throws RHException {
    	Usuario usuario = bauth.getUserPassword(auth);
    	return this.icliente.buscarCliente(usuario);
    }
    
    public void registrarCliente(Cliente cliente, String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	this.icliente.registrarCliente(cliente, usuario);
    }
    
    public Cliente[] listarClientexRV(String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	return this.icliente.listarClientesRV(usuario);
    }
    
    /*
     * 
     * REPRESENTANTE DE VENTAS
     * 
     * 
     * 
     */
    
    public void registrarRepresentanteVentas(RepresentanteVentas rp, String auth) throws RHException {
    	Usuario usuario = bauth.getUserPassword(auth);
    	if(rp.getGRADO()==null) {
    		rp.setGRADO("BEGINEER");
    	}
    	this.irp.registrarRepresentanteVentas(rp, usuario);
    }
    
    public RepresentanteVentas buscarRepresentanteVentas(String auth) throws RHException {
    	Usuario usuario = bauth.getUserPassword(auth);
    	return this.irp.buscarRepresentanteVentas(usuario);
    }
    
    /*
     * 
     * REGION
     * 
     * 
     * 
     */
    
    public Region[] verRegiones(String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	return this.iregion.verRegiones(usuario);
    }
    
    /*
     * 
     * PRODUCTOREGION
     * 
     * 
     * 
     */
    
    public ProductoRegion[] buscarProductosxRegion(int region, String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	return this.ipr.buscarProductoxRegion(region, usuario);
    }
    
    /*
     * PEDIDDO
     * 
     * 
     * 
     * 
     * 
     */
    
    public void realizarPedido(ClientePedido cp, String auth) throws RHException {
    	Usuario usuario = bauth.getUserPassword(auth);
    	icp.realizarPedido(cp, usuario);
    }
    
    /*
     * COMISION
     * 
     * 
     * 
     * 
     * 
     */
    
    public Venta[] obtenerComision(String finicio, String ffinal,String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	return ic.obtenerVentaxComisionTotal(finicio, ffinal, usuario);
    }
    
    public int obtenerValorTotal(int representante,String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	return ic.obtenerValorTotal(representante, usuario);
    }
    
    
    
    /*
     * SEGURIDAD
     * 
     * 
     * 
     * 
     * 
     */
    
    
    public NatameUsrRole[] obtenerUsuariosXRol(String auth) throws RHException {
    	Usuario usuario = bauth.getUserPassword(auth);
		return is.obtenerUsuariosXRol(usuario);
    }
    
    public NatameRolePrivs[] obtenerPermisosXRol(String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
		return is.obtenerPermisosXRol(usuario);
    }
    
    /*
     * CATEGORIA
     * 
     * 
     * 
     * 
     * 
     */
    
    public Subcategoria[] obtenerCategorias(String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	return ict.obtenerCategorias(usuario);
    }
    
    /*
     * PEDIDOS
     * 
     * 
     * 
     * 
     */
    
    public Pedido[] obtenerPedidos(String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	return this.ip.obtenerListaPedidos(usuario);
    }
    
    public void calificarPedido(int pedido, int calificacion, String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	this.ip.calificarPedido(calificacion, pedido, usuario);
    }
    
    /*
     * PAGOS
     * 
     * 
     * 
     * 
     * 
     */
    
    public void registrarUsuarioPagos(String auth, UsuarioPagos userp) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
    	this.iud.registrarUsuario(usuario, userp);
    }
}
