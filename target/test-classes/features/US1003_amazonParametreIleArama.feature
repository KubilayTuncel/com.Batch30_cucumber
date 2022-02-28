@Paralel2
Feature: US1003 kullanici istedigi kelime icin arama yapip, sonucu test eder


  Scenario: TC07 istenen kelimenin oldugunu test etme
    Given kullanici "amazonUrl" sayfasina gider
    And "armut" icin arama yapar
    Then sonucun "armut" icerdigini test eder
    And sayfayi kapatir
    # parametre olarak yazdigimiz kelimeyi stepdefination'da String olarak kullanacaksa
    # ne yazdigimiz önemli degil "armut" gibi

    #Ancak eger parametre olarak yazdigimiz kelimeyi configuration.properties'den alacaksak
    # burada yazdigimiz parametre'nin configuration.properties' deki yazim ile ayni olmasi gerekir
    #"amazonUrl" gubu, eger yazim farkli olursa bullPointeException verir
    #buradaki parametre ile configuration.properties'deki key ayni olduktan sonra
    #stepdefination'da parametre adi olarak ne yazdigimizin bir önemi yok