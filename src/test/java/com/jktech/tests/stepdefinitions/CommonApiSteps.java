package com.jktech.tests.stepdefinitions;

import com.jktech.utils.ApiUtils;
import com.jktech.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;


public class CommonApiSteps {
	private final TestContext context;

	
    public CommonApiSteps(TestContext context) {
        this.context = context;
    }
    
	String apiEndpoint="";
	public Response response;
	
	@Given("I have the API endpoint {string}")
	public void i_have_the_api_endpoint(String endpoint) {
	    apiEndpoint = ApiUtils.getBaseUri()+endpoint;
	    System.out.println("apiEndpoint:"+apiEndpoint);
	    
	}
	
	
	
	@When("I send a {string} request")
	public void i_send_request(String method) {
	    String jsonPayload = context.getJsonPayload();
	    String token = context.getToken();

	    // Build common request spec
	    var requestSpec = RestAssured.given()
	            .header("Content-Type", "application/json");

	    if (token != null && !token.isEmpty()) {
	        requestSpec.header("Authorization", "Bearer " + token);
	    }

	    // Send request based on method
	    if (method.equalsIgnoreCase("POST")) {
	        response = requestSpec
	                .body(jsonPayload)
	                .when()
	                .post(apiEndpoint);

	    } else if (method.equalsIgnoreCase("GET")) {
	        response = requestSpec
	                .when()
	                .get(apiEndpoint);

	    } else if (method.equalsIgnoreCase("PUT")) {
	        response = requestSpec
	                .body(jsonPayload)
	                .when()
	                .put(apiEndpoint);

	    } else if (method.equalsIgnoreCase("DELETE")) {
	        response = requestSpec
	                .when()
	                .delete(apiEndpoint);

	    } else {
	        throw new IllegalArgumentException("Unsupported HTTP method: " + method);
	    }

	    context.setResponse(response);
	    System.out.println("Response: " + response.asPrettyString());
	}
	
	@When("I send a {string} request for access token")
	public void i_send_request_access_token(String method) {
		String jsonPayload=context.getJsonPayload();
	    if (method.equalsIgnoreCase("POST")) {
	        response = RestAssured.given()
	                    .header("Content-Type", "application/json")
	                    .body(jsonPayload)
	                    .when()
	                    .post(apiEndpoint);

	    } else {
	        throw new IllegalArgumentException("Unsupported HTTP method: " + method);
	    }
        context.setResponse(response);
	    System.out.println("Response:"+response.asPrettyString());
	}
	
	@Then("I should receive status code {int}")
	public void i_should_receive_status_code(int expectedStatus) {
	    response.then().statusCode(expectedStatus);
	}
	
	@Then("the response message should be {string}")
	public void the_response_message_should_be(String expectedMessage) {
	    String actualMessage = response.jsonPath().getString("message");
	    assertEquals(actualMessage, expectedMessage, "Response message mismatch");
	}
	
	@Given("I hvae add the path parameter in endpoint {int}")
	public void i_hvae_add_the_path_parameter_in_endpoint(Integer id) {
		apiEndpoint = apiEndpoint+id;
	}

}
