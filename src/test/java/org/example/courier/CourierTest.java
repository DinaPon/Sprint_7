package org.example.courier;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
public class CourierTest {

    private final CourierGenerator generator = new CourierGenerator();
    private final CourierClient client = new CourierClient();
    private final CourierCheck check = new CourierCheck();
    private int courierId;

    @After public void deleteCourier() {
        if (courierId > 0) {
            ValidatableResponse response = client.delete(courierId);
            check.deletedSuccessfully(response);
        }
    }

    @Test
    public void courier() {
        var courier = generator.random();
        ValidatableResponse creationResponse = client.create(courier);
        check.assertCreatedSuccessful(creationResponse);

        Credentials creds = Credentials.from(courier);
        ValidatableResponse loginResponse = client.login(creds);
        int id = check.loggedInSuccessful(loginResponse);

        assert id >100;
    }

    @Test
    public void loginFails(){
        var courier = generator.generic();
        courier.setPassword(null);

        ValidatableResponse loginResponse = client.create(courier);
        check.creationFailed(loginResponse);
    }
    @Test
    public void createTwoSameCouriers(){
        var courier = generator.random();
        ValidatableResponse creationResponse = client.create(courier);
        check.assertCreatedSuccessful(creationResponse);

        creationResponse = client.create(courier);
        check.loginIsUsed(creationResponse);
    }
}
