package parallel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.testng.Assert;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.User;

public class GitHubApiSteps {

		private static String BASE_URL;
		RequestSpecification request;
		private Response response;
		String path;
		
		
		
		@Given("I set the baseurl")
		public void i_set_the_baseurl() {
			Properties prop = new Properties();
			 try {
			FileInputStream fip = new FileInputStream("./src/test/resources/config/config.properties");
		   
				prop.load(fip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    BASE_URL = (String) prop.get("url");
		    System.out.println("Base url : "+BASE_URL);
			RestAssured.baseURI = BASE_URL;
		    request = RestAssured.given();
		}

		@Given("I add authentication to the request")
		public void i_add_authentication_to_the_request() {
		    request.header("Authorization","Token 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");
		}

		@Given("I create a GET Request for the end point Users")
		public void i_create_a_get_request_for_the_end_point_users() {
			 
		}

		@Given("I add below Parameters to the request")
		public void i_add_below_parameters_to_the_request() {
			
		}

		@Given("I add below path Parameters to the request")
		public void i_add_headers_to_the_request(DataTable headers) {
			
				//Headers header = new Headers();
			  List<List<String>> headersList = headers.asLists(); 
			  for(List<String> s: headersList) 
			  { 
				  request.header(s.get(0),s.get(1));
				  System.out.println("Header Key : "+ s.get(0) + " Header value : " + s.get(1));
			  }		  
			  
			
		}

		@When("I execute the request")
		public void i_execute_the_request() {
		    response = request.get("/users/amritpanda4u");
		}

		@Then("I verify the respose code is {int} {string}")
		public void i_verify_the_respose_code_is_ok(Integer code, String message) {
			System.out.println("Expected status code : "+code);
			System.out.println("Actual status code : "+ response.getStatusCode());
		    Assert.assertEquals(code.intValue(), response.getStatusCode());
		}

		@Then("I validate the response content for Users")
		public void i_validate_the_response_content_for_users(DataTable userDetails) {
			//Assert.assertEquals(getJsonPath(response, "login"), "amritpanda4u");
			//System.out.println("Response -----> Key(name) : "+getJsonPath(response, "name"));
			User user = response.getBody().as(User.class);
			System.out.println("Response -----> Key(user) : "+user.getLogin());
		}
		
		/*
		 * public String getJsonPath(Response response, String key) { String resp =
		 * response.asString(); JsonPath js = new JsonPath(resp); return
		 * js.get(key).toString(); }
		 */
		
		
		@Given("I add the below Parameters to the body")
		public void i_add_the_below_parameters_to_the_body(DataTable body) {
			
			/*
			 * List<List<String>> bodyList = body.asLists(); JsonObject requestParams = new
			 * JsonObject(); for(List<String> s : bodyList) { String key = s.get(0); String
			 * value = s.get(1); System.out.println("Body Key : "+ key + " Body value : " +
			 * value); requestParams.add(key , value); }
			 */
			 
			String requestParams = "{\r\n  \"name\": \"test2\",\r\n  \"description\": \"Created from the API\",\r\n  \"homepage\": \"https://github.com\",\r\n  \"private\": false,\r\n  \"has_issues\": true,\r\n  \"has_projects\": true,\r\n  \"has_wiki\": true\r\n}";
			//System.out.println(requestParams.asString());
			request.body(requestParams);
		}
		
		@When("I execute the post request {string}")
		public void i_execute_the_post_request(String param) {
			System.out.println("Path parameter : "+param);
			response = request.post(param);
		}
		
		
		@When("I execute the delete request {string}")
		public void i_execute_the_delete_request(String param) {
			System.out.println("Path parameter : "+param);
			response = request.delete(param);
		}
	}



