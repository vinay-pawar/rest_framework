package apiTests.stepDefinitions;

import apiEngine.endpoint.PetEndpoint;
import apiEngine.model.requests.Pet;
import apiEngine.model.response.PetResponse;
import apiEngine.model.response.RestResponse;
import apiTests.libs.PetLib;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

public class PetStepDefs {
  @Given("Pet in {string} are not present")
  public void pet_in_are_not_present(String jsonFile) throws IOException {
    List<Integer> petIds = PetLib.getPetIdsFromDataJson(jsonFile);
    for(Integer petId: petIds){
      if(PetLib.ifPetExist(petId)){
        PetEndpoint.deletePet(petId);
      }
    }
  }
  @When("I add pets from {string} via api")
  public void i_add_pets_from_via_api(String jsonFile) throws IOException {
    List<Pet> pets =(List<Pet>)PetLib.jsonFileToClass(jsonFile, Pet.class);
    for(Pet pet:pets){
      RestResponse<PetResponse> petResponse = PetEndpoint.createPet(pet);
      Assert.assertTrue(String.format("Unable to create pet %s \nAPI Response: %s",pet.getName(),petResponse.getBody()),
        petResponse.isSuccessful());
    }
  }
  @Then("the pet in {string} are added to Pet Store")
  public void the_pet_in_are_added_to_pet_store(String jsonFile) throws IOException {
    List<PetResponse> pets =(List<PetResponse>)PetLib.jsonFileToClass(jsonFile, PetResponse.class);
    for(PetResponse pet:pets){
      PetResponse petResponse = PetEndpoint.getPetByID(pet.getId()).getBody();
      Assert.assertEquals(String.format("Pet information not matched %s \nAPI Response: %s",pet.getName(),petResponse),
        pet,petResponse);
    }
  }
  @Given("Pets in {string} are present")
  public void pets_in_are_present(String jsonFile) throws IOException {
    List<Integer> petIds = PetLib.getPetIdsFromDataJson(jsonFile);
    for(Integer petId: petIds){
      Assert.assertTrue(String.format("Pet %s information not available",petId),
        PetLib.ifPetExist(petId));
    }
  }
  @When("I update pets from {string} via api")
  public void i_update_pets_from_via_api(String jsonFile) throws IOException {
    List<Pet> pets =(List<Pet>)PetLib.jsonFileToClass(jsonFile, Pet.class);
    for(Pet pet:pets){
      RestResponse<PetResponse> petResponse = PetEndpoint.updatePet(pet);
      Assert.assertTrue(String.format("Unable to update pet %s \nAPI Response: %s",pet.getName(),petResponse.getBody()),
        petResponse.isSuccessful());
    }
  }
  @Then("Verify pet details in {string} are updated to Pet Store")
  public void verify_pet_details_in_are_updated_to_pet_store(String jsonFile) throws IOException {
    List<PetResponse> pets =(List<PetResponse>)PetLib.jsonFileToClass(jsonFile, PetResponse.class);
    for(PetResponse pet:pets){
      PetResponse petResponse = PetEndpoint.getPetByID(pet.getId()).getBody();
      Assert.assertEquals(String.format("Pet information not matched %s \nAPI Response: %s",pet.getName(),petResponse),
        pet,petResponse);
    }
  }
}
