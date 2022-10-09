import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagepattern.HomePage;
import pagepattern.LoginPage;
import utility.TestBase;
import utility.TestUtility;

public class TestNGRunner extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

   static String accountFirstName=TestUtility.readFromExcelCell("test-data/accountinformation.xlsx",
            "Sheet1",1,0);
    static String accountLastName=TestUtility.readFromExcelCell("test-data/accountinformation.xlsx",
            "Sheet1",1,1);
    static String accountPhoneNumber=TestUtility.readFromExcelCell("test-data/accountinformation.xlsx",
            "Sheet1",1,2);
    static String accountEmail=TestUtility.readFromExcelCell("test-data/accountinformation.xlsx",
            "Sheet1",1,3);

    String config = "config.properties";
    String userEmail=TestUtility.readFromConfigProperties(config,"email");
    String userPassword=TestUtility.readFromConfigProperties(config,"password");
    @BeforeClass
    public void setUp(){
        browserSetUp(TestUtility.readFromConfigProperties(config,"url"));
        loginPage=new LoginPage(driver);
        loginPage.acceptCookie();
    }

    @Test
    public void theForkTest(){
        Assert.assertTrue(loginPage.verifyLoginPageOpened());
       homePage= loginPage.loginMethod(userEmail,userPassword);
        Assert.assertTrue(homePage.verifyLogin());
        homePage.clickOnMyPersonalInformationButton();
        accountInfoValidation();

    }
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();

    }

    public void accountInfoValidation() {
        Assert.assertEquals(homePage.validateFirstName(),accountFirstName);
        Assert.assertEquals(homePage.validateLastName(),accountLastName);
        Assert.assertEquals(homePage.validatePhoneNumber(),accountPhoneNumber);
        Assert.assertEquals(homePage.validateEmail(),accountEmail);
    }
}
