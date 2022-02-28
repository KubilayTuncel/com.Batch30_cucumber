@Paralel2
Feature: US1005 amazonda liste ile arama

  Scenario Outline:

    Given kullanici "amazonUrl" sayfasina gider
    Then "<arananUrun>" icin arama yapar
    And sonuc sayisini yazdirir
    And sonucun "<arananUrun>" icerdigini test eder
    Then sayfayi kapatir

    Examples:
    |arananUrun|
    |nutella   |
    |java      |
    |ipod      |
    |armut     |
    |Apple     |