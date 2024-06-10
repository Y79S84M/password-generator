package fr.ysaintmartin.pwgen.app.validation;

import java.util.List;

import fr.ysaintmartin.pwgen.app.exception.InvalidArgumentsException;
import fr.ysaintmartin.pwgen.app.exception.NoArgsException;

public class CmdValidator {

	private static final String NO_ARGS_ERROR_MESSAGE = """
			-----------------------------------------------------------------------------------------
			Error: Please provide, at least, the desired length for the password you want to generate.
			use the flag -l or --length to provide the length of the password.
			-----------------------------------------------------------------------------------------
			""";
	private static final String INVALID_ARGS_ERROR_MESSAGE = """
			---------------------------------------------------------------------------------
			Error: Please provide, valid arguments such as -l or --length, -r or --robustness.
			---------------------------------------------------------------------------------
			""";
	
	public static void check(List<String> args) throws NoArgsException, InvalidArgumentsException {
		if(args.isEmpty()) {
			throw new NoArgsException(NO_ARGS_ERROR_MESSAGE);
		}
		if(CommandFlags.LENGTH.isMissing(args)) {
			throw new InvalidArgumentsException(INVALID_ARGS_ERROR_MESSAGE);
		}
	}
	
	
	
}
