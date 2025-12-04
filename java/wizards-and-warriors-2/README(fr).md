# Wizards and Warriors 2

## Introduction

## Surcharge de méthode 

Dans Java, la surcharge de méthode est une fonctionnalité qui permet a une classe d'avoir plus de méthode avec le même nom, si leurs parametres sont differents.
C'est lié au polymorphism à la compilation (ou statique).
Ce concept est crucial pour créer pour être performant sur des tâches similaires mais avec des differentes entrée.

### Pourquoi surcharger des méthodes

Surcharger des méthodes augmente la lisibilité du programme. 
Differentes méthodes peuvent avoir les mêmes noms mais avec des parametres différents.
Cela dépend du nombre de parametres ou du type de parametres, la méthode correspondante est appelé. 

### Comment Surcharger des méthodes

La clé de surcharge de méthode réside dans la signature de la méthode.
Deux méthodes peuvent être considéré comme differente si ils ont des signatures differentes.
Il y a deux maniere de surcharer une méthode :

1. **Nombre differents de Parametres**: Les méthodes peuvent avoir le même nom mais un nombre different de parametre.

```java
   public class Display {

       public void show(int x) {
           System.out.println("Show with int: " + x);
       }

       public void show(int x, int y) {
           System.out.println("Show with two ints: " + x + ", " + y);
       }
   }
```


2. **Parametres de types differents**: Les méthodes peuvent avoir le même nom et le même nombre de parametres mais avec des types differents.

```java
   public class Display {

       public void show(int x) {
           System.out.println("Show with int: " + x);
       }

       public void show(String s) {
           System.out.println("Show with String: " + s);
       }
   }
```


### Point à retenir

- Les méthodes surchargées doivent modifier la liste des arguments.
- Les méthodes surchargées peuvent aussi changer le type de retour, mais simplement changer le type retourner n'en fait pas une méthode surchargées.
- Les méthodes peuvent être surchargées dans la même classe ou bien dans une sous class.

Dans ce concept, nous allons explorer les exemples variés et les nuances de la surcharge de ùéthode en java.

## Instructions

Dans cette exercice vous allez jouez à un jeu de rôle appelé "Wizard and Warriors" avec vos meilleurs amis.

Vous êtes le maitre du jeu, la personne chargé de donnée vie au monde du jeu pour les joueurs.
L'aspect clé, est de décrire le jeu aux joueurs: Quels sont les status des personnages, à quoi ressemble la ville qu'ils visitent, etc.

Vous avez cinq taches qui consistent à décrire des parties de jeux aux joueurs.

## 1. Decrire un personnage

Chaque caractère a une classe, un niveau et un nombre de points de vie  et est décrit comme: `"You're a level <LEVEL> <CLASS> with <HIT_POINTS> hit points."`.
Implementer la méthode `GameMaster.describe` qui prend un `Character ` comme son seul parametre et renvoie sa description.

```java
Character character = new Character();
character.setCharacterClass("Wizard");
character.setLevel(4);
character.setHitPoints(28);

new GameMaster().describe(character);
// => "You're a level 4 Wizard with 28 hit points."
```

## 2. Décrire la destination

Chaque destination a un nom et un nombres d'habitants et il est décrit comme: `"You've arrived at <NAME>, which has <INHABITANTS> inhabitants."`. Implémenter la méthode `GameMaster.describe` qui prend une `Description`comme seul parametre et renvoie sa description.

```java
Destination destination = new Destination();
destination.setName("Muros");
destination.setInhabitants(732);

new GameMaster().describe(destination);
// => "You've arrived at Muros, which has 732 inhabitants."
```

## 3. Decrire la méthode de voyage

Les personnages peuvent voyager vers une destination en utilisant une ou deux options:
- Marcher, décrit comme:`"You're traveling to your destination by walking."`.
- À cheval, décrit comme: ``"You're traveling to your destination on horseback."``.

Implémenter la méthode `GameMaster.describe` qui prend `TravelMethod` comme son seul parametre et renvoie sa description.

```java
new GameMaster().describe(TravelMethod.HORSEBACK);
// => "You're traveling to your destination on horseback."
```

## 4. Décrire le chemin du personnage vers une destination

Dans la majorité des cas, les personnages sont en voyages vers une destination en marchant.
Par commodité, les joueurs ont la permissions de ne pas mentionner leurs méthodes de voyages, dans ce cas on considérera que la méthode de voyage est la marche.
Implementer la méthode `GameMaster.describe` qui prend comme paramètres `Character` et `Destination` et retourne ça déscription.

```java
Character character = new Character();
character.setCharacterClass("Wizard");
character.setLevel(4);
character.setHitPoints(28);

Destination destination = new Destination();
destination.setName("Muros");
destination.setInhabitants(732);

new GameMaster().describe(character, destination);
// => "You're a level 4 Wizard with 28 hit points. You're traveling to your destination by walking. You've arrived at Muros, which has 732 inhabitants."
```