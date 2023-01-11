package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.steps.UsersSteps;
import io.swagger.petstore.utils.TestUtils;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs_users {
    static ValidatableResponse response;
    static int id = 12;
    static String username = "prime123" + TestUtils.getRandomValue();
    static String firstname = "Pradip";
    static String lastname = "Kakadiya";
    static String email = "Pradip123@gmail.com";
    static String password = "pradi123";
    static String phone = "7565241521";
    static String userStatus = "5";

    static int userID;

    @Steps
    UsersSteps usersSteps;

    @When("^I create new user by providing the information id \"([^\"]*)\" username \"([^\"]*)\" firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" phone \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateNewUserByProvidingTheInformationIdUsernameFirstnameLastnameEmailPasswordPhoneStatus(int id, String username, String firstname, String lastname, String email, String password, String phone, String userStatus) {
        id = 5;
        username = "pradip123" + TestUtils.getRandomValue();
        firstname = "pradi";
        lastname = "kakiya";
        email = "mojno123@gmail.com";
        password = "pass123";
        phone = "7452638690";
        userStatus = "8";

        response = usersSteps.createNewUser(id, username, firstname, lastname, email, password, phone, userStatus);
    }

    @Then("^I verify that the user is created with status 200$")
    public void iVerifyThatTheUserIsCreatedWithStatus() {
        response.statusCode(200);
    }

    @When("^I get a new added user with username \"([^\"]*)\"$")
    public void iGetANewAddedUserWithUsername(String username)  {
        username=response.log().all().extract().path("username");
        response.statusCode(200);
    }

    @When("^I update user with username \"([^\"]*)\"$")
    public void iUpdateUserWithUsername(String username) {
        username = username + "_updated";
        response = usersSteps.updateUser(id,username,firstname,lastname,email,password,phone,userStatus);
    }

    @Then("^I verify that user is updated$")
    public void iVerifyThatUserIsUpdated() {
        response.statusCode(200);
    }

    @When("^I delete user that created$")
    public void iDeleteUserThatCreated() {
        response = usersSteps.deleteUser(username);
    }

    @Then("^I verify user is deleted and status code is 200$")
    public void iVerifyUserIsDeletedAndStatusCodeIs() {
        response.statusCode(200);
        usersSteps.getUserByUserName(username);
    }

    @Given("^User application is running$")
    public void userApplicationIsRunning() {
    }

    @Then("^I verify that the user is created with \"([^\"]*)\"$")
    public void iVerifyThatTheUserIsCreatedWith(String username)  {
        username=response.log().all().extract().path("username");
        response.statusCode(200);
    }

    @Then("^I verify user is deleted$")
    public void iVerifyUserIsDeleted() {
        response = usersSteps.deleteUser(username);
        response.statusCode(404);
    }

}
