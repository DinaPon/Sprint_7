package org.example.order;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
public class OrderClient {
    protected final String BASE_URI = "https://qa-scooter.praktikum-services.ru";
    protected final String ROOT = "/api/v1/orders/";

    public ValidatableResponse create(Order order){
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(order)
                .when()
                .post(ROOT)
                .then();
    }

    public ValidatableResponse returnOrderList(){
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .when()
                .get(ROOT)
                .then();
    }

}
