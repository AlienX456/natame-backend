package com.natame.dao;
import com.natame.util.RHException;
import com.natame.auth.Usuario;

public interface IFuncionesNatame {
	
	/*
	 * FUNCIONES
	 * 
	 */
	
	//public void totalizarCarrtitoFU(Usuario user) throws  RHException;
	public Float calcularIVAProductoFU(String nombre,Usuario user) throws  RHException;
	//public void pagarEnLineaFU(int id, String tipoid,Usuario user) throws  RHException;
	public String generarFacturaFU(int id_pedido, Usuario user) throws  RHException;
	public void calificarRVFU(int pedido, int calificacion, Usuario user) throws  RHException;
	
	
}
