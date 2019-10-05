package br.com.shrobo.domain.exception;

public class ShAtivacaoException extends Exception {

	private static final long serialVersionUID = 4650526739295007580L;

	public ShAtivacaoException(String message) {
		super(message);
	}

	public ShAtivacaoException(Throwable cause) {
		super(cause);
	}

	public ShAtivacaoException(String message, Throwable cause) {
		super(message, cause);
	}
}