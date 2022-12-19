package apiTests.libs;

import apiEngine.endpoint.UserEndpoint;
import apiEngine.model.requests.User;
import apiEngine.model.response.GetUserResponse;
import apiEngine.model.response.IRestResponse;
import apiEngine.model.response.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UserLib extends BaseLib {
  public static List<String> getUserNameFromDataJson(String jsonFile) throws IOException {
    File dataFile = getDataFile(jsonFile, "json");
    ObjectMapper objectMapper = new ObjectMapper();
    TypeFactory typeFactory = objectMapper.getTypeFactory();
    List<User> user = objectMapper.readValue(dataFile, typeFactory.constructCollectionType(List.class, User.class));
    List<String> userNamesList = user.stream().map(User::getUsername).collect(Collectors.toList());
    return userNamesList;
  }

  public static Boolean ifUserExist(String userName) {
    RestResponse<GetUserResponse> response = UserEndpoint.getUser(userName);
    return response.isSuccessful();
  }
}
