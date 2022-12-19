package apiEngine.endpoint;

import apiEngine.model.requests.CreateUsersRequest;
import apiEngine.model.requests.User;
import apiEngine.model.response.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class UserEndpoint extends Endpoint{

  public static RestResponse<CreateUserResponse> createUsers(List<CreateUsersRequest> createUsersRequest) {
    RestAssured.baseURI = BASE_URL;
    RequestSpecification request = RestAssured.given();
    request.header("Content-Type", "application/json");
    Response response = request.body(createUsersRequest).post("/user/createWithArray");
    return new RestResponse(CreateUserResponse.class, response);
  }

  public static RestResponse<UpdateUserResponse> updateUser(String username, User updateUsersRequest) {
    RestAssured.baseURI = BASE_URL;
    RequestSpecification request = RestAssured.given();
    request.header("Content-Type", "application/json");
    request.pathParam("username",username);
    Response response = request.body(updateUsersRequest).put("/user/{username}");
    return new RestResponse(UpdateUserResponse.class, response);
  }

  public static RestResponse<GetUserResponse> getUser(String username){
    RestAssured.baseURI = BASE_URL;
    RequestSpecification request = RestAssured.given();
    request.pathParam("username",username);
    Response response = request.get("/user/{username}");
    return new RestResponse(GetUserResponse.class, response);
  }

  public static RestResponse<DeleteUserResponse> deleteUser(String username){
    RestAssured.baseURI = BASE_URL;
    RequestSpecification request = RestAssured.given();
    request.pathParam("username",username);
    Response response = request.delete("/user/{username}");
    return new RestResponse(DeleteUserResponse.class, response);
  }

}
