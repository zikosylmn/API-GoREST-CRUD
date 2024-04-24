package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.crudUsers.CrudUsers;

public class DeleteUserStepDef {

    @Steps
    CrudUsers crudUsers;

    @Given("Delete user valid data by {int}")
    public void deleteUserValidDataBy(int id) {
        crudUsers.deleteUser(id);
    }

    @When("Send request delete user by id valid data")
    public void sendRequestDeleteUserByIdValidData() {
        SerenityRest.when()
                .delete(CrudUsers.RUD_USER);
    }

    @Given("Delete user valid data by invalid ID {int}")
    public void deleteUserValidDataByInvalidID(int id) {
        crudUsers.deleteUser(id);
    }

    @When("Send request delete user by invalid data ID")
    public void sendRequestDeleteUserByInvalidDataID() {
        SerenityRest.when()
                .delete(CrudUsers.RUD_USER);
    }
}
