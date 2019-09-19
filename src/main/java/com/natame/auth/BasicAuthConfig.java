package com.natame.auth;
import java.util.Base64;

public class BasicAuthConfig {
	
	public Usuario getUserPassword(String auth) {
		String code = auth.replace("Basic ", "");
		System.out.println(code);
		String decodedString = new String(Base64.getDecoder().decode(code));
		String[] cred = decodedString.split(":");
		return new Usuario(cred[0],cred[1]);
	}
}
