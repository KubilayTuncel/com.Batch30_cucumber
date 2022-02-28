package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CHQAPage;

public class CHQAStepdefinations {

    CHQAPage chqaPage = new CHQAPage();

    @Then("CH login linkine tiklar")
    public void ch_login_linkine_tiklar() {
    chqaPage.logIn.click();

    }
    @Then("CH username kutusuna {string} yazar")
    public void ch_username_kutusuna_yazar(String userName) {
    chqaPage.userName.sendKeys(userName);
    }
    @Then("CH password kutusuna {string} yazar")
    public void ch_password_kutusuna_yazar(String password) {
    chqaPage.password.sendKeys(password);
    }
    @Then("CH login butonuna basar")
    public void ch_login_butonuna_basar() {
    chqaPage.enterButonu.click();
    }
    @Then("giris yapilamadigini test eder")
    public void giris_yapilamadigini_test_eder() {
        Assert.assertTrue(chqaPage.isLoginFailed.isDisplayed());
    }
}
