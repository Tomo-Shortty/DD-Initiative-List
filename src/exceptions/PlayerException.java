package exceptions;

/**
 * Class that represents exceptions related to the construction and use of Player objects.
 * 
 * @author Thomas Shortt
 *
 */
public class PlayerException extends Exception {
	
	/**
	 * Produces a PlayerException
	 */
	public PlayerException(){
	}
	
	/**
	 * Produces a PlayerException with the specified message
	 * @param message - The exception's message
	 */
	public PlayerException(String message) {
		super(message);
	}
	
	/**
	 * Produces a PlayerException with the specified cause
     * @param cause - The exception's cause
	 */
	public PlayerException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Produces a PlayerException with the specified message and cause
     * @param cause - The exception's cause
	 * @param message - The exception's message
	 */
	public PlayerException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Produces a PlayerException with the specified message and cause and flags to enable suppression and make the stack trace writable
     * @param cause - The exception's cause
	 * @param message - The exception's message
	 * @param enableSuppression - A flag to indicate if suppression should be enabled or disabled
	 * @param writableStackTrace - A flag to indicate if the stacktrace should be writable or not    
	 */
	public PlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
