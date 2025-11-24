
## Introduction

## Enums

Un _type enum_ est un type de données spécial qui permet à une variable d'être un ensembe de constantes prédéfinies.
La variable peut uniquement être égual à une des valeurs qui ont été prédéfinies pour ça.
Un exemple courant est de mettre les differentes directions d'une boussole (Valeurs : `NORTH`, `SOUTH`, `EAST`, et `WEST`) et les differents jours de la semaine.

Parce que c'est des valeurs constantes, les noms des champs dans le type enum sont en lettres majuscule.

### Définir un type enum

Dans le langage de programmation Java, vous pouvez definir le type enum en utilisant le mot clé `enum`.
Par exemple, vous voulez spécifié les jours de la semaine avec un type enum comme:

```java
public enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}
```

Vous devez utilisé le type enum autant de fois que vous devez représenter un ensemble fixe de constante.
Ça comprend les types d'énumération naturel telle que les planetes de notre systemes solaire et les ensembles de données quand on connait toutes les valeurs possible au moment de la compilation. - Par exemple, le choix dans un menu, les indicateurs de ligne de commande, et ainsi de suite. 

### Utilisé un type énum

Voici un peu de code qui vous montre comment utilisé l'énumération `DayOfWeek` définie plus haut :

```java
public class Shop {
    public String getOpeningHours(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                return "9am - 5pm";
            case SATURDAY:
                return "10am - 4pm"
            case SUNDAY:
                return "Closed.";
        }
    }
}
```

```java
var shop = new Shop();
shop.getOpeningHours(DayOfWeek.WEDNESDAY);
// => "9am - 5pm"
```

### Ajout de la méthodes et de champs

Dans le langage de programmation Java les types enum sont beaucoup plus puissant que ses homologues dans d'autres langages.
La déclaration `enum` definit une _class_ (appelé un _enum type_).
Le corps de la classe enum peut inclure des méthodes et d'autres champs :

```java
public enum Rating {
    GREAT(5),
    GOOD(4),
    OK(3),
    BAD(2),
    TERRIBLE(1);

    private final int numberOfStars;

    Rating(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public int getNumberOfStars() {
        return this.numberOfStars;
    }
}
```

Appelé la méthode `getNumberOfStars` sur un membre de du type énum `Rating`:

```java
Rating.GOOD.getNumberOfStars();
// => 4
```


## Introductions

Dans cette exercice vous traiterez des lignes de journalisation.
Chaque ligne de log est une chaîne de caractère formater comme suivant : `"[<LVL>]: <MESSAGE>"`.

Il y a different niveaux de logs :

- `TRC` (trace)
- `DBG` (debug)
- `INF` (info)
- `WRC` (warning)
- `ERR` (error)
- `FTL` (fatal)

Vous avez 3 tâches.

## 1. Analyser les niveaux de log

Definir une énumération `LogLevel` qui a six éléments correspondant aux niveaux de log du dessus.

- `TRACE`
- `DEBUG`
- `INFO`
- `WARNING`
- `ERROR`
- `FATAL`

Suivant l'implementation de la méthode `LogLine.getLogLevel()` ça retourne une analyse du niveau de log de la ligne de log:

```java
var logLine = new LogLine("[INF]: File deleted");
logLine.getLogLevel();
// => LogLevel.INFO
```

## 2. Supporter un niveau de log inconnu

Malheureusement, occasionellement quelques lignes de log ont une niveau de log inconnu.
Pour gérer correctement les lignes de log, ajouter un élément `UNKNOWN` dans l'énumération `LogLevel` qui devra être retouner quand l'analyse à un niveau de log inconnu:

```java
var logLine = new LogLine("[XYZ]: Overly specific, out of context message");
logline.getLogLevel();
// => LogLevel.UNKNOW
```

## 3. Convertir une ligne de log en format court

Le niveau de détaille d'une ligne de log est assez verbeux.
Pour réduire l'espace disque necessaire pour stocker les lignes de logs, un format court est developper : `"[<ENCORED_LEVEL>]: <MESSAGE>"`.

Les niveaux de logs encodé est une simple correspondance entre un niveau de log et un nombre :
- `UNKNOWN` - `0`
- `TRACE` - `1`
- `DEBUG` - `2`
- `INFO` - `4`
- `WARNING` - `5`
- `ERROR` - `6`
- `FATAL` - `42`

implementer la méthode `LogLine.getOutputForShortLog()` comme ça la sortie de format des logs peut est reduite :

```java
var logLine = new LogLine("[ERR]: Stack OverFlow");
logLine.getOutputForShortLog();
// => "6:Stack Overflow"
```