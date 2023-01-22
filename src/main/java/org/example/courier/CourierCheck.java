package org.example.courier;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;

public class CourierCheck {
    public void assertCreatedSuccessful(ValidatableResponse response){
        response.assertThat()
                .statusCode(201)
                .body("ok", is(true))
                ;
    }
    public int loggedInSuccessful(ValidatableResponse response) {
       return response.assertThat()
                .statusCode(200)
                .body("id", greaterThan(0))
                .extract()
                .path("id")
        ;
    }

    public void creationFailed(ValidatableResponse response){
        response.assertThat()
                .statusCode(400)
        ;
    }

    public void loginFailed(ValidatableResponse response) {
        response.assertThat()
                .statusCode(400);

    }

    public void deletedSuccessfully(ValidatableResponse response) {
        response.assertThat()
                .statusCode(200)
                .body("ok",is(true))
                ;
    }

    public void loginIsUsed(ValidatableResponse response) {
        response.assertThat()
                .statusCode(201)
                .body("ok",is(true))
                .log()
                .all()
        ;
    }
}

