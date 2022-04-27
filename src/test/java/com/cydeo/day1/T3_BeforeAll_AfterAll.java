package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class T3_BeforeAll_AfterAll {
  @BeforeAll
  public void beforeAll(){
      RestAssured.baseURI="http://3.86.82.161:1000";
      RestAssured.basePath="/ords/hr";
  }


    @Test
    public void test(){
        //1. Send request to HR url and save the response
        //2. GET /regions
        //3. Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("/regions");

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

    @Test
    public void test1() {
        //1. Send request to HR url and save the response
        //2. GET /employees/150
        //3. Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("/employees/150");
        //print response
        response.prettyPrint();
        //4. Print out followings
        //      - First Name
        String first_name = response.path("first_name");
        System.out.println(first_name);
        //      - Last Name
        System.out.println(response.path("last_name").toString());
        // href
        System.out.println(response.path("links[0].href").toString());
        int[] a=new int[5];
        System.out.println(a[0]);
        //      - Verify status code is 200
        //      - Verify First Name is "Peter"
        //      - Verify content-Type is application/json
    }
}
