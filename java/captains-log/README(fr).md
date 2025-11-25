# Captain's Log

## Introduction

## Le hasard

Un instance de la classe `java.util.Random` peut être utilisépour généré un nombre aléatoire en Java.

### Nombres entiers aléatoire

Un nombre entier aléatoire peut être généré en utilisant la methode `nextInt()`.
Cela va générer une valeur entre `Integer.MIN_VALUE` et `Integer.MAX_VALUE`.

```java
Random random = new Random();

random.nextInt();
// => -1169335537
```

Pour limiter la porté des valeurs généré, on utilise `nextInt(int)`.
Ceci va généré une valeur entre la porté `0` inclus et la valeur supérieur donnée (exclue).

Pour l'exemple, ceci va généré un nombre aléatoire entre `0` et `9`.

```java
Random random = new Random();

random.nextInt(10);
// => 6
```

Et ceci générera un nombre aléatoire entre `10` et `19`.

```java
Random random = new Random();

10 + random.nextInt(10);
// => 11
```

### Nombres doubles Aléatoires

Un nombre de type double aléatoire peut être généré en utilisant la méthode `nextDouble()`.
Ceci générera une valeur entre `0.0` et `1.0`.

```java
Random random = new Random();

random.nextDouble();
// => 0.19250004204021398
```

Et ceci générera un nombre aléatoire entre `100.0` et `200.0`.

```java
Random random = new Random();

100.0 + 100.0 * random.nextDouble();
// => 111.31849856260328
```

## Instructions

Mary est une grosse fan de la séries TV _Star Trek: The Next Génération_.
Elle joue souvent à des jeux de rôles avec un stylo et du papier, elle et ses amis font comme si ils étaient l'équipage du _Starship enterprise_.
Le personnage de Mary est le capitaine Picard, ce qui signifie qu'elle doit tenir le journal de bord du capitaine.
Elle adore cette partie créative du jeu, mais elle n'aime pas généré des données aléatoire sur le champ.

Aide Mary à crée un générateur de nombre aléatoire pour les données courantes du journal du capitaine.

~~~note
Les implémentations du début de cette exercice utilise l'instance `java.util.Random` comme argument pour le constructeur.
Ceci permet que les testes des exercices utilise l'insatnce avec la seed prédéfinie, pour faire des testes avec des résultats prédictible.

Par conséquent, vous devez utiliser l'instance `java.util.Random` fournie dans votre implémentation.
~~~

## 1. Généré une planete aléatoire

Le _Starship Enterprise_ rencontre beaucoup de planete au cours de ses voyages.
Les planetes dans l'univers de Star Trek sont diviser en plusieurs catégories basé sur leurs propriétés.
Par exemple, La Terre est classé en planete `M`.
Toutes les classes possibles de planetes sont: `D`, `H`, `J`, `K`, `L`, `M`, `N`, `R`, `T`, and `Y`.

Implemente la méthode `randomPlanetClass()`.
Il devra retourner une des classes des planetes de manières aleatoire.

```java
captainsLog.randomPlanetClass();
// => "K"
```

## 2. Généré un nombre de registre aléatoire pour le vaisseau

L'entreprise (nombre d'enregistrement `NCC-1701`) n'est pas le seule vaisseau à voler dans les alentoures!
Quand il y a un rendez-vous avec un autre vaisseau, Mary à besoins d'utiliser les journales de nombre d'enregistrement de ce vaisseau.

Les nombres d'enregistrement commence par le préfix `"NCC-"` et ensuite utilise un nombre entre `1000`et `9999` (inclusif).

Implémente la méthode `randomShipRegistryNumber()` qui retourne un nombre aléatoire d'enregistrement du vaisseau.

```java
captainsLog.randomShipRegistryNumber();
// => "NCC-1947"
```

## 3. Générer une date stéllaire aléatoire

À quoi sert un journal s'il ne comporte pas de dates ?

Une date stéllaire est un nombre avec une virgule flottante.
Les aventures du _Starship Enterprise_ de la 1er saison de _The Next Generation_ ce passe entre ces deux dates stellaire `41000.0` et `42000.0`.
Le "4" represente le 24ème siecle, le "1" est là pour la 1er saison.

Implement la méthode `randomStardate()` qui retourne un nombre à virgule flottante entre `41000.0` (inclus) et `42000.0` (exclus).

```java
captainsLog.randomStardate();
// => 41458.15721310934
```
