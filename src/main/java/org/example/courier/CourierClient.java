package org.example.courier;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CourierClient {

    protected final String BASE_URI = "https://qa-scooter.praktikum-services.ru";
    protected final String ROOT = "/api/v1/courier";

    public ValidatableResponse create(CourierCreate courier) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all();

    }
    public ValidatableResponse login(Credentials creds) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(creds)
                .when()
                .post(ROOT + "/login")
                .then().log().all();
    }

    public ValidatableResponse delete(int courierId){
        String json = String.format("{\"id\": \"%\"}", courierId);

        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(json)
                .when()
                .delete(ROOT + "/" +courierId)
                .then().log().all();
    }
}

