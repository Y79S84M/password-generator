package fr.ysaintmartin.pwgen.in.validation;

import java.util.List;

public enum CommandFlags {
	LENGTH("-l"),
	ROBUSTNESS("-r");
	
	private String flag;
	
	private CommandFlags(String value) {
		flag = value;
	}
	
	public boolean isMissing(List<String> args) {
		return !args.contains(flag);
	}
}
