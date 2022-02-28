Feature: US1014 Kullanici DB Util ile concort Hotel database'ini test eder

  @dbutil
  Scenario: TC19 DB Util ile Concort Hotel Database REad Test

    Given kullanici DB Util ile CHQA database'ine baglanir
    Then kullanici DB Util ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullamici DB Util ile "Price" sutunundaki 5. fiyatin 400 oldugunu test eder

  @dbupdate
  Scenario: Kullanici tHOTEL tablosundan istedigi Emaili update eder
    Given kullanici DB Util ile CHQA database'ine baglanir
    Then  DBU IDHotel degeri 1016 olan kaydin Email degerini "elveda@gmail.com" yapar