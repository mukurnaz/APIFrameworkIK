import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Posts;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PUT extends InitTest{
    Response response;
    Posts posts = new Posts();
    @Test
    public void putMethod(){
        baseURI = ConfigurationReader.getProperty("base_uri");
        posts.setTitle("title muaz");
        posts.setBody("body muaz");
        posts.setId(22333);
        posts.setUserId(33322);
        response = given().when().body(posts).post("/posts/1");
    }
    @Test
    public void deleteMethod(){
        baseURI = ConfigurationReader.getProperty("base_uri");

        given().when().delete("posts/1")
                .then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

        given().when().get("/posts/1")
                .then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

        given().when().post("/posts/1")
                .then().assertThat().statusCode(500)
                .statusLine("HTTP/1.1 500 Internal Server Error");

        given().when().put("/posts/1")
                .then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK");


    }
}
