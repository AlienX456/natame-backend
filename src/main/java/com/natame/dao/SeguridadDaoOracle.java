package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.natame.auth.Usuario;
import com.natame.model.NatameRolePrivs;
import com.natame.model.NatameUsrRole;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class SeguridadDaoOracle implements ISeguridadDao{

	@Override
	public NatameRolePrivs[] obtenerPermisosXRol(Usuario user) throws RHException {
		ArrayList<NatameRolePrivs> lista = new ArrayList<NatameRolePrivs>();
		try {
			String strSQL = "SELECT * from NATAME_ROLE_PRIVS";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        ResultSet rs = prepStmt.executeQuery();
	        while(rs.next()) {
	        	NatameRolePrivs resultado = new NatameRolePrivs();
		        resultado.setGRANTEE(rs.getString("GRANTEE"));
		        resultado.setTABLE_NAME(rs.getString("TABLE_NAME"));
		        resultado.setPRIVILEGE(rs.getString("PRIVILEGE"));
		        lista.add(resultado);
	        }
	        prepStmt.close();
	        return lista.toArray(new NatameRolePrivs[lista.size()]);
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en obtenerPermisosXRol() "+ e.getMessage());
			}  finally {
	          ServiceLocator.getInstance().liberarConexion();
	       }
	}

	@Override
	public NatameUsrRole[] obtenerUsuariosXRol(Usuario user) throws RHException {
		ArrayList<NatameUsrRole> lista = new ArrayList<NatameUsrRole>();
		try {
			String strSQL = "SELECT * from NATAME_USR_ROLE";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        ResultSet rs = prepStmt.executeQuery();
	        while(rs.next()) {
	        	NatameUsrRole resultado = new NatameUsrRole();
		        resultado.setGRANTEE(rs.getString("GRANTEE"));
		        resultado.setGRANTED_ROLE(rs.getString("GRANTED_ROLE"));
		        resultado.setADMIN_OPTION(rs.getString("ADMIN_OPTION"));
		        lista.add(resultado);
	        }
	        prepStmt.close();
	        return lista.toArray(new  NatameUsrRole[lista.size()]);
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en obtenerUsuariosXRol() "+ e.getMessage());
			}  finally {
	          ServiceLocator.getInstance().liberarConexion();
	       }
	}

}
