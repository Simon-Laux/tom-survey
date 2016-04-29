package de.simonlaux.survey;

public class StoreInitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StoreInitException(String msg) {
		super(msg);
	}

	public StoreInitException(String msg, Exception cause) {
		super(msg, cause);
		// System.out.println(
		// "Sorry, there is a Problem with " + thing.toString() + "\nWe try to
		// Fall back to your alternative");
	}

}
