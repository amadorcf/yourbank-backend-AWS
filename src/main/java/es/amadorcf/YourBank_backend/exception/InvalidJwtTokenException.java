package es.amadorcf.YourBank_backend.exception;

public class InvalidJwtTokenException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6859778110195654839L;

	public InvalidJwtTokenException(String message) {
        super(message);
    }
}
