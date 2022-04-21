import apiconfigs.APIPaths;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Comments;
import pojo.Posts;
import apiverification.ResponseVerification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class GET extends InitTest {
    Response response;
    Comments comments = new Comments();
    Posts post = new Posts();
    List<Posts> listPosts;

    @Test
    public void getValidation(){
        test.log(LogStatus.INFO,"getComments Test Starting....");
        response = given().when().get(APIPaths.GET_POSTS+"/1");
        ResponseVerification.responseCodeValidation(response,201);
        test.log(LogStatus.INFO,"getComments Test End.....");
    }

    @Test
    public void getComments(){
        // Response pretty print
        response = given().when().get(APIPaths.GET_POSTS+"/1");
        response.prettyPrint();

        // Hamcrest Matchers Validation
        given().when().get("/comments/1")
                .then().assertThat().body("id", Matchers.equalTo(1));

        // Pojo Class Validation
        comments = given().when().get(APIPaths.GET_POSTS+"/1")
                .then().extract().as(Comments.class);
        Assert.assertEquals(comments.getId(),1);

        // JsonPath Validation -1
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getInt("id"),1);

        // JsonPath Validation -2
        jsonPath = given().when().get("/comments/1")
                .then().extract().jsonPath();
        Assert.assertEquals(jsonPath.getInt("id"),1);


    }
    @Test
    public void getListPost(){
        // id Filed
        int id = given().when().get("/posts/1")
                .then().extract().path("id");
        System.out.println(id);

        // post only 1
        post = given().when().get("/posts/1")
                .then().extract().as(Posts.class);

        // List
        listPosts = given().when().get("/posts")
                .then().extract().jsonPath()
                .getList(".",Posts.class);

        List<Posts> postsList = new ArrayList<>();
        postsList.add(post);

        Assert.assertTrue(listPosts.containsAll(postsList));
    }

    @Test
    public void getCommentsParam(){
        /*
        Comments[] commentsList = given().pathParams("postId","?postId=1")
                .when().get("/comments{postId}")
                .then().extract().as(Comments[].class);
        System.out.println(commentsList);
        */
        // Path Param
        listPosts = given().pathParams("com","comments")
                .when().get("/posts/1/{com}")
                .then().extract().jsonPath()
                .getList(".",Posts.class);

        // Path Param
        listPosts = given().queryParam("postId",1)
                .when().get("/comments")
                .then().extract().jsonPath()
                .getList(".",Posts.class);
    }
}
