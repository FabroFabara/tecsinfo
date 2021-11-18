package com.tecsinfo.exception;

public class ModeloNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8298658278039325817L;

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
