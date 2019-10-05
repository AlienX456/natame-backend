package com.natame.model;




public class Cliente {

	private int CEDULA;
	
	private String NOMBRECLIENTE;
	
	private String APELLIDOCLIENTE;
	
	private String TELEFONO;

	private String DIRECCION;
	
	private String CIUDAD;
	
	private String CORREOELECTRONICO;
	
	private String TIPOID;

	private String USERNAME;
	
	private int RPCREADOR;
	

	public String getTIPOID() {
		return TIPOID;
	}

	public void setTIPOID(String tIPOID) {
		TIPOID = tIPOID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public int getCEDULA() {
		return CEDULA;
	}

	public void setCEDULA(int cEDULA) {
		CEDULA = cEDULA;
	}

	public String getNOMBRECLIENTE() {
		return NOMBRECLIENTE;
	}

	public void setNOMBRECLIENTE(String nOMBRECLIENTE) {
		NOMBRECLIENTE = nOMBRECLIENTE;
	}

	public String getAPELLIDOCLIENTE() {
		return APELLIDOCLIENTE;
	}

	public void setAPELLIDOCLIENTE(String aPELLIDOCLIENTE) {
		APELLIDOCLIENTE = aPELLIDOCLIENTE;
	}

	public String getTELEFONO() {
		return TELEFONO;
	}

	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}

	public String getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}

	public String getCIUDAD() {
		return CIUDAD;
	}

	public void setCIUDAD(String cIUDAD) {
		CIUDAD = cIUDAD;
	}

	public String getCORREOELECTRONICO() {
		return CORREOELECTRONICO;
	}

	public void setCORREOELECTRONICO(String cORREOELECTRONICO) {
		CORREOELECTRONICO = cORREOELECTRONICO;
	}

	public int getRPCREADOR() {
		return RPCREADOR;
	}

	public void setRPCREADOR(int rPCREADOR) {
		RPCREADOR = rPCREADOR;
	}

	
}
