Feature: US1008 Editor sayfasina farkli kullanicilar ekleyelim

  @editor2
  Scenario Outline: TC11 Editor sayfasina farkli ksiler ekleme
    Given kullanici "editorUrl" sayfasina gider
    When User clicks on new button
    And editor ilgili kutulara "<firstName>"  "<lastName>"  "<position>" "<office>"  "<extension>" "<startDate>"  "<salary>" bilgilerini girer
    And User clicks CreateButton
    And sayfayi kapatir

    Examples:
      |firstName|lastName|position|office|extension|startDate|salary|firstName|
      |Hakan    |Tetik   |TestLead|Paris |124      |2021-12-12|60000|Hakan    |
      |Fatih    |Aslan   |Qa      |Kenya |126      |2021-12-12|50000|Fatih   |
      |Mehmet   |Citik   |Developer|Leipzig |128   |2021-12-12|55000|Mehmet    |