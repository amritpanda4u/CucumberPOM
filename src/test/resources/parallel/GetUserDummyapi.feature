Feature: DummyApiIo

Background: 
	Given I set the baseurl
	And I add authentication to the request
	
	
Scenario:
	Given I create a GET Request for the end point Users
	And I add below Parameters to the request 
	And I add Headers "app-id" and "6104e67a1888b5777720360b" to the request 			
	And I add authentication to the request
	When I execute the request
	Then I verify the respose code is 200 OK 
	And I validate the response content for Users
			|firstName | lastName | 
			|Sara  | Andersen|
	