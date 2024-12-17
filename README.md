# Dezentrale Systeme REST

## Aufgabenstellung

Gegeben sind Daten von einem Wahllokal. Jeder Bezirk will diese über eine REST Schnittstelle veröffentlichen. Formate sind JSON und XML:

## Umsetzung

### WarehouseApplication.java
Main Klasse des Programmes. Startet die "Simulation"

### "model" Ordner
Dieser ordner Beinhält Klassen welche für Datenstrukturen (bsp. Lagerhausdaten) zuständig sind

#### WarehouseData.java
Warehousedata ist für die Daten der Lagerhäuser zuständig (Wie viele Votes, welche Adresse etc) 
Der Tag `@XmlElement` ist wichtig, da er ein neues XML Element definiert

#### PartyVotes.java
PartyVotes repräsentiert die jeweiligen Partein sowie die dazugehörigen Daten.

#### PreferredVote.java
PreferredVote stellt die Stimmen der einzelnen Parteimitglieder dar, sollte ein Mitglied bevorzugt werden

### "Warehouse" Ordner
In diesem Ordner befinden sich die Klassen welche für die Datengenerierung sowie REST schnittstelle zuständig sind.

** WICHTIG ** in diesem Fall gibt es kein WarehouseService da dieses Programm klein genug ist um ohne auszukommen, in größeren Programmen sollte es jedoch einen Service geben welcher mit @Service annotiert ist, und eine Art Wrapper für die Simulation ist.

#### WarehouseSimulation.java
Hier werden die Lagerhäuser mit generierten Daten erstellt. Diese sind nicht persistent d.h. wenn die Seite neugeladen wird, werden die Daten ebenfalls neu generiert.

Mit `getData()` wird ein neues Lagerhaus erstellt und mit Daten befüllt. Die addresse und ähnliches bleiben hierbei immer Gleich. Es werden immer die selben Parteien hinzugefügt, jedoch werden die Stimmen pseudozufällig generiert, das selbe gilt für die "preferredVotes" welche hier ebenfalls generiert werden.

#### WarehouseController.java
Diese Klasse gilt als der Kontroller dieses Programmes und muss so mit hilfe von zwei Annotations definiert werden.

```java
@RestController
@RequestMapping("/warehouse")
```

"@RestController" macht diese Klasse zu einer REST Schnittstelle. "RequestMapping" definiert hier das Root element ("warehouse")

Dies ist der Ganze code.  
**WICHTIG** wie vorhin erwähnt sollte es hier einen Service geben. In diesem Fall würde er hier wsim ersetzen.
Diesen müsste man mit "@autowired" annotieren

```java
private WarehouseSimulation wsim = new WarehouseSimulation();

@GetMapping(value = "/{inID}", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public WarehouseData getWarehouseDataJSON(@PathVariable String inID) {
    return wsim.getData(inID);
}

@GetMapping(value = "/{inID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
@ResponseBody
public WarehouseData getWarehouseDataXML(@PathVariable String inID) {
    return wsim.getData(inID);
}
```

Mit localhost:8080 kann man auf den laufenden Server zugreifen
## Quellen

https://spring.io/projects/spring-boot [Spring Boot, Accessed 2024-11-03]  
https://spring.io/guides/gs/rest-service/ [Building a RESTful Web Service, Accessed 2024-11-03]  
https://spring.io/guides/gs/consuming-rest/ [Consuming a RESTful Web Service, Accessed 2024-11-03]
