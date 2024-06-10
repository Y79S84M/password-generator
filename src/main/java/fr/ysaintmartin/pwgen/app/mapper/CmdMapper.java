package fr.ysaintmartin.pwgen.app.mapper;

import java.util.List;
import java.util.Map;


public class CmdMapper {
	public static Map<String,String> mapParameters(List<String> argsList) {
		List<String> flags = argsList.stream().filter(el -> el.startsWith("-")).toList();
		List<String> parameters = argsList.stream().filter(el -> !el.startsWith("-")).toList();
		return Map.of(flags.getFirst(),parameters.getFirst(),flags.getLast(),parameters.getLast());
	}
}
