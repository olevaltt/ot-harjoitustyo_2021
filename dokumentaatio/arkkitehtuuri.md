# Arkkitehtuuri

Ohjelman rakenne noudattaa kaksikerroksista kerrosarkkitehtuuria ja koodin perusrakenne on seuraava.

![image](https://user-images.githubusercontent.com/62206609/117840573-f6255100-b284-11eb-9fb2-6e21613661bb.png)

Pakkaus chordtrainer.ui sisältää käyttöliittymän ja chordtrainer.domain sovelluslogiikan.

## Käyttöliittymä

Käyttöliittymässä on vain yksi näkymä. Käyttöliittymään sisältyy pudotusvalikko, josta voidaan valita haluttu sointuasteikko. Keskellä on sointukartta, johon piirretään asteikon soinnut. käyttöliitymään sisältyy nappi, jolla voidaan näyttää seuraava sointu ja nappi jolla voidaan kytkeä sointujen automaattikierto päälle ja pois. Lopuksi käyttöliittymässä on säädin, jolla voidaan määrittää automaattikierron nopeus. Käyttöliittymä on rakennettu luokassa Chordtrainer.ui.ChordtrainerUi.

## Sovelluslogiikka

Sovelluslogiikan muodostavat luokat ChordHandler, Chord ja Scale. Scale-luokassa määritellään mahdolliset asteikot. Chord-luokan olio kuvaa yksittäistä sointua ja ChordHandler luo ja kokoaa soinnut sointuasteikkoihin. Käyttöliitymä pääsee käsiksisountuasteikoihin ja niiden sisällä oleviin sointuihin ChordHandlerin metodin ChordHandler.getNextChord(currentscale) kautta.

## Sointujen tallennus

Sointujen tallennus on toteutettu kovakoodaamalla niiden tiedot ChordHandler-luokkaan.

## Päätoiminnallisuudet

Kuvataan sovelluksen toimintalogiikka päätoiminnallisuuksien osalta.

#### Sointuasteikon valinta

![image](https://user-images.githubusercontent.com/62206609/117841452-c0349c80-b285-11eb-8cd3-f3a209f6b790.png)

Kun valitaan uusi asteikko, pudotusvalikkoon liitetty kuuntelija asettaa currentChord-muuttujan arvon oikeaksi, ja kysyy ChordHandlerilta seuraavaa asteikon sointua. ChordHandler palauttaa soinnun tiedot, ja nyt sointu piirretään tietojen mukaisesti showChord-funktion avulla.

#### Seuraavan soinnun näyttäminen

![image](https://user-images.githubusercontent.com/62206609/117842178-5b2d7680-b286-11eb-8afd-449991054c17.png)

Kun painetaan nappia "Next chord", nappiin liitetty toiminnallisuus kysyy ChordHandler-luokan metodilta getNextChord(currentScale), sointuasteikon seuraavan soinnun tietoja. Metodi palauttaa soinnun tiedot ja näiden tietojen mukaisesti piirretään sointu käyttäjän nähtäväksi.

#### Sointujen automaattinen toistaminen

## Ohjelman rakenteeseen jääneet heikkoudet

Sointujen tallentaminen kovakoodaamalla ei ole hyvä ratkaisu pidemmän päälle. Tästä aiheutuu pitkä metodi ChordTrainer-luokkaan, eikä nyt ole helppoa toteuttaa toiminnallisuutta sointujen ja asteikkojen lisäämiseksi.
