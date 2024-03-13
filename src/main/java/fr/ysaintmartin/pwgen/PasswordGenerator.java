package fr.ysaintmartin.pwgen;

import fr.ysaintmartin.pwgen.app.exception.NoArgsException;
import fr.ysaintmartin.pwgen.in.validation.CmdValidator;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		System.out.println("The application checks your requirements.");
		try {
			CmdValidator.check(args);			
		} catch(NoArgsException ex) {
			System.out.println(ex.getMessage());
		} finally {			
			System.exit(0);
		}
		
		
	}

}
