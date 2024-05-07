package rahulshetty.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class data {
	
	public List<HashMap<String, String>> getJasonDataToMap(String filepath) throws IOException {
		
		//Jason to String
		String jasonContent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);

        //String to Hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jasonContent, new TypeReference<List<HashMap<String,String>>>(){});
			return data;	

	}

}
