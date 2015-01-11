#KESKEN!!!


Labyrintinratkaija ropotti on robotti, joka itsenäisesti kulkee viivoista muodostettua labyrinttia pitkin etsien ratkaisua eli ulospääsyä labyrintista. Ratkaisun löydettyä robotti ilmoittaa päässeensä maaliin ja lopettaa etsimisen. Jos ratkaisua ei löydy, ilmoittaa robotti myös siitä.

##Robotin rakenne:

Robotti on kulkuneuvo, jossa on kaksi moottoria, valosensori ja takana on moottoriton pyörä sivuttaissuunnassa.

##Labyrintin rakenne:

Labyrintin kootaan käyttäen kahdenlaista teippiä. Mustalla sähköteipillä merkitään labyrintin kulkureitit ja heijastavalla teipillä merkitään labyritin päätepiste. Mustan maalarinteipin täytyy olla tummempi kuin lattia ja heijastavan teipin tulisi heijastaa enemmän valoa kuin lattia. Robotti tarkistaa lattian, sähköteipin ja heijastavan teipin valoarvojen oikeellisuuden, eli teippien valoarvojen tarpeellisen eroavuuden, ohjelman alussa.




##Testaus

<b>Valoarvojen oikeellisuus:</b>

<u>Testitapaus1:</u>

Robotin kysyessä teipin, lattian ja maalin valoarvoja asetan ne oikeisiin kohtiin.

<i>Tulos:<i/> testi onnistui ja valoarvot kelpaavat (ei virheilmoitusta).

<u>Testitapaus 2:</u>

Robotin kysyessä teipin, lattian ja maalin valoarvoja asetan robotin lattiaan ja annan väärät valoarvot asettamalla kaikki valoarvot lattian valoarvoiksi.

<i>Tulos:<i/> onnistui, eli ruutuun tuli virheilmoitus valoarvojen puutteellisuudesta.

<u>Testitapaus 3:</u>

Asetan teipin valoarvoksi maalin valoarvon, lattian valoarvoksi lattian valoarvon ja maalin valoarvoksi teipin valoarvon.

<i>Tulos:</i> testi onnistui, ruutuun tuli virheilmoitus.



##Rajoitukset ja tulevaisuus

Labyrintin rakenne itsessään aiheuttaa rajoitteita, koska robotti pystyy kulkemaan vain tietynlaisessa labyrintissa: risteydet tulee merkitä tarkoin. Labyrintti täytyy olla syklitön.

Tulevaisuudessa robotti voisi ratkaista myös syklillisiä labyrintteja. Tällä hetkellä robotti kulkee labyrinttia itsenäisesti, eikä kommunikoi minkäänlaisen laitteen kanssa. Tätä voisi jatkokehittää paljon. Robotti voisi esimerkiksi lähettää tietoa sijainnista ja piirtää kartan labyrintista.




##Käyttöohje:

Robotin ja labyrintin kokoamisen jälkeen kytke robotti tietokoneeseen usb-johdolla. Ajamalla build.xml -tiedostoa ohjelma siirtyy robottiin, jonka jälkeen se suoritetaan automaattisesi. Jos haluat ajaa ohjelmaa jatkossa, se löytyy valikosta Files nimellä LabyRobo.

1. Aivan aluksi robotti lukee lattian, teipin ja maalin valoarvot. Lue ruudulta minkä valoarvoa robotti on lukemassa, aseta robottin valosensori lukemaan kyseistä materiaalia ja paina mitä tahansa nappia robotissa. Jos valoarvot eivät eroa tarpeeksi, robotti lopettaa ohjelman ja lähettää virheilmoituksen (lue labyrintin rakenne).

2. Valoarvojen lukemisen jälkeen ruudussa lukee “Aloita ENTER”. Aseta robotti pystysuunnassa viivaa nähden labyrintin alkuun, siten että valosensori on sähköteipin päällä ja paina ENTER-painiketta. Robotti aloittaa liikkumisen. Jos robotin toiminnassa tapahtuu jotain hälyyttävää, voit milloin tahansa lopettaa ohjelman painamalla robotin ENTER-painiketta ja ohjelma pysähtyy.

3. Robotti ilmaisee ratkaisun löytämisen pitkällä ja matalalla merkkiäänellä. Ruutuun ilmestyy joko viesti “Maali!” tai “Ei ratkaisua”. Robotti joko palasi ensimmäiseen risteykseen ratkaisua löytämättä tai se on maalissa. Ohjelman voi nyt lopettaa painamalla mitä tahansa nappia.

<b>HUOM!</b> Virhetilanteen sattuessa robotti pysähtyy ja robotti piippaa pitkään matalaa ääntä. Virheilmoitus lukee robotin ruudussa ja ohjelma loppuu mitä tahansa painamalla.
