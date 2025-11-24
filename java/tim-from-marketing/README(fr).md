# Tim du Marketing

## Introduction

## Nullable

En Java, le `null` litéral est utilisé pour montrer une absence de valeur.

Les types de données primitives en java ont toutes une valeurs par défaut et donc ne peuvent pas être `null`.
Par convention, ils commencent avec une lettre en minuscule, par exemple `int`.

Les types de références contiennent une adresse mémoire de l'objet et peuvent avoir une valeur `null`.
Ils commencent généralement avec une lettre en majuscule, par exemple `String`.

Tenter d'assigner la valeur `null` à une variable primitive entrainera une erreur lors du moment de la compilation comme une variable à toujours une valeur primitive de type assigné.

```java
// Lève une erreur de compilation indiquant que le type requis est int, mais null a été fourni
int number = null;
```

Assigné la variable de référence à la valeur `null` n'entrainera pas d'erreur à la compilation comme les variables de références peuvent être null.

```java
// Pas d'erreur parce que la variable String str est nullable
String str = null;
```

## Instructions

Dans cette exercice vous devrez écrire du code pour imprimer un badge de nominatifs pour les employés de l'usine.

## 1. Imprimer un badge pour un employé

Les employées ont des ID, nom et nom de département. Les badges d'employés ont une étiquette avec le format suivant : `"[id] - name - DEPARTMENT"`.
Implémenter la méthode `Badge.print()` pour retourner les étiquettes des badges d'employés.

```java
Badge badge = new Badge();
badge.print(734, "Ernest Johnny Payne", "Strategic communication");
// => "[734] - Ernest Johnny Payne - STRATEGIC COMMUNICATION"
```

Le département devra être en majuscule sur l'étiquette.

## 2. Imprimer une étiquette pour un nouvelle employé 

En raison d'un dysfonctionnement du système informatique, occasionnellement les nouveaux employés peuvent ne pas avoir d'ID quand ils commencent à travailler à l'usine.
Comme les badges sont necessaires, ils recevront temporairement un badge sans le préfix ID.
Modify la méthode `Badge.print()` pour supporter que les nouveaux employés n'aient pas d'ID.

```java
Badge badge = new Badge();
Badge.print(null, "Jane Johson", "Procurement");
// => "Jane Johnson - PROCUREMENT"
```
## 3. Imprimer un badge pour le propriétaire

Même le propriétaire de l'usine doit porter un badge en permanence.
Cependant, le propriétaire n'a pas de département. Dans ce cas, l'étiquette devra imprimer `"OWNER"` à la place du nom de département. 
Modifie la méthode `Badge.print()` pour imprimer une étuiquette pour le propriétaire.

```java
Badge badge = new Badge();
badge.print(254, "Carlotte Hale", null);
// => "[254] - Charlotte Hale - OWNER"
```

Il est possible que le propriétaire soit un nouvel employé:

```java
Badge badge = new Badge();
badge.print(null, "Charlotte Hale", null);
// => "Charlotte Hale - OWNER"
```