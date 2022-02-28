Feature: US1010 GMIBank sayfasina gidip yeni girisler yapmak

  @GMIBank2
  Scenario: TC13 Editor sayfasina farkli ksiler ekleme

Given kullanici gmibank sayfasina gider
Then gmibank signin butonuna tiklar
Then kullanici gecerli username ve password girer
And  gmibank signin butonuna basar
Then kullanici userIcona tiklar
Then kullanici user settings sayfasinda olmalidir
And   kullanici language dropdown da secenekleri gorur
Then  kullanici English ve Turkish den basaka dil seceneginin olmadigini dogrular
