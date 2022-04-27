package com.cydeo.day1;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class T4_MethodChainingPathParams extends SpartanTestBase {
    @Test
    public void methodChaining() {
        String word = "Cydeo";

        System.out.println("word= " + word
                .toLowerCase()  //make it lower case
                .toUpperCase() //make it uppercase
                .substring(2)
                .replace('E', 'e')
        );
        //traditional way
        Employee employee1 = new Employee("Adam", 30);
        System.out.println("employee1 = " + employee1);
        //builder way
        Employee employee = Employee.builder().age(30).name("Adam").build();
        System.out.println("employee = " + employee);

    }


    /**
     * Task 4:
     * <p>
     * 1. Given accept type is Json
     * 2. Path Parameters values are
     * - id —> 5
     * 3. When user sends GET request to /spartans/{id}
     * 4. Verify followings
     * - Status code should be 200
     * - Content Type is application/json
     * - ID is 5
     * - Name is "Blythe"
     * - gender is "Female"
     * - phone is 3677539542
     */

    @Test
    public void test() {
        //1. Given accept type is Json
        Response response =
                given()
                .accept(ContentType.JSON)
                //2. Path Parameters values are
                .and()
                .pathParam("id", 5)
                //     - id —> 5
                //3. When user sends GET request to /spartans/{id}
                .when()
                .get("/spartans/{id}").prettyPeek();
        //4. Verify followings
        //     - Status code should be 200
        Assertions.assertEquals(200, response.getStatusCode());
        //     - Content Type is application/json
        Assertions.assertEquals(ContentType.JSON.toString(), response.getContentType());
        //     - ID is 5
        int actulaId = response.path("id");
        Assertions.assertEquals(5, actulaId, "verify id");


        //     - Name is "Blythe"
        String actualName = response.path("name");
        Assertions.assertEquals("Blythe",actualName);
        //     - gender is "Female"
        String gender = response.path("gender");
        Assertions.assertEquals("Female",gender);
        //     - phone is 3677539542
        Long phone = response.path("phone");
        Assertions.assertEquals(3677539542L,phone);

    }
}
