package org.example.order;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderTestParam {
    private OrderClient orderClient;
    private Order order;
    private int statusCode;

    public OrderTestParam(Order order, int statusCode) {
        this.order = order;
        this.statusCode = statusCode;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {OrderGenerator.getWithBlack(), SC_CREATED},
                {OrderGenerator.getWithGrey(), SC_CREATED},
                {OrderGenerator.getWithoutTwoColours(), SC_CREATED},
                {OrderGenerator.getWithTwoColours(), SC_CREATED}
        };
    }

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @Test
    public void orderCanBeCreated(){
        ValidatableResponse responseCreate = orderClient.create(order);
        int actualStatusCode = responseCreate.extract().statusCode();
        int track = responseCreate.extract().path("track");
        assertThat("Expected track number",track, notNullValue());
        assertEquals("Status Code incorrect",statusCode,actualStatusCode);
    }
}
