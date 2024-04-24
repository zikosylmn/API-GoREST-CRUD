package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.crudUsers.CrudResponses;
import starter.crudUsers.CrudUsers;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserStepDef {

    @Steps
    CrudUsers crudUsers;

    @Given("Update user {string} by {int}")
    public void updateUserBy(String json, int id) {
        File jsonUpdateUser = new File(Constants.REQ_BODY + json);
                crudUsers.updateUser(jsonUpdateUser, id);
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when()
                .put(CrudUsers.RUD_USER);
    }

    @Given("Update user with invalid ID {string} and json is {string}")
    public void updateUserWithInvalidIDAndJsonIs(String id, String json) {
        File jsonInvalidUpdateUser = new File(Constants.REQ_BODY + json);
        crudUsers.updateUserInvalid(jsonInvalidUpdateUser, id);
    }

    @When("Send request update user with invalid ID")
    public void sendRequestUpdateUserWithInvalidID() {
        SerenityRest.when()
                .put(CrudUsers.RUD_USER);
    }

    @Given("Update valid user ID {int} and JSON file {string}")
    public void updateValidUserIDAndJSONFile(int id, String json) {
        File jsonWithoutAuthorization = new File(Constants.REQ_BODY + json);
        crudUsers.updateUser(jsonWithoutAuthorization, id);
    }

    @When("Send request update valid user ID without valid authorization")
    public void sendRequestUpdateValidUserIDWithoutValidAuthorization() {
        SerenityRest.when()
                .put(CrudUsers.RUD_USER);
    }

    @When("Send request update valid user ID with blank name")
    public void sendRequestUpdateValidUserIDWithBlankName() {
        SerenityRest.when()
                .put(CrudUsers.RUD_USER);
    }

    @When("Send request update valid user ID with blank email")
    public void sendRequestUpdateValidUserIDWithBlankEmail() {
        SerenityRest.when()
                .put(CrudUsers.RUD_USER);
    }

    @When("Send request update valid user ID with blank gender")
    public void sendRequestUpdateValidUserIDWithBlankGender() {
        SerenityRest.when()
                .put(CrudUsers.RUD_USER);
    }

    @When("Send request update valid user ID with blank status")
    public void sendRequestUpdateValidUserIDWithBlankStatus() {
        SerenityRest.when()
                .put(CrudUsers.RUD_USER);
    }

    @And("Responses body message is {string}")
    public void responsesBodyMessageIs(String msg) {
        SerenityRest.and()
                .body(CrudResponses.MSG, equalTo(msg));
    }
}
