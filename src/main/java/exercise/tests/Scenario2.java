package exercise.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Scenario2 {

	@Test
	private static void getCurrentPrices() {
		RestAssured.baseURI = "https://api.coindesk.com";
		RequestSpecification specs = RestAssured.given();
		Response resp = specs.get("/v1/bpi/currentprice.json");
		String response = resp.asString();
		System.out.println(response);
		ReadContext ctx = JsonPath.parse(response);
		Map<String, Object> bpi = ctx.read("$.bpi");
		String gbpDescription = ctx.read("$.bpi.GBP.description");
		System.out.println(gbpDescription);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(bpi.size(), 3);
		softAssert.assertEquals(gbpDescription, "British Pound Sterling");
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("USD", "GBP", "EUR"));
		int i = 0;
		for (Map.Entry<String, Object> b : bpi.entrySet()) {
			System.out.println(b.getKey());
			softAssert.assertEquals(b.getKey(), expected.get(i++));
		}
		softAssert.assertAll();
	}

}
