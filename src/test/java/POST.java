import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Posts;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class POST extends InitTest{
    Response response;
    Posts posts = new Posts();
    @Test
    public void postPosts(){
        baseURI = ConfigurationReader.getProperty("base_uri");

        // Create Body with Pojo
        posts.setBody("muaz body");
        posts.setId(333);
        posts.setUserId(4444);
        posts.setTitle("muaz title");

        // Create Body with Map
        Map<String,Object> mapPost = new HashMap<>();
        //mapPost.put("id",55555);
        //mapPost.put("userId",666666);
        //mapPost.put("title","muazTitle2");
        //mapPost.put("body","muazBody2");

        //
        response = given().when().body(mapPost).post("/posts");
        response.prettyPrint();
    }
}
