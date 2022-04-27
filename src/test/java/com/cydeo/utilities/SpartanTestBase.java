package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public abstract class SpartanTestBase {
    @BeforeAll
    public static void init() {
        baseURI = "http://3.86.82.161:8000";
        basePath = "/api";

    }

    @AfterAll
    public static void resetApi() {
        reset();
    }
}
