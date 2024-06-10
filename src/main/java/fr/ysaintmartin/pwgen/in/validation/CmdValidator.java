package fr.ysaintmartin.pwgen.in.validation;

import java.util.ArrayList;
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
	
	public static void check(String[] args) throws NoArgsException, InvalidArgumentsException {
		if(args.length<=0) {
			throw new NoArgsException(NO_ARGS_ERROR_MESSAGE);
		} 
			
		List<String> argsList = new ArrayList<>();
		for (String string : args) {
			argsList.add(string);
		}
		
		if(CommandFlags.LENGTH.isMissing(argsList)) {
			throw new InvalidArgumentsException(INVALID_ARGS_ERROR_MESSAGE);
		}
		

	}
	
	
	
}
