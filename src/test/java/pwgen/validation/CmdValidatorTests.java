package pwgen.validation;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ysaintmartin.pwgen.app.exception.InvalidArgumentsException;
import fr.ysaintmartin.pwgen.app.exception.NoArgsException;
import fr.ysaintmartin.pwgen.app.validation.CmdValidator;

public class CmdValidatorTests {
	
	private final List<String> NO_ARGS_GIVEN = List.of(); 
	private final List<String> INVALID_ARGS_GIVEN = List.of("-invalid","15");
	private final List<String> LENGTH_OF_15_GIVEN = List.of("-l","15");
	private final List<String> LENGTH_AND_ROBUSTNESS = List.of("-l","16","-r","standard");

	@Test
	void whenRunningPwGenWithNoArgs_returnsNoArgsException() {
		assertThrows(NoArgsException.class, () -> {			
			CmdValidator.check(NO_ARGS_GIVEN);
		});		
	}
	
	@Test
	void whenRunningPwGenWithNoArgs_returnsNoArgsExceptionWithErrorMessage() {
		Exception ex = assertThrows(NoArgsException.class, () -> {			
			CmdValidator.check(NO_ARGS_GIVEN);
		});
		String expectedMessage = """
				-----------------------------------------------------------------------------------------
				Error: Please provide, at least, the desired length for the password you want to generate.
				use the flag -l or --length to provide the length of the password.
				-----------------------------------------------------------------------------------------
				""";
		String actualMessage = ex.getMessage();
		
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test
	void whenRunningPwGenWithInvalidArgs_returnsInvalidArgumentsException() throws Exception {
		Exception ex = assertThrows(InvalidArgumentsException.class, () -> {			
			CmdValidator.check(INVALID_ARGS_GIVEN);
		});
		String expectedMessage = """
				---------------------------------------------------------------------------------
				Error: Please provide, valid arguments such as -l or --length, -r or --robustness.
				---------------------------------------------------------------------------------
				""";
		String actualMessage = ex.getMessage();
		
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test
	void whenRunningPwGenWithLengthArg_returnsNoException() throws Exception {
		assertAll(() -> CmdValidator.check(LENGTH_OF_15_GIVEN));
	}

	@Test
	void whenRunningPwGenWithLengthArgAndRobustnessArg_returnsNoException() throws Exception {
		assertAll(() -> CmdValidator.check(LENGTH_AND_ROBUSTNESS));
	}
}
