#Viikko1

Kokosin robotin, jossa on 2 moottoria edessä ja ohjaamaton pyörä takana. Robotin etupäässä on valosensori. Robotin rakentaminen osoittautui helpoksi, koska löysin internetistä ohjeet. Pyrin parantamaan hieman rakennetta supistamalla pyörien väliä ja tekemään siitä omalaatuisemman.

Suurin haaste viikolla oli saada ohjelmointiympäristö toimimaan. Kopioin Robjosin USB-tikulle ja pienen kamppailun jälkeen tajusin, että tikku toimii vain USB2-portin kautta. Vaikeinta oli saada koodi robottiin. Build.xml-tiedostoa käyttäen sain sen onnistumaan, mutta välillä tulee virheilmoituksia ja koodi ei päädy robottiin asti. Täytyy selvittää parempi ratkaisu (esim. käyttäen Eclipse-pluginia).

Aloitin ohjelmoinnin viivan seuraamisen toteuttamisella. Tähän kuului pieni valosensorinlukuohjelma, jolla sain teipin ja lattian valoarvot. Robotti seuraa teipin vasenta reunaa: robotti kääntyy hieman oikealle, kun se lukee lattian valoarvoa ja hieman vasemmalle, kun se lukee teipin valoarvoa. Tästä seuraa se, että robotti hieman nykii oikealle ja vasemmalle sen liikkuessaan eteenpäin. Pyrin parantaa ratkaisuani sulavammaksi. Ohjelma pysähtyy painamalla ENTER-painiketta ja näin vältytään vahingoilta mahdollisten ongelmien sattuessa.
