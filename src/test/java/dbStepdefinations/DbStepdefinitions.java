package dbStepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.sql.*; seklinde yazilabilir

public class DbStepdefinitions {
    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=qaconcorthotel; user=Ahmet_User;password=Ahmet123!";
    String username="Ahmet_User";
    String password="Ahmet123!";
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Given("kullanici CHQA database'ine baglanir")
    public void kullaniciCHQADatabaseIneBaglanir() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    @Then("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullaniciTablosundakiVerileriniAlir(String table, String field) throws SQLException {
        //SELECT Price FROM tHOTELROOM
        String readQuery="SELECT "+field+" FROM "+table;

        resultSet = statement.executeQuery(readQuery);
    }

    @And("kullamici {string} sutunundaki verileri okur ve istedigi islemleri yapar")
    public void kullamiciSutunundakiVerileriOkurVeIstedigiIslemleriYapar(String field) throws SQLException {
        //resultSet iterator gibi calisir
        resultSet.first();

        //resultSet.next() bir sonraki objeye gecer, sonraki eleman varsa true, yoksa false doner
        System.out.println(resultSet.next()); //true
        System.out.println(resultSet.getObject(field).toString());
        //son objeye gider ve sonra resultSet.next() calistirirsak
        //bir snraki eleman olmayacagi icin bize false doner
          resultSet.last();
        System.out.println(resultSet.next()); //false
        //tum listeyi yazdirmak istersek while loop ile birlikte resultSet.next() kullanabiliriz
        //cunku resultSet.next() bir sonraki obje var oldugu muddetce bize true dondurecek
        //ve while loop calismaya devamedecek
        //son obje ye ulastigimizda resultSet.next() false donecek ve while loop bitecek
        //Ancak biz 40. satirda son objeye gittigimiz icin
        //while loop u calistirirsak hic bir sey yazdirmaz
        //while loop calistirmadan once ilk objeye gitmemiz gerek
       /* resultSet.first(); // brinci objeye gittim
        while (resultSet.next()) { // usteki satir birinci objeye gitti ama resultSet.next() sonraki objeye gecirdi
                                    //dolayisiyla liste ikinci fiyattan basladi
            System.out.println(resultSet.getObject(field).toString());
        }
        */
        resultSet.absolute(0);
        while (resultSet.next()){
            System.out.println(resultSet.getObject(field).toString());
        }

        //varsa ilk yuz fiyati integer olarak bir liste olarak
        //1. yöntem
        resultSet.first();
        List<String > elemanlar = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
                elemanlar.add((i+1) +"- " + resultSet.getObject(field).toString()) ;
            }catch (Exception e) {

            }
        }

        System.out.println(elemanlar);
        //2. yöntem
        int sayac=1;
        List<Double> ilkYuzSayi= new ArrayList<>();

        while (sayac<=100 && resultSet.next()) {
            ilkYuzSayi.add(resultSet.getDouble(field));
            sayac++;
        }
        System.out.println(ilkYuzSayi);

        //7. fiyatin  double olarak 620.0 oldugunu test edin
        resultSet.absolute(7);
        double yedinciSayi=resultSet.getDouble(field);

        Assert.assertTrue(yedinciSayi==620);


    }

}
