package es.amadorcf.YourBank_backend.exception;

public class AccountDoesNotExists extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1180822918717228267L;

	public AccountDoesNotExists(String message) {
		super(message);
	}

}
