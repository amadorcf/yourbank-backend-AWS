package es.amadorcf.YourBank_backend.exception;

public class OtpRetryLimitExceededException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2676963743942921043L;

	public OtpRetryLimitExceededException(String message) {
        super(message);
    }
}
