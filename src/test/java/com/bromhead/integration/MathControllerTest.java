package com.bromhead.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {

	@LocalServerPort
    int port;
	
	@Test
	public void testAdd_GETRequest() {
		//given().port(port)
		begin()
			.queryParam("n1", "10")
			.queryParam("n2", "25")
		.get("/math/add")
		.then()
		.body("sum", equalTo("35"));
		
	}
	
	@Test
	public void testAdd_POSTRequest() {
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("1", "20");
		requestBody.put("2", "30");
		
		//given().port(port)
		begin()
		//.body(requestBody)
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
		.get("/math/add");
	}
	
	private RequestSpecification begin() {
		return given().port(port);
	}
}
