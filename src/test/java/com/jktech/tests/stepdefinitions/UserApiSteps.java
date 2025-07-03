package com.jktech.tests.stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jktech.models.SignupRequest;
import com.jktech.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserApiSteps {
	
	public String token = "";
	public JsonPath jsonresponse;
	public String jsonPayload ="";
	
	private final TestContext context;

    public UserApiSteps(TestContext context) {
        this.context = context;
    }
	
	@Given("I have a signup request body with id {string}, email {string}, and password {string}")
	public void i_have_a_signup_request_body_with_id_email_and_password(String id, String email, String password) throws JsonProcessingException {
	    SignupRequest signupRequest = new SignupRequest(id, email, password);
	    ObjectMapper mapper = new ObjectMapper();
	    jsonPayload = mapper.writeValueAsString(signupRequest);
	    context.setJsonPayload(jsonPayload);
	}
	
	@Then("I should get the accessToken from response")
	public void i_should_get_the_access_token_from_response() {
		Response response = context.getResponse();
		jsonresponse = response.jsonPath();
		token = jsonresponse.get("access_token");
		context.setToken(token);
	}

}
