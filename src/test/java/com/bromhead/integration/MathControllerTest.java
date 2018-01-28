package com.bromhead.integration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {

	@LocalServerPort
    int port;
	
	@Test
	public void testAdd_GETRequest() {
		begin()
			.queryParam("n1", "10")
			.queryParam("n2", "25")
		.get("/math/add")
		.then()
		.body("sum", equalTo("35"));
		
	}
	
	@Test
	public void testAdd_POSTRequest() {
		begin()
		.parameters("1", "20", "2", "30")
		.when()
		.post("/math/add")
		.then()
		.body("sum", equalTo("50"));
	}
	
	@Test
	public void testADD_GETRequest_InvalidParams() {
		begin()
		.queryParam("n1", "bad_param")
		.queryParam("n2", "25")
		.expect().statusCode(422)
		.when()
		.get("/math/add")
		.then()
		.body("error", equalTo("bad_param is not a valid numeric value"));
	}
	
	@Test
	public void testAdd_POSTRequest_InvalidParams() {
		begin()
		.parameters("1", "20", "2", "bad_param")
		.expect().statusCode(422)
		.when()
		.post("/math/add")
		.then()
		.body("error", equalTo("bad_param is not a valid numeric value"));
	}
	
	private RequestSpecification begin() {
		return given().port(port);
	}
}
