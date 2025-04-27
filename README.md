# ***API Automation***

## Project Overview
The project involves working with REST web-services, where the primary objective is to complete a series of tasks related to the implementation and testing of REST APIs.

## Prerequisites
- Java Development Kit (JDK) installed

## Setup Instructions
1. **Add Dependencies**: JUnit Jupiter Engine, REST Assured, Gson, JUnit Jupiter API.
2. **Navigate to the test directory**.
3. **Run Tests**: Right-click on the desired test to run.

## Acceptance Criteria
- Tests should be created using either Rest Assured or Spring Rest Template. 
- Tests have to include validations that are given. 
- Implemented tests should be readable. 
- Tests must be implemented so that they could be launched in parallel. 
- Naming and Code Conventions should be followed. 
- As for tests of the bonus task, they should be created to test CRUD operations of the given resource.

### First Scenario - Create a test to verify an http status code
1. Send the http request by using the GET method. 
2. The URL is `https://jsonplaceholder.typicode.com/users`.
3. **Validation**: status code of the obtained response is 200 OK.

### Second Scenario - Create a test to verify an http response header
1. Send the http request by using the GET method.
2. The URL is `https://jsonplaceholder.typicode.com/users`.
3. **Validation**:
   - the content-type header exists in the obtained response;
   - the value of the content-type header is application/json; charset=utf-8.


### Create a test to verify an http response body
1. Send the http request by using the GET method.
2. The URL is `https://jsonplaceholder.typicode.com/users`.
3. **Validation**: the content of the response body is the array of 10 users.


_For the Bonus Task CRUDTest class was implemented and all the necessary entities, too._