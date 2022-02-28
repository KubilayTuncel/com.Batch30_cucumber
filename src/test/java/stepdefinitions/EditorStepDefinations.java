package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.EditorPage;
import utilities.Driver;

public class EditorStepDefinations {
    EditorPage editorPage = new EditorPage();
    Actions actions = new Actions(Driver.getDriver());
    @When("User clicks on new button")
    public void user_clicks_on_new_button() {
        editorPage.newButton.click();
    }
    @When("User firstName enters {string}")
    public void user_first_name_enters(String name) {
        editorPage.firstName.sendKeys(name);
    }
    @When("User lastName enters {string}")
    public void user_last_name_enters(String lastName) {
        editorPage.lastName.sendKeys(lastName);
    }
    @When("User position enters {string}")
    public void user_position_enters(String position) {
        editorPage.position.sendKeys(position);
    }
    @When("User office enters {string}")
    public void user_office_enters(String office) {
        editorPage.office.sendKeys(office);
    }
    @When("User  extension enters {string}")
    public void user_extension_enters(String extension) {
        editorPage.extension.sendKeys(extension);
    }
    @When("User startDate enters {string}")
    public void user_start_date_enters(String startDate) {
        editorPage.startDate.sendKeys(startDate);
    }
    @When("User salary enters {string}")
    public void user_salary_enters(String salary) {
        editorPage.salary.sendKeys(salary);
    }
    @When("User clicks CreateButton")
    public void user_clicks_create_button() {
        editorPage.createButton.click();
    }


    @And("editor ilgili kutulara {string}  {string}  {string} {string}  {string} {string}  {string} bilgilerini girer")
    public void editorIlgiliKutularaBilgileriniGirer(String firstName, String lastName, String position, String office, String extention, String startDate, String salary) {
        actions.sendKeys(firstName)
                .sendKeys(Keys.TAB).sendKeys(lastName)
                .sendKeys(Keys.TAB).sendKeys(position)
                .sendKeys(Keys.TAB).sendKeys(office)
                .sendKeys(Keys.TAB).sendKeys(extention)
                .sendKeys(Keys.TAB).sendKeys(startDate)
                .sendKeys(Keys.TAB).sendKeys(salary).click(editorPage.createButton).perform();
    }

    @Then("girerek {string} {string} kaydin tamalandigini kontrol ediniz")
    public void girerekKaydinTamalandiginiKontrolEdiniz(String firstName, String lastName) throws InterruptedException {
        Thread.sleep(2000);
        editorPage.searchBox.click();
        editorPage.searchBox.sendKeys(firstName + " "+ lastName);
        Assert.assertTrue(editorPage.isimAramaIlkSatir.isDisplayed());
    }


}
