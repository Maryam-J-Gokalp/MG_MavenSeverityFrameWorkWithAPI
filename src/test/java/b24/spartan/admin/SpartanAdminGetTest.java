package b24.spartan.admin;
import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static net.serenitybdd.rest.SerenityRest.given;
//InThis class only the given resources has changed instead of get all the spartan from library directly
//we are getting from the selenium Severity rest class provide() 4 us while is executing is taking some note RestQuery
//If the link is not clicked go to Target -->site..>Index.html..>right click..>open in Browser..>Chrome

//Always make sure you select clean

@Disabled
@SerenityTest
public class SpartanAdminGetTest {



    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://44.195.19.167:7000";

    }

    @Test
    public void getAllSpartan(){

        given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin","admin")
                .when()
                .get("/api/spartans")
                .then()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);
    }

    @Test
    public void getOneSpartan(){

        given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin","admin")
                .pathParam("id",15)
                .when()
                .get("/api/spartans/{id}");

        //if you send a request using SerenityRest, the response object
        //can be obtained from the method called lastResponse() without being saved separately
        //same with Response response object
        System.out.println("Status code = " + lastResponse().statusCode());

        //print id
        //instead of response.path, we use lastResponse.path()
        System.out.println("lastResponse().path(\"id\") = " + lastResponse().path("id"));

        //use jsonpath with lastResponse and get the name
        String name = lastResponse().jsonPath().getString("name");
        System.out.println("name = " + name);
    }


    @DisplayName("GET request with Serenity Assertion way")
    @Test
    public void getOneSpartanAssertion(){

        given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin","admin")
                .pathParam("id",15)
                .when()
                .get("/api/spartans/{id}");

        //Serenity way of assertion

        Ensure.that("Status code is 200",validatableResponse -> validatableResponse.statusCode(201) );

        Ensure.that("Content-type is JSON",vRes -> vRes.contentType(ContentType.JSON));

        Ensure.that("Id is 15", vRes -> vRes.body("id",is(15)));





    }


}