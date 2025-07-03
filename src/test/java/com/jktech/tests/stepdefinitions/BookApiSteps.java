package com.jktech.tests.stepdefinitions;

import static org.testng.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jktech.models.CreateBookRequest;
import com.jktech.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class BookApiSteps {
	
	public String jsonPayload ="";
	public JsonPath jsonresponse;
	
	private final TestContext context;

    public BookApiSteps(TestContext context) {
        this.context = context;
    }
	
	@Given("I have a create a book with id {int}, name {string}, author {string}, published_year {int} and book_summary {string}")
	public void i_have_a_create_a_book_with_id_name_author_published_year_and_book_summary(Integer id, String name, String author, int published_year, String book_summary) throws JsonProcessingException {
		CreateBookRequest createBookRequest = new CreateBookRequest(id, name, author,published_year,book_summary);
		    ObjectMapper mapper = new ObjectMapper();
		    jsonPayload = mapper.writeValueAsString(createBookRequest);
		    context.setJsonPayload(jsonPayload);	}
	
	@Given("I have a update a book with id {int}, name {string}, author {string}, published_year {int} and book_summary {string}")
	public void i_have_a_update_a_book_with_id_name_author_published_year_and_book_summary(Integer id, String name, String author, int published_year, String book_summary) throws JsonProcessingException {
		CreateBookRequest createBookRequest = new CreateBookRequest(id, name, author,published_year,book_summary);
		    ObjectMapper mapper = new ObjectMapper();
		    jsonPayload = mapper.writeValueAsString(createBookRequest);
		    context.setJsonPayload(jsonPayload);	}
	
	@Given("I have a delete a book with id {int}, name {string}, author {string}, published_year {int} and book_summary {string}")
	public void i_have_a_delete_a_book_with_id_name_author_published_year_and_book_summary(Integer id, String name, String author, int published_year, String book_summary) throws JsonProcessingException {
		CreateBookRequest createBookRequest = new CreateBookRequest(id, name, author,published_year,book_summary);
		    ObjectMapper mapper = new ObjectMapper();
		    jsonPayload = mapper.writeValueAsString(createBookRequest);
		    context.setJsonPayload(jsonPayload);	}
	
	@Then("I should validate the create reponse with feild values {int},{string},{string},{int},{string}")
	public void i_should_validate_the_create_reponse_with_feild_values(Integer id, String name, String author, Integer published_year, String book_summary) {
		Response response = context.getResponse();
		jsonresponse = response.jsonPath();
		assertEquals(id,jsonresponse.get("id"));
		assertEquals(name,jsonresponse.get("name"));
		assertEquals(author,jsonresponse.get("author"));
		assertEquals(published_year,jsonresponse.get("published_year"));
		assertEquals(book_summary,jsonresponse.get("book_summary"));
	}
	
	@Then("I should check the get book response with feild value {int}")
	public void i_should_check_the_get_book_response_with_feild_value(Integer id) {
		Response response = context.getResponse();
		jsonresponse = response.jsonPath();
		assertEquals(id,jsonresponse.get("id"));
	}
	
	@Then("I should validate the error message {string}")
	public void i_should_validate_the_error_message(String errormessage) {
		Response response = context.getResponse();
		jsonresponse = response.jsonPath();
		assertEquals(errormessage,jsonresponse.get("detail"));
	}
	
	@Then("I should validate the update reponse with feild values {int},{string},{string},{int},{string}")
	public void i_should_validate_the_update_reponse_with_feild_values(Integer id, String name, String author, Integer published_year, String book_summary) {
		Response response = context.getResponse();
		jsonresponse = response.jsonPath();
		assertEquals(id,jsonresponse.get("id"));
		assertEquals(name,jsonresponse.get("name"));
		assertEquals(author,jsonresponse.get("author"));
		assertEquals(published_year,jsonresponse.get("published_year"));
		assertEquals(book_summary,jsonresponse.get("book_summary"));
	}
	
	@Then("I should validate the successfully deleted response message {string}")
	public void i_should_validate_the_successfully_deleted_response_message(String successMessage) {
		Response response = context.getResponse();
		jsonresponse = response.jsonPath();
		assertEquals(successMessage,jsonresponse.get("message"));
	}




}
