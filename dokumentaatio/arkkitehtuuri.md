# Arkkitehtuuri

Ohjelman rakenne on seuraavan näköinen.

![image](https://user-images.githubusercontent.com/62206609/117840573-f6255100-b284-11eb-9fb2-6e21613661bb.png)

Pakkaus chordtrainer.ui sisältää käyttöliittymän ja chordtrainer.domain sovelluslogiikan.

## Käyttöliittymä

Käyttöliittymässä on yksi näkymä. Käyttöliittymään sisältyy pudotusvalikko, josta voidaan valita haluttu sointuasteikko. Keskellä on sointukartta, johon piirretään asteikon soinnut. käyttöliitymään sisältyy nappi, jolla voidaan näyttää seuraava sointu ja nappi jolla voidaan kytkeä sointujen automaattikierto päälle ja pois. Lopuksi käyttöliittymässä on säädin, jolla voidaan määrittää automaattikierron nopeus. Käyttöliittymä on rakennettu luokassa Chordtrainer.ui.ChordtrainerUi.

## Sovelluslogiikka

Sovelluslogiikan muodostavat luokat ChordHandler, Chord ja Scale. Scale-luokassa määritellään mahdolliset asteikot. Chord-luokan olio kuvaa yksittäistä sointua ja ChordHandler luo ja kokoaa soinnut sointuasteikkoihin. Käyttöliitymä pääsee käsiksi sointuasteikoihin ja niiden sisällä oleviin sointuihin ChordHandlerin metodin ChordHandler.getNextChord(currentscale) kautta.

## Sointujen tallennus

Sointujen tallennus on toteutettu kovakoodaamalla niiden tiedot ChordHandler-luokkaan.

## Päätoiminnallisuudet

Ohjelman toimintalogiikka tärkeimpien ominaisuuksien kannalta on seuraavanlainen.

#### Sointuasteikon valinta

![image](https://user-images.githubusercontent.com/62206609/117841452-c0349c80-b285-11eb-8cd3-f3a209f6b790.png)

Kun valitaan uusi asteikko, pudotusvalikkoon liitetty kuuntelija asettaa currentChord-muuttujan arvon oikeaksi, ja kysyy ChordHandlerilta seuraavaa asteikon sointua. ChordHandler palauttaa soinnun tiedot, ja nyt sointu piirretään tietojen mukaisesti showChord-funktion avulla.

#### Seuraavan soinnun näyttäminen

![image](https://user-images.githubusercontent.com/62206609/117842178-5b2d7680-b286-11eb-8afd-449991054c17.png)

Kun painetaan nappia "Next chord", nappiin liitetty toiminnallisuus kysyy ChordHandler-luokan metodilta getNextChord(currentScale) sointuasteikon seuraavan soinnun tietoja. Metodi palauttaa soinnun tiedot ja näiden tietojen mukaisesti piirretään sointu käyttäjän nähtäväksi.

#### Sointujen automaattinen toistaminen

![image](https://user-images.githubusercontent.com/62206609/117964896-dd6f7680-b32a-11eb-8573-1b437e2f4514.png)

Kun painetaan nappia "Cycle chords" sointujen automaattitoiston toteuttava silmukka kytkeytyy päälle. Silmukka odottaa määrätyn aikaintervallin jonka jälkeen Chordhandler-luokan metodilta getNextChord(currentScale) kysytään sointuasteikon seuraavan soinnun tietoja. Metodin palautettua tiedot sointu piirretään niiden mukaisesti käyttäjän nähtäväksi. Kun käyttäjä painaa "Cycle chords"-nappia uudestaan silmukka kytketään pois päältä.

## Ohjelman rakenteeseen jääneet heikkoudet

Sointujen tallentaminen kovakoodaamalla ei ole hyvä ratkaisu pidemmän päälle. Tästä aiheutuu pitkä metodi ChordTrainer-luokkaan, eikä nyt ole helppoa toteuttaa toiminnallisuutta sointujen ja asteikkojen lisäämiseksi.
