package com.natame.model;

public class NatameRolePrivs {
	private String GRANTEE;
	private String TABLE_NAME;
	private String PRIVILEGE;
	
	
	public String getGRANTEE() {
		return GRANTEE;
	}
	public void setGRANTEE(String gRANTEE) {
		GRANTEE = gRANTEE;
	}
	public String getTABLE_NAME() {
		return TABLE_NAME;
	}
	public void setTABLE_NAME(String tABLE_NAME) {
		TABLE_NAME = tABLE_NAME;
	}
	public String getPRIVILEGE() {
		return PRIVILEGE;
	}
	public void setPRIVILEGE(String pRIVILEGE) {
		PRIVILEGE = pRIVILEGE;
	}
	
}
