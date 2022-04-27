package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class T1_SimpleGetRequestFromHR {
    /**
     * Task 1:
     *
     * 1. Send request to HR url and save the response
     * 2. GET /regions
     * 3. Store the response in Response Object that comes from get Request
     * 4. Print out followings
     *    - Headers
     *    - Content-Type
     *    - Status Code
     *    - Response
     *    - Date
     * 5. Verify response body has "Europe"
     * 6. Verify response has Date
     */


    @Test
   public void test(){
        //1. Send request to HR url and save the response
        //2. GET /regions
        //3. Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("http://3.86.82.161:1000/ords/hr/regions");

        // print response
        response.prettyPrint();
        //4. Print out followings
        //   - Headers
        System.out.println("==============================");
        System.out.println("response.headers() = " + response.headers());
        //   - Content-Type
        System.out.println("==============================");
        System.out.println(response.contentType());
        //   - Status Code
        System.out.println("==============================");
        System.out.println(response.statusCode());

        //   - Date
        System.out.println(response.header("Date"));
        //5. Verify response body has "Europe"
        Assertions.assertTrue(response.body().asString().contains("Europe"));
        //6. Verify response has Date
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

    }
}
