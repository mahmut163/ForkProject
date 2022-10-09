package pagepattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtility;

public class LoginPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(id = "_evidon-accept-button")
    WebElement acceptButton;
    @FindBy(xpath = "(//span[contains(text(),'Log in')])[1]")
     WebElement loginButton;
    @FindBy(id = "identification_email")
    WebElement emailField;
    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement continueButton;
    @FindBy(id = "password")
    WebElement passwordField;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    public void acceptCookie(){
        testUtility.waitForElementPresent(acceptButton);
        acceptButton.click();
        testUtility.sleep(3);
    }
    public boolean verifyLoginPageOpened() {
        testUtility.waitForElementPresent(loginButton);
        if (loginButton.isDisplayed())
            return true;
        else
            return false;
    }
   public void clickOnLoginButton(){
        testUtility.waitForElementPresent(loginButton);
        loginButton.click();
        //testUtility.sleep(2);
   }
   public void enterEmailAddress(String email){
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(email);
        testUtility.waitForElementPresent(continueButton);
        continueButton.click();
   }
   public void enterPassword(String password){
        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
        testUtility.waitForElementPresent(continueButton);
        continueButton.click();
       //testUtility.sleep(2);
   }
   public HomePage loginMethod(String email,String password){
        clickOnLoginButton();
        enterEmailAddress(email);
        enterPassword(password);

    return new  HomePage(driver);
   }

}
