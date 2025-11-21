# Traduction du README



## Héritage
L'héritage est le coeur du concept dans le POO (Programmation Orienté-Objet).
Il represente une relation.
Il est littéralement pensé en programmation comme ça l'est pensé en Français, il hérite les caractéristiques des Parents (en programmation les caracrèristiques sont normalement des fonctions et variables).


Considerer une class, `Animal` comme montré :

```java 
// Crée une classe Animal avec bark comme une fonction 

public class Animal {

    public void bark() {
        System.out.println("This is an animal");
    }
}

```

`Animal` est une classe parent, parce que les propriétés de cette classe peuvent être étendu à tous les animaux en général. 


Considerer un animal nommé `Lion`, qui a une classe comme,

```java
// Lion est une classe enfant de Animal.
public class Lion extends Animal {

    @Override
    public void bark() {
        System.out.println("Lion here !!");
    }
}
```


~~~exercism/note
L'annotation `Overide` sert à indiqué qu'une sous classe redéfinit une méthode de sa superclasse.

Il est pas strictement necessaire mais fortement recommendée.
~~~

```java 
Animal animal = new Lion(); // Création de l'instance Animal de type Lion
animal.bark();
```


Note: L'initialisation de la classe `Animal` avec `Lion`.
La sortie va ressembler à ça:
```java 
Lion here!!
```

Selon la POO, il y a beaucoup de type d'héritage, mais  Java support seulement certain d'entre eux (Multi-niveau et Hiérarchique).


## Instructions

Dans cet exercice tu joue à un jeu de rôle avec different type de combattants qui peuvent combattre.
Le jeu à differentes règles pour chaque type de combattant. 
Nous allons nous concentrer sur deux types spécifiques: Sorciers et Guerriers.

Pour un Guerrier, il y a ces règles:

- Un Guerrier est jamais vulnerable.
- Un Guerrier fait `6` points de dommages si l'adversaire attaqué est pas vulnérable.
- Un Guerrier fait `10`points de dommages si l'adversaire attaqué est vulnérable.

Pour un Sorciers, il y a ces regles:

- Un Sorcier peu préparer un sort en avance.
- Un sorcier est vulnérable à moins d'avoir préparé un sort en à l'avance.
- Un Sorcier fait `12` points de dégats si il a préparé un sort à l'avance.
- Un Sorcier fait `3` points de dégats si il n'a pas préparé de sort à l'avance.


## 1. Crée la classe Guerrier

Crée une nouvelle classe appelé `Warrior`.
Cette classe devrait hérité de la classe existante `Fighter`.

## 2. Décrire le Guerrier 

Mettra à jour la classe `Warrior` de sorte que ça méthode `toString()` décrit le type de combattant qu'il représente.
La méthode devrait retourner la chaine de caractère `"Fighter is a Warrior"`.

```java
Warrior warrior = new Warrior();
warrior.toString(); 
// => "Fighter is a Warrior"
```

## 3. Make Warriors invulnérable 
Mettre à jour la classe `Warrior` pour que la méthode `isVulnerable()` retourne toujours `false`;

```java
Warrior warrior = new Warrior();
warrior.isVulnerable();
// => false
```

## 4. Calculate les points de dommage pour le guerrier
Mettre à jour la classe `Guerriers` pour que la méthode `getDomagePoints (Fighters)` calcule les dommages faits  par le guerrier en accord avec les règles au dessus.

```java
Warrior warrior = new Warrior();
Wizard wizard = new Wizard();

warrior.getDomagePoints(wizard);
// => 10
```

## 5. Crée la classe Sorcier

Crée une autre classe nommée `Wizard`. Cette classe devrait aussi hérité de la classe existante `Fighters`.

## 6. Décrire le Sorcier

Mettre à jour la classe `Wizard` pour que la méthode `toString()` décrit le type de combattant qu'il représente.
La method devrait retourner la chaine de caractère `"Fighter is Wizard"`.

```java
Wizard wizard= new Wizard();
wizard.toString();

// => "Fighter is a Wizard"
```
## 7. Permettre aux Sorciers de préparer un sort et de le rendre vulnérable quand il ne prepare pas un sort.

Mettre à jour la classe `Wizard` et ajouter la méthode appelé `prepareSpell()`.
La classe devrait se souvenir quand la méthode à été appelé, et faire en sorte que la méthode `isVulnerable()` retourne `false` seulement quand le sort est préparé.

```java
Wizard wizard = new Wizard();
Warrior warrior = new Warrior();

wizard.prepareSpell();
wizard.getDamagePoints(warrior);
// => 12
```



