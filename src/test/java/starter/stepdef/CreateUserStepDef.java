package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.crudUsers.CrudResponses;
import starter.crudUsers.CrudUsers;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDef {

    @Steps
    CrudUsers crudUsers;

    @Given("Create user with json {string}")
    public void createUserWithJson(String json) {
    File jsonCreateUser = new File(Constants.REQ_BODY + json);
    crudUsers.createUser(jsonCreateUser);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when()
                .post(CrudUsers.CREATE_USER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA + json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Create user with blank name {string}")
    public void createUserWithBlankName(String json) {
        File jsonInvalidCreateUser = new File(Constants.REQ_BODY + json);
        crudUsers.createUser(jsonInvalidCreateUser);
    }

    @And("Responses body field is {string} and message was {string}")
    public void responsesBodyFieldIsAndMessageWas(String field, String message) {
        SerenityRest.and()
                .body(CrudResponses.DATA_FIELD, equalTo(field))
                .body(CrudResponses.MESSAGE, equalTo(message));
    }

    @Given("Create user with blank email {string}")
    public void createUserWithBlankEmail(String json) {
        File jsonInvalidCreateUser = new File(Constants.REQ_BODY + json);
        crudUsers.createUser(jsonInvalidCreateUser);
    }

    @Given("Create user with blank gender {string}")
    public void createUserWithBlankGender(String json) {
        File jsonInvalidCreateUser = new File(Constants.REQ_BODY + json);
        crudUsers.createUser(jsonInvalidCreateUser);
    }

    @Given("Create user with blank status {string}")
    public void createUserWithBlankStatus(String json) {
        File jsonInvalidCreateUser = new File(Constants.REQ_BODY + json);
        crudUsers.createUser(jsonInvalidCreateUser);
    }

    @Given("Create user with same name {string}")
    public void createUserWithSameName(String json) {
        File jsonDuplicateNameUser = new File(Constants.REQ_BODY + json);
        crudUsers.createUser(jsonDuplicateNameUser);
    }

    @Given("Create user with same email {string}")
    public void createUserWithSameEmail(String json) {
        File jsonDuplicateEmailUser = new File(Constants.REQ_BODY + json);
        crudUsers.createUser(jsonDuplicateEmailUser);
    }
}
