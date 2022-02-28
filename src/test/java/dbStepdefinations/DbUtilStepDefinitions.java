package dbStepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class DbUtilStepDefinitions {
    @Given("kullanici DB Util ile CHQA database'ine baglanir")
    public void kullaniciDBUtilIleCHQADatabaseIneBaglanir() {
        DBUtils.getConnection();
    }

    @Then("kullanici DB Util ile {string} tablosundaki {string} verilerini alir")
    public void kullaniciDBUtilIleTablosundakiVerileriniAlir(String table, String field) {
        String readQuery="SELECT "+field+" FROM "+table;
        DBUtils.executeQuery(readQuery);
    }

    @And("kullamici DB Util ile {string} sutunundaki {int}. fiyatin {int} oldugunu test eder")
    public void kullamiciDBUtilIleSutunundakiFiyatinOldugunuTestEder(String field, int satirNo, int expectedPrice) throws Exception {



        int satirSayisi = DBUtils.getRowCount();
        int aktifSatirNumarasi = 0;
        System.out.println(satirSayisi); //603
        DBUtils.getResultset().first();

        while(aktifSatirNumarasi<satirSayisi) {
            System.out.println(aktifSatirNumarasi + ".satirindaki fiyat :"+DBUtils.getResultset().getDouble(field));
            DBUtils.getResultset().next();
            aktifSatirNumarasi++;
        }
        DBUtils.getResultset().absolute(satirNo);
        Integer actualDeger = (int)DBUtils.getResultset().getDouble(field);
        Assert.assertTrue(actualDeger==expectedPrice);

    }

    @Then("DBU IDHotel degeri {int} olan kaydin Email degerini {string} yapar")
    public void dbuIDHotelDegeriOlanKaydinEmailDegeriniYapar(int IDHotelNo, String yeniEmail) throws SQLException {
        String readQuery="SELECT Email FROM tHotel";
        DBUtils.executeQuery(readQuery);
        int satirSayisi=1;
        DBUtils.getResultset().first();

        while(satirSayisi<100) {
            Object satirdakiObje=DBUtils.getResultset().getObject("Email");

            System.out.println(satirSayisi + " .satirindaki Hotel : "+satirdakiObje.toString());
            DBUtils.getResultset().next();
            satirSayisi++;
        }
        String updateQuery="UPDATE tHOTEL SET Email='"+yeniEmail+"' WHERE IDHotel="+IDHotelNo;
                DBUtils.executeQuery(updateQuery);
    }
}
