package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.steps.PetsSteps;
import io.swagger.petstore.utils.TestUtils;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.IsAnything.anything;

public class MyStepdefs_pets {

    static ValidatableResponse response;
    static long petId;

    static HashMap<String, Object> category;
    static String name;

    static ArrayList<String> photoUrls;

    static ArrayList<HashMap<String, Object>> tags;

    static String status;

    @Steps
    PetsSteps petsSteps;


    @When("^I Create NewPet By Providing The Information Category Name Photo Urls Tags Statuse$")
    public void iCreateNewPetByProvidingTheInformationCategoryNamePhotoUrlsTagsStatuse() {
        name = "Room" + TestUtils.getRandomValue();
        status = "available";
        HashMap<String, Object> category = new HashMap<>();
        category.put("id", "2");
        category.put("name", "Mixed");

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("String");

        ArrayList<HashMap<String, Object>> tags = new ArrayList<>();
        HashMap<String, Object> tagMap = new HashMap<>();
        tagMap.put("id", 301);
        tagMap.put("name", "Room");
        tags.add(tagMap);

        response = petsSteps.createPet(petId, category, name, photoUrls, tags, status);
    }

    @Then("^I verify that the pets is created with status 200 codee$")
    public void iVerifyThatThePetsIsCreatedWithStatusCodee() {
        response.statusCode(200);
        petId = response.log().all().extract().path("id");
    }

    @When("^I GetA New Pet With Pet Ide$")
    public void iGetANewPetWithPetIde() {
        HashMap<String, Object> petMap = petsSteps.findPetById(petId);
        Assert.assertThat(petMap, anything(name));
    }

    @Then("^I Verify That The Pet Is Createde$")
    public void iVerifyThatThePetIsCreatede() {
        response.statusCode(200);
    }

    @When("^I Update Pet With Statuse$")
    public void iUpdatePetWithStatuse(String cate, String name, String photo, String tag, String status) {
        name = "Rommo" + TestUtils.getRandomValue();
        status = "Not available";
        HashMap<String, Object> category = new HashMap<>();
        category.put("name", "Mixed");
        category.put("id", "2");

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://th.bing.com/th/id/OIP.L90UXlIDXPcyWOOnOIjlggHaFa?pid=ImgDet&rs=1");

        ArrayList<HashMap<String, Object>> tags = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> tagMap = new HashMap<>();
        tagMap.put("id", 301);
        tagMap.put("name", "ropkji");
        tags.add(tagMap);

        response = petsSteps.updatePet(petId, category, name, photoUrls, tags, status);
    }

    @Then("^I verify that pets is updatede$")
    public void iVerifyThatPetsIsUpdatede() {
        HashMap<String, Object> petMap = petsSteps.findPetById(petId);
        Assert.assertThat(petMap, anything(status));
    }

    @When("^I delete pets that createde$")
    public void iDeletePetsThatCreatede() {
        response = petsSteps.deletePetById(petId);
    }

    @Then("^I verify pets is deletede$")
    public void iVerifyPetsIsDeletede() {
        //        petId = response.log().all().extract().path("id");
        response.statusCode(404);
        petsSteps.getPetById(petId).statusCode(200);
    }
}
