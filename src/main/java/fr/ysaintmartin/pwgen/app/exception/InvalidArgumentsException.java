package fr.ysaintmartin.pwgen.app.exception;

public class InvalidArgumentsException extends Exception {

	private static final long serialVersionUID = 6494378336128332478L;
	
	public InvalidArgumentsException(String message) {
		super(message);
	}
}
