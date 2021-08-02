package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetUserDummyapiSteps {

	/*
	 * private static final String BASE_URL = "https://dummyapi.io/data/api/user";
	 * RequestSpecification request; private Response response; String path;
	 * 
	 * 
	 * @Given("I set the baseurl") public void i_set_the_baseurl() {
	 * RestAssured.baseURI = BASE_URL; request = RestAssured.given(); }
	 * 
	 * @Given("I add authentication to the request") public void
	 * i_add_authentication_to_the_request() {
	 * 
	 * }
	 * 
	 * @Given("I create a GET Request for the end point Users") public void
	 * i_create_a_get_request_for_the_end_point_users() {
	 * request.header("Content-Type", "application/json"); }
	 * 
	 * @Given("I add below Parameters to the request") public void
	 * i_add_below_parameters_to_the_request() { //request.queryParam("limit",
	 * "10"); }
	 * 
	 * @Given("I add Headers {string} and {string} to the request") public void
	 * i_add_headers_to_the_request(String key, String value) { request.header(key,
	 * value); System.out.println("Request : " + request.toString()); }
	 * 
	 * @When("I execute the request") public void i_execute_the_request() { response
	 * = request.get(); }
	 * 
	 * @Then("I verify the respose code is {int} OK") public void
	 * i_verify_the_respose_code_is_ok(Integer code) {
	 * Assert.assertEquals(code.intValue(), response.getStatusCode()); }
	 * 
	 * @Then("I validate the response content for Users") public void
	 * i_validate_the_response_content_for_users(DataTable userDetails) {
	 * List<Map<String, String>> username = userDetails.asMaps(); String firstName =
	 * username.get(0).get("firstName"); String lastName =
	 * username.get(0).get("lastName");
	 * System.out.println("firstName --------> "+firstName +
	 * " lastName --------> "+lastName); //Assert.assertEquals(false, false);
	 * //System.out.println(getJsonPath(response,"id")); }
	 * 
	 * public String getJsonPath(Response response, String key) { String resp =
	 * response.asString(); JsonPath js = new JsonPath(resp); return
	 * js.get(key).toString(); }
	 */
}
