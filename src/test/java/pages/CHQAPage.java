package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CHQAPage {

    public CHQAPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement logIn;

    @FindBy (xpath = "//input[@class='form-control required']")
    public WebElement userName;

    @FindBy (xpath = "//input[@class='form-control required password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='btnSubmit']")
    public WebElement enterButonu;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement isLoginFailed;
}
