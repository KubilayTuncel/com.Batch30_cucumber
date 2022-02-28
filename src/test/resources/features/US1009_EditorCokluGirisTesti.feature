Feature: US1009 Editor sayfasina farkli kullanicilar ekleyelim

@editor
Scenario Outline: TC11 Editor sayfasina farkli ksiler ekleme
Given kullanici "editorUrl" sayfasina gider
When User clicks on new button
And User firstName enters "<firstName>"
And User lastName enters "<lastName>"
And User position enters "<position>"
And User office enters "<office>"
And User  extension enters "<extension>"
And User startDate enters "<startDate>"
And User salary enters "<salary>"
And User clicks CreateButton
  Then girerek "<firstName>" "<lastName>" kaydin tamalandigini kontrol ediniz
And sayfayi kapatir

Examples:
|firstName|lastName|position|office|extension|startDate|salary|firstName|
|Hakan    |Tetik   |TestLead|Paris |124      |2021-12-12|60000|Hakan    |
|Fatih    |Aslan   |Qa      |Kenya |126      |2021-12-12|50000|Fatih   |
|Mehmet   |Citik   |Developer|Leipzig |128   |2021-12-12|55000|Mehmet    |