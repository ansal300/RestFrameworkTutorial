package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static Map<String, Object> readFromJsonAsMap(String filename) throws IOException {
        String jsonPath = System.getProperty("user.dir") + "/src/test/resources/" + filename;
        Map<String, Object> data = mapper.readValue(new File(jsonPath), new TypeReference<>() {
        });
        return data;
    }
}
