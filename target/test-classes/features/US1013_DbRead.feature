Feature: US1013 Kullanici concort Hotel database'ini test eder

  @db
  Scenario: TC18 Concort Hotel Database REad Test

    Given kullanici CHQA database'ine baglanir
    Then kullanici "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullamici "Price" sutunundaki verileri okur ve istedigi islemleri yapar