package TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class GetDataFromJson {
    @Test
    public List<HashMap<String, String>> readData() throws IOException {
        String jsonFileContent = FileUtils.readFileToString(new File("C:\\Users\\suhail.shahapur\\IdeaProjects\\RSSelenium\\src\\main\\java\\Resources\\TestData.json"), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonFileContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }
}
