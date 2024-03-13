package pwgen.in.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.ysaintmartin.pwgen.app.exception.NoArgsException;
import fr.ysaintmartin.pwgen.in.validation.CmdValidator;

public class CmdValidatorTests {
	
	private final String[] NO_ARGS_GIVEN = {}; 

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
				Error: Please provide, at least, the desired length for the password you want to generate.
				use the flag -l or --length to provide the length of the password.
				""";
		String actualMessage = ex.getMessage();
		
		assertTrue(expectedMessage.equals(actualMessage));
	}
}
