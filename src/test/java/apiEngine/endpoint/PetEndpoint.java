package apiEngine.endpoint;

import apiEngine.model.requests.Pet;
import apiEngine.model.response.CreateUserResponse;
import apiEngine.model.response.DeletePetResponse;
import apiEngine.model.response.PetResponse;
import apiEngine.model.response.RestResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class PetEndpoint extends Endpoint{

  public static RestResponse<PetResponse> createPet(Pet createPetRequest) {
    RestAssured.baseURI = BASE_URL;
    RequestSpecification request = RestAssured.given();
    request.header("Content-Type", "application/json");
    Response response = request.body(createPetRequest).post("/pet");
    return new RestResponse(PetResponse.class, response);
  }

  public static RestResponse<PetResponse> updatePet(Pet updatePetRequest) {
    RestAssured.baseURI = BASE_URL;
    RequestSpecification request = RestAssured.given();
    request.header("Content-Type", "application/json");
    Response response = request.body(updatePetRequest).put("/pet");
    return new RestResponse(PetResponse.class, response);
  }

  public static RestResponse<List<PetResponse>> getPetByStatus(String[] statuses){
    RestAssured.baseURI = BASE_URL;
    RequestSpecification request = RestAssured.given();
    for(String status : statuses)
      request.queryParam("status",status);
    Response response = request.get("/pet");
    return new RestResponse(List.class, response);
  }

  public static RestResponse<PetResponse> getPetByID(Integer id){
    RestAssured.baseURI = BASE_URL;
    RequestSpecification request = RestAssured.given();
    request.pathParam("id",id);
    Response response = request.get("/pet/{id}");
    return new RestResponse(PetResponse.class, response);
  }

  public static RestResponse<PetResponse> deletePet(Integer id){
    RestAssured.baseURI = BASE_URL;
    RequestSpecification request = RestAssured.given();
    request.pathParam("id",id);
    Response response = request.delete("/pet/{id}");
    return new RestResponse(DeletePetResponse.class, response);
  }
}
