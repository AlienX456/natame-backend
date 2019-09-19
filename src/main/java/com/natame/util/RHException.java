package com.natame.util;

public class RHException extends Exception {
    private String detalle;
    private String clase;
    /**
     * M�todo constructor que recoge la descripci�n del 
     * error que genero la excepci�n.
     * 
     * @param error
     *        cadena que contiene la descripci�n del error.
     */

    public RHException(String clase,String error) {
      super(error);
      this.clase = clase; 
      detalle = error;
    }

    public String toString() {
      return "["+clase+"] "+detalle;
    }
}
