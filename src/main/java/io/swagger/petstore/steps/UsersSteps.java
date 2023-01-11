package io.swagger.petstore.steps;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.constants.Endpoints;
import io.swagger.petstore.model.UsersPojo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UsersSteps {

    @Step("Create user with userName : {1}, firstName:{2}, lastName: {3},email:{4}")
    public ValidatableResponse createNewUser(int id, String userName, String firstName, String lastName, String email, String password, String phone, String userStatus){
        UsersPojo userPojo= UsersPojo.createUserPojo(id,userName,firstName,lastName,email,password,phone,userStatus);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post(Endpoints.CREATE_USER)
                .then();
    }

    @Step("Getting the user information with firstName: {0}")
    public HashMap<String, Object> getUserByUserName(String username) {
//        String p1 = "findAll{it.username == '";
//        String p2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .pathParam("username", username)
                .when()
                .get(Endpoints.GET_USER_BY_USERNAME)
                .then()
                .statusCode(200)
                .extract().path("");
    }

    @Step("Updating User information with userName: {1}, firstName: {2}, lastName: {3}, email: {4}, programme: {5} and courses: {6}")

    public ValidatableResponse updateUser(int id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        UsersPojo userPojo= UsersPojo.createUserPojo(id,username,firstName,lastName,email,password,phone,userStatus);
        return  SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .body(userPojo)
                .put(Endpoints.UPDATE_USER_BY_USERNAME)
                .then();

    }

    @Step
    public ValidatableResponse deleteUser(String username) {

        return SerenityRest.given().log().all()
                .pathParam("username", username)
                .when()
                .delete(Endpoints.DELETE_USER_BY_USERNAME)
                .then();
    }
}
