package apiverification;

import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.ExtentReportListener;

public class ResponseVerification extends ExtentReportListener {

    public static void responseCodeValidation(Response response, int statusCode){
        try{
            Assert.assertEquals(response.getStatusCode(),statusCode);
            test.log(LogStatus.PASS,"Status code successfully validated, status code is : " + response.getStatusCode());
        }catch (AssertionError e){
            test.log(LogStatus.FAIL, e.fillInStackTrace());
            test.log(LogStatus.FAIL,"");
        }catch (Exception e){
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }
}
