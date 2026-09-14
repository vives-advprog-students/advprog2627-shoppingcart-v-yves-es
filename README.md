# ShoppingCart

![Coverage](.github/badges/jacoco.svg)

## Doelstellingen
Je wordt enkel beter in het ontwikkelen van software door het te doen. Naast heel wat theoretische kennis dat in het OPO Advanced Programming aan bod komt, zullen ook heel wat opdrachten moeten uitgewerkt worden. Eén van de doelstelling van dit OPO dat zich uitstrekt over alle lessen heen is om je algoritmisch denkvermogen om een (complexer) probleem op te lossen aan te scherpen.

Het is belangrijk naar de volgende lessen toe dat je vlot overweg kan met een array. In deze opdracht word je gevraagd een aantal bewerkingen op een array te ontwikkelen.

## Opdrachtomschrijving
Accepteer het Classroom assignment dat je terugvindt op Toledo.
Een private git repository met een startproject wordt voor je aangemaakt.

Het doel van het project is om een eenvoudige shoppingcart te ontwikkelen waarin producten, bestaande uit een naam en een prijs, kunnen worden toegevoegd.
Er zijn twee restricties die worden opgelegd:
- De shoppingcart is een array die maximum 5 verschillende producten kan bevatten.
- De shoppingcart mag geen “gaten” bevatten. 

## Gegeven
Het project bevat volgende klassen:
De klasse `Product` bestaat uit 2 velden (name en price) en stelt een product voor dat verkocht wordt in onze webwinkel. Eénmaal een product is aangemaakt kan dit object niet meer wijzigen. Ieder product in onze webwinkel heeft een unieke naam.

De klasse `ShoppingCartItem` stelt één lijn voor in onze shoppingcart. Ze bestaat uit een bepaald product en een hoeveelheid (veld quantity). De hoeveelheid van een `ShoppingCartItem` is aanpasbaar.

De klasse `ShoppingCart` bevat op dit moment nog niet zo heel veel code. Enkel het maximum aantal shoppingcart-items is er in vastgelegd.

## Gevraagd
Werk de klasse `ShoppingCart` verder uit.

Een shoppingcart kan maximaal 5 verschillende producten bevatten.

Eénzelfde product kan wel meerdere malen opgenomen worden in de shoppingcart.

Gebruik een array om de shoppingcart voor te stellen.

### Toevoegen product
Het moet mogelijk zijn om een product toe te voegen aan de shoppingcart. Je geeft bij het toevoegen van het product aan de shoppingcart steeds de hoeveelheid op.
- Wanneer bij het toevoegen van een nieuw product de shoppingcart reeds vol is (maximum 5 **verschillende** producten) dan gooi je een ongecontroleerde zelfgeschreven exception.
- Wanneer bij het toevoegen het product reeds is opgenomen in de shoppingcart, dan wordt enkel de hoeveelheid verhoogd van het desbetreffende product in de shoppingcart.

### Verwijderen product
Het moet ook mogelijk zijn om een product te verwijderen uit de shoppingcart. Ook hier weer geef je steeds de hoeveelheid mee van het aantal producten dat verwijderd moet worden.
- Wanneer de shoppingcart vier woordenboeken bevat en je verwijdert er twee dan blijven nog twee woordenboeken over in de shoppingcart.
- Wanneer de shoppingcart drie woordenboeken bevat en je verwijdert er drie dan wordt het product volledig verwijderd uit de shoppingcart. **Let op:** de shoppingcart mag nooit “gaten” bevatten.  Als de shoppingcart vier verschillende producten bevat en je verwijdert het tweede product uit de array, dan moeten alle volgende producten opschuiven.
- Wanneer bij het verwijderen een product wordt meegegeven dat zich niet in de shoppingcart bevindt dan gooi je een `IllegalArgumentException`.
- Wanneer bij het verwijderen van een product een hoeveelheid wordt meegegeven dat groter is dan het aantal nog aanwezig in de shoppingcart voor dat product dan wordt eveneens een `IllegalArgumentException` opgegooid.

### Totale prijs
Schrijf een methode om de totale prijs van de shoppingcart te berekenen.

### toString
Schrijf een toString-methode in de klasse ShoppingCart. De toString-methode bevat een afdruk van de shoppingcart (producten met hun aantal) + de totale prijs van de shoppingcart.

### Testen
Er is een aanzet voor een testklasse voorzien in het project. Werk deze verder uit om je code grondig te controleren.






