import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utilities.ConfigurationReader;
import utilities.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class InitTest extends ExtentReportListener {
    @BeforeClass
    public void baseTest(){
        RestAssured.baseURI = ConfigurationReader.getProperty("base_uri");
    }
}
