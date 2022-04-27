package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class T2_SimpleGetRequestWithPath {

    /**
     * Task 2:
     * <p>
     * 1. Send request to HR url and save the response
     * 2. GET /employees/150
     * 3. Store the response in Response Object that comes from get Request
     * 4. Print out followings
     * - First Name
     * - Last Name
     * - Verify status code is 200
     * - Verify First Name is "Peter"
     * - Verify content-Type is application/json
     */
    @Test
    public void test() {
        //1. Send request to HR url and save the response
        //2. GET /employees/150
        //3. Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("http://3.86.82.161:1000/ords/hr/employees/150");
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
