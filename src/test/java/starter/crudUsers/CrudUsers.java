package starter.crudUsers;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class CrudUsers {

    public static String CREATE_USER = Constants.BASE_URL + "/users";
    public static String RUD_USER = Constants.BASE_URL + "/users/{id}";

    @Step ("Create User")
    public void createUser (File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Get User")
    public void getUser (int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", id);
    }

    @Step ("Get all users")
    public void getAllUsers (){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }

    @Step ("Update user by id")
    public void updateUser (File json, int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Update user by invalid id")
    public void updateUserInvalid (File json, String id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Delete user by id")
    public void deleteUser (int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .pathParam("id", id);
    }
}
