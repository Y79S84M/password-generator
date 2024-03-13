package fr.ysaintmartin.pwgen.in.validation;

import fr.ysaintmartin.pwgen.app.exception.NoArgsException;

public class CmdValidator {

	private static final String NO_ARGS_ERROR_MESSAGE = """
			Error: Please provide, at least, the desired length for the password you want to generate.
			use the flag -l or --length to provide the length of the password.
			""";
	
	public static void check(String[] args) throws NoArgsException {
		if(args.length<=0) {
			throw new NoArgsException(NO_ARGS_ERROR_MESSAGE);
		}
	}
	
}
