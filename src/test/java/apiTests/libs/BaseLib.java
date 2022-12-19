package apiTests.libs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class BaseLib {

  static final String dataFilesPath = "src/test/resources/testData";

  /**
   * @param fileName
   * @param ext
   * @return
   */
  public static File getDataFile(String fileName, String ext) {
    String dataFilePath = Paths.get(System.getProperty("user.dir"), dataFilesPath, fileName + '.' + ext).toString();
    File dataFile = new File(dataFilePath);
    if (!dataFile.exists() && dataFile.isDirectory()) {
      throw new RuntimeException(String.format("Unable to find data file %s on path %s", fileName, dataFilePath));
    }
    return dataFile;
  }

  public static Object jsonFileToClass(String fileName, Class t) throws IOException {
    File dataFile = getDataFile(fileName, "json");
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(dataFile, t);
    } catch (MismatchedInputException e) {
      TypeFactory typeFactory = objectMapper.getTypeFactory();
      return objectMapper.readValue(dataFile, typeFactory.constructCollectionType(List.class, t));
    }
  }
}
