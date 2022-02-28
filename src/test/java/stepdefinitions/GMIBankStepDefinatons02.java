package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.GMIBankPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;


public class GMIBankStepDefinatons02 {
    GMIBankPage gmiBankPage = new GMIBankPage();
    @When("kullanici gmibank sayfasina gider")
    public void kullanici_gmibank_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));
    }
    @Then("sayfaya giris yapar")
    public void sayfaya_giris_yapar() {
        gmiBankPage.GMIBankLogin();
    }
    @Then("sayfaya giris yaptigini dogrular")
    public void sayfaya_giris_yaptigini_dogrular() {
        gmiBankPage.girisOnayWebElementi.isDisplayed();
    }
    @When("gmibank signout butonuna tikalar")
    public void gmibank_signout_butonuna_tikalar() {
        gmiBankPage.girisOnayWebElementi.click();
        gmiBankPage.signOutWebElementi.click();
    }
    @When("gmibank sayfasindan cikis yaptigini dogrular")
    public void gmibank_sayfasindan_cikis_yaptigini_dogrular() {
        //h2[normalize-space()='THANK YOU FOR USING US...']
        //html//div[@id='app-view-container']/div[1]//h2[.='THANK YOU FOR USING US...']
        //*[@id="app-view-container"]/div[1]/div/div/div/h2
        gmiBankPage.signOutOnayWebElementi.isDisplayed();
    }
    @Then("gmibank signin butonuna tiklar")
    public void gmibankSigninButonunaTiklar() {
        gmiBankPage.ilkGirisButonu.click();
        gmiBankPage.signInButonu.click();
    }
    @And("gmibank username kutusuna {string} yazar")
    public void gmibankUsernameKutusunaYazar(String yanlisUserName) {
        gmiBankPage.gmibankUsernameKutusu.sendKeys(yanlisUserName);
    }
    @And("gmibank password kutusuna {string} yazar")
    public void gmibankPasswordKutusunaYazar(String yanlisPassword) {
        gmiBankPage.gmiBankPasswordKutusu.sendKeys(yanlisPassword);
    }
    @And("gmibank signin butonuna basar")
    public void gmibankSigninButonunaBasar() {
        gmiBankPage.gmiBankSigInOkButonu.click();
    }
    @Then("gmibank giris yapilamadigini test eder")
    public void gmibankGirisYapilamadiginiTestEder() {
        Assert.assertTrue(gmiBankPage.hataliGirisWebElementi.isDisplayed());
    }
    @Then("kullanici gecerli username ve password girer")
    public void kullaniciGecerliUsernameVePasswordGirer() {
        gmiBankPage.gmibankUsernameKutusu.sendKeys(ConfigReader.getProperty("gmibankUsernameValid"));
        gmiBankPage.gmiBankPasswordKutusu.sendKeys(ConfigReader.getProperty("gmibankUPasswordValid"));
    }
    @Then("kullanici userIcona tiklar")
    public void kullaniciUserIconaTiklar() {
        gmiBankPage.girisOnayWebElementi.click();
    }
    @Then("kullanici user settings sayfasinda olmalidir")
    public void kullaniciUserSettingsSayfasindaOlmalidir() {
        gmiBankPage.userInfoWebElementi.click();
        String expectedUrl = "https://www.gmibank.com/account/settings";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(expectedUrl.equals(actualUrl) ? "PASS" : "FALL");
    }
    @And("kullanici language dropdown da secenekleri gorur")
    public void kullaniciLanguageDropdownDaSecenekleriGorur() {

        Select select = new Select(gmiBankPage.dilDropDown);
        List<WebElement> dilsecenekleri= select.getOptions();
        dilsecenekleri.stream().forEach(t-> System.out.println(t.getText()+" "));

    }
    @Then("kullanici English ve Turkish den basaka dil seceneginin olmadigini dogrular")
    public void kullaniciEnglishVeTurkishDenBasakaDilSecenegininOlmadiginiDogrular() {
        Select select = new Select(gmiBankPage.dilDropDown);
        List<WebElement> dilsecenekleri= select.getOptions();
        List<String> list = new ArrayList<>();
        dilsecenekleri.stream().forEach(t->list.add(t.getText()));
        Assert.assertTrue(list.contains("English") || list.contains("Türkçe"));
    }

    @Then("kullanici My Opertions a tiklar")
    public void kullaniciMyOpertionsATiklar() {
    gmiBankPage.myOperationWebElementi.click();
    }

    @Then("kullanici Manage Customers i secer")
    public void kullaniciManageCustomersISecer() {
        gmiBankPage.manageCustomersWebElementi.click();
    }

    @And("kullanici Create a New Customer a tiklar")
    public void kullaniciCreateANewCustomerATiklar() {
        gmiBankPage.createNewCustomer.click();
    }

    @And("kullanici  {string} girer")
    public void kullaniciGirer(String ssn) {
        gmiBankPage.searcSSN.sendKeys(ConfigReader.getProperty("ssn"));
    }

    @And("kullanici Search button a tiklar")
    public void kullaniciSearchButtonATiklar() {
        gmiBankPage.searchButton.click();
    }

    @Then("kullanici fail message i gorur")
    public void kullaniciFailMessageIGorur() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(gmiBankPage.failedMessage.isDisplayed());
    }
}
