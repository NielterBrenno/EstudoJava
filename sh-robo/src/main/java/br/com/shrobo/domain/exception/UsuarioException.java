package br.com.shrobo.domain.exception;

public class UsuarioException extends Exception {

	private static final long serialVersionUID = 4650526739295007580L;

	public UsuarioException(String message) {
		super(message);
	}

	public UsuarioException(Throwable cause) {
		super(cause);
	}

	public UsuarioException(String message, Throwable cause) {
		super(message, cause);
	}
}