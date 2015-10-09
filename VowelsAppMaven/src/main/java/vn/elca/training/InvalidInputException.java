package vn.elca.training;

public class InvalidInputException extends Exception {

	/**
	 * Define InvalidInputException class
	 */
	private static final long serialVersionUID = -4715160416164568576L;

	public InvalidInputException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public InvalidInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public InvalidInputException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
