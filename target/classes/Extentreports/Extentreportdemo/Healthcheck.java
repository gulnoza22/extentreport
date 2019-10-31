package Extentreports.Extentreportdemo;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Healthcheck {
	
	Response response;
	JSONObject each = null;
	Properties p = new Properties();
	InputStream is;

	@Test
	public void print() {
		
		int num1 = 5;
		int num2 = 10;
		
		assertEquals(num1, num2);
		
		
	}
	
	@Test
	public void print1() {
		
		int num1 = 10;
		int num2 = 10;
		
		assertEquals(num1, num2);
		
		
	}
	
	@Test
	public void website() throws IOException {
		
		is = new FileInputStream("configuration.properties");
		p.load(is);
		response = RestAssured.given().accept(ContentType.JSON).get(p.getProperty("url")).then().assertThat().statusCode(200).and().extract().response();
		response.prettyPrint();
		
	}
}
