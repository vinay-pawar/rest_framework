Feature: Pet Store Pet Tests
  Description:  Pet  APIs allows mechanism to add, update, view and delete pet on Pet Store.
  These test are designed to test happy flow to create multiple pet and update them.

  Scenario Outline: Create multiple pets on Pet Store via api
    Given Pet in "<json>" are not present
    When I add pets from "<json>" via api
    Then the pet in "<json>" are added to Pet Store

    Examples:
      | json      |
      | CreatePet |

  Scenario Outline: Update multiple pets to Pet Store via api
    Given Pets in "<json>" are present
    When I update pets from "<json>" via api
    Then Verify pet details in "<json>" are updated to Pet Store

    Examples:
      | json      |
      | UpdatePet |
