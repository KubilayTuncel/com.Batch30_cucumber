Feature: US1004 ebay sayfasinda kelime arama


  Scenario: TC08 kullanici ebay da istedigi kelimeyi aratip test eder
    #Bu test calismaz
    Given kullanici "ebayUrl" sayfasina gider
    Then "nutella" icin arama yapar
    And sonucun "nutella" icerdigini test eder
    Then sayfayi kapatir

    #burada tum stepdefination'lar tanimli gibi görünse de testimiz calismaz
    #Cünkü arama yapar ve sonucu test eder stepdefination'lari amazon sayfsina gore locate edilmisti
    #burada yeniden locate etmemiz gerekirken ayni cumleyi yazdigimiz icin
    #bizden yeni stepdefination istemedi
    #Bu yuzden gherkin ile yazdigimiz cumlelerin tam tanimlayici olmasi önemlidir