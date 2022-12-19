package apiTests.stepDefinitions;

import apiEngine.endpoint.UserEndpoint;
import apiEngine.model.requests.CreateUsersRequest;
import apiEngine.model.requests.User;
import apiEngine.model.response.*;
import apiTests.libs.UserLib;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

public class UserStepDefs {
  UserLib helper = new UserLib();
  @Given("Users in {string} are not present")
  public void users_in_are_not_present(String jsonFile) throws IOException {
    List<String> userNames = helper.getUserNameFromDataJson(jsonFile);
    for(String userName: userNames){
      if(helper.ifUserExist(userName)){
        UserEndpoint.deleteUser(userName);
      }
    }
  }
  @When("I add users from {string} via api")
  public void i_add_users_from_via_api(String jsonFile) throws IOException {
    RestResponse<CreateUserResponse> response= UserEndpoint.createUsers((List<CreateUsersRequest>)helper.jsonFileToClass(jsonFile, CreateUsersRequest.class));
    if(!response.isSuccessful())
      throw new RuntimeException("Unable to create Users, API return response"+response.getResponse());
  }
  @Then("the users in {string} are added to Pet Store")
  public void the_users_in_are_added_to_pet_store(String jsonFile) throws IOException {
    List<GetUserResponse> users =(List<GetUserResponse>)helper.jsonFileToClass(jsonFile, GetUserResponse.class);
    for(GetUserResponse user: users){
      String userName = user.getUsername();
      Assert.assertTrue(String.format("User not created for for username %s",userName),
        helper.ifUserExist(userName));
      GetUserResponse actualUserDetails = UserEndpoint.getUser(userName).getBody();
      System.out.println("Response for username "+userName+" is "+UserEndpoint.getUser(userName).getBody());
      Assert.assertEquals("Created User details does not match", user, actualUserDetails);
    }
  }
  @Given("Users in {string} are present")
  public void users_in_are_present(String jsonFile) throws IOException {
    List<GetUserResponse> users =(List<GetUserResponse>)helper.jsonFileToClass(jsonFile, GetUserResponse.class);
    for(GetUserResponse user: users){
      Assert.assertTrue(String.format("User with user id:%s and username:%s does not exist",user.getId(),user.getUsername()),
        helper.ifUserExist(user.getUsername()));
    }
  }
  @When("I update users from {string} via api")
  public void i_update_users_from_via_api(String jsonFile) throws IOException {
    List<User> users =(List<User>)helper.jsonFileToClass(jsonFile, User.class);
    for(User user: users){
      UpdateUserResponse updatedUserResponse = UserEndpoint.updateUser(user.getUsername(),user).getBody();
      Assert.assertEquals("Wrong http status returned for Update User details for user "+user.getUsername() +"\nResponse"+updatedUserResponse,
        Integer.valueOf(200), updatedUserResponse.getCode());
      Assert.assertEquals("User details cannot be updated", user.getId(), updatedUserResponse.getMessage());
    }
  }
  @Then("Verify user details in {string} are updated to Pet Store")
  public void verify_user_details_in_are_updated_to_pet_store(String jsonFile) throws IOException {
    List<GetUserResponse> users =(List<GetUserResponse>)helper.jsonFileToClass(jsonFile, GetUserResponse.class);
    for(GetUserResponse user: users){
      String userName = user.getUsername();
      GetUserResponse actualUserDetails = UserEndpoint.getUser(userName).getBody();
      System.out.println("Response for username "+userName+" is "+UserEndpoint.getUser(userName).getBody());
      Assert.assertEquals("Updated User details does not match", user, actualUserDetails);
    }
  }
}
