package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.crudUsers.CrudResponses;
import starter.crudUsers.CrudUsers;

import static org.hamcrest.Matchers.equalTo;

public class GetUserStepDef {

    @Steps
    CrudUsers crudUsers;

    @Given("Get user data by {int}")
    public void getUserDataBy(int id) {
        crudUsers.getUser(id);
    }

    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when()
                .get(CrudUsers.RUD_USER);
    }

    @Given("Get all user data")
    public void getAllUserData() {
        crudUsers.getAllUsers();
    }

    @When("Send request get all user")
    public void sendRequestGetAllUser() {
        SerenityRest.when()
                .get(CrudUsers.CREATE_USER);
    }

    @Given("Get user data invalid {int}")
    public void getUserDataInvalid(int id) {
        crudUsers.getUser(id);
    }

    @And("Responses body message was {string}")
    public void responsesBodyMessageWas(String message) {
        SerenityRest.and()
                .body(CrudResponses.MESSAGE, equalTo(message));
    }
}
