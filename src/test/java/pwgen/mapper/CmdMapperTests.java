package pwgen.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import fr.ysaintmartin.pwgen.app.mapper.CmdMapper;

public class CmdMapperTests {
	
	private final List<String> VALID_ARGS_LIST = List.of("-l","15","-r","strong");
	
	@Test
	void mapParameters_returnsMapOfCommandFlagsAndString() {
		Map<String,String> flagsParameters = CmdMapper.mapParameters(VALID_ARGS_LIST);
		Map<String,String> expectedParameters = Map.of("-l","15","-r","strong");
		assertEquals(expectedParameters,flagsParameters);
	}
}
