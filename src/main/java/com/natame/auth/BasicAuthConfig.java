package com.natame.auth;
import java.util.Base64;

import com.natame.util.RHException;


public class BasicAuthConfig {
	
	private static final Usuario invitado = new Usuario("invitado_natame","invitado_natame");
	
	private static BasicAuthConfig instance = null;
	
	private BasicAuthConfig() {

	}
	
	public static BasicAuthConfig getInstance() {
		if (instance == null) {
			instance = new BasicAuthConfig();
		}
		return instance;
	}
	
	public Usuario getUserPassword(String auth) throws RHException {
		try {
			if (auth!=null) {
				String code = auth.replace("Basic ", "");
				String decodedString = new String(Base64.getDecoder().decode(code));
				String[] cred = decodedString.split(":");
				return new Usuario(cred[0],cred[1]);
			}else {
				return invitado;
			}
		}catch(Exception e){
			throw new RHException( this.getClass().getName(), "Error en getUserPassword() "+ e.getMessage());
		}


	}
	
}
