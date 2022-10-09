package pagepattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ScreenShotUtility;
import utility.TestUtility;

public class HomePage {
    WebDriver driver;
    TestUtility testUtility;
    ScreenShotUtility screenShotUtility;

    @FindBy(xpath = "//span[contains(text(),'mahmut')]")
    WebElement accountName;
    @FindBy(xpath = "//button[@aria-controls=\"user-space-user-information\"]")
    WebElement personalInformationButton;
    @FindBy(name = "firstName")
    WebElement firstName;
    @FindBy(name = "lastName")
    WebElement lastName;
    @FindBy(name = "phoneNumber.nationalNumber")
    WebElement phoneNumber;
    @FindBy(name = "email")
    WebElement email;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        screenShotUtility=new ScreenShotUtility();
    }
    public boolean verifyLogin() {
        testUtility.waitForElementPresent(accountName);
        return accountName.isDisplayed();
    }
    public void clickOnMyPersonalInformationButton(){
        testUtility.waitForElementPresent(personalInformationButton);
        personalInformationButton.click();
        screenShotUtility.takeScreenshot("image","accountinformation",driver);
    }
    public String validateFirstName(){

        return firstName.getAttribute("value");
    }
    public String validateLastName(){

        return lastName.getAttribute("value");
    }
    public String validatePhoneNumber(){

        return phoneNumber.getAttribute("value");
    }
    public String validateEmail(){

        return email.getAttribute("value");
    }


}
