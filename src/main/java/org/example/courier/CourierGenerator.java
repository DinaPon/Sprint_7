package org.example.courier;
import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    public CourierCreate generic(){
        return new CourierCreate("naaainja", "1234","saske");
    }
    public CourierCreate random(){
        return new CourierCreate(RandomStringUtils.randomAlphanumeric(10), "1234","saske");
    }
}
