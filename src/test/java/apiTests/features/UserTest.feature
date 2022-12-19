Feature: Pet Store User Tests
  Description:  User  APIs allows mechanism to add, update, view and delete users on Pet Store.
  These test are designed to test happy flow to create multiple user and update them.

  Scenario Outline: Create multiple users to Pet Store via api
    Given Users in "<json>" are not present
    When I add users from "<json>" via api
    Then the users in "<json>" are added to Pet Store

    Examples:
      | json       |
      | createUser |

  Scenario Outline: Update multiple users to Pet Store via api
    Given Users in "<json>" are present
    When I update users from "<json>" via api
    Then Verify user details in "<json>" are updated to Pet Store

    Examples:
      | json       |
      | updateUser |