package restTestpackage;
import pages.constants;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
//import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
//import static org.junit.Assert.assertThat;

import java.util.List;

public class restTest {
	
	@Test
	public void validateStatusCode() {
	Response res=given()	
		.baseUri(constants.BASEURL)
	.when().
		get(constants.basepath)
	.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK").extract().response();
	}
	
	@Test
	public void validateHeaderType() {
	ValidatableResponse res=given()	
		.baseUri(constants.BASEURL)
	.when().
		get(constants.basepath)
	.then()
		.assertThat().header("Content-Type", "application/json; charset=utf-8");



	}
	
	@Test
	public void validateUserId() {
		Response res=given()	
			.baseUri(constants.BASEURL)
		.when().
			get(constants.basepath)
		.then()
			.extract().response();
		

		JsonPath path=res.jsonPath();
				
		Assert.assertEquals(path.getInt("data[5].user_id"),93);
		int userid = path.get("data.find {i-> i.title=='Vesco taceo suscipit amita universe civis spargo tollo et corrupti tumultus est carus ut tandem confero sint dolores doloremque.'}.user_id");
	
		System.out.println(userid);
		Assert.assertEquals(userid, 93);		
				
		


		}
	
	@Test
	public void validateTitle() {
		Response res=given()	
			.baseUri(constants.BASEURL)
		.when().
			get(constants.basepath)
		.then()
			.extract().response();
		

		JsonPath path=res.jsonPath();
				
		Assert.assertEquals(path.getString("data[6].title"),"Tres convoco stabilis ars expedita strenuus ut damno et somniculosus deinde valetudo auctor repudiandae utroque aeneus.");
		String title = path.get("data.find {i-> i.user_id==96}.title");
	
		System.out.println(title);
		Assert.assertEquals(title, "Tumultus denuo carpo aetas censura vae utique degero deficio demitto convoco tenetur paens quidem.");		
				
		


		}
}

