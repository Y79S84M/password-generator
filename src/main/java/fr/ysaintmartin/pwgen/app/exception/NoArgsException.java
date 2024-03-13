package fr.ysaintmartin.pwgen.app.exception;

public class NoArgsException extends Exception {

	private static final long serialVersionUID = -1920718005043196103L;
	
	public NoArgsException() {
		super();
	}
	
	public NoArgsException(String message) {
		super(message);
	}
}
