#KESKEN!!!

![](http://www.cs.helsinki.fi/u/antthaap/joulurobo/ropotti.jpg)

Labyrintinratkaija ropotti on robotti, joka itsenäisesti kulkee viivoista muodostettua labyrinttia pitkin etsien ratkaisua, eli ulospääsyä labyrintista. Ratkaisun löydettyä robotti ilmoittaa päässeensä maaliin ja lopettaa etsimisen. Jos ratkaisua ei löydy, ilmoittaa robotti myös siitä.

Robotti liikkuu labyrinttia pitkin ja valitsee risteyksestä suuntia järjestyksessä: oikea, ylös, vasen ja lopuksi palaa tulosiintaansa. Suunnat ovat aloitussuunnan mukaisia eikä risteyksien. Jos risteys päätyy umpikujan tai kaikki mahdolliset suunnat on kokeiltu, robotti palaa takaisin tulosuuntaansa pitkin edelliseen risteykseen.

##Robotin rakenne:

Robotti on auton tapainen laite, joka kulkee itsenäisesti.Siinä on kaksi moottoria, valosensori ja takana on moottoriton pyörä sivuttaissuunnassa. Tarkempia kuvia kasausohjeissa.

####LUE kasausohje: [kasausohje](kasausohje.md)

##Labyrintin rakenne:

![](http://www.cs.helsinki.fi/u/antthaap/joulurobo/labyrintti_1.jpg)

Labyrintin kootaan käyttäen kahdenlaista teippiä. Mustalla sähköteipillä merkitään labyrintin kulkureitit ja heijastavalla teipillä merkitään labyritin päätepiste. Mustan maalarinteipin täytyy olla tarpeeksi tummempi kuin lattia ja heijastavan teipin tulisi heijastaa enemmän valoa kuin lattian. Robotti tarkistaa ohjelman alussa lattian, sähköteipin ja heijastavan teipin valoarvojen oikeellisuuden, eli teippien valoarvojen tarpeellisen eroavuuden, ohjelman alussa.

Risteyksien mitat tulee olla 7cm * 7cm. Apuna kannattaa käyttää paperin palaa jonka mitat on 7cm * 7cm ja merkitä sähköteipillä sen keskelle musta risti. Rakentaessa asetat paperin palan sähköteipin loppuun ja teippaat risteydelle suunnat.

Maalin, eli labyrintin labyrintin ulopääsy, merkitään heijastavalla teipillä. Maalin koon olisi hyvä olla ainakin 7cm * 7cm tai suurempi.

Labyrintin viivat voivat kaartua, mutta käännekset eivät saa olla liian jyrkkiä tai robotti luulee saapuneensa risteykseen. Labyrintin voi koota miten haluaa, kuhan sinä ei ole syklejä. Maali ja lähtöviiva saa olla missä tahansa.

Syklejä ei saa esiintyä labyrintissa. Robotti ei tue tällä hetkellä syklillisiä labyrintteja.


##Koodin rakenne

Koodi on jaettu kolmeen pakettiin: labyrintinratkaisija, laitehallinta ja main.

<b>Laitehallinta</b>

Javadoc löytyy kansiosta. <b>KANSIO!!!</b>

Paketissa on kaikki oleellinen robotin laitteiden hallintaa: moottorit, valosensori ja satunnaiset toiminnot (luokassa Robotti).

* __LaitePortit__ - Luokka pitää sisälllään static-tyyppisiä muuttujat laitteiden porteille. MotorPort oikealle ja vasemmalle moottorille sekä SensorPort valosensorille. Jos portit muuttuvat robotissa, tähän luokkaan täytyy vain tehdä muutokset.
* __Moottorit__ - Pitää sisällään kaikki oleelliset toiminnot moottorien liikuttamiseen littyen. Kaikki metodit ovat static-tyyppisiä, eli luokkaa ei tarvitse käsitellä oliona.
* __Valonlukija__ - Valonlukija lukee valoarvot teipille, lattialle ja labyrintin maalille. Näiden arvojen avulla tehdään raja-arvot teipin valoarvon ja lattian valoarvon välille, sekä maalin valoarvon ja lattian valoarvon välille. Raja-arvoja käyttää metodit onkoTeipillä ja onkoMaalissa metodit palauttaa totuusarvon valosensorin nykyisen arvon tilasta.
* __Robotti__ - Luokassa on satunnaisia tarvittavia metodeja, jotka toteuttavat satunnaisia hyödyllisiä toimintoja. Toimonnot ovat: nuku, lopetaOhjelma, kirjoitaViesti.

<b>labyrintinratkaisija</b>

<b>main</b>

Sisältää main luokan.




##Testaus

<b>Valoarvojen oikeellisuus:</b>

<u>Testitapaus1:</u>

Robotin kysyessä teipin, lattian ja maalin valoarvoja asetan ne oikeisiin kohtiin.

<i>Tulos:<i/> testi onnistui ja valoarvot kelpaavat (ei virheilmoitusta).

<u>Testitapaus 2:</u>

Robotin kysyessä teipin, lattian ja maalin valoarvoja asetan robotin lattiaan ja annan väärät valoarvot asettamalla kaikki valoarvot lattian valoarvoiksi.

<i>Tulos:<i/> onnistui, ruutuun tuli virheilmoitus valoarvojen puutteellisuudesta.

<u>Testitapaus 3:</u>

Asetan teipin valoarvoksi maalin valoarvon, lattian valoarvoksi lattian valoarvon ja maalin valoarvoksi teipin valoarvon.

<i>Tulos:</i> testi onnistui, ruutuun tuli virheilmoitus.

<b>Valo-olosuhteet<b>

_Testitapaus 1:_

Himmensin olohuneen lampuista kauimmaisen.

<i>Tulos:</i> testi onnistu, robotti liikku labyrinttia pitkin normaalisti.

_Testitapaus 2:_

Suljin huoneen kaikki valot: huone on pilkkopimeä.

<i>Tulos:</i> testi onnistui, robotti liikkui labyrinttia pitkin normaalisti (valosensorissa on punainen ledivalo).



<b>Labyrintit</b>

_Testitapaus 1:_

Labyrintti koostuu vain yhdestä viivasta.

Tulos: testi onnistu, robotti tekee yhden etsien reitit tyhjästä risteyksestä ja ilmoittaa "Ei ratkaisua."

_Testitapaus 2:_ 

Labyrinttissa ei maalia.

Tulos: testi onnistu, robotti käy kaikki mahdolliset reitit läpi, palaa ensimmäiseen risteykseen ja ilmoittaa "Ei ratkaisua."

_Testitapaus 3:_

Labyrintissa on maali.

Tulos: testi onnistu, robotti käy kaikkia mahdollisia reittejä läpi, kunnes löytää maalin.



##Rajoitukset ja tulevaisuus

Labyrintin rakenne itsessään aiheuttaa paljon rajoitteita, koska robotti pystyy kulkemaan vain tietynlaisessa labyrintissa: risteydet tulee merkitä tarkoin labyrintin rakenne -kohdan mukaan. Virheet labyrinti kokoamisessa aiheuttaa varmasti ei-toivottuja toimintoja. Robotin voi kuitenkin pysäyttää painamalla enter-painiketta. Labyrintti täytyy myös olla syklitön, koska projekti ei ehtinyt edetä sinne asti. Tulevaisuudessa robotti voisi ratkaista myös syksillisiä labyrintteja.

Robotin rakenne on myös rajoite, sillä ohjelma toimii vain ja ainoastaan kyseisen robotin rakenteella. Moottorien hallinnassa olisi kannattanut käyttää Pilottia ja settaa sille renkaiden etäisyydet, eikä lukea käännöksiä moottorien kierroksien avulla kuten tein. Tätä voisi jatkokehittää. 

Tällä hetkellä robotti kulkee labyrinttia itsenäisesti, eikä kommunikoi minkäänlaisen laitteen kanssa. Tätä voisi jatkokehittää, paljon. Robotti voisi esimerkiksi lähettää tietoa sijainnista, edistymisestään ja piirtää kartan labyrintista. Kartta voisi sisältää lyimmän reitin labyrintista ulos. Labyrinttiin voisi myös asettaa esineitä, joita robotti etsii.





##Käyttöohje:

Robotin ja labyrintin kokoamisen jälkeen kytke robotti tietokoneeseen usb-johdolla. Ajamalla build.xml -tiedostoa ohjelma siirtyy robottiin, jonka jälkeen se suoritetaan automaattisesi. Jos haluat ajaa ohjelmaa jatkossa, se löytyy valikosta Files nimellä LabyRobo.

1. Aivan aluksi robotti lukee lattian, teipin ja maalin valoarvot. Lue ruudulta minkä valoarvoa robotti on lukemassa, aseta robottin valosensori lukemaan kyseistä materiaalia ja paina mitä tahansa nappia robotissa. Jos valoarvot eivät eroa tarpeeksi, robotti lopettaa ohjelman ja lähettää virheilmoituksen (lue labyrintin rakenne).

2. Valoarvojen lukemisen jälkeen ruudussa lukee “Aloita ENTER”. Aseta robotti pystysuunnassa viivaa nähden labyrintin alkuun, siten että valosensori on sähköteipin päällä ja paina ENTER-painiketta. Robotti aloittaa liikkumisen. Jos robotin toiminnassa tapahtuu jotain hälyyttävää, voit milloin tahansa lopettaa ohjelman painamalla robotin ENTER-painiketta ja ohjelma pysähtyy.

3. Robotti ilmaisee ratkaisun löytämisen pitkällä ja matalalla merkkiäänellä. Ruutuun ilmestyy joko viesti “Maali!” tai “Ei ratkaisua”. Robotti joko palasi ensimmäiseen risteykseen ratkaisua löytämättä tai se on maalissa. Ohjelman voi nyt lopettaa painamalla mitä tahansa nappia.

<b>HUOM!</b> Virhetilanteen sattuessa robotti pysähtyy ja robotti piippaa pitkään matalaa ääntä. Virheilmoitus lukee robotin ruudussa ja ohjelma loppuu mitä tahansa painamalla.
