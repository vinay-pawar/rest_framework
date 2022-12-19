package apiTests.libs;

import apiEngine.endpoint.PetEndpoint;
import apiEngine.endpoint.UserEndpoint;
import apiEngine.model.requests.Pet;
import apiEngine.model.requests.User;
import apiEngine.model.response.GetUserResponse;
import apiEngine.model.response.PetResponse;
import apiEngine.model.response.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PetLib extends BaseLib{
  public static List<Integer> getPetIdsFromDataJson(String jsonFile) throws IOException {
    File dataFile = getDataFile(jsonFile, "json");
    ObjectMapper objectMapper = new ObjectMapper();
    TypeFactory typeFactory = objectMapper.getTypeFactory();
    List<Pet> pets = objectMapper.readValue(dataFile, typeFactory.constructCollectionType(List.class, Pet.class));
    List<Integer> petIdList = pets.stream().map(Pet::getId).collect(Collectors.toList());
    return petIdList;
  }

  public static Boolean ifPetExist(Integer petId) {
    RestResponse<PetResponse> response = PetEndpoint.getPetByID(petId);
    return response.isSuccessful();
  }
}
