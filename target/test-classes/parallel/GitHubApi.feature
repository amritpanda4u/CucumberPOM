@POJOTest
Feature: GitHubApi

Background: 
	Given I set the baseurl
	And I add authentication to the request
	
	
Scenario: Get Git hub user deatils using GET
	Given I create a GET Request for the end point Users
	And I add below path Parameters to the request 
			|Content-Type| application/json |
			|Accept      | application/json |
	When I execute the request
	Then I verify the respose code is 200 "OK" 
	And I validate the response content for Users
			|firstName | lastName | 
			|Sara  | Andersen|
	
		
Scenario: Create a new repo using POST
	Given I create a GET Request for the end point Users
	And I add below path Parameters to the request 
			|Content-Type| application/json |	
			|Accept      | application/json |
	And I add the below Parameters to the body
			|name 				| test2								 |
			|description  | Created from the API | 
			|homepage 		| https://github.com|
			|private  		|false							|
			|has_issues 	| true							|
			|has_projects | true 							| 
			|has_wiki 		| true 							|
	When I execute the post request "/user/repos"
	Then I verify the respose code is 201 "OK" 
	And I validate the response content for Users
			|firstName | lastName | 
			|Sara  | Andersen|
			
			@GitHubAPITest
Scenario: Delete a repo using Delete
	Given I create a GET Request for the end point Users
	And I add below path Parameters to the request 
			|Content-Type| application/json |	
			|Accept      | application/json |
	When I execute the delete request "/repos/amritpanda4u/test2"
	Then I verify the respose code is 204 "No Content" 