package io.swagger.petstore.crudtests;

import io.swagger.petstore.steps.UsersSteps;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@UseTestDataFrom("src/test/java/resources/testdata/user.csv")
@RunWith(SerenityParameterizedRunner.class)
public class UsersDataDrivenTest extends TestBase {

    static int id;
    static String username;
    static String firstname;
    static String lastname;
    static String email;
    static String password;
    static String phone;
    static String userStatus;
    static int userID;

    @Steps
    UsersSteps usersSteps;

    @Title("Data driven test for adding multiple users to the application")
    @Test
    public void createMultipleUsers(){
        usersSteps.createNewUser(id,username,firstname,lastname,email,password,phone,userStatus).statusCode(200);
    }
}
