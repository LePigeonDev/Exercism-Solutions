## Introduction 

## Manipulation de bit

Java a des opérateurs pour manipuler les bits de `byte`, `short`, `int`, `long` ou `char`.

### Opérateurs de décalages

Utiliser `<<` pour décaler les bits vers la gauche et `>>` pour décaler les bits vers la droite.

```java
// Shift two places to the left
0b0000_1011 << 2;
// # => 0b0010_1100

// Shift two places to the right
0b0000_1011 >> 2;
// # => 0b0000_0010
```

L'opérateur `<<` insert toujours des 0 à droite.
Cependant, `>>` insert le même bit que le bit le plus à gauche (1 si le nombre est négative ou 0 si il est positive).

```java
// Shift 2 places to the right preserves the sign
// This is a negative value, whose binary representation is
// 1000_0000_0000_0000_0000_0000_0010_0110
int value = -0x7FFFFFDA;

// Shift two places to the right, preserving the sign bit
value >> 2;
// # => 1110_0000_0000_0000_0000_0000_0000_1001
```

Utiliser `>>>` plutôt quand les 0 doivent être inseré quand le décalage est vers la droite.

```java
// Shift two places to the right, inserting 0s on the left
value >>> 2;
// # => 0010_0000_0000_0000_0000_0000_0000_1001
```

### Les opérations au niveaux du bit

#### "ET" au niveau du bit

L'opérateur ET bit à bit (`&`) prend deux valeurs et effectue un ET sur chaque bit.
Il compare chaque bit depuis la 1er valeur avec le bit dans la meme position dans la seconde valeur.
Si les deux sont égales à 1, alors le résultat du bit est 1.
Sinon, le résultat du bit est 0.

```java
0b0110_0101 & 0b0011_1100;
// # => 0b0010_0100
```

#### "OU" au niveau du bit

Au niveau du bit l'opérateur OR (`|`) prends 2 valeurs et effectue un OU pour chaque bit.
Il compare chaque bit depuis la 1er valeur avec le bit dans la même position dans la seconde valeur.
Si l'un ou l'autre bit vaut 1, le résultat du bit est 1.
Sinon, c'est 0.

```java
0b0110_0101 | 0b0011_1100;
// # => 0b0111_1101
```

#### XOR au niveau du bit

L'opérateur XOR bit à bit (`^`) effectue un XOR bit à bit sur deux valeurs.
Comme les opérateurs ET et OU, il compare chaque bit depuis la 1er valeur avec le bit dans la même position dans la seconde valeur.
Si un seul d'entre eux vaut 1, alors le résultat du bit est 1.
Sinon, c'est 0.
```java
0b0110_0101 ^ 0b0011_1100;
// # => 0b0101_1001
```

#### NON(`~`) bit à bit

Dernierement, l'opérateur NON (`~`) inverse chaque bit.
Contrairement aux opérateurs précédents, Il s'agit d'un opérateur unaire, agissant uniquement sur une seule valeur.

```java
~0b0110_0101;
// # => 0b1001_1010
```

## Instructions

Votre ami vous a envoyé un message avec un secret important.
Il ne veut pas que ça soit facilement lisible pour les autres, le message est crypté en effectuant des séries de manipulation de bit.
Vous avez besoins d'écrire des méthodes pour aidé à décrypté le message.

## 1. Reculer des bites

La 1er étape pour décrypter le message est de défaire le décalage effectué lors du processus de cryptage en décalant les bits vers la droite.
Le processus de décryptage comportera d'autres étapes qui supposent l'insertion de zéros à partir de la gauche.

implementer la méthode `Secrets.shiftBack` qui prends une valeur et un nombre de place de décalage et effectue le décalage.

```java
Secrets.shiftBack(0b1001, 2);
# => 0b0010
```

## 2. Définir quelques bits

Suivant, il y a quelque bits qui ont besoins d'être mis à 1.

Implementer la méthode `Secrets.setBits` pour prendre une valeur et un masque et retourner le résultat de la mise à 1 des bits.
Un bit de la valeur doit être mis à 1 lorsque le bit du masque est également à 1.
Tous autres bits devra rester inchangé.

```java
Secrets.setBits(0b0110, 0b0101);
# => 0b0111
```

## 3. Inverser des bits spécifiques

Quelques bits sont inversés pendant le chiffrement.
Ils ont besoins d'être réinversé pour déchiffrer le message.

Implémenter la méthode `Secrets.flipBits` qui prend une valeur et un masque.
Le masque indique quels bits inversé dans la valeur.
Si le bit est 1 dans le masque, le bit est inversé dans la valeur.
Tous les autres bits reste inchangé.

```java
Secrets.flipBits(0b1100, 0b0101);
# => 0b1001
```


## 1. Effacer des bots spécifiques

Enfin, il y a certain bits qui sont toujours déchiffrer à 0.

Implementer la méthode `Secrets.clearBits` qui prend une valeur et un masque.
Les bits dans la `value` devrait être mis à 0 quand le bit dans le masque est 1.
Tous les autres bits reste inchangé.

```java
Secrets.clearBits(0b0110, 0b0101);
# => 0b0010
```